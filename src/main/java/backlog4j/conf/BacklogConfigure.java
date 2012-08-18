package backlog4j.conf;

import java.net.URL;

/**
 * @author eguchi
 */
public interface BacklogConfigure {

    String getSpaceId();

    String getUsername();

    String getPassword();

    URL getXmlRpcUrl();
}
