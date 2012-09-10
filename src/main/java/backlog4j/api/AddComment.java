package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.Comment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eguchi
 */
public class AddComment implements BacklogCommand<Comment> {

    private final BacklogClient client;
    protected final Map<String, Object> map = new HashMap<String, Object>();

    public AddComment(BacklogClient client) {
        this.client = client;
    }

    public String getKey() {
        return (String) map.get(KEY);
    }

    public AddComment setKey(String key) {
        map.put(KEY, key);

        return this;
    }

    public String getContent() {
        return (String) map.get(CONTENT);
    }

    public AddComment setContent(String content) {
        map.put(CONTENT, content);

        return this;
    }

    private void checkParameters() {
        if (getKey() == null) {
            throw new BacklogException("key is required");
        }
        if (getContent() == null) {
            throw new BacklogException("content is required");
        }
    }

    @Override
    public Comment execute() {
        checkParameters();

        Object res = client.execute(BACKLOG_ADD_COMMENT, map);
        return new Comment((Map<String, Object>) res);
    }
}
