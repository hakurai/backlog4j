package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Version;
import backlog4j.VersionList;
import backlog4j.impl.VersionImpl;
import backlog4j.impl.VersionListImpl;
import backlog4j.util.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetVersions implements BacklogCommand<VersionList> {

    private final BacklogClient client;
    private       Integer       projectId;

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

    public VersionList execute() {
        checkParameters();
        Object res = client.execute(BACKLOG_GET_VERSIONS, projectId);

        List<Version> versionList = XmlRpcUtil.<Version>toList(VersionImpl.class, res);
        return new VersionListImpl(versionList);
    }
}
