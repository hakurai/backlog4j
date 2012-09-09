package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.Issue;

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
        Object res = client.execute(BACKLOG_CREATEISSUE, map);

        return new Issue((Map<String, Object>) res);
    }


}
