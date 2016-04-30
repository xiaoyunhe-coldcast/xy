package xy.yangtzeu.service;

import org.springframework.stereotype.Service;

import xy.yangtzeu.webservice.Weatherws;
import xy.yangtzeu.webservice.bean.Weather;

/**
 * webservice业务逻辑层
 *
 * @author 肖云鹤
 * 2016年4月20日
 */
@Service("webService")
public class WebService {
	
	public Weather query(String city){
       Weatherws client = new Weatherws();  
       Weather weather = new Weather();
       
       String xml2 = client.weather(city);  
       String weathers [] =xml2.split("</string><string>");
       weather.setAdress(weathers[1]);
       weather.setBase(weathers[5]);
       weather.setDate(weathers[3]);
       weather.setDescription(weathers[6]);
       return weather;
	}
}
