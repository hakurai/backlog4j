package backlog4j.api;

import backlog4j.User;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class GetUsersTest extends BacklogCommandTestBase {

    @Test
    public void testShouldWorkGetUsers() throws Exception {
        GetUsers getUsers = immutableClient.getUsers().setProjectId(PROJECT_ID);
        List<User> userList = getUsers.execute();

        assertThat(userList.size(), is(4));

        User user1 = userList.get(0);
        assertThat(user1.getId(), is(1073806664));
        assertThat(user1.getName(), is("hakurai"));

        User user2 = userList.get(1);
        assertThat(user2.getId(), is(1073806659));
        assertThat(user2.getName(), is("owner"));

        User user3 = userList.get(2);
        assertThat(user3.getId(), is(1073806665));
        assertThat(user3.getName(), is("tom"));

        User user4 = userList.get(3);
        assertThat(user4.getId(), is(1073806666));
        assertThat(user4.getName(), is("uochan"));

    }
}
