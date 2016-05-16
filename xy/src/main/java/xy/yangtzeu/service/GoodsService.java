package xy.yangtzeu.service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xy.yangtzeu.exception.BusinessException;
import xy.yangtzeu.model.Boss;
import xy.yangtzeu.model.Goods;
import xy.yangtzeu.model.Storage;
import xy.yangtzeu.repository.GoodsRepository;

/**
 * 商品业务层
 *
 * @author 肖云鹤
 * 2016年4月13日
 */
@Service("goodsService")
public class GoodsService {
	
	@Resource(name="goodsRepository")
	private GoodsRepository GR;
	
	/** 查询商品类别  **/
	public List<Goods> getByType(Integer type, int pageindex, int pagesize){
		List <Goods> list = null;
		if (type > 20|| type < 0){
			throw new BusinessException("商品类别不在范围内");
		} else {
			list = GR.queryBytype(type, pageindex, pagesize);
		}
		return list;
	}
	
	/**更新商品**/
	public Goods save(Goods goods, Boss boss, Storage storage){
		Goods goods1 = new Goods();
		goods1.setAddress(goods.getAddress());
		goods1.setBoss(boss);
		goods1.setBz(goods.getBz());
		goods1.setDate(goods.getDate());
		goods1.setDescription(goods.getDescription());
		goods1.setName(goods.getName());
		goods1.setPicture(goods.getPicture());
		goods1.setPrice(goods.getPrice());
		goods1.setType(goods.getType());
		goods1.setStorage(storage);
		return goods1;
	}
}
