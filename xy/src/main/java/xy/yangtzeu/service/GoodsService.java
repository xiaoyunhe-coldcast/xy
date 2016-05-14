package xy.yangtzeu.service;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import xy.yangtzeu.exception.BusinessException;
import xy.yangtzeu.model.Goods;
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
}
