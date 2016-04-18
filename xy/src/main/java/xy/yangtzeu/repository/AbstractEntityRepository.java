package xy.yangtzeu.repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.metamodel.EntityType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 *抽象实体工厂类，实现基本的对数据库操作
 * @author 肖云鹤 2016-03-25
 * @param <T> 实体类型
 * @param <I> 主键类型
 */
public abstract class AbstractEntityRepository <T,I>{

	@PersistenceContext(unitName="jpaxy")
	protected EntityManager em;
	
	/**
	 * 构造函数
	 */
	public AbstractEntityRepository() {
		Class<T> clazz = getEntityClazz();
	}
	
	/**
	 * 持久化实体对象
	 */
	@Transactional
	public void save(T t) {
		em.persist(t);
	}
	
	/**
	 * 更新持久化实体对象的状态
	 */
	@Transactional	
	public void update(T t) {
		em.merge(t);		
	}
	
	/**
	 * 根据实体标识符得到实体对象
	 */	
	@Transactional
	public T get(I id) {
		return (T) em.find(getEntityClazz(), id);
	}
	
	/**
	 * 删除持久化对象
	 */
	@Transactional
	public void drop(T t) {
		em.remove(t);
	}
	
	/**
	 * 删除持久化对象
	 */
	@Transactional	
	public void dropById(I id) {
		drop( get(id) );
	}
	
	/**
	 * 查询总记录数
	 */
	@Transactional	
	public Long count(){
		Long count = (Long) em.createQuery("select count (t) from "+getEntityClazz().getSimpleName()+" t")
		.getSingleResult();
		return count;
	}
	
	/**
	 * 使用预定义的NameQuery{@link NamedQuery}}进行查询
	 */
	@Transactional
	public List<T> query(String nameQuery, Object... params) {
		TypedQuery<T> query = takeQuery(nameQuery, params);
		return query.getResultList();
	}
	
	/**
	 * 使用预定义的NameQuery{@link NamedQuery}}进行查询
	 */
	@Transactional
	public List<T> query(String nameQuery) {
		TypedQuery<T> query = em.createNamedQuery(nameQuery, getEntityClazz());
		return query.getResultList();
	}
	
	/**
	 * 使用预定义的NameQuery{@link NamedQuery}}进行查询，得到唯一的结果
	 */
	@Transactional	
	public T queryUnique(String nameQuery, Object... params) {
		TypedQuery<T> query = takeQuery(nameQuery, params);
		return query.getSingleResult();		
	}
	
	/**
	 * 辅助方法，根据nameQuery与参数得到TypedQuery对象
	 */
	private TypedQuery<T> takeQuery(String nameQuery, Object... params) {
		TypedQuery<T> query = em.createNamedQuery(nameQuery, getEntityClazz());

		//设置查询参数		
		if (params != null) {
			int position = 1;
			for (Object param : params) {
				query.setParameter(position, param);
				position++;
			}			
		}
		return query;
	}
	
	/**
	 * 获得的有实体对象
	 */
	@Transactional
	public List<T> getAll() {
		TypedQuery<T> query = em.createQuery("select t from " + getEntityClazz().getSimpleName() + " t ", getEntityClazz());
		return query.getResultList();
	}
	
	/**
	 * 取得对象的主键名,辅助函数.
	 */
	@Transactional
	protected String getIdName() {
		Class<T> clazz = getEntityClazz();
		EntityType<T> et = em.getMetamodel().entity( clazz );
		Assert.notNull(et, "Class " + clazz + " not define in JPA.");
		String idName = et.getId( et.getIdType().getJavaType() ).getName();
		Assert.hasText(idName, clazz.getSimpleName() + " has no identifier property define.");		
		return idName;
		//return "id";
	}
	
	/**
	 * 仓库类需要管理的实体类，子类必须返回
	 */
	protected abstract Class<T> getEntityClazz();

}