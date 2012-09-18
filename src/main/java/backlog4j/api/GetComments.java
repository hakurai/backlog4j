package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Comment;
import backlog4j.impl.CommentImpl;
import backlog4j.util.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetComments implements BacklogCommand<List<Comment>> {


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

    public List<Comment> execute() {
        checkParameters();

        Object res = client.execute(BACKLOG_GET_COMMENTS, getIssueId());

        return XmlRpcUtil.<Comment>toList(CommentImpl.class, res);
    }
}
