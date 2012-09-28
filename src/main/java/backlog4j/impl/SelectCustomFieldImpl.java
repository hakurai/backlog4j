package backlog4j.impl;

import backlog4j.Item;
import backlog4j.SelectCustomField;
import backlog4j.util.XmlRpcUtil;

import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public final class SelectCustomFieldImpl extends CustomFieldImpl implements SelectCustomField {

    private final List<Item> items;
    private final Boolean allowInput;

    public SelectCustomFieldImpl(Map<String, Object> map) {
        super(map);

        items = XmlRpcUtil.<Item>toList(ItemImpl.class, map);
        allowInput = (Boolean) map.get("allow_input");

    }

    @Override
    public Boolean isAllowInput() {
        return allowInput;
    }

    @Override
    public List<Item> getItems() {
        return items;
    }
}
