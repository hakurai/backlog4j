package backlog4j.impl;

import backlog4j.Status;
import backlog4j.StatusList;

import java.util.List;

/**
 * @author eguchi
 */
public final class StatusListImpl extends BacklogResponse<Status> implements StatusList {

    private final List<Status> delegate;

    public StatusListImpl(List<Status> delegate) {
        this.delegate = delegate;
    }
    @Override
    public List<Status> getDelegate() {
        return delegate;
    }

    @Override
    public Status getById(Integer id) {
        return super.getById(delegate, id);
    }

    @Override
    public Status getByName(String name) {
        return super.getByName(delegate, name);
    }
}
