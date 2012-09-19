package backlog4j;

/**
 * @author eguchi
 */
public interface Activity {
    ActivityType getType();

    String getContent();

    String getUpdatedOn();

    User getUser();

    Issue getIssue();
}
