package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Category;
import backlog4j.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetComponents {

    private final BacklogClient client;
    private Integer projectId;

    public GetComponents(BacklogClient client) {
        this.client = client;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public GetComponents setProjectId(Integer projectId) {
        this.projectId = projectId;

        return this;
    }

    public List<Category> execute() {
        if (getProjectId() == null) {
            throw new BacklogException();
        }

        Object res = client.execute(BacklogClient.BACKLOG_GETCOMPONENTS, getProjectId());

        return XmlRpcUtil.toList(Category.class, res);
    }
}
