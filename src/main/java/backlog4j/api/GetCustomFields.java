package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.CustomField;
import backlog4j.impl.CustomFieldParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public class GetCustomFields implements BacklogCommand<List<CustomField>> {

    protected final BacklogClient client;
    protected final Map<String, Object> map = new HashMap<String, Object>();

    public GetCustomFields(BacklogClient client) {
        this.client = client;
    }

    public Integer getProjectId() {
        return (Integer) map.get(PROJECT_ID);
    }

    public GetCustomFields setProjectId(Integer projectId) {
        map.put(PROJECT_ID, projectId);

        return this;
    }

    public Integer getIssueTypeId() {
        return (Integer) map.get(ISSUE_TYPE_ID);
    }

    public GetCustomFields setIssueTypeId(Integer issueTypeId) {
        map.put(ISSUE_TYPE_ID, issueTypeId);

        return this;
    }

    @Override
    public List<CustomField> execute() {
        if (getProjectId() == null) {
            throw new BacklogException("projectId is required");
        }

        Object[] res = (Object[]) client.execute(BACKLOG_GET_CUSTOM_FIELDS, map);

        List<CustomField> list = new ArrayList<CustomField>(res.length);

        for (Object o : res) {
            Map<String, Object> map = (Map<String, Object>) o;

            CustomField customField = CustomFieldParser.parse(map);
            if (customField != null) {
                list.add(customField);
            }

        }


        return list;
    }
}
