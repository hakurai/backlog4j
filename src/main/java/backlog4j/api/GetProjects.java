package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.Project;
import backlog4j.ProjectList;
import backlog4j.impl.ProjectImpl;
import backlog4j.impl.ProjectListImpl;
import backlog4j.util.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetProjects implements BacklogCommand<ProjectList> {

    private final BacklogClient client;

    public GetProjects(BacklogClient client) {
        this.client = client;
    }

    public ProjectList execute() {
        Object res = client.execute(BACKLOG_GET_PROJECTS);

        List<Project> projectList = XmlRpcUtil.<Project>toList(ProjectImpl.class, res);
        return new ProjectListImpl(projectList);
    }
}
