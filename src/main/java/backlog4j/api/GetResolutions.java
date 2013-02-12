package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.Resolution;
import backlog4j.ResolutionList;
import backlog4j.impl.ResolutionImpl;
import backlog4j.impl.ResolutionListImpl;
import backlog4j.util.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetResolutions implements BacklogCommand<ResolutionList> {

    private final BacklogClient client;

    public GetResolutions(BacklogClient client) {
        this.client = client;
    }

    public ResolutionList execute() {
        Object res = client.execute(BACKLOG_GET_RESOLUTIONS);

        List<Resolution> resolutionList = XmlRpcUtil.<Resolution>toList(ResolutionImpl.class, res);
        return new ResolutionListImpl(resolutionList);
    }

}
