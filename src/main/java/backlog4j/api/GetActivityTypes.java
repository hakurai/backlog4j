package backlog4j.api;

import backlog4j.ActivityType;
import backlog4j.BacklogClient;
import backlog4j.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetActivityTypes implements BacklogCommand<List<ActivityType>> {

    private final BacklogClient client;

    public GetActivityTypes(BacklogClient client) {
        this.client = client;
    }

    public List<ActivityType> execute() {
        Object res = client.execute(BACKLOG_GET_ACTIVITY_TYPES);

        return XmlRpcUtil.toList(ActivityType.class, res);
    }

}
