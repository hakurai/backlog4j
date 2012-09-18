package backlog4j;

/**
 * @author eguchi
 */
public interface BacklogClientBase {

    Object execute(String methodName);

    Object execute(String methodName, Object... params);
}
