package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.Project;
import backlog4j.impl.ProjectImpl;
import backlog4j.util.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetProjects implements BacklogCommand<List<Project>> {

    private final BacklogClient client;

    public GetProjects(BacklogClient client) {
        this.client = client;
    }

    public List<Project> execute() {
        Object res = client.execute(BACKLOG_GET_PROJECTS);

        return XmlRpcUtil.<Project>toList(ProjectImpl.class, res);
    }
}
