package xy.yangtzeu.repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xy.yangtzeu.model.Buyer;

/**
 * 用户工厂类
 * @author 肖云鹤
 * 2016-03-25
 */
@Repository("buyerRepository")
public class BuyerRepository extends AbstractEntityRepository<Buyer, Integer> {

	@Override
	protected Class<Buyer> getEntityClazz() {
		return Buyer.class;
	}
	
	@PersistenceContext(unitName="jpaxy")
	protected EntityManager em;
	
	/**
	 * 根据姓名预定义查询买家
	 * @param name
	 * @return
	 */
	@Transactional
	public Buyer queryByName(String name){
		List<Buyer> list = this.query("queryBuyerByName", name);
		return list.size() > 0 ?list.get(0) : null;
	}
	
	/**
	 * 查询所有进行分页，条件筛选
	 * @param pageIndex
	 * @param pageSize
	 * @param m
	 * @return
	 */
	@Transactional
	public List<Buyer> getAll(int pageIndex, int pageSize, String like){
		String hql = "from Buyer b where b.buyername like ? or b.realname like ? or b.address like ?";
		List<Buyer> list = null;
		
		list = em.createQuery(hql,Buyer.class)
		.setParameter(1, "%"+like+"% ")
		.setParameter(2, "%"+like+"% ")
		.setParameter(3, "%"+like+"% ")
		.setFirstResult((pageIndex-1) * pageSize)
		.setMaxResults(pageSize)
		.getResultList();
		return list;
	}
	
	/**
	 * 查询所有进行分页.
	 * @param pageIndex
	 * @param pageSize
	 * @param m
	 * @return
	 */
	@Transactional
	public List<Buyer> getAll(int page, int rows){
		String hql = "from Buyer ";
		List<Buyer> list = em.createQuery(hql, Buyer.class)
		.setFirstResult((page-1) * rows)
		.setMaxResults(rows)
		.getResultList();
		return list;
	}
}
