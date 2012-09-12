package backlog4j.api;

import backlog4j.Status;
import backlog4j.User;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class GetStatusesTest extends BacklogCommandTestBase {

    @Test
    public void testShouldReturnStatusList() throws Exception {
        List<Status> statusList = client.getStatuses().execute();

        assertThat(statusList.size(), is(4));

    }
}
