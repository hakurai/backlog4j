package backlog4j.api;

import backlog4j.Project;
import org.junit.Test;

/**
 * @author eguchi
 */
public class GetProjectTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkKey() throws Exception {
        GetProject getProject = immutableClient.getProject().setProjectKey("P_1");


        Project project = getProject.execute();

        expectProject1(project);
    }

    @Test
    public void testShouldWorkProjectId() throws Exception {
        GetProject getProject = immutableClient.getProject().setProjectId(PROJECT_ID);

        Project project = getProject.execute();

        expectProject1(project);
    }
}
