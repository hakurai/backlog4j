package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.Status;
import backlog4j.impl.StatusImpl;
import backlog4j.util.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetStatuses implements BacklogCommand<List<Status>> {

    private final BacklogClient client;

    public GetStatuses(BacklogClient client) {
        this.client = client;
    }

    public List<Status> execute() {
        Object res = client.execute(BACKLOG_GET_STATUSES);

        return XmlRpcUtil.<Status>toList(StatusImpl.class, res);
    }

}
