package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Issue;
import backlog4j.impl.IssueImpl;

import java.util.Map;

/**
 * @author eguchi
 */
public class GetIssue implements BacklogCommand<Issue> {

    private final BacklogClient client;
    private Integer issueId;
    private String issueKey;

    public GetIssue(BacklogClient client) {
        this.client = client;
    }

    public Integer getIssueId() {
        return issueId;
    }

    public GetIssue setIssueId(Integer issueId) {
        this.issueId = issueId;

        return this;
    }

    public String getIssueKey() {
        return issueKey;
    }

    public GetIssue setIssueKey(String issueKey) {
        this.issueKey = issueKey;

        return this;
    }

    public Issue execute() {
        Object params;

        if (getIssueId() != null) {
            params = getIssueId();
        } else if (getIssueKey() != null) {
            params = getIssueKey();
        } else {
            throw new BacklogException("issueId or issueKey is riquired");
        }

        Object res = client.execute(BACKLOG_GET_ISSUE, params);

        return new IssueImpl((Map<String, Object>) res);
    }
}
