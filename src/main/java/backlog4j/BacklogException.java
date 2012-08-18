package backlog4j;

/**
 * @author eguchi
 */
public class BacklogException extends RuntimeException {

    public BacklogException() {
    }

    public BacklogException(String s) {
        super(s);
    }

    public BacklogException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BacklogException(Throwable throwable) {
        super(throwable);
    }
}
