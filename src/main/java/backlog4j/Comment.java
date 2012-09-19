package backlog4j;

/**
 * @author eguchi
 */
public interface Comment {
    Integer getId();

    String getContent();

    User getCreatedUser();

    String getCreatedOn();

    String getUpdatedOn();
}
