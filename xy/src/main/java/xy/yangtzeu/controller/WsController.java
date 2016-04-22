package xy.yangtzeu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xy.yangtzeu.service.WebService;
import xy.yangtzeu.webservice.bean.Weather;

/**
 * webservice 调用控制层
 *
 * @author 肖云鹤
 * 2016年4月20日
 */
@Controller
@RequestMapping("/webservice")
public class WsController {
	
	@Resource(name="webService")
	WebService ws ;

	/**
	 * 天气预报
	 */
	@RequestMapping("/weather")
	public ModelAndView logout(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView("/other/index");
		String city = request.getParameter("city");
		Weather weather = ws.query(city);
		mav.addObject("weather", weather);
		return mav ;
	}
}
