package xy.yangtzeu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xy.yangtzeu.model.Boss;
import xy.yangtzeu.model.Comment;
import xy.yangtzeu.model.Goods;
import xy.yangtzeu.model.Page;
import xy.yangtzeu.model.Result;
import xy.yangtzeu.model.Storage;
import xy.yangtzeu.repository.BossRepository;
import xy.yangtzeu.repository.CommentRepository;
import xy.yangtzeu.repository.GoodsRepository;
import xy.yangtzeu.repository.StorageRepository;
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
	
	@Resource(name = "bossRepository")
	private BossRepository BR;
	
	@Resource(name = "StorageRepository")
	private StorageRepository SR;
	
	@Resource(name="commentRepository")
	private CommentRepository CR;
	
	
	ConvertJson cj = new ConvertJson();
	
	@RequestMapping("/querytype/{type}")
	public ModelAndView QueryByType(@PathVariable Integer type, Long pagesize, Long pageindex){
		Page page = GR.getpage(pageindex.intValue(), pagesize.intValue(), "where t.type ="+type);
		List <Goods>goodslist = new ArrayList<Goods>();
		ModelAndView mav = new ModelAndView("/goods/goodstype");
		try {
			mav.addObject("good",page.getList());
			mav.addObject("page", page);
			mav.addObject("type",type);
		} catch (Exception e){
			mav.setViewName("/exception");
			e.printStackTrace();
		}
		return mav;
	}
	
	//json格式
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
			mav.setViewName("/Exception/exception");
		}
		mav.addObject("good", goods);
		mav.addObject("comlist", comment);
		return mav;
	}
	
	//删除
	@RequestMapping("/remove/{id}")
	@ResponseBody
	public Result remove(@PathVariable Integer goodid){
		Result result = null;
		try {
			GR.dropById(goodid);
			result = Result.successResult("删除成功");
		} catch (Exception e){
			result = Result.failureResult("删除失败"+e.getMessage());
		}	
		return result;
	}
	
	/** 增加商品 **/
	@ResponseBody
	@RequestMapping("/add")
	public Result add(HttpServletRequest request, Goods goods){
		Result result = null;
		int bossid = Integer.parseInt(request.getParameter("bossid"));
		int storageid =Integer.parseInt(request.getParameter("storageid"));
		try {
			goods.setBoss(BR.get(bossid));
			goods.setStorage(SR.get(storageid));
			GR.save(goods);
			result = Result.successResult("操作成功");
		} catch (Exception e){
			result = Result.failureResult("操作失败"+e.getMessage());
		}
		return result;
	}
	
	/**修改商品**/
	@ResponseBody
	@RequestMapping("/update")
	public Result update(HttpServletRequest request, Goods goods){
		Result result = null;
		try {
			int bossid = Integer.parseInt(request.getParameter("bossid"));
			int storageid = Integer.parseInt(request.getParameter("storageid"));
			Storage storage  = SR.get(storageid);
			Boss boss = BR.get(bossid);
			Goods goods1 = GS.save(goods, boss, storage);
			GR.save(goods1);
			
			Result.successResult("修改成功");
		} catch (Exception e){
			result = Result.failureResult("修改失败"+e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/all")
	public ModelAndView getall(Long pageindex, Long pagesize, String search){
		System.out.println(pageindex+""+pagesize+""+search);
		String hql = " where t.name = '"+search+"'";
		if (search == "" || search == null){
			hql = "";
		}
		ModelAndView mav = new ModelAndView("/goods/allgoods");
		Page page = GR.getpage(pageindex.intValue(), pagesize.intValue(), hql);
		try {
			List<Goods> goodslist = GR.getAll(pageindex.intValue(), pagesize.intValue(), "desc");
			mav.addObject("good", goodslist);
			mav.addObject("page", page);
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/Exception/exception");
		}
		return mav;
	}
}
