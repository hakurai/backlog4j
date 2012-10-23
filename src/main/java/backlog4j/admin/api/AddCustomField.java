package backlog4j.admin.api;

import backlog4j.BacklogAdminClient;
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
public class AddCustomField implements BacklogAdminCommand {

    private final BacklogAdminClient client;
    private final Map<String, Object> map = new HashMap<String, Object>();

    public AddCustomField(BacklogAdminClient client) {
        this.client = client;
    }

    public AddCustomField setProjectId(Integer projectId) {
        map.put(PROJECT_ID, projectId);

        return this;
    }

    public Integer getProjectId() {
        return (Integer) map.get(PROJECT_ID);
    }

    public AddCustomField setTypeId(Integer typeId) {
        CustomField.Type.valueOf(typeId);//check
        map.put(TYPE_ID, typeId);

        return this;
    }

    public Integer getTypeId() {
        return (Integer) map.get(TYPE_ID);
    }

    public AddCustomField setType(CustomField.Type type) {
        Integer typeId = type == null ? null : type.getId();
        return setTypeId(typeId);
    }

    public AddCustomField setName(String name) {
        map.put(NAME, name);

        return this;
    }

    public String getName() {
        return (String) map.get(NAME);
    }

    public AddCustomField addIssueType(Integer issueTypeId) {
        List<Integer> issueTypes = getIssueTypes();
        if (issueTypes == null) {
            issueTypes = new ArrayList<Integer>();
            map.put(ISSUE_TYPES, issueTypes);
        }

        issueTypes.add(issueTypeId);

        return this;
    }

    public List<Integer> getIssueTypes() {
        return (List<Integer>) map.get(ISSUE_TYPES);
    }

    public AddCustomField setDescription(String description) {
        map.put(DESCRIPTION, description);

        return this;
    }

    public String getDescription() {
        return (String) map.get(DESCRIPTION);
    }

    public AddCustomField setRequired(Boolean required) {
        map.put(REQUIRED, required);

        return this;
    }

    public Boolean isRequired() {
        return (Boolean) map.get(REQUIRED);
    }

    public AddCustomField setMin(Double min) {
        map.put(MIN, min);

        return this;
    }

    public AddCustomField setMin(String min) {
        map.put(MIN, min);

        return this;
    }

    public Object getMin() {
        return map.get(MIN);
    }

    public AddCustomField setMax(Double max) {
        map.put(MAX, max);

        return this;
    }

    public AddCustomField setMax(String max) {
        map.put(MAX, max);

        return this;
    }

    public Object getMax() {
        return map.get(MAX);
    }

    public AddCustomField setInitialValue(Double initialValue) {
        map.put(INITIAL_VALUE, initialValue);

        return this;
    }

    public Double getInitialValue() {
        return (Double) map.get(INITIAL_VALUE);
    }

    public AddCustomField setUnit(String unit) {
        map.put(UNIT, unit);

        return this;
    }

    public String getUnit() {
        return (String) map.get(UNIT);
    }

    public AddCustomField setInitialValueType(Integer initialValueType) {
        map.put(INITIAL_VALUE_TYPE, initialValueType);
        return this;
    }

    public Integer getInitialValueType() {
        return (Integer) map.get(INITIAL_VALUE_TYPE);
    }

    public AddCustomField setInitialShift(Integer initialShift) {
        map.put(INITIAL_SHIFT, initialShift);
        return this;
    }

    public Integer getInitialShift() {
        return (Integer) map.get(INITIAL_SHIFT);
    }

    public AddCustomField setInitialDate(String initialDate) {
        map.put(INITIAL_DATE, initialDate);

        return this;
    }

    public String getInitialDate() {
        return (String) map.get(INITIAL_DATE);
    }

    public AddCustomField addItem(String item) {
        List<String> items = getItems();
        if (items == null) {
            items = new ArrayList<String>();
            map.put(ITEMS, items);
        }

        items.add(item);

        return this;
    }

    public List<String> getItems() {
        return (List<String>) map.get(ITEMS);
    }

    public AddCustomField setAllowInput(Boolean allowInput) {
        map.put(ALLOW_INPUT, allowInput);

        return this;
    }

    public Boolean isAllowInput() {
        return (Boolean) map.get(ALLOW_INPUT);
    }

    private void checkParameters() {
        if (getProjectId() == null) {
            throw new BacklogException("projectId is required");
        }
        if (getTypeId() == null) {
            throw new BacklogException("typeId is required");
        }
        if (getName() == null) {
            throw new BacklogException("name is required");
        }
    }


    @Override
    public CustomField execute() {
        checkParameters();
        Object res = client.execute(BACKLOG_ADMIN_ADD_CUSTOM_FIELD, map);

        return CustomFieldParser.parse((Map<String, Object>) res);
    }
}
