package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.Project;
import backlog4j.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetProjects {

    private final BacklogClient client;

    public GetProjects(BacklogClient client) {
        this.client = client;
    }

    public List<Project> execute() {
        Object res = client.execute(BacklogClient.BACKLOG_GETPROJECTS);

        return XmlRpcUtil.toList(Project.class, res);
    }
}
