package xy.yangtzeu.repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xy.yangtzeu.model.Boss;


@Repository("bossRepository")
public class BossRepository extends AbstractEntityRepository<Boss, Integer>{

	@Override
	protected Class<Boss> getEntityClazz() {
		return Boss.class;
	}
	
	@PersistenceContext(unitName="jpaxy")
	protected EntityManager em;
	
	/**
	 * 根据姓名查询卖家
	 * @param name
	 * @return
	 */
	@Transactional
	public Boss queryByName(String name){
		List<Boss> list = this.query("queryBossByName", name);
		return list.size() > 0 ?list.get(0) : null;
	}
	
	/**
	 * 查询所有卖家分页
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@Transactional
	public List<Boss> getAll(int pageIndex ,int pageSize ){
		String hql = "from Boss ";
		List<Boss> list = null;
		list = em.createQuery(hql,Boss.class)
		.setFirstResult((pageIndex-1) * pageSize)
		.setMaxResults(pageSize)
		.getResultList();
		return list;
	}
	
	/**
	 * 登录
	 * @param name
	 * @return
	 */
	@Transactional
	public Boss login(String name) {
		List<Boss> list = this.query("queryBossByName", name);
		return list.size() > 0 ?list.get(0) : null;
	}
	
	/**
	 * 修改密码
	 * @param password
	 * @param bossid
	 */
	@Transactional
	public void updatepaw(String password, Integer bossid){
		em.createQuery("update Boss b set b.password = ? where b.bossid = ? ")
		.setParameter(1, password)
		.setParameter(2, bossid);
	}
	
}
