package backlog4j.admin.api;

import backlog4j.BacklogAdminClient;
import backlog4j.admin.impl.ProjectEx;
import backlog4j.util.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetProjects implements BacklogAdminCommand<List<ProjectEx>> {

    private final BacklogAdminClient client;

    public GetProjects(BacklogAdminClient client) {
        this.client = client;
    }

    @Override
    public List<ProjectEx> execute() {

        Object res = client.execute(BACKLOG_ADMIN_GET_PROJECTS);

        return XmlRpcUtil.toList(ProjectEx.class, res);
    }
}