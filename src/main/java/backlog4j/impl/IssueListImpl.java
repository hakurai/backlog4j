package backlog4j.impl;

import backlog4j.Issue;
import backlog4j.IssueList;

import java.util.List;

/**
 * @author eguchi
 */
public final class IssueListImpl extends BacklogResponse<Issue> implements IssueList {

    private final List<Issue> delegate;

    public IssueListImpl(List<Issue> delegate) {
        this.delegate = delegate;
    }
    @Override
    public List<Issue> getDelegate() {
        return delegate;
    }

    @Override
    public Issue getById(Integer id) {
        return super.getById(delegate, id);
    }

    public Issue getByKey(String key) {
        for (Issue issue : delegate) {
            if (issue.getKey().equals(key)) {
                return issue;
            }
        }
        return null;
    }


}
