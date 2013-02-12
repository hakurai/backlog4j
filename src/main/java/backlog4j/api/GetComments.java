package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Comment;
import backlog4j.CommentList;
import backlog4j.impl.CommentImpl;
import backlog4j.impl.CommentListImpl;
import backlog4j.util.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetComments implements BacklogCommand<CommentList> {


    private final BacklogClient client;
    private Integer issueId;

    public GetComments(BacklogClient client) {
        this.client = client;
    }

    public Integer getIssueId() {
        return issueId;
    }

    public GetComments setIssueId(Integer issueId) {
        this.issueId = issueId;

        return this;
    }

    private void checkParameters() {
        if (getIssueId() == null) {
            throw new BacklogException("issueId is required");
        }

    }

    public CommentList execute() {
        checkParameters();

        Object res = client.execute(BACKLOG_GET_COMMENTS, getIssueId());

        List<Comment> commentList = XmlRpcUtil.<Comment>toList(CommentImpl.class, res);
        return new CommentListImpl(commentList);
    }
}
