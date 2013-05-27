package backlog4j.admin.api;

import backlog4j.BacklogAdminClient;
import backlog4j.BacklogException;
import backlog4j.admin.impl.ProjectEx;

import java.util.Map;

/**
 * @author eguchi
 */
public class DeleteProject implements BacklogAdminCommand<ProjectEx> {

    private final BacklogAdminClient client;
    private       Integer            id;

    public DeleteProject(BacklogAdminClient client) {
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public DeleteProject setId(Integer id) {
        this.id = id;

        return this;
    }

    private void checkParameters() {
        if (getId() == null) {
            throw new BacklogException("id is required");
        }
    }

    @Override
    public ProjectEx execute() {
        checkParameters();

        Object res = client.execute(BACKLOG_ADMIN_DELETE_PROJECT, getId());

        return new ProjectEx((Map<String, Object>) res);
    }
}