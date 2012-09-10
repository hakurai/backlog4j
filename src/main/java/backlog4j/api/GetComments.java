package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Comment;
import backlog4j.XmlRpcUtil;

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

    public List<Comment> execute() {
        if (getIssueId() == null) {
            throw new BacklogException();
        }

        Object res = client.execute(BACKLOG_GET_COMMENTS, getIssueId());

        return XmlRpcUtil.toList(Comment.class, res);
    }
}
