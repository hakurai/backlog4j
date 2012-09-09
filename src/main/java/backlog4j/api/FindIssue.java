package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.Issue;
import backlog4j.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class FindIssue extends AbstractFindIssueRequest<List<Issue>> {


    private final BacklogClient client;

    public FindIssue(BacklogClient client) {
        this.client = client;
    }

    public String getSort() {
        return (String) map.get(SORT);
    }

    public FindIssue setSort(String sort) {
        map.put(SORT, sort);

        return this;
    }


    public Boolean getOrder() {
        return (Boolean) map.get(ORDER);
    }

    public FindIssue setOrder(boolean order) {
        map.put(ORDER, order);

        return this;
    }

    public Integer getOffset() {
        return (Integer) map.get(OFFSET);
    }

    public FindIssue setOffset(int offset) {
        map.put(OFFSET, offset);

        return this;
    }

    public Integer getLimit() {
        return (Integer) map.get(LIMIT);
    }

    public FindIssue setLimit(int limit) {
        if (limit > MAX_LIMIT || limit < 0) {
            throw new IllegalArgumentException();
        }
        map.put(LIMIT, limit);

        return this;
    }

    public List<Issue> execute() {
        Object res = client.execute(BACKLOG_FINDISSUE, map);

        return XmlRpcUtil.toList(Issue.class, res);
    }

}
