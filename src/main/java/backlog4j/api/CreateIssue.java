package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.Issue;
import backlog4j.impl.IssueImpl;

import java.util.Map;

/**
 * @author eguchi
 */
public class CreateIssue extends AbstractUpdateIssue {

    private final BacklogClient client;

    public CreateIssue(BacklogClient client) {
        this.client = client;
    }

    public Integer getProjectId() {
        return (Integer) map.get(PROJECT_ID);
    }

    public CreateIssue setProjectId(Integer projectId) {
        map.put(PROJECT_ID, projectId);

        return this;
    }


    public Issue execute() {
        Object res = client.execute(BACKLOG_CREATE_ISSUE, map);

        return new IssueImpl((Map<String, Object>) res);
    }


}
