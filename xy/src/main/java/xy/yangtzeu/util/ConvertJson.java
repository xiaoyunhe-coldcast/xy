package xy.yangtzeu.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import net.sf.json.JSONArray;
import xy.Repository.model;

public class ConvertJson{
	
	public String list2Json(List list){
		String data = JSONArray.fromObject(list).toString();
		//String data = "{\"total\":"+cs.getcount()+" , \"rows\":"+json+"}";
		return data;
	}
	
	public String Map2Json(Map map){
		String data = JSONArray.fromObject(map).toString();
		return data;
	}
	
	@Test
	public void test1(){
		List carlist = new ArrayList<>();
		model d = new model();
		d.setMoney(22);
		d.setName("11");
		carlist.add(d);
		String data = JSONArray.fromObject(carlist.get(0)).toString();
		System.out.println(data);
	}
	
	@Test
	public void test2(){
		Map<String, Object> a = new HashMap<String,Object>();
		model d = new model();
		d.setMoney(55);
		d.setName("22");
		a.put("2", d);
		String data = JSONArray.fromObject(a.get("2")).toString();
		System.out.println(data);
	}
}