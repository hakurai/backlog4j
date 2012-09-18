package backlog4j.api;

import backlog4j.Comment;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class GetCommentsTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkGetComments() throws Exception {
        GetComments getComments = immutableClient.getComments().setIssueId(1074790284);

        List<Comment> comments = getComments.execute();

        assertThat(comments.size(), is(2));

        Comment comment1 = comments.get(0);
        assertThat(comment1.getId(), is(1078454063));
        assertThat(comment1.getContent(), is("completed!"));
        assertThat(comment1.getCreatedUser().getName(), is("owner"));
        assertThat(comment1.getCreatedOn(), is("20120819163901"));
        assertThat(comment1.getUpdatedOn(), is("20120819163901"));

        Comment comment2 = comments.get(1);
        assertThat(comment2.getId(), is(1078454287));
        assertThat(comment2.getContent(), is("update!"));
        assertThat(comment2.getCreatedUser().getName(), is("owner"));
        assertThat(comment2.getCreatedOn(), is("20120819183620"));
        assertThat(comment2.getUpdatedOn(), is("20120819183630"));
    }
}
