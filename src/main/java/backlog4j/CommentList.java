package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface CommentList extends List<Comment> {

    Comment getById(Integer id);

}
