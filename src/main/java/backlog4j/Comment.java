package backlog4j;

/**
 * @author eguchi
 */
public interface Comment extends Identifired {

    String getContent();

    User getCreatedUser();

    String getCreatedOn();

    String getUpdatedOn();
}
