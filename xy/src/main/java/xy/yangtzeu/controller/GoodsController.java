package xy.yangtzeu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	ConvertJson cj;
	
	@RequestMapping("/querytype/{type}")
	@ResponseBody
	public Object QueryByType(@PathVariable Integer type){
		String data = null;
		try {
			List goodslist = GS.getByType(type);
			data = cj.list2Json(goodslist);
		} catch (Exception e){
			e.printStackTrace();
		}
		return data;
	}
	
}
