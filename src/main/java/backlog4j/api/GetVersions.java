package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.Version;
import backlog4j.XmlRpcUtil;

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

    public List<Version> execute() {
        Object res = client.execute(BACKLOG_GET_VERSIONS, projectId);

        return XmlRpcUtil.toList(Version.class, res);
    }
}
