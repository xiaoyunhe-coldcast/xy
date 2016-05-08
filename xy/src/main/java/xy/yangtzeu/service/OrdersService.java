package xy.yangtzeu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xy.yangtzeu.exception.BusinessException;
import xy.yangtzeu.model.Orders;
import xy.yangtzeu.repository.OrdersRepository;


/**
 * 订单业务逻辑层
 *
 * @author 肖云鹤
 * 2016年4月17日
 */
@Service("ordersService")
public class OrdersService {
	
	@Resource(name="ordersRepository")
	private OrdersRepository OR;
	
	public Object add(Orders bean){
		String Msg = "";
		if (bean.getOrderid()!= null){
			OR.update(bean);
			Msg = "修改成功";
		} else {
			OR.save(bean);
			Msg = "保存成功";
		}
		return Msg;
	} 
	
	public void updatestatus(int oredrsid){
		Orders bean = OR.get(oredrsid);
		
		if (bean.getStatus() < 5){
			OR.updatestatus(oredrsid);
		} else {
			throw new BusinessException("订单已完成，不能修改");
		}
	}
}
