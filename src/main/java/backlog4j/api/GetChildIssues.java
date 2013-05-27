package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Issue;
import backlog4j.IssueList;
import backlog4j.impl.IssueImpl;
import backlog4j.impl.IssueListImpl;
import backlog4j.util.XmlRpcUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public class GetChildIssues implements BacklogCommand<Map<String, IssueList>> {

    private final BacklogClient client;
    private       Integer[]     parentIssueIds;

    public GetChildIssues(BacklogClient client) {
        this.client = client;
    }


    public GetChildIssues setParentIssueIds(Integer... parentIssueIds) {
        this.parentIssueIds = parentIssueIds;
        return this;
    }

    public Integer[] getParentIssueIds() {
        return parentIssueIds;
    }

    private void checkParameters() {
        if (getParentIssueIds() == null) {
            throw new BacklogException("parentIssueIds is required");
        }

    }

    @Override
    public Map<String, IssueList> execute() {
        checkParameters();

        Map res = (Map) client.execute(BACKLOG_GET_CHILD_ISSUES, (Object) getParentIssueIds());

        HashMap<String, IssueList> childIssuesMap = new HashMap<String, IssueList>();
        for (Object key : res.keySet()) {
            List<Issue> childIssues = XmlRpcUtil.<Issue>toList(IssueImpl.class, res.get(key));
            childIssuesMap.put((String) key, new IssueListImpl(Collections.unmodifiableList(childIssues)));
        }

        return childIssuesMap;
    }
}
