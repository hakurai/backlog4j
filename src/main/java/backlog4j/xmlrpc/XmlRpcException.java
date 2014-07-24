package backlog4j.xmlrpc;

/**
 * @author eguchi
 */
public class XmlRpcException extends RuntimeException {

    private Integer faultCode;
    private String  faultString;

    public XmlRpcException() {

    }

    public XmlRpcException(Throwable cause) {
        super(cause);
    }
    
    public XmlRpcException(Integer faultCode, String faultString) {
        super("Request faild faultCode : " + faultCode + " faultString : " + faultString);
        this.faultCode = faultCode;
        this.faultString = faultString;
    }

    public Integer getFaultCode() {
        return faultCode;
    }
    public String getFaultString() {
        return faultString;
    }
}
