package backlog4j.impl;

import backlog4j.NumberCustomField;

import java.util.Map;

/**
 * @author eguchi
 */
public final class NumberCustomFieldImpl extends CustomFieldImpl implements NumberCustomField {

    private final Double min;
    private final Double max;
    private final Double initialValue;
    private final String unit;

    public NumberCustomFieldImpl(Map<String, Object> map) {
        super(map);

        min = (Double) map.get("min");
        max = (Double) map.get("max");
        initialValue = (Double) map.get("initial_value");
        unit = (String) map.get("unit");

    }

    @Override
    public Double getMin() {
        return min;
    }

    @Override
    public Double getMax() {
        return max;
    }

    @Override
    public Double getInitialValue() {
        return initialValue;
    }

    @Override
    public String getUnit() {
        return unit;
    }
}
