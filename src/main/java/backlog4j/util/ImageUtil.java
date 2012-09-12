package backlog4j.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author eguchi
 */
public final class ImageUtil {

    private ImageUtil() {
    }

    public static void writeFile(byte[] source, String format, File file) throws IOException {

        ImageIcon imageIcon = new ImageIcon(source);


        BufferedImage buffered = new BufferedImage(
                imageIcon.getIconWidth(),
                imageIcon.getIconHeight(),
                BufferedImage.TYPE_INT_RGB
        );
        Graphics2D g = buffered.createGraphics();
        g.drawImage(imageIcon.getImage(), 0, 0, null);
        g.dispose();

        ImageIO.write(buffered, format, file);
    }

}
