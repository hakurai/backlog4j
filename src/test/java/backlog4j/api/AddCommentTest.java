package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogClientImpl;
import backlog4j.Comment;
import backlog4j.Issue;
import backlog4j.conf.MutableSpaceConfigure;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class AddCommentTest {

    @Test
    public void testShouldworkAddComment() throws Exception {
        final int projectId = 1073771652;
        BacklogClient client = new BacklogClientImpl(MutableSpaceConfigure.getInstance());

        Issue issue = client.createIssue().setProjectId(projectId).setSummary("test").execute();

        assertThat(issue.getStatus().getName(), is("未対応"));

        Comment commnet = client.addComment().setKey(issue.getKey()).setContent("Hello backlog!").execute();

        assertThat(commnet.getContent(), is("Hello backlog!"));


    }
}
