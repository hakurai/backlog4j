package backlog4j.api;

import backlog4j.Comment;
import backlog4j.Issue;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class AddCommentTest extends BacklogCommandTestBase {

    @Test
    public void testShouldworkAddComment() throws Exception {
        final int projectId = 1073771652;

        Issue issue = mutableClient.createIssue().setProjectId(projectId).setSummary("test").execute();

        assertThat(issue.getStatus().getName(), is("未対応"));

        Comment commnet = mutableClient.addComment().setKey(issue.getKey()).setContent("Hello backlog!").execute();

        assertThat(commnet.getContent(), is("Hello backlog!"));


    }
}
