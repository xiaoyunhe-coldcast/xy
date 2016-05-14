package xy.yangtzeu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xy.yangtzeu.model.Boss;
import xy.yangtzeu.model.Result;
import xy.yangtzeu.repository.BossRepository;
import xy.yangtzeu.service.BossService;

/**
 * 卖家控制层
 *
 * @author 肖云鹤
 * 2016年5月3日
 */
@Controller
@RequestMapping("/boss")
public class BossController {
	
	@Resource(name="bossRepository")
	private BossRepository BR;
	
	@Resource(name="BossService")
	private BossService BS;
	
	@RequestMapping("/login")
	@ResponseBody
	public Result login(String name, String password, HttpSession session, HttpServletRequest request){
		Result result = null;
		Boss bean = null;
		try {
			bean = BS.login(name, password);
			result = Result.successResult("登录成功");
			session.setAttribute("boss", bean);
		} catch(Exception e){
			 result = Result.failureResult("登录失败"+e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session){
		ModelAndView mav = new ModelAndView("/boss/bosslogin");
		try {
			session.removeAttribute("boss");
		} catch(Exception e){
			e.getMessage();
			mav.setViewName("Exception/exception");
		}
		return mav;
	}
}
