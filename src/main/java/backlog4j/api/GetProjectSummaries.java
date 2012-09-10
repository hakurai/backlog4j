package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.ProjectSummary;
import backlog4j.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetProjectSummaries implements BacklogCommand<List<ProjectSummary>> {

    private final BacklogClient client;

    public GetProjectSummaries(BacklogClient client) {
        this.client = client;
    }

    public List<ProjectSummary> execute() {

        Object res = client.execute(BACKLOG_GET_PROJECT_SUMMARIES);

        return XmlRpcUtil.toList(ProjectSummary.class, res);
    }
}
