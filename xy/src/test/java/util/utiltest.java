package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import xy.Repository.model;
import xy.Repository.model2;
import xy.Repository.model3;
import xy.yangtzeu.util.ConvertJson;

public class utiltest {
	ConvertJson cj = new ConvertJson();
	
	@Test
	public void test1(){
		List<model> carlist = new ArrayList<>();
		model d = new model();
		model2 d2 = new  model2();
		model3 d3 = new model3();
		
		d3.setName2("111");
		d2.setName("5555555");
		d.setMoney(22);
		d2.setModel3(d3);
		d.setName("11");
		d.setMode2(d2);
		carlist.add(d);
		String data =cj.u(carlist);
		System.out.println(data);
	}
	
	@Test
	public void test2(){
		Map<String, Object> a = new HashMap<String,Object>();
		model d = new model();
		d.setMoney(55);
		d.setName("22");
		a.put("2", d);
		a.put("3", 2);
		a.put("4", 5);
		//String data = JSONArray.fromObject(a.get("2")).toString();
		a.values();
		  for (String key : a.keySet()) {
			   System.out.println("key= "+ key + " and value= " + a.get(key));
			  }
		//System.out.println(data);
	}
	
	@Test
	public void test3(){
		 Map<String, String> map = new HashMap<String, String>();
		  map.put("1", "value1");
		  map.put("2", "value2");
		  map.put("3", "value3");
		  
		  //第一种：普遍使用，二次取值
		  System.out.println("通过Map.keySet遍历key和value：");
		  for (String key : map.keySet()) {
		   System.out.println("key= "+ key + " and value= " + map.get(key));
		  }
		  
		  //第二种
//		  System.out.println("通过Map.entrySet使用iterator遍历key和value：");
//		  Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
//		  while (it.hasNext()) {
//		   Map.Entry<String, String> entry = it.next();
//		   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		  }
}
