package backlog4j.api;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class ConutIssueTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkProjectId() throws Exception {
        int count = client.countIssue().setProjectId(PROJECT_ID).execute();

        assertThat(count, is(5));
    }


    @Test
    public void testShouldWorkPriority() throws Exception {
        int count = client.countIssue().setProjectId(PROJECT_ID).addPriorityId(3).execute();

        assertThat(count, is(4));
    }

    @Test
    public void testShouldWorkProjectIdCreatedUserId() throws Exception {
        int count = client.countIssue().setProjectId(PROJECT_ID).addCreatedUserId(1073806664).execute();

        assertThat(count, is(1));
    }
}
