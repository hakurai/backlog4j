package backlog4j.impl;

import backlog4j.Resolution;
import backlog4j.ResolutionList;

import java.util.List;

/**
 * @author eguchi
 */
public final class ResolutionListImpl extends BacklogResponse<Resolution> implements ResolutionList {

    private final List<Resolution> delegate;

    public ResolutionListImpl(List<Resolution> delegate) {
        this.delegate = delegate;
    }
    @Override
    public List<Resolution> getDelegate() {
        return delegate;
    }

    @Override
    public Resolution getById(Integer id) {
        return super.getById(delegate, id);
    }

    @Override
    public Resolution getByName(String name) {
        return super.getByName(delegate, name);
    }
}
