package backlog4j.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author eguchi
 */
public class Base64Test {

    @Test
    public void testEncode1character() throws Exception {

        String text = Base64.encode("A".getBytes());

        assertThat(text, is("QQ=="));

    }

    @Test
    public void testEncode2characters() throws Exception {

        String text = Base64.encode("AB".getBytes());

        assertThat(text, is("QUI="));

    }

    @Test
    public void testEncode3characters() throws Exception {

        String text = Base64.encode("ABC".getBytes());

        assertThat(text, is("QUJD"));

    }

    @Test
    public void testEncode4characters() throws Exception {

        String text = Base64.encode("ABCD".getBytes());

        assertThat(text, is("QUJDRA=="));

    }

    @Test
    public void testEncodeJapanese() throws Exception {

        String text = Base64.encode("こんにちはJava".getBytes());

        assertThat(text, is("44GT44KT44Gr44Gh44GvSmF2YQ=="));

    }


    @Test
    public void testDecode() throws Exception {

        byte[] bytes = Base64.decode("QUJDREVG");

        assertThat(new String(bytes), is("ABCDEF"));
    }

    @Test
    public void testDecodeJapanese() throws Exception {

        byte[] bytes = Base64.decode("44GT44KT44Gr44Gh44GvSmF2YQ==");

        assertThat(new String(bytes), is("こんにちはJava"));
    }

    @Test
    public void testEncodeAndDecode() throws Exception {
        String source = "`1234567890-=\\][poiuytrewqasdfghjkl;'/.,mnbvcxz?><:{}|+_)(*&^%$#@!~)あ\n";


        byte[] bytes = Base64.decode(
                Base64.encode(source.getBytes()));

        assertThat(new String(bytes), is(source));

    }


}
