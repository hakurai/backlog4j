package backlog4j;

import java.util.Map;

/**
 * @author eguchi
 */
public final class Activity {

    private final ActivityType type;
    private final String content;
    private final String updatedOn;
    private final User user;
    private final Issue issue;


    public Activity(Map<String, Object> map) {
        type = ActivityType.create((Map<String, Object>) map.get("type"));
        content = (String) map.get("content");
        updatedOn = (String) map.get("updated_on");
        user = new User((Map<String, Object>) map.get("user"));
        issue = new Issue((Map<String, Object>) map.get("issue"));

    }

    public static Activity create(Map<String, Object> map) {
        return map == null ? null : new Activity(map);
    }

    public ActivityType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public User getUser() {
        return user;
    }

    public Issue getIssue() {
        return issue;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "content='" + content + '\'' +
                ", updatedOn='" + updatedOn + '\'' +
                '}';
    }
}
