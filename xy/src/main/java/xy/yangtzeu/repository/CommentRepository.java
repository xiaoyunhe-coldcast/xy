package xy.yangtzeu.repository;

import org.springframework.stereotype.Repository;

import xy.yangtzeu.model.Comment;

@Repository("commentRepository")
public class CommentRepository extends AbstractEnyityRepository<Comment, Integer> {

	@Override
	protected Class<Comment> getEntityClazz() {
		return Comment.class;
	}
}