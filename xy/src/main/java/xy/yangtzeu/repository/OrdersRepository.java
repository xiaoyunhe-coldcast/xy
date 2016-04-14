package xy.yangtzeu.repository;
import java.util.List;
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
public class OrdersRepository extends AbstractEntityRepository<Orders, Long> {

	@Override
	protected Class<Orders> getEntityClazz() {
		return Orders.class;
	}
	
	/**
	 * 根据买家主键查询买家的订单
	 * @param name
	 * @return
	 */
	@Transactional
	public List<Orders> queryBybuyerid(Integer buyerid){
		List<Orders> list = this.query("queryBybuyerid", buyerid);
		return list.size() > 0 ?list : null;
	}
}
