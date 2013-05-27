package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Issue;
import backlog4j.IssueList;
import backlog4j.impl.IssueImpl;
import backlog4j.impl.IssueListImpl;
import backlog4j.util.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class FindIssue extends AbstractFindIssueRequest<IssueList, FindIssue> {


    private final BacklogClient client;

    public FindIssue(BacklogClient client) {
        this.client = client;
    }

    @Override
    protected FindIssue getThis() {
        return this;
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

    private void checkParameters() {
        if (getProjectId() == null) {
            throw new BacklogException("projectId is required");
        }
    }

    public IssueList execute() {
        checkParameters();
        Object res = client.execute(BACKLOG_FIND_ISSUE, map);

        List<Issue> issueList = XmlRpcUtil.<Issue>toList(IssueImpl.class, res);
        return new IssueListImpl(issueList);
    }

}
