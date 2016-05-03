package xy.yangtzeu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xy.yangtzeu.model.Boss;
import xy.yangtzeu.model.Buyer;
import xy.yangtzeu.model.Result;
import xy.yangtzeu.repository.BossRepository;
import xy.yangtzeu.service.BossService;

@Controller
@RequestMapping("/boss")
public class BossController {
	
	@Resource(name="bossRepository")
	private BossRepository BR;
	
	@Resource(name="BossService")
	private BossService BS;
	
	
	@RequestMapping("/login")
	@ResponseBody
	public Result login(String name, String password, HttpSession session){
		System.out.println(name);
		Result result = null;
		Boss bean = null;
		try {
			bean = BS.login(name, password);
			result = Result.successResult("登录成功");
			session.setAttribute("buyer", bean);
		} catch(Exception e){
			 result = Result.failureResult("登录失败"+e.getMessage());
		}
		return result;
	}
}
