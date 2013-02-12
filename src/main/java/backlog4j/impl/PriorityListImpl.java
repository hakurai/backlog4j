package backlog4j.impl;

import backlog4j.Priority;
import backlog4j.PriorityList;

import java.util.List;

/**
 * @author eguchi
 */
public final class PriorityListImpl extends BacklogResponse<Priority> implements PriorityList {

    private final List<Priority> delegate;

    public PriorityListImpl(List<Priority> delegate) {
        this.delegate = delegate;
    }
    @Override
    public List<Priority> getDelegate() {
        return delegate;
    }

    @Override
    public Priority getById(Integer id) {
        return super.getById(delegate, id);
    }

    @Override
    public Priority getByName(String name) {
        return super.getByName(delegate, name);
    }
}
