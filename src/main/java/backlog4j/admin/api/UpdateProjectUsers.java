package backlog4j.admin.api;

import backlog4j.BacklogAdminClient;
import backlog4j.BacklogException;
import backlog4j.User;
import backlog4j.admin.impl.ProjectUser;
import backlog4j.util.XmlRpcUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public class UpdateProjectUsers implements BacklogAdminCommand {
    private final BacklogAdminClient client;
    private final Map<String, Object> map = new HashMap<String, Object>();

    public UpdateProjectUsers(BacklogAdminClient client) {
        this.client = client;
    }

    public UpdateProjectUsers setProjectId(Integer projectId) {
        map.put(PROJECT_ID, projectId);

        return this;
    }

    public Integer getProjectId() {
        return (Integer) map.get(PROJECT_ID);
    }

    public UpdateProjectUsers addUserId(Integer userId) {
        List<Integer> list = ensureUserIdList();
        list.add(userId);

        return this;
    }

    public UpdateProjectUsers addUserIdList(List<Integer> userId) {
        List<Integer> list = ensureUserIdList();

        list.addAll(userId);

        return this;
    }

    public UpdateProjectUsers addUserList(List<? extends User> userList) {
        List<Integer> list = ensureUserIdList();


        for (User user : userList) {
            list.add(user.getId());
        }

        return this;
    }

    private List<Integer> ensureUserIdList() {
        List<Integer> list = getUserId();
        if (list == null) {
            list = new ArrayList<Integer>();
            map.put(USER_ID, list);
        }

        return list;
    }

    public List<Integer> getUserId() {
        return (List<Integer>) map.get(USER_ID);
    }

    private void checkParameters() {
        if (getProjectId() == null) {
            throw new BacklogException("projectId is required");
        }
        if (getUserId() == null) {
            throw new BacklogException("userId is required");
        }

        if (getUserId().isEmpty()) {
            throw new BacklogException("userId is empty");
        }
    }


    @Override
    public List<ProjectUser> execute() {

        checkParameters();
        Object res = client.execute(BACKLOG_ADMIN_UPDATE_PROJECT_USERS, map);

        return XmlRpcUtil.toList(ProjectUser.class, res);
    }
}