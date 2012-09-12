package backlog4j.api;

import backlog4j.Activity;
import backlog4j.BacklogClient;
import backlog4j.BacklogClientImpl;
import backlog4j.conf.MutableSpaceConfigure;
import org.junit.Test;

import java.util.List;

/**
 * @author eguchi
 */
public class GetTimelineTest {

    @Test
    public void testShouldReturnActivities() throws Exception {
        BacklogClient client = new BacklogClientImpl(MutableSpaceConfigure.getInstance());

        List<Activity> activityList = client.getTimeline().execute();

    }
}
