package backlog4j.api;

import backlog4j.Issue;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class FindIssueTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkFindIssue() throws Exception {
        List<Issue> issueList = immutableClient.findIssue().setProjectId(PROJECT_ID).execute();

        assertThat(issueList.size(), is(5));

        Issue p_1_1 = issueList.get(4);
        assertThat(p_1_1.getId(), is(1074790283));
        assertThat(p_1_1.getKey(), is("P_1-1"));
        assertThat(p_1_1.getSummary(), is("create new task"));
        assertThat(p_1_1.getDescription(), is("hallo backlog!"));
        assertThat(p_1_1.getUrl(), is("https://b4jtest.backlog.jp/view/P_1-1"));
        assertThat(p_1_1.getDueDate(), is(""));
        assertThat(p_1_1.getStartDate(), nullValue());
        assertThat(p_1_1.getEstimatedHours(), nullValue());
        assertThat(p_1_1.getActualHours(), nullValue());
        assertThat(p_1_1.getIssueType().getName(), is("バグ"));
        assertThat(p_1_1.getPriority().getName(), is("中"));
        assertThat(p_1_1.getResolution(), nullValue());
        assertThat(p_1_1.getStatus().getName(), is("未対応"));
        assertThat(p_1_1.getComponents().size(), is(1));
        assertThat(p_1_1.getVersions().size(), is(1));
        assertThat(p_1_1.getMilestones().size(), is(1));
        assertThat(p_1_1.getCreatedUser().getName(), is("owner"));
        assertThat(p_1_1.getAssigner().getName(), is("owner"));
        assertThat(p_1_1.getCreatedOn(), is("20120818232007"));
        assertThat(p_1_1.getUpdatedOn(), is("20120818232007"));
    }
}
