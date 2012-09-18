package backlog4j;

/**
 * @author eguchi
 */
public interface UserIcon {
    Integer getId();

    String getContentType();

    byte[] getData();

    String getUpdatedOn();
}
