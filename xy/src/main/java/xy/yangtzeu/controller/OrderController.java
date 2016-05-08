package xy.yangtzeu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xy.yangtzeu.model.Orders;
import xy.yangtzeu.model.Result;
import xy.yangtzeu.repository.BossRepository;
import xy.yangtzeu.repository.BuyerRepository;
import xy.yangtzeu.repository.GoodsRepository;
import xy.yangtzeu.repository.OrdersRepository;
import xy.yangtzeu.service.OrdersService;
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
	
	@Resource(name= "bossRepository")
	private BossRepository BR;
	
	@Resource(name="buyerRepository")
	private BuyerRepository YR;
	
	@Resource(name="goodsRepository")
	private GoodsRepository GR;
	
	@Resource(name="ordersService")
	OrdersService OS;
	
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
	
	@RequestMapping("/add")
	@ResponseBody
	public Result addOne(HttpServletRequest request){
		int buyerid = Integer.parseInt(request.getParameter("buyerid"));
		int goodsid = Integer.parseInt(request.getParameter("goodsid"));
		int bossid = Integer.parseInt(request.getParameter("bossid"));
		int status = Integer.parseInt(request.getParameter("status"));
		int num = Integer.parseInt(request.getParameter("num"));
		String date = request.getParameter("date");
		double total = Double.parseDouble(request.getParameter("total"));
		String bz = request.getParameter("bz");
		
		Orders bean = new Orders();
		
		bean.setBuyer(YR.get(buyerid));
		bean.setBoss(BR.get(bossid));
		bean.setBz(bz);
		bean.setDate(date);
		bean.setGoods(GR.get(goodsid));
		bean.setNum(num);
		bean.setStatus(status);
		bean.setTotal(total);
		
		Result result = null;
		String msg = "";
		try {
		msg = (String) OS.add(bean);
		result = Result.successResult(msg);
		
		} catch (Exception e){
			
		result = Result.failureResult("操作失败"+e.getMessage());
		}
		return result;
	}
	
	
	@RequestMapping("/remove/{orderid}")
	@ResponseBody
	public Result remove(@PathVariable Integer id){
		Result result = null;
		try {
			OR.dropById(id);
			result = Result.successResult("删除成功");
		} catch (Exception e){
			result = Result.failureResult("删除失败" + e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Result update(HttpServletRequest request){
		request.getParameter("");
		
		return null;
	}
	
	@RequestMapping("/updatetype/{id}")
	@ResponseBody
	public Result updatetype(@PathVariable Integer id){
		Result result = null;
		try {
			OS.updatestatus(id);
			result = Result.successResult("");
		} catch (Exception e){
			result = Result.failureResult(e.getMessage());
		}
		return result;
	}
}
