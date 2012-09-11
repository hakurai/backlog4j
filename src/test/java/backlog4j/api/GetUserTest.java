package backlog4j.api;

import backlog4j.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class GetUserTest extends BacklogCommandTestBase {

    @Test
    public void testShouldReturnUser() throws Exception {
        User user = client.getUser().setId(1073806664).execute();

        assertThat(user.getId(), is(1073806664));
        assertThat(user.getName(), is("hakurai"));

    }
}
