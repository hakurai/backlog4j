package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;

/**
 * @author eguchi
 */
public class CountIssue extends AbstractFindIssueRequest<Integer> {

    private final BacklogClient client;


    public CountIssue(BacklogClient client) {
        this.client = client;
    }

    private void checkParameters() {
        if (getProjectId() == null) {
            throw new BacklogException("projectId is required");
        }
    }

    public Integer execute() {
        checkParameters();
        Integer res = (Integer) client.execute(BACKLOG_COUNTISSUE, map);

        return res;
    }
}
