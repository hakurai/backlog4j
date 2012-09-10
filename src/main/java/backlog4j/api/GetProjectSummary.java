package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.ProjectSummary;

import java.util.Map;

/**
 * @author eguchi
 */
public class GetProjectSummary implements BacklogCommand<ProjectSummary> {

    private final BacklogClient client;
    private Integer projectId;

    public GetProjectSummary(BacklogClient client) {
        this.client = client;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public GetProjectSummary setProjectId(Integer projectId) {
        this.projectId = projectId;

        return this;
    }

    private void checkParameters() {
        if (getProjectId() == null) {
            throw new BacklogException("projectId is required");
        }
    }

    public ProjectSummary execute() {
        checkParameters();

        Object res = client.execute(BACKLOG_GET_PROJECT_SUMMARY, getProjectId());

        return new ProjectSummary((Map<String, Object>) res);
    }
}
