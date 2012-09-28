package backlog4j.impl;

import backlog4j.StringCustomField;

import java.util.Map;

/**
 * @author eguchi
 */
public final class StringCustomFieldImpl extends CustomFieldImpl implements StringCustomField{

    public StringCustomFieldImpl(Map<String, Object> map) {
        super(map);
    }
}
