package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.Priority;
import backlog4j.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetPriorities implements BacklogCommand<List<Priority>> {

    private final BacklogClient client;

    public GetPriorities(BacklogClient client) {
        this.client = client;
    }

    public List<Priority> execute() {
        Object res = client.execute(BACKLOG_GET_PRIORITIES);

        return XmlRpcUtil.toList(Priority.class, res);
    }

}
