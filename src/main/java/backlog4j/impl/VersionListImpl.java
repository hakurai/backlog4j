package backlog4j.impl;

import backlog4j.Version;
import backlog4j.VersionList;

import java.util.List;

/**
 * @author eguchi
 */
public final class VersionListImpl extends BacklogResponse<Version> implements VersionList {

    private final List<Version> delegate;

    public VersionListImpl(List<Version> delegate) {
        this.delegate = delegate;
    }
    @Override
    public List<Version> getDelegate() {
        return delegate;
    }

    @Override
    public Version getById(Integer id) {
        return super.getById(delegate, id);
    }

    @Override
    public Version getByName(String name) {
        return super.getByName(delegate, name);
    }
}
