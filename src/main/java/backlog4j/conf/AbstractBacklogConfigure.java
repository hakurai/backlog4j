package backlog4j.conf;

import backlog4j.util.Base64;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author eguchi
 */
public abstract class AbstractBacklogConfigure implements BacklogConfigure {
    private final String username;
    private final String password;
    private final int    readTimeout;
    private final int    connectTimeout;

    public AbstractBacklogConfigure(String username, String password, int readTimeout, int connectTimeout) {
        if (username == null) {
            throw new IllegalArgumentException("username must not be null");
        }
        if (password == null) {
            throw new IllegalArgumentException("password must not be null");
        }
        this.password = password;
        this.username = username;
        this.readTimeout = readTimeout;
        this.connectTimeout = connectTimeout;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int getReadTimeout() {
        return readTimeout;
    }

    @Override
    public int getConnectTimeout() {
        return connectTimeout;
    }

    public HttpURLConnection createConnection() throws IOException {
        URL url = getXmlRpcUrl();

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        String encode = Base64.encode((getUsername() + ":" + getPassword()).getBytes());

        con.setConnectTimeout(getConnectTimeout());
        con.setReadTimeout(getReadTimeout());


        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", "Basic " + encode);
        con.setRequestProperty("Content-Type", "text/xml");

        con.setDoOutput(true);

        return con;
    }
}
