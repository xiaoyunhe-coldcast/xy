package xy.yangtzeu.controller;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import xy.yangtzeu.model.Buyer;
import xy.yangtzeu.model.Comment;
import xy.yangtzeu.model.Goods;
import xy.yangtzeu.model.Orders;
import xy.yangtzeu.model.Result;
import xy.yangtzeu.repository.BuyerRepository;
import xy.yangtzeu.repository.CommentRepository;
import xy.yangtzeu.repository.GoodsRepository;
import xy.yangtzeu.repository.OrdersRepository;
import xy.yangtzeu.service.BuyerService;
import xy.yangtzeu.util.ConvertJson;

/**
 * 买家 控制层
 * @author 肖云鹤
 * 2016-03-25
 */
@Controller
@RequestMapping("/buyer")
public class BuyerController {
	
	@Resource(name="buyerRepository")
	private BuyerRepository BR;
	
	@Resource(name="buyerService")
	private BuyerService BS;
	
	@Resource(name="goodsRepository")
	private GoodsRepository GR;
	
	@Resource(name="ordersRepository")
	private OrdersRepository OR;
	
	@Resource(name="commentRepository")
	private CommentRepository CR;
	
	ConvertJson tj = new ConvertJson();
	
	/**
	 *  买家注册
	 * @param bean
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Result SaveBuyer(Buyer bean){
		Result result = null;
		try {
		    BS.save(bean);
		   result = Result.successResult("注册成功");
		} catch (Exception  e){
			result = Result.failureResult("注册失败"+e.getMessage());
		}
		return result;
	}
	
	/**
	 * 登录  将买家放入session域中
	 * @return 
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Result login(String name, String password, HttpSession session){
		Result result = null;
		Buyer bean = null;
		try {
			bean = BS.login(name, password);
			result = Result.successResult("登录成功");
			session.setAttribute("buyer", bean);
		} catch(Exception e){
			 result = Result.failureResult("登录失败"+e.getMessage());
		}
		return result;
	}
	
	/**
	 * 注销
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session){
		ModelAndView mav = new ModelAndView("/other/index");
		session.removeAttribute("buyer");
		return mav ;
	}
	
	/**
	 * 删除买家
	 * @param id
	 */
	@RequestMapping("/remove/{id}")
	@ResponseBody
	public String remove(@PathVariable Integer id){
		String msg = "";
		try {
			BR.dropById(id);
			System.out.println("开始删除。。。");
			msg = "删除成功";
		} catch (Exception e){
			msg = "删除失败"+e.getMessage();
		}
		return msg;
	}
	
	/**
	 * 修改买家信息
	 * @param id
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Result update(Buyer bean){
		Result result = null;
		try {
			BR.update(bean);
			result = Result.successResult("修改成功！") ;
		} catch (Exception e){
			result = Result.successResult("修改失败"+e.getMessage()) ;
		}
		return result;
	}
	
	/**
	 * 根据主键 id 查询买家 订单，购买的商品，评论历史
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/query/{id}")
	public ModelAndView queryBuyer(HttpServletRequest request,@PathVariable Integer id){
		ModelAndView mav = new ModelAndView("/buyer/myspace");
		String msg = "";
		Buyer bean = null;
		List <Goods> goodslist = null;
		List <Orders> orderslist1 = null;
		List <Orders> orderslist2 = null;
		List <Comment> commentlist = null;
		try {
			bean = BR.get(id);
			//goodslist =	GR.queryBybuyerid(id);
			orderslist1 = OR.queryBybuyerid(id);
			orderslist2 = OR.querygoodBybuyerid(id);
			commentlist = CR.queryBuyer(id);
			} catch(Exception e){
			msg = "操作失败"+ e.getMessage();
		}
		mav.addObject("buyer", bean);
	//	mav.addObject("goodslist", goodslist);
		mav.addObject("orderslist", orderslist1);
		mav.addObject("goodslist", orderslist2);
		mav.addObject("comlist", commentlist);
		mav.addObject("msg", msg);
		return mav;
	}
	
	/**
	 * 查询所有的买家 支持模糊查询
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Object querAll(int page ,int rows ,String like){
		if (like == null){
			like ="";
		}
		List <Buyer> list = BS.getAll(page, rows, like);
		String json = tj.list2Json(list);
		String data = "{\"total\":"+BR.count()+" , \"rows\":"+json+"}";
		System.out.println(data);
		return data;
	}
}
