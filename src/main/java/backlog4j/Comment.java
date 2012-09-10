package backlog4j;

import java.util.Map;

/**
 * @author eguchi
 */
public final class Comment {

    private final Integer id;
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

    public static Comment create(Map<String, Object> map) {
        return map == null ? null : new Comment(map);
    }

    public Integer getId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != null ? !id.equals(comment.id) : comment.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
