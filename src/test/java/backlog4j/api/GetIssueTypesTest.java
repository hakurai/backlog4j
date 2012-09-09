package backlog4j.api;

import backlog4j.IssueType;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class GetIssueTypesTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkGetIssueTypes() throws Exception {
        GetIssueTypes getIssueTypes = client.getIssueTypes().setProjectId(PROJECT_ID);

        List<IssueType> issueTypeList = getIssueTypes.execute();

        assertThat(issueTypeList.size(), is(4));

        IssueType issueType1 = issueTypeList.get(0);
        assertThat(issueType1.getId(), is(1073884674));
        assertThat(issueType1.getName(), is("バグ"));
        assertThat(issueType1.getColor(), is("#990000"));

        IssueType issueType2 = issueTypeList.get(1);
        assertThat(issueType2.getId(), is(1073884675));
        assertThat(issueType2.getName(), is("タスク"));
        assertThat(issueType2.getColor(), is("#7ea800"));

        IssueType issueType3 = issueTypeList.get(2);
        assertThat(issueType3.getId(), is(1073884676));
        assertThat(issueType3.getName(), is("要望"));
        assertThat(issueType3.getColor(), is("#ff9200"));

        IssueType issueType4 = issueTypeList.get(3);
        assertThat(issueType4.getId(), is(1073884677));
        assertThat(issueType4.getName(), is("その他"));
        assertThat(issueType4.getColor(), is("#2779ca"));

    }
}
