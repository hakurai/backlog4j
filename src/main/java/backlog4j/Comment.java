package backlog4j;

import java.util.Map;

/**
 * @author eguchi
 */
public final class Comment {

    private final int id;
    private final String content;
    private final User createdUser;
    private final String createdOn;
    private final String updatedOn;


    public Comment(Map<String, Object> map) {
        assert (map.size() == 5);
        id = (Integer) map.get("id");
        content = (String) map.get("content");
        createdUser = new User((Map<String, Object>) map.get("created_user"));
        createdOn = (String) map.get("created_on");
        updatedOn = (String) map.get("updated_on");
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getCreatedUser() {
        return createdUser;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "createdUser=" + createdUser +
                ", content='" + content + '\'' +
                '}';
    }
}
