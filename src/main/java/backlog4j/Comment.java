package backlog4j;

/**
 * @author eguchi
 */
public interface Comment extends identified {

    String getContent();

    User getCreatedUser();

    String getCreatedOn();

    String getUpdatedOn();
}
