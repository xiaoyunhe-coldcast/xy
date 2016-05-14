package xy.yangtzeu.repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xy.yangtzeu.model.Orders;

/**
 *订单实体工厂
 *
 * @author 肖云鹤
 * 2016年4月13日
 */
@Repository("ordersRepository")
public class OrdersRepository extends AbstractEntityRepository<Orders, Integer> {

	@Override
	protected Class<Orders> getEntityClazz() {
		return Orders.class;
	}
	
	@PersistenceContext(unitName="jpaxy")
	protected EntityManager em;
	
	/**
	 * 根据买家主键查询买家的订单
	 * @param name
	 * @return
	 */
	@Transactional
	public List<Orders> queryBybuyerid(Integer buyerid) {
		List<Orders> list = this.query("queryBybuyerid", buyerid);
		return list.size() > 0 ?list : null;
	}
	
	/**
	 * 根据买家查购买的商品
	 * @param name
	 * @return
	 */
	@Transactional
	public List<Orders> querygoodBybuyerid(Integer buyerid) {
		List<Orders> list = this.query("querygoodbuyerid", buyerid);
		return list.size() > 0 ?list : null;
	}
	
	/**
	 * 查询全部订单
	 */
	@Transactional
	public List<Orders> query(int page ,int rows) {
		String hql = "from Orders";
		List <Orders> list = em.createQuery(hql)
				.setFirstResult((page-1)*rows)
				.setMaxResults(rows)
				.getResultList();
		return list;
	}
	
	/**
	 * 修改订单状态
	 * @param ordersid
	 */
	@Transactional
	public void updatestatus(int ordersid) {
		String hql = "update Orders o set o.status = o.status+1 where o.orderid = ?";
		em.createQuery(hql).setParameter(1, ordersid);
	}
	
	//退款
	@Transactional
	public void returnmoney(int ordersid) {
		String hql = "update Orders o set o.state = 0 where o.orderid = ?";
		em.createQuery(hql).setParameter(1, ordersid);
	}
}
