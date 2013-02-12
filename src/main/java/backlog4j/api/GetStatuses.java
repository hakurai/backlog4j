package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.Status;
import backlog4j.StatusList;
import backlog4j.impl.StatusImpl;
import backlog4j.impl.StatusListImpl;
import backlog4j.util.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetStatuses implements BacklogCommand<StatusList> {

    private final BacklogClient client;

    public GetStatuses(BacklogClient client) {
        this.client = client;
    }

    public StatusList execute() {
        Object res = client.execute(BACKLOG_GET_STATUSES);

        List<Status> statusList = XmlRpcUtil.<Status>toList(StatusImpl.class, res);
        return new StatusListImpl(statusList);
    }

}
