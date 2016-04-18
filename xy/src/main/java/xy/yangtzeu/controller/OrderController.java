package xy.yangtzeu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xy.yangtzeu.model.Orders;
import xy.yangtzeu.repository.OrdersRepository;
import xy.yangtzeu.util.ConvertJson;

/**
 * 订单控制层
 *
 * @author 肖云鹤
 * 2016年4月17日
 */
@Controller
@RequestMapping("/orders")
public class OrderController {
	
	@Resource(name="ordersRepository")
	private OrdersRepository OR;
	
	ConvertJson cj = new ConvertJson();
	
	@RequestMapping("/list")
	@ResponseBody
	public String getAll(int page,int rows){
		String data = null;
		
		try {
			List<Orders> goodslist = OR.query(page, rows);
			data = cj.list2Json(goodslist);
			data = "{\"total\":"+OR.count()+" , \"rows\":"+data+"}";
			System.out.println(data);
		} catch (Exception e){
			e.printStackTrace();
		}
		return data;
	}

	@RequestMapping("/query/{id}")
	public ModelAndView getOne(@PathVariable Integer id){
		ModelAndView mav = new ModelAndView("/orders/orders");
		
		try {
			Orders bean = OR.get(id);
			mav.addObject("orders", bean);
		} catch (Exception e){
			e.printStackTrace();
		}
		return mav;
	}
}
