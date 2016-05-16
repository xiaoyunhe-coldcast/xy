package xy.yangtzeu.repository;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xy.yangtzeu.model.Goods;

/**
 * 商品工厂类
 *
 * @author 肖云鹤
 * 2016年4月13日
 */
@Repository("goodsRepository")
public class GoodsRepository extends AbstractEntityRepository<Goods, Integer>{

	@Override
	protected Class<Goods> getEntityClazz() {
		return Goods.class;
	}
	
	@PersistenceContext(unitName="jpaxy")
	protected EntityManager em;
	
	/**
	 * 根据商品类别预定义查询商品
	 * @param name
	 * @return
	 */
	@Transactional
	public List<Goods> queryBytype(Integer type, int pageIndex, int pageSize){
		
		String hql = "from Goods b where b.type=?";
		List <Goods> list = em.createQuery(hql,Goods.class)
		.setParameter(1, type)
		.setFirstResult((pageIndex-1) * pageSize)
		.setMaxResults(pageSize)
		.getResultList();
		return list;
	}
	
	/**
	 * 查询所有商品分页
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@Transactional
	public List<Goods> getAll(int pageIndex, int pageSize, String order){
		if (order == ""||order == null){
			order = "asc";
		}
		String hql = "from Goods g order by g.price "+order;
		List<Goods> list = new ArrayList<Goods>();
		list = em.createQuery(hql, Goods.class)
		.setFirstResult((pageIndex-1) * pageSize)
		.setMaxResults(pageSize)
		.getResultList();
		return list;
	}
	
}
