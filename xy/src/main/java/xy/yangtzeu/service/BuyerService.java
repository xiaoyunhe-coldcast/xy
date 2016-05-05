package xy.yangtzeu.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xy.yangtzeu.exception.BusinessException;
import xy.yangtzeu.model.Buyer;
import xy.yangtzeu.repository.BuyerRepository;

/**
 * 买家业务逻辑
 * @author 肖云鹤
 * 2016-03-25
 *
 */
@Service("buyerService")
public class BuyerService {
	
	@Resource(name="buyerRepository")
	private BuyerRepository BR;
	
	/**
	 * 注册
	 * @param buyer
	 */
	public void save(Buyer buyer){
		if( BR.queryByName(buyer.getBuyername()) == null){
			BR.save(buyer);
		} else {
			throw new BusinessException("此人已经注册过！");
		}
	}
	
	/**
	 * 登录
	 */
	public Buyer login(String name ,String password){
		Buyer buyer = BR.queryByName(name);
		if (buyer.getBuyerpsw().equals(password)){
			return buyer;
		} else {
			throw new BusinessException("用户名或者密码不正确");
		}
	}
	
	/**
	 * 获取买家的集合
	 */
	public List<Buyer> getAll(Integer page, Integer rows, String like){
		List<Buyer> list = null;
		if(page <= 0 || rows >20){
			page = 1;
			rows = 10 ;
		} 
		if (like=="" || like == null){
			list = BR.getAll(page, rows);
		} else {
			 list = BR.getAll(page, rows, like);
		}
		
		return list;
	}
}
