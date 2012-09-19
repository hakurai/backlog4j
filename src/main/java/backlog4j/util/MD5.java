package backlog4j.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author eguchi
 */
public final class MD5 {

    public static String encode(String source) throws NoSuchAlgorithmException {

        ByteArrayInputStream in = new ByteArrayInputStream(source.getBytes());


        MessageDigest digest = MessageDigest.getInstance("MD5");
        try {
            byte[] buff = new byte[4096];
            int len = 0;
            while ((len = in.read(buff, 0, buff.length)) >= 0) {
                digest.update(buff, 0, len);
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
        byte[] hash = digest.digest();

        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            if ((0xff & hash[i]) < 0x10) {
                hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
            } else {
                hexString.append(Integer.toHexString(0xFF & hash[i]));
            }
        }

        return hexString.toString();
    }

}
