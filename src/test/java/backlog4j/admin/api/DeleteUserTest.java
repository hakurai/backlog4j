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
public class DeleteUserTest extends BacklogAdminCommandTestBase {

    @Test
    public void testShouldDeleteUser() throws Exception {
        int size = immutableClient.getUsers().execute().size();


        UserEx newUser = mutableClient.addUser()
                .setUserId("newUser")
                .setPassword("newUser")
                .setName("newUserName")
                .setMailAddress("test@test.jp")
                .setRole("admin")
                .execute();


        mutableClient.deleteUser().setId(newUser.getId()).execute();

        List<UserEx> userExList = immutableClient.getUsers().execute();

        assertThat(userExList.size(), is(size));


    }

    @Test(expected = BacklogException.class)
    public void testShouldThrowException() throws Exception {

        normalUserClient.deleteUser().setId(1073804493).execute();


    }
}
