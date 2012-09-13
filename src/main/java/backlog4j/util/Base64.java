package backlog4j.util;

import java.io.ByteArrayOutputStream;

/**
 * @author eguchi
 */
public class Base64 {
    private static final int[] INDEX_TABLE;
    private static final char[] BASE64 = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };

    private static int[] MASKS = {0,0,63,0,15,0,3};

    static {
        INDEX_TABLE = new int[128];
        for (int i = 0, len = BASE64.length; i < len; i++) {
            INDEX_TABLE[BASE64[i]] = i;
        }

    }

    public static String encode(byte[] source) {

        StringBuilder sb = new StringBuilder((int) (source.length * 1.38) + 3);

        int current = 0;
        int shift = 2;

        for (int i = 0, len = source.length; i < len; i++) {

            current = (current | (source[i] >> shift) & MASKS[shift]);
            sb.append(BASE64[current]);

            current = (source[i] << (6 - shift)) & 63;
            if (shift == 6) {
                sb.append(BASE64[current]);
                current = 0;
                shift = 2;
            } else {
                shift += 2;
            }

        }
        if (shift > 2) {
            sb.append(BASE64[current]);
        }

        int rem = sb.length() % 4;
        if (rem > 0) {
            sb.append("==", 0, 4 - rem);
        }

        return sb.toString();

    }

    public static byte[] decode(String source) {

        ByteArrayOutputStream bos = new ByteArrayOutputStream(source.length());
        char[] chars = source.toCharArray();

        byte[] buf = new byte[3];


        for (int i = 0, len = chars.length; i < len; ) {
            int length = 1;

            if (chars[i] == '\n') {
                i += 2;
            }
            int b = INDEX_TABLE[chars[i++]] << 18;
            b = b | INDEX_TABLE[chars[i++]] << 12;
            if (chars[i] != '=') length++;
            b = b | INDEX_TABLE[chars[i++]] << 6;
            if (chars[i] != '=') length++;
            b = b | INDEX_TABLE[chars[i++]];

            buf[0] = (byte) (b >> 16);
            buf[1] = (byte) (b >> 8);
            buf[2] = (byte) b;

            bos.write(buf, 0, length);
        }

        return bos.toByteArray();
    }
}
