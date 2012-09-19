package backlog4j.admin.api;

import backlog4j.BacklogAdminClient;
import backlog4j.BacklogException;
import backlog4j.Issue;
import backlog4j.admin.impl.UserEx;
import backlog4j.util.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetProjectUsers implements BacklogAdminCommand<List<UserEx>> {

    private final BacklogAdminClient client;
    private Integer projectId;

    public GetProjectUsers(BacklogAdminClient client) {
        this.client = client;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public GetProjectUsers setProjectId(Integer projectId) {
        this.projectId = projectId;

        return this;
    }

    @Override
    public List<UserEx> execute() {
        if( getProjectId() == null ){
            throw new BacklogException("projectId is required");
        }

        Object res = client.execute(BACKLOG_ADMIN_GET_PROJECT_USERS,getProjectId());

        return XmlRpcUtil.toList(UserEx.class, res);
    }
}