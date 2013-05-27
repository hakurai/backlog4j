package backlog4j.conf;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author eguchi
 */
public final class BacklogPackageConfigureImpl extends AbstractBacklogConfigure {


    private final URL              xmlRpcUrl;
    private final HostnameVerifier hostnameVerifier;
    private final SSLSocketFactory sslSocketFactory;

    public BacklogPackageConfigureImpl(
            String url,
            String username,
            String password,
            int readTimeout,
            int connectTimeout,
            HostnameVerifier hostnameVerifier,
            SSLSocketFactory sslSocketFactory) throws MalformedURLException {
        super(username, password, readTimeout, connectTimeout);
        this.hostnameVerifier = hostnameVerifier;
        this.sslSocketFactory = sslSocketFactory;

        if (url == null) {
            throw new IllegalArgumentException("url must not be null");
        }

        if (url.endsWith("/")) {
            this.xmlRpcUrl = new URL(url + "XML-RPC");
        } else {
            this.xmlRpcUrl = new URL(url + "/XML-RPC");
        }
    }

    @Override
    public URL getXmlRpcUrl() {
        return xmlRpcUrl;
    }

    @Override
    public HttpURLConnection createConnection() throws IOException {
        HttpURLConnection connection = super.createConnection();
        if (connection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) connection;
            if (hostnameVerifier != null) {
                httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            }

            if (sslSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sslSocketFactory);
            }

        }

        return connection;
    }
}
