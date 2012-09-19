package backlog4j.api;

import backlog4j.IssueType;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class DeleteIssueTypeTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkDeleteIssueType() throws Exception {
        final int projectId = 1073771652;

        IssueType deletedIssueType = mutableClient.addIssueType().setProjectId(projectId).setName("deletedIssueType").setColor("#e30000").execute();

        mutableClient.deleteIssueType().setId(deletedIssueType.getId()).execute();

        List<IssueType> issueTypeList = mutableClient.getIssueTypes().setProjectId(projectId).execute();

        assertThat(issueTypeList.contains(deletedIssueType), is(false));

    }
}
