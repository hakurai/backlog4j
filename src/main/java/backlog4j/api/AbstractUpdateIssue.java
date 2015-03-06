package backlog4j.api;

import backlog4j.Issue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
abstract class AbstractUpdateIssue<S> implements BacklogCommand<Issue> {

    protected final Map<String, Object> map = new HashMap<String, Object>();

    protected abstract S getThis();

    public Integer getParentIssueId() {
        return (Integer) map.get(PARENT_ISSUE_ID);
    }

    public S setParentIssueId(Integer parentIssueId) {
        map.put(PARENT_ISSUE_ID, parentIssueId);

        return getThis();
    }

    public String getSummary() {
        return (String) map.get(SUMMARY);
    }

    public S setSummary(String summary) {
        map.put(SUMMARY, summary);

        return getThis();
    }

    public String getDescription() {
        return (String) map.get(DESCRIPTION);
    }

    public S setDescription(String description) {
        map.put(DESCRIPTION, description);

        return getThis();
    }

    public String getDueDate() {
        return (String) map.get(DUE_DATE);
    }

    public S setDueDate(String dueDate) {
        map.put(DUE_DATE, dueDate);

        return getThis();
    }

    public String getStartDate() {
        return (String) map.get(START_DATE);
    }

    public S setStartDate(String startDate) {
        map.put(START_DATE, startDate);

        return getThis();
    }

    public BigDecimal getEstimatedHours() {
        return (BigDecimal) map.get(ESTIMATED_HOURS);
    }

    public S setEstimatedHours(Double estimatedHours) {
        return setEstimatedHours(new BigDecimal(estimatedHours));
    }

    public S setEstimatedHours(BigDecimal estimatedHours) {
        map.put(ESTIMATED_HOURS, estimatedHours.setScale(2, RoundingMode.HALF_EVEN));

        return getThis();
    }

    public BigDecimal getActualHours() {
        return (BigDecimal) map.get(ACTUAL_HOURS);
    }

    public S setActualHours(Double actualHours) {
        return setActualHours(new BigDecimal(actualHours));
    }

    public S setActualHours(BigDecimal actualHours) {
        map.put(ACTUAL_HOURS, actualHours);

        return getThis();
    }

    public Integer getIssueTypeId() {
        return (Integer) map.get(ISSUE_TYPE_ID);
    }

    public S setIssueTypeId(Integer issueTypeId) {
        map.put(ISSUE_TYPE_ID, issueTypeId);

        return getThis();
    }

    public Integer getPriorityId() {
        return (Integer) map.get(PRIORITY_ID);
    }

    public S setPriorityId(Integer priorityId) {
        map.put(PRIORITY_ID, priorityId);

        return getThis();
    }

    public List<Integer> getComponentId() {
        return (List<Integer>) map.get(COMPONENT_ID);
    }

    public S setComponentId(Integer componentId) {
        return setValue(COMPONENT_ID, componentId);
    }

    public S addComponentId(Integer componentId) {
        return addValue(COMPONENT_ID, componentId);
    }

    public List<Integer> getVersionId() {
        return (List<Integer>) map.get(VERSION_ID);
    }

    public S setVersionId(Integer versionId) {
        return setValue(VERSION_ID, versionId);
    }

    public S addVersionId(int versionId) {
        return addValue(VERSION_ID, versionId);
    }

    public List<Integer> getMilestoneId() {
        return (List<Integer>) map.get(MILESTONE_ID);
    }

    public S setMilestoneId(Integer milestoneId) {
        return setValue(MILESTONE_ID, milestoneId);
    }

    public S addMilestonId(int milestone) {
        return addValue(MILESTONE_ID, milestone);
    }

    public Integer getAssignerId() {
        return (Integer) map.get(ASSIGNER_ID);
    }

    public S setAssignerId(int assignerId) {
        map.put(ASSIGNER_ID, assignerId);

        return getThis();
    }

    protected <V> S setValue(String name, V value) {
        List<V> list = (List<V>) map.get(name);
        if (list != null && !list.isEmpty()) {
            list.clear();
        }
        addValue(name, value);

        return getThis();
    }

    protected <V> S addValue(String name, V value) {
        List<V> list = (List<V>) map.get(name);
        if (list == null) {
            list = new ArrayList<V>();
            map.put(name, list);
        }
        list.add(value);

        return getThis();
    }

    public S setCustomFieldValue(Integer customFieldId, String value) {
        Map<String, Object> customFieldObject = ensureCustomFieldObject(customFieldId);
        customFieldObject.put("values", value);

        return getThis();
    }

    public S setCustomFieldValue(Integer customFieldId, Integer value) {
        Map<String, Object> customFieldObject = ensureCustomFieldObject(customFieldId);
        customFieldObject.put("values", value);

        return getThis();
    }

    public S setCustomFieldValue(Integer customFieldId, List<Integer> values) {
        Map<String, Object> customFieldObject = ensureCustomFieldObject(customFieldId);
        customFieldObject.put("values", values);

        return getThis();
    }
    
    public Object getCustomFieldValue(Integer customFieldId) {
        Map<String, Object> object = getCustomFieldObject(customFieldId);
        if(object != null){
            return object.get("values");
        }else{
            return null;
        }
    }
    
    public Object getCustomFieldOtherText(Integer customFieldId) {
        Map<String, Object> object = getCustomFieldObject(customFieldId);
        if(object != null){
            return object.get("other_text");
        }else{
            return null;
        }
    }

    public S setCustomFieldOtherText(Integer customFieldId, String value) {
        Map<String, Object> customFieldObject = ensureCustomFieldObject(customFieldId);
        customFieldObject.put("other_text", value);

        return getThis();
    }

    private Map<String, Object> ensureCustomFieldObject(Integer customFieldId) {
        Map<String, Object> customFieldObject = getCustomFieldObject(customFieldId);
        if (customFieldObject == null) {
            customFieldObject = new HashMap<String, Object>();
            customFieldObject.put("id", customFieldId);
            addCustomFieldObject(customFieldObject);
        }
        return customFieldObject;
    }

    private Map<String, Object> getCustomFieldObject(Integer customFieldId) {
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> customFields = (List<Map<String, Object>>) map.get("custom_fields");
        if (customFields != null) {
            for (Map<String, Object> customFieldObj : customFields) {
                if (customFieldObj.get("id").equals(customFieldId)) {
                    return customFieldObj;
                }
            }
        }
        return null;
    }

    private void addCustomFieldObject(Map<String, Object> obj) {
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> customFields = (List<Map<String, Object>>) map.get("custom_fields");
        if (customFields == null) {
            customFields = new ArrayList<Map<String, Object>>();
            map.put("custom_fields", customFields);
        }

        customFields.add(obj);
    }
}
