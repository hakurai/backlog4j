package backlog4j.api;

import backlog4j.ProjectSummary;
import org.junit.Test;

import java.util.List;

/**
 * @author eguchi
 */
public class GetProjectSummariesTest extends BacklogCommandTestBase {

    @Test
    public void testShouldReturnProjectSummaryList() throws Exception {
        final int projectId = 1073771652;
        List<ProjectSummary> projectSummaryList =
                client.getProjectSummaries().execute();

    }
}
