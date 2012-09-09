package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogClientImpl;
import backlog4j.Issue;
import backlog4j.conf.BacklogConfigureImpl;
import backlog4j.conf.MutableSpaceConfigure;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class CreateIssueTest extends BacklogCommandTestBase{

    @Test
    public void testShouldWorkCreateIssue() throws Exception {
        final int projectId = 1073771652;
        BacklogClient client = new BacklogClientImpl(MutableSpaceConfigure.getInstance());

        int count = client.countIssue().setProjectId(projectId).execute();

        Issue issue = client.createIssue().setProjectId(projectId).setSummary("test").execute();

        assertThat(issue.getSummary(), is("test"));

        assertThat(client.countIssue().setProjectId(projectId).execute(), is(count + 1));
    }

}
