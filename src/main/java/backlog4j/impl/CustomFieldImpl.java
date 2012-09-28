package backlog4j.impl;

import backlog4j.CustomField;
import backlog4j.IssueType;
import backlog4j.util.XmlRpcUtil;

import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public abstract class CustomFieldImpl implements CustomField {

    private final Integer id;
    private final Type typeId;
    private final String name;
    private final String description;
    private final Boolean required;
    private final List<IssueType> issueTypes;

    protected CustomFieldImpl(Map<String, Object> map) {
        id = (Integer) map.get("id");
        typeId = Type.valueOf((Integer) map.get("type_id"));
        name = (String) map.get("name");
        description = (String) map.get("description");
        required = (Boolean) map.get("required");
        issueTypes = XmlRpcUtil.<IssueType>toList(IssueTypeImpl.class, map.get("issueTypes"));

    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Type getTypeId() {
        return typeId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Boolean isRequired() {
        return required;
    }

    @Override
    public List<IssueType> getIssueTypes() {
        return issueTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomFieldImpl that = (CustomFieldImpl) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
