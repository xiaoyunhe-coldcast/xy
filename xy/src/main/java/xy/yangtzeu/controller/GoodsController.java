package xy.yangtzeu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xy.yangtzeu.model.Comment;
import xy.yangtzeu.model.Goods;
import xy.yangtzeu.repository.CommentRepository;
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
	
	@Resource(name="commentRepository")
	private CommentRepository CR;
	
	
	ConvertJson cj = new ConvertJson();
	
	@RequestMapping("/querytype/{type}")
	public ModelAndView QueryByType(@PathVariable Integer type){
		List <Goods>goodslist = null;
		ModelAndView mav = new ModelAndView("/goods/goodstype");
		try {
			goodslist = GS.getByType(type);
			mav.addObject("good",goodslist );
		} catch (Exception e){
			e.printStackTrace();
		}
		return mav;
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
	
	/**
	 * 查询商品
	 * @param id
	 */
	@RequestMapping("/query/{goodid}")
	public ModelAndView remove(@PathVariable Integer goodid,Integer pageIndex,Integer pagesize){
		ModelAndView mav = new ModelAndView("/goods/goodsshow");
		Goods goods = new Goods();
		List <Comment> comment = new ArrayList<Comment>();
		try {
			goods = GR.get(goodid);
			if (pageIndex == 0 || pagesize == 0 ){
				pageIndex = 1;
				 pagesize = 20;
			}
			comment = CR.queryByGood(goodid,pageIndex , pagesize);
		} catch (Exception e){
			e.printStackTrace();
		}
		mav.addObject("good", goods);
		mav.addObject("comlist", comment);
		return mav;
	}
	
}
