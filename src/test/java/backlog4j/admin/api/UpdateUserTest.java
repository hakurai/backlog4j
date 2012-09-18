package backlog4j.admin.api;

import backlog4j.admin.impl.UserEx;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class UpdateUserTest extends BacklogAdminCommandTestBase{

    @Test
    public void testShouldUpdateUserName() throws Exception {

        UserEx newUser = mutableClient.addUser()
                .setUserId("newUser")
                .setPassword("newUser")
                .setName("newUserName")
                .setMailAddress("test@test.jp")
                .setRole("admin")
                .execute();

        UserEx updatedUser = mutableClient.updateUser().setId(newUser.getId()).setName("updatedName").execute();


        assertThat(updatedUser.getName(), is("updatedName"));

        mutableClient.deleteUser().setId(newUser.getId()).execute();
    }
}
