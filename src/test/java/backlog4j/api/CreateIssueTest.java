package backlog4j.api;

import backlog4j.Issue;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class CreateIssueTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkCreateIssue() throws Exception {
        final int projectId = 1073771652;

        int count = mutableClient.countIssue().setProjectId(projectId).execute();

        Issue issue = mutableClient.createIssue().setProjectId(projectId).setSummary("test").execute();

        assertThat(issue.getSummary(), is("test"));

        assertThat(mutableClient.countIssue().setProjectId(projectId).execute(), is(count + 1));
    }

}
