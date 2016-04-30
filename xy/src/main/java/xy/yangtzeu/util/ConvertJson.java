package xy.yangtzeu.util;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import net.sf.json.JSONArray;
import xy.yangtzeu.exception.BusinessException;

/**
 * json格式转化工具
 *
 * @author 肖云鹤
 * 2016年4月17日
 */
@Component
public class ConvertJson{
	
	public String list2Json(List list){
		if(list == null||list.size()<1){
			throw new BusinessException("集合是空的额");
		}
		String data = JSONArray.fromObject(list).toString();
		return data ==null ? "":data;
	}
	
	public String Map2Json(Map<String, Object> map){
		String data = JSONArray.fromObject(map).toString();
		return data;
	}
	
	public String u(Object o){
		Gson gson = new Gson(); //谷歌
		String jsonStr = gson.toJson(o);
		return jsonStr;
	}
}