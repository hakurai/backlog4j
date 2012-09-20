package backlog4j.admin.api;

import backlog4j.BacklogException;
import backlog4j.admin.impl.UserEx;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class GetUsersTest extends BacklogAdminCommandTestBase {

    @Test
    public void testShouldReturn5Users() throws Exception {
        List<UserEx> userExList = immutableClient.getUsers().execute();

        assertThat(userExList.size(), is(5));

    }

    @Test(expected = BacklogException.class)
    public void testShouldThrowException() throws Exception {
        normalUserClient.getUsers().execute();

    }
}
