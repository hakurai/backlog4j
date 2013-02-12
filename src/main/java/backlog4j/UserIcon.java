package backlog4j;

/**
 * @author eguchi
 */
public interface UserIcon extends Identifired {

    String getContentType();

    byte[] getData();

    String getUpdatedOn();
}
