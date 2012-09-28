package backlog4j.impl;

import backlog4j.CustomField;

import java.util.Map;

/**
 * @author eguchi
 */
public final class CustomFieldParser {

    public static CustomField parse(Map<String, Object> map) {

        CustomField.Type type = CustomField.Type.valueOf((Integer) map.get("type_id"));

        CustomField customField;
        switch (type) {
            case STRING:
                customField = new StringCustomFieldImpl(map);
                break;

            case TEXT:
                customField = new TextCustomFieldImpl(map);
                break;

            case NUMBER:
                customField = new NumberCustomFieldImpl(map);
                break;

            case DATE:
                customField = new DateCustomFieldImpl(map);
                break;

            case SINGLE_LIST:
            case MULTIPLE_LIST:
                customField = new ListCustomFieldImpl(map);
                break;

            case CHECKBOX:
            case RADIO:
                customField = new SelectCustomFieldImpl(map);
                break;

            default:
                customField = null;

        }

        return customField;


    }


}
