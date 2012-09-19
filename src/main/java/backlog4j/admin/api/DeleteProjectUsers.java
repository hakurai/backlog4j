package backlog4j.admin.api;

import backlog4j.BacklogAdminClient;
import backlog4j.BacklogException;
import backlog4j.admin.impl.ProjectUser;
import backlog4j.util.XmlRpcUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public class DeleteProjectUsers implements BacklogAdminCommand<List<ProjectUser>> {

    private final BacklogAdminClient client;
    private final Map<String, Object> map = new HashMap<String, Object>();

    public DeleteProjectUsers(BacklogAdminClient client) {
        this.client = client;
    }

    public DeleteProjectUsers setProjectId(Integer projectId) {
        map.put(PROJECT_ID, projectId);

        return this;
    }

    public Integer getProjectId() {
        return (Integer) map.get(PROJECT_ID);
    }

    public DeleteProjectUsers setUserId(Integer userId) {
        map.put(USER_ID, userId);

        return this;
    }

    public Integer getUserId() {
        return (Integer) map.get(USER_ID);
    }

    private void checkParameters() {
        if (getProjectId() == null) {
            throw new BacklogException("projectId is required");
        }
        if (getUserId() == null) {
            throw new BacklogException("userId is required");
        }
    }


    @Override
    public List<ProjectUser> execute() {

        checkParameters();
        Object res = client.execute(BACKLOG_ADMIN_DELETE_PROJECT_USER, map);

        return XmlRpcUtil.toList(ProjectUser.class, res);
    }
}