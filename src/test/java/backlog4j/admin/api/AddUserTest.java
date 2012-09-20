package backlog4j.admin.api;

import backlog4j.BacklogException;
import backlog4j.admin.impl.UserEx;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class AddUserTest extends BacklogAdminCommandTestBase {

    @Test
    public void testShouldAddNewUser() throws Exception {
        UserEx newUser = mutableClient.addUser()
                .setUserId("newUser")
                .setPassword("newUser")
                .setName("newUserName")
                .setMailAddress("test@test.jp")
                .setRole("admin")
                .execute();


        assertThat(newUser.getName(), is("newUserName"));

        mutableClient.deleteUser().setId(newUser.getId()).execute();
    }

    @Test(expected = BacklogException.class)
    public void testShouldThrowException() throws Exception {
        normalUserClient.addUser()
                .setUserId("newUser")
                .setPassword("newUser")
                .setName("newUserName")
                .setMailAddress("test@test.jp")
                .setRole("admin")
                .execute();

    }
}
