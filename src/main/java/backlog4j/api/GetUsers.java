package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.User;
import backlog4j.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetUsers {

    private final BacklogClient client;
    private Integer projectId;

    public GetUsers(BacklogClient client) {
        this.client = client;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public GetUsers setProjectId(Integer projectId) {
        this.projectId = projectId;

        return this;
    }

    public List<User> execute() {
        if (getProjectId() == null) {
            throw new BacklogException();
        }

        Object res = client.execute(BacklogClient.BACKLOG_GETUSERS, getProjectId());

        return XmlRpcUtil.toList(User.class, res);
    }
}
