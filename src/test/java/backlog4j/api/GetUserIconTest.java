package backlog4j.api;

import backlog4j.UserIcon;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class GetUserIconTest extends BacklogCommandTestBase {

    @Test
    public void testShouldReturnUserIcon() throws Exception {
        UserIcon user = immutableClient.getUserIcon().setId(1073806664).execute();

        assertThat(user.getId(), is(1073806664));
    }
}
