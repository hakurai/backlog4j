package backlog4j.api;

import backlog4j.Activity;
import org.junit.Test;

import java.util.List;

/**
 * @author eguchi
 */
public class GetTimelineTest extends BacklogCommandTestBase {

    @Test
    public void testShouldReturnActivities() throws Exception {

        List<Activity> activityList = immutableClient.getTimeline().execute();

    }
}
