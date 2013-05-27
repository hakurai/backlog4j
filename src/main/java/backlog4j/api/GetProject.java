package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Project;
import backlog4j.impl.ProjectImpl;

import java.util.Map;

/**
 * @author eguchi
 */
public class GetProject implements BacklogCommand<Project> {

    private final BacklogClient client;
    private       Integer       projectId;
    private       String        projectKey;

    public GetProject(BacklogClient client) {
        this.client = client;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public GetProject setProjectId(Integer projectId) {
        this.projectId = projectId;

        return this;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public GetProject setProjectKey(String projectKey) {
        this.projectKey = projectKey;

        return this;
    }

    public Project execute() {
        Object params;

        if (getProjectId() != null) {
            params = getProjectId();
        } else if (getProjectKey() != null) {
            params = getProjectKey();
        } else {
            throw new BacklogException("projectId or projectKey required");
        }

        Object res = client.execute(BACKLOG_GET_PROJECT, params);

        return new ProjectImpl((Map<String, Object>) res);
    }
}
