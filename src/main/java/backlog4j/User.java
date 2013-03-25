package backlog4j;

/**
 * @author eguchi
 */
public interface User extends identified, Named {

    String getLang();

    String getUpdatedOn();
}
