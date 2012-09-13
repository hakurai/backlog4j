package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Version;
import backlog4j.util.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetVersions implements BacklogCommand<List<Version>> {

    private final BacklogClient client;
    private Integer projectId;

    public GetVersions(BacklogClient client) {
        this.client = client;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public GetVersions setProjectId(Integer projectId) {
        this.projectId = projectId;

        return this;
    }

    private void checkParameters() {
        if (getProjectId() == null) {
            throw new BacklogException("projectId is required");
        }
    }

    public List<Version> execute() {
        checkParameters();
        Object res = client.execute(BACKLOG_GET_VERSIONS, projectId);

        return XmlRpcUtil.toList(Version.class, res);
    }
}
