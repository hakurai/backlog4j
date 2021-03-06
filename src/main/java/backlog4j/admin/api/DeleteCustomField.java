package backlog4j.admin.api;

import backlog4j.BacklogAdminClient;
import backlog4j.BacklogException;
import backlog4j.CustomField;
import backlog4j.impl.CustomFieldParser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eguchi
 */
public class DeleteCustomField implements BacklogAdminCommand {

    private final BacklogAdminClient client;
    private Integer id;

    public DeleteCustomField(BacklogAdminClient client) {
        this.client = client;
    }


    public DeleteCustomField setId(Integer id) {
        this.id = id;

        return this;
    }

    public Integer getId() {
        return id;
    }

    private void checkParameters() {
        if (getId() == null) {
            throw new BacklogException("id is required");
        }
    }

    @Override
    public CustomField execute() {
        checkParameters();
        Object res = client.execute(BACKLOG_ADMIN_DELETE_CUSTOM_FIELD, getId());

        return CustomFieldParser.parse((Map<String, Object>) res);
    }
}