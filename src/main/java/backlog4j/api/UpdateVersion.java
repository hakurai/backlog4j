package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Version;
import backlog4j.impl.VersionImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eguchi
 */
public class UpdateVersion implements BacklogCommand<Version> {

    protected final BacklogClient client;
    protected final Map<String, Object> map = new HashMap<String, Object>();

    public UpdateVersion(BacklogClient client) {
        this.client = client;
    }

    public Integer getId() {
        return (Integer) map.get(ID);
    }

    public UpdateVersion setId(Integer id) {
        map.put(ID, id);

        return this;
    }

    public String getName() {
        return (String) map.get(NAME);
    }

    public UpdateVersion setName(String name) {
        map.put(NAME, name);

        return this;
    }

    public String getStartDate() {
        return (String) map.get(START_DATE);
    }

    public UpdateVersion setStartDate(String startDate) {
        map.put(START_DATE, startDate);

        return this;
    }

    public String getDueDate() {
        return (String) map.get(DUE_DATE);
    }

    public UpdateVersion setDueDate(String dueDate) {
        map.put(DUE_DATE, dueDate);

        return this;
    }

    public Boolean isArchived() {
        return (Boolean) map.get(ARCHIVED);
    }

    public UpdateVersion setArchived(Boolean archived) {
        map.put(ARCHIVED, archived);

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
    public Version execute() {
        checkParameters();

        Object res = client.execute(BACKLOG_UPDATE_VERSION, map);
        return new VersionImpl((Map<String, Object>) res);
    }
}
