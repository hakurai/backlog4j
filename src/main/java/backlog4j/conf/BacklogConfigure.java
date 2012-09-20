package backlog4j.conf;

import java.net.URL;

/**
 * @author eguchi
 */
public interface BacklogConfigure {

    String getUsername();

    String getPassword();

    URL getXmlRpcUrl();

    int getReadTimeout();

    int getConnectTimeout();
}
