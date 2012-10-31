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
        int count = immutableClient.countIssue().setProjectId(PROJECT_ID).execute();

        assertThat(count, is(5));
    }

    @Test
    public void testShouldWorkIssueTypeId() throws Exception {
        int count = immutableClient.countIssue().setProjectId(PROJECT_ID).addIssueTypeId(1073884674).execute();

        assertThat(count, is(3));
    }

    @Test
    public void testShouldWorkIssueType() throws Exception {
        int count = immutableClient.countIssue().setProjectId(PROJECT_ID).addIssueType("バグ").execute();

        assertThat(count, is(3));
    }

    @Test
    public void testShouldWorkComponentId() throws Exception {
        int count = immutableClient.countIssue().setProjectId(PROJECT_ID).addComponentId(1073813651).execute();

        assertThat(count, is(1));
    }

    @Test
    public void testShouldWorkPriority() throws Exception {
        int count = immutableClient.countIssue().setProjectId(PROJECT_ID).addPriorityId(3).execute();

        assertThat(count, is(4));
    }

    @Test
    public void testShouldWorkProjectIdCreatedUserId() throws Exception {
        int count = immutableClient.countIssue().setProjectId(PROJECT_ID).addCreatedUserId(1073806664).execute();

        assertThat(count, is(1));
    }
}
