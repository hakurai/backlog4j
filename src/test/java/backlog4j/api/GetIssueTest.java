package backlog4j.api;

import backlog4j.Issue;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class GetIssueTest extends BacklogCommandTestBase {

    @Test
    public void testShouldReturnP_1_1() throws Exception {
        GetIssue getIssue = client.getIssue().setIssueKey("P_1-1");

        Issue issue = getIssue.execute();

        assertThat(issue.getId(), is(1074790283));
        assertThat(issue.getKey(), is("P_1-1"));
        assertThat(issue.getSummary(), is("create new task"));
        assertThat(issue.getDescription(), is("hallo backlog!"));
        assertThat(issue.getUrl(), is("https://b4jtest.backlog.jp/view/P_1-1"));
        assertThat(issue.getDueDate(), is(""));
        assertThat(issue.getStartDate(), nullValue());
        assertThat(issue.getEstimatedHours(), nullValue());
        assertThat(issue.getActualHours(), nullValue());
        assertThat(issue.getIssueType().getName(), is("バグ"));
        assertThat(issue.getPriority().getName(), is("中"));
        assertThat(issue.getResolution(), nullValue());
        assertThat(issue.getStatus().getName(), is("未対応"));
        assertThat(issue.getComponents().size(), is(1));
        assertThat(issue.getVersions().size(), is(1));
        assertThat(issue.getMilestones().size(), is(1));
        assertThat(issue.getCreatedUser().getName(), is("owner"));
        assertThat(issue.getAssigner().getName(), is("owner"));
        assertThat(issue.getCreatedOn(), is("20120818232007"));
        assertThat(issue.getUpdatedOn(), is("20120818232007"));

    }

    @Test
    public void testShouldReturnP_1_2() throws Exception {
        GetIssue getIssue = client.getIssue().setIssueKey("P_1-2");

        Issue issue = getIssue.execute();

        assertThat(issue.getId(), is(1074790284));
        assertThat(issue.getKey(), is("P_1-2"));
        assertThat(issue.getSummary(), is("setup jenkins"));
        assertThat(issue.getDescription(), is(""));
        assertThat(issue.getUrl(), is("https://b4jtest.backlog.jp/view/P_1-2"));
        assertThat(issue.getDueDate(), is("20120820"));
        assertThat(issue.getStartDate(), nullValue());
        assertThat(issue.getEstimatedHours(), nullValue());
        assertThat(issue.getActualHours(), nullValue());
        assertThat(issue.getIssueType().getName(), is("タスク"));
        assertThat(issue.getPriority().getName(), is("中"));
        assertThat(issue.getResolution().getName(), is("対応済み"));
        assertThat(issue.getStatus().getName(), is("完了"));
        assertThat(issue.getComponents().size(), is(2));
        assertThat(issue.getVersions().size(), is(2));
        assertThat(issue.getMilestones().size(), is(2));
        assertThat(issue.getCreatedUser().getName(), is("owner"));
        assertThat(issue.getAssigner().getName(), is("owner"));
        assertThat(issue.getCreatedOn(), is("20120818232128"));
        assertThat(issue.getUpdatedOn(), is("20120819164005"));

    }

    @Test
    public void testShouldReturn1074790283() throws Exception {
        GetIssue getIssue = client.getIssue().setIssueId(1074790283);

        Issue issue = getIssue.execute();

        assertThat(issue.getId(), is(1074790283));
        assertThat(issue.getKey(), is("P_1-1"));
        assertThat(issue.getSummary(), is("create new task"));
        assertThat(issue.getDescription(), is("hallo backlog!"));
        assertThat(issue.getUrl(), is("https://b4jtest.backlog.jp/view/P_1-1"));
        assertThat(issue.getDueDate(), is(""));
        assertThat(issue.getStartDate(), nullValue());
        assertThat(issue.getEstimatedHours(), nullValue());
        assertThat(issue.getActualHours(), nullValue());
        assertThat(issue.getIssueType().getName(), is("バグ"));
        assertThat(issue.getPriority().getName(), is("中"));
        assertThat(issue.getResolution(), nullValue());
        assertThat(issue.getStatus().getName(), is("未対応"));
        assertThat(issue.getComponents().size(), is(1));
        assertThat(issue.getVersions().size(), is(1));
        assertThat(issue.getMilestones().size(), is(1));
        assertThat(issue.getCreatedUser().getName(), is("owner"));
        assertThat(issue.getAssigner().getName(), is("owner"));
        assertThat(issue.getCreatedOn(), is("20120818232007"));
        assertThat(issue.getUpdatedOn(), is("20120818232007"));

    }
}
