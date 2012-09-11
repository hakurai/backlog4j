package backlog4j;


import java.util.Map;

/**
 * @author eguchi
 */
public final class UserIcon {

    private final Integer id;
    private final String contentType;
    private final byte[] data;
    private final String updatedOn;

    public UserIcon(Map<String, Object> map) {
        id = (Integer) map.get("id");
        contentType = (String) map.get("content_type");
        data = (byte[]) map.get("data");
        updatedOn = (String) map.get("updated_on");
    }

    public static UserIcon create(Map<String, Object> map) {
        return new UserIcon(map);
    }

    public Integer getId() {
        return id;
    }

    public String getContentType() {
        return contentType;
    }

    public byte[] getData() {
        return data;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }
}
