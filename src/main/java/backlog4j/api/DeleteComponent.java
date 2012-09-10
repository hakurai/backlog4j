package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Category;

import java.util.Map;

/**
 * @author eguchi
 */
public class DeleteComponent implements BacklogCommand<Category> {

    protected final BacklogClient client;
    protected Integer id;

    public DeleteComponent(BacklogClient client) {
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public DeleteComponent setId(Integer id) {
        this.id = id;

        return this;
    }

    private void checkParameters() {
        if (getId() == null) {
            throw new BacklogException("id is required");
        }

    }

    @Override
    public Category execute() {
        checkParameters();

        Object res = client.execute(BACKLOG_DELETE_COMPONENT, id);
        return new Category((Map<String, Object>) res);
    }
}
