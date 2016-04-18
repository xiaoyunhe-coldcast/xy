package xy.yangtzeu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xy.yangtzeu.model.Goods;
import xy.yangtzeu.repository.GoodsRepository;
import xy.yangtzeu.service.GoodsService;
import xy.yangtzeu.util.ConvertJson;

/**
 *商品 控制层
 *
 * @author 肖云鹤
 * 2016年4月13日
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Resource(name="goodsService")
	private GoodsService GS;
	
	@Resource(name="goodsRepository")
	private GoodsRepository GR;
	
	ConvertJson cj = new ConvertJson();
	
	@RequestMapping("/querytype/{type}")
	@ResponseBody
	public Object QueryByType(@PathVariable Integer type){
		String data = null;
		try {
			List <Goods>goodslist = GS.getByType(type);
			data = cj.list2Json(goodslist);
		} catch (Exception e){
			e.printStackTrace();
		}
		return data;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public Object Queryall(int page,int rows,String order){
		String data = null;
		
		try {
			List<Goods> goodslist = GR.getAll(page, rows,order);
			data = cj.list2Json(goodslist);
			data = "{\"total\":"+GR.count()+" , \"rows\":"+data+"}";
			System.out.println(data);
		} catch (Exception e){
			e.printStackTrace();
		}
		return data;
	}
}
