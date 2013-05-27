package backlog4j.impl;

import backlog4j.Activity;
import backlog4j.ActivityType;
import backlog4j.Issue;
import backlog4j.User;

import java.util.Map;

/**
 * @author eguchi
 */
public final class ActivityImpl implements Activity {

    private final ActivityType type;
    private final String       content;
    private final String       updatedOn;
    private final User         user;
    private final Issue        issue;


    public ActivityImpl(Map<String, Object> map) {
        type = ActivityTypeImpl.create((Map<String, Object>) map.get("type"));
        content = (String) map.get("content");
        updatedOn = (String) map.get("updated_on");
        user = UserImpl.create((Map<String, Object>) map.get("user"));
        issue = new IssueImpl((Map<String, Object>) map.get("issue"));

    }

    public static Activity create(Map<String, Object> map) {
        return map == null ? null : new ActivityImpl(map);
    }

    @Override
    public ActivityType getType() {
        return type;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getUpdatedOn() {
        return updatedOn;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
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
