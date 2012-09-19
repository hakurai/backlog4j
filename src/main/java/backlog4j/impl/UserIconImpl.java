package backlog4j.impl;


import backlog4j.UserIcon;

import java.util.Map;

/**
 * @author eguchi
 */
public final class UserIconImpl implements UserIcon {

    private final Integer id;
    private final String contentType;
    private final byte[] data;
    private final String updatedOn;

    public UserIconImpl(Map<String, Object> map) {
        id = (Integer) map.get("id");
        contentType = (String) map.get("content_type");
        data = (byte[]) map.get("data");
        updatedOn = (String) map.get("updated_on");
    }

    public static UserIcon create(Map<String, Object> map) {
        return new UserIconImpl(map);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public byte[] getData() {
        return data;
    }

    @Override
    public String getUpdatedOn() {
        return updatedOn;
    }
}
