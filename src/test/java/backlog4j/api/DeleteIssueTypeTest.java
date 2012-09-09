package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogClientImpl;
import backlog4j.IssueType;
import backlog4j.conf.MutableSpaceConfigure;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class DeleteIssueTypeTest {

    @Test
    public void testShouldWorkDeleteIssueType() throws Exception {
        final int projectId = 1073771652;
        BacklogClient client = new BacklogClientImpl(MutableSpaceConfigure.getInstance());

        IssueType deletedIssueType = client.addIssueType().setProjectId(projectId).setName("deletedIssueType").setColor("#e30000").execute();

        client.deleteIssueType().setId(deletedIssueType.getId());

        List<IssueType> issueTypeList = client.getIssueTypes().setProjectId(projectId).execute();

        assertThat(issueTypeList.contains(deletedIssueType), is(false));

    }
}
