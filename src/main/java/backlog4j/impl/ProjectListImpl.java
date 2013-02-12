package backlog4j.impl;

import backlog4j.Project;
import backlog4j.ProjectList;

import java.util.List;

/**
 * @author eguchi
 */
public final class ProjectListImpl extends BacklogResponse<Project> implements ProjectList {

    private final List<Project> delegate;

    public ProjectListImpl(List<Project> delegate) {
        this.delegate = delegate;
    }
    @Override
    public List<Project> getDelegate() {
        return delegate;
    }

    @Override
    public Project getById(Integer id) {
        return super.getById(delegate, id);
    }

    @Override
    public Project getByName(String name) {
        return super.getByName(delegate, name);
    }
}
