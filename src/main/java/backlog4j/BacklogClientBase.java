package backlog4j;

/**
 * @author eguchi
 */
public interface BacklogClientBase {

    /**
     * Executes a Backlog API without a parameter.
     *
     * @param methodName the name of the method to be executed
     * @return result of the method execution.
     */
    Object execute(String methodName);

    /**
     * Executes a Backlog API with a parameter.
     *
     * @param methodName the name of the method to be executed
     * @param params     the parameters ot the method to be executed
     * @return result of the method execution.
     */
    Object execute(String methodName, Object... params);
}
