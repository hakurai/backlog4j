package backlog4j.impl;

import backlog4j.DateCustomField;

import java.util.Map;

/**
 * @author eguchi
 */
public final class DateCustomFieldImpl extends CustomFieldImpl implements DateCustomField {


    private final InitialValueType initialValueType;
    private final Integer          initialShift;
    private final String           initialiDate;
    private final String           min;
    private final String           max;


    public DateCustomFieldImpl(Map<String, Object> map) {
        super(map);
        initialValueType = InitialValueType.valueOf((Integer) map.get("initial_value_type"));
        initialShift = (Integer) map.get("initial_shift");
        initialiDate = (String) map.get("initial_date");
        min = (String) map.get("min");
        max = (String) map.get("max");
    }

    @Override
    public InitialValueType getInitialValueType() {
        return initialValueType;
    }

    @Override
    public Integer getInitialShift() {
        return initialShift;
    }

    @Override
    public String getInitialDate() {
        return initialiDate;
    }

    @Override
    public String getMin() {
        return min;
    }

    @Override
    public String getMax() {
        return max;
    }
}
