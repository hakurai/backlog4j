package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.Resolution;
import backlog4j.util.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetResolutions implements BacklogCommand<List<Resolution>> {

    private final BacklogClient client;

    public GetResolutions(BacklogClient client) {
        this.client = client;
    }

    public List<Resolution> execute() {
        Object res = client.execute(BACKLOG_GET_RESOLUTIONS);

        return XmlRpcUtil.toList(Resolution.class, res);
    }

}
