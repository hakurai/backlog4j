package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.IssueType;
import backlog4j.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetIssueTypes implements BacklogCommand<List<IssueType>> {
    private final BacklogClient client;
    private Integer projectId;

    public GetIssueTypes(BacklogClient client) {
        this.client = client;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public GetIssueTypes setProjectId(Integer projectId) {
        this.projectId = projectId;

        return this;
    }

    private void checkParameters() {
        if (getProjectId() == null) {
            throw new BacklogException("projectId is required");
        }
    }

    public List<IssueType> execute() {
        checkParameters();
        Object res = client.execute(BACKLOG_GET_ISSUE_TYPES, projectId);

        return XmlRpcUtil.toList(IssueType.class, res);
    }
}
