package backlog4j;

/**
 * @author eguchi
 */
public interface User extends Identifired, Named {

    String getLang();

    String getUpdatedOn();
}
