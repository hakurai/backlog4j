package backlog4j.admin.impl;

import backlog4j.Project;
import backlog4j.impl.ProjectImpl;

import java.util.Map;

/**
 * @author eguchi
 */
public class ProjectEx implements Project {

    private final Project delegate;

    private final Boolean useChart;
    private final String createdOn;
    private final String updatedOn;

    public ProjectEx(Map<String, Object> map) {
        delegate = new ProjectImpl(map);

        useChart = (Boolean) map.get("use_chart");
        createdOn = (String) map.get("created_on");
        updatedOn = (String) map.get("updated_on");
    }

    @Override
    public Integer getId() {
        return delegate.getId();
    }

    @Override
    public String getName() {
        return delegate.getName();
    }

    @Override
    public String getKey() {
        return delegate.getKey();
    }

    @Override
    public String getUrl() {
        return delegate.getUrl();
    }

    @Override
    public Boolean isArchived() {
        return delegate.isArchived();
    }

    @Override
    public String toString() {
        return delegate.toString();
    }

    public Project getDelegate() {
        return delegate;
    }

    public Boolean getUseChart() {
        return useChart;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectEx projectEx = (ProjectEx) o;

        if (delegate != null ? !delegate.equals(projectEx.delegate) : projectEx.delegate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return delegate != null ? delegate.hashCode() : 0;
    }
}
