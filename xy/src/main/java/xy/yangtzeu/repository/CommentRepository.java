package xy.yangtzeu.repository;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xy.yangtzeu.model.Comment;

@Repository("commentRepository")
public class CommentRepository extends AbstractEntityRepository<Comment, Integer> {

	@Override
	protected Class<Comment> getEntityClazz() {
		return Comment.class;
	}
	
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
}
