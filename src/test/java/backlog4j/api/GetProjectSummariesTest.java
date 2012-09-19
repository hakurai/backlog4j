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

        List<ProjectSummary> projectSummaryList = immutableClient.getProjectSummaries().execute();

    }
}
