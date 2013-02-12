package backlog4j.impl;

import backlog4j.Comment;
import backlog4j.CommentList;

import java.util.List;

/**
 * @author eguchi
 */
public final class CommentListImpl extends BacklogResponse<Comment> implements CommentList {

    private final List<Comment> delegate;

    public CommentListImpl(List<Comment> delegate) {
        this.delegate = delegate;
    }
    @Override
    public List<Comment> getDelegate() {
        return delegate;
    }

    @Override
    public Comment getById(Integer id) {
        return super.getById(delegate, id);
    }


}
