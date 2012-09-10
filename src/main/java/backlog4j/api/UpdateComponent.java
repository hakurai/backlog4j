package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Category;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eguchi
 */
public class UpdateComponent implements BacklogCommand<Category> {

    protected final BacklogClient client;
    protected final Map<String, Object> map = new HashMap<String, Object>();

    public UpdateComponent(BacklogClient client) {
        this.client = client;
    }

    public Integer getId() {
        return (Integer) map.get(ID);
    }

    public UpdateComponent setId(Integer id) {
        map.put(ID, id);

        return this;
    }

    public String getName() {
        return (String) map.get(NAME);
    }

    public UpdateComponent setName(String name) {
        map.put(NAME, name);

        return this;
    }

    private void checkParameters() {
        if (getId() == null) {
            throw new BacklogException("id is required");
        }
        if (getName() == null) {
            throw new BacklogException("name is required");
        }

    }

    @Override
    public Category execute() {
        checkParameters();

        Object res = client.execute(BACKLOG_UPDATE_COMPONENT, map);
        return new Category((Map<String, Object>) res);
    }
}
