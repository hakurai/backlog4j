package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogClientImpl;
import backlog4j.IssueType;
import backlog4j.conf.MutableSpaceConfigure;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class UpdateIssueTypeTest {

    @Test
    public void testShouldWorkUpdateIssueType() throws Exception {
        final int projectId = 1073771652;
        BacklogClient client = new BacklogClientImpl(MutableSpaceConfigure.getInstance());

        IssueType issueType =
                client.addIssueType().setProjectId(projectId).setName("newIssueType").setColor("#e30000").execute();

        IssueType updatedIssueType =
                client.updateIssueType().setId(issueType.getId()).setName("updatedIssueType").setColor("#990000").execute();


        assertThat(updatedIssueType.getName(), is("updatedIssueType"));
        assertThat(updatedIssueType.getColor(), is("#990000"));

        client.deleteIssueType().setId(issueType.getId());


    }
}
