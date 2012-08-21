package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.Version;
import backlog4j.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetVersions {

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
        Object res = client.execute(BacklogClient.BACKLOG_GETVERSIONS, projectId);

        return XmlRpcUtil.toList(Version.class, res);
    }
}
