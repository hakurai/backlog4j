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
public class AddIssueTypeTest {

    @Test
    public void testShouldWorkAddIssueType() throws Exception {
        final int projectId = 1073771652;
        BacklogClient client = new BacklogClientImpl(MutableSpaceConfigure.getInstance());

        IssueType issueType = client.addIssueType().setProjectId(projectId).setName("newIssueType").setColor("#e30000").execute();

        assertThat(issueType.getName(), is("newIssueType"));
        assertThat(issueType.getColor(), is("#e30000"));

        client.deleteIssueType().setId(issueType.getId());


    }
}
