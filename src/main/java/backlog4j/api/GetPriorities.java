package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.Priority;
import backlog4j.PriorityList;
import backlog4j.impl.PriorityImpl;
import backlog4j.impl.PriorityListImpl;
import backlog4j.util.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetPriorities implements BacklogCommand<PriorityList> {

    private final BacklogClient client;

    public GetPriorities(BacklogClient client) {
        this.client = client;
    }

    public PriorityList execute() {
        Object res = client.execute(BACKLOG_GET_PRIORITIES);

        List<Priority> priorityList = XmlRpcUtil.<Priority>toList(PriorityImpl.class, res);
        return new PriorityListImpl(priorityList);
    }

}
