package xy.yangtzeu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xy.yangtzeu.model.Comment;
import xy.yangtzeu.model.Result;
import xy.yangtzeu.repository.CommentRepository;

@Controller("/com")
public class CommentController {
	
	@Resource(name="commentRepository")
	private CommentRepository comRep;
	
	@RequestMapping("/query/{id}")
	public ModelAndView queryone(){
		ModelAndView mav = new ModelAndView("/comment/comshow");
		List <Comment> comlist = comRep.queryBuyer(6);
		try {
			mav.addObject("com", comlist);
		} catch (Exception e){
			mav.setViewName("Exception/exception");
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/remove/{id}")
	@ResponseBody
	public Result remove(@PathVariable Integer id){
		Result result = null;
		try{
			comRep.dropById(id);
			result = Result.successResult("删除成功");
		} catch (Exception e){
			result =  Result.failureResult("删除失败"+e.getMessage());
		}
		return result;
	}
	

}
