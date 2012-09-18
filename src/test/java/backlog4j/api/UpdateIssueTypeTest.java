package backlog4j.api;

import backlog4j.IssueType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class UpdateIssueTypeTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkUpdateIssueType() throws Exception {
        final int projectId = 1073771652;

        IssueType issueType =
                mutableClient.addIssueType().setProjectId(projectId).setName("newIssueType").setColor("#e30000").execute();

        IssueType updatedIssueType =
                mutableClient.updateIssueType().setId(issueType.getId()).setName("updatedIssueType").setColor("#990000").execute();


        assertThat(updatedIssueType.getName(), is("updatedIssueType"));
        assertThat(updatedIssueType.getColor(), is("#990000"));

        mutableClient.deleteIssueType().setId(issueType.getId());


    }
}
