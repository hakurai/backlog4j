package backlog4j.api;

import backlog4j.ProjectSummary;
import org.junit.Test;

/**
 * @author eguchi
 */
public class GetProjectSummaryTest extends BacklogCommandTestBase {

    @Test
    public void testShouldReturnProjectSummary() throws Exception {
        final int projectId = 1073771652;
        ProjectSummary projectSummary =
                immutableClient.getProjectSummary().setProjectId(projectId).execute();

    }
}
