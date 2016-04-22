package xy.yangtzeu.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xy.yangtzeu.model.Comment;

@Repository("commentRepository")
public class CommentRepository extends AbstractEntityRepository<Comment, Integer> {

	@Override
	protected Class<Comment> getEntityClazz() {
		return Comment.class;
	}
	
	@PersistenceContext(unitName="jpaxy")
	protected EntityManager em;
	
	/**
	 * 根据用户主键获取评论
	 * @param name
	 * @return
	 */
	@Transactional
	public List<Comment> queryBuyer(Integer buyerid){
		List<Comment> list = this.query("combuyer", buyerid);
		return list.size() > 0 ?list : null;
	}
	
	@Transactional
	public List<Comment> queryByGood(Integer goodsid,int pageIndex ,int pagesize ){
		if (pagesize < 2){
			pagesize = 5 ;
		}
		String hql = "from Comment c where c.goods.goodsid = ?";
		
		List<Comment> commentlist = em.createQuery(hql,Comment.class)
		.setParameter(1, goodsid)
		.setFirstResult((pageIndex-1) * pagesize)
		.setMaxResults(pagesize)
		.getResultList();
		return commentlist;
	}
}
