package backlog4j.impl;

import backlog4j.Item;

import java.util.Map;

/**
 * @author eguchi
 */
public final class ItemImpl implements Item {

    private final Integer id;
    private final String name;

    public ItemImpl(Map<String, Object> map) {
        this.id = (Integer) map.get("id");
        this.name = (String) map.get("name");
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
