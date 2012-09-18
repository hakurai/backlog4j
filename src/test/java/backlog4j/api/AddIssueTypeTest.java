package backlog4j.api;

import backlog4j.IssueType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class AddIssueTypeTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkAddIssueType() throws Exception {
        final int projectId = 1073771652;

        IssueType issueType = mutableClient.addIssueType().setProjectId(projectId).setName("newIssueType").setColor("#e30000").execute();

        assertThat(issueType.getName(), is("newIssueType"));
        assertThat(issueType.getColor(), is("#e30000"));

        mutableClient.deleteIssueType().setId(issueType.getId());


    }
}
