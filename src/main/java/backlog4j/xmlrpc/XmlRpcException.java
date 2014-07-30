package backlog4j.xmlrpc;

/**
 * @author eguchi
 */
public class XmlRpcException extends RuntimeException {

    private Integer faultCode;

    public XmlRpcException() {

    }

    public XmlRpcException(Throwable cause) {
        super(cause);
    }

    public XmlRpcException(Integer faultCode, String faultString) {
        super(faultString);
        this.faultCode = faultCode;
    }

    public Integer getFaultCode() {
        return faultCode;
    }
}
