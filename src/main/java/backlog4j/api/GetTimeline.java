package backlog4j.api;

import backlog4j.Activity;
import backlog4j.BacklogClient;
import backlog4j.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetTimeline implements BacklogCommand<List<Activity>> {

    private final BacklogClient client;

    public GetTimeline(BacklogClient client) {
        this.client = client;
    }

    public List<Activity> execute() {
        Object res = client.execute(BACKLOG_GET_TIMELINE);

        return XmlRpcUtil.toList(Activity.class, res);
    }
}
