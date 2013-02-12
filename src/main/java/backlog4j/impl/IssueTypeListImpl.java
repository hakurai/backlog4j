package backlog4j.impl;

import backlog4j.IssueType;
import backlog4j.IssueTypeList;

import java.util.List;

/**
 * @author eguchi
 */
public final class IssueTypeListImpl extends BacklogResponse<IssueType> implements IssueTypeList {

    private final List<IssueType> delegate;

    public IssueTypeListImpl(List<IssueType> delegate) {
        this.delegate = delegate;
    }
    @Override
    public List<IssueType> getDelegate() {
        return delegate;
    }

    @Override
    public IssueType getById(Integer id) {
        return super.getById(delegate, id);
    }

    @Override
    public IssueType getByName(String name) {
        return super.getByName(delegate, name);
    }
}
