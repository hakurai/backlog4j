package backlog4j;

/**
 * @author eguchi
 */
public interface UserIcon extends identified {

    String getContentType();

    byte[] getData();

    String getUpdatedOn();
}
