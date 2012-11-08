package backlog4j.impl;

import backlog4j.Item;
import backlog4j.ListCustomField;
import backlog4j.util.XmlRpcUtil;

import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public final class ListCustomFieldImpl extends CustomFieldImpl implements ListCustomField {

    private final List<Item> items;

    public ListCustomFieldImpl(Map<String, Object> map) {
        super(map);

        items = XmlRpcUtil.<Item>toList(ItemImpl.class, map.get("items"));
    }

    @Override
    public List<Item> getItems() {
        return items;
    }
}
