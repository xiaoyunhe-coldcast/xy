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

import com.fasterxml.jackson.annotation.JsonFormat;

import groovy.json.JsonBuilder;
import xy.yangtzeu.model.Buyer;
import xy.yangtzeu.repository.BuyerRepository;
import xy.yangtzeu.service.BuyerService;

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
	
	/**
	 *  买家注册
	 * @param bean
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String  SaveBuyer(Buyer bean){
		String msg = "";
		try {
		    BS.save(bean);
		    msg = "注册成功" ;
		} catch (Exception  e){
			msg = "注册失败"+e.getMessage();
		}
		return msg;
	}
	
	/**
	 * 登录  将买家放入session域中
	 * @return 
	 */
	@RequestMapping("/login")
	public ModelAndView login(String name , String password,HttpSession session){
		ModelAndView mav = new ModelAndView("/myspace");
		String msg = "";
		Buyer bean = null;
		try {
			bean = BS.login(name, password);
		} catch(Exception e){
			msg = "登录失败"+e.getMessage();
		}
		session.setAttribute("buyer", bean);
		mav.addObject("msg", msg);
		return mav;
	}
	
	/**
	 * 注销
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session){
		ModelAndView mav = new ModelAndView("/");
		session.removeAttribute("buyer");
		return mav ;
	}
	
	/**
	 * 删除买家
	 * @param id
	 */
	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable Integer id){
		String msg = "";
		try {
			BR.dropById(id);
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
	public String update(Buyer bean){
		String msg = "";
		try {
			BR.update(bean);
			msg = "修改成功！";
		} catch (Exception e){
			msg = "修改失败"+e.getMessage();
		}
		return msg;
	}
	
	/**
	 * 根据主键 id 查询买家
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/query/{id}")
	public ModelAndView queryBuyer(HttpServletRequest request,@PathVariable Integer id){
		ModelAndView mav = new ModelAndView("/myspace");
		String msg = "";
		Buyer bean = null;
		
		try {
			bean = BR.get(id);
		} catch(Exception e){
			msg = "操作失败"+ e.getMessage();
		}
		mav.addObject("buyer", bean);
		mav.addObject("msg", msg);
		return mav;
	}
	
	/**
	 * 查询所有的买家
	 * @return
	 */
	@RequestMapping("/list")
	public Object querAll(int pageIndex ,int pageSize ,String like){
		List <Buyer> list = BS.getAll(pageIndex, pageSize, like);
		
//		String json = JSONArray.fromObject(list).toString();
//		String data = "{\"total\":"+cs.getcount()+" , \"rows\":"+json+"}";
		return null;
	}
}
