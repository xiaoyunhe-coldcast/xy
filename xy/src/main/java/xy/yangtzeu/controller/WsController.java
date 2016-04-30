package xy.yangtzeu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xy.yangtzeu.model.Result;
import xy.yangtzeu.service.WebService;
import xy.yangtzeu.util.ConvertJson;
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
	
	@Autowired
	ConvertJson tj;

	/**
	 * 天气预报
	 */
	@RequestMapping("/weather")
	@ResponseBody
	public Result logout(HttpServletRequest request){
		String city = request.getParameter("city");
		Weather weather = ws.query(city);
		Result result = null;
		result =Result.successResult("天气信息:"+weather.getBase()+"详细描述："+weather.getDescription()+"; 更新时间："+weather.getDate());
		return result ;
	}
}
