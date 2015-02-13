package graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Class for loading images.
 *
 * @author Eero
 */
public class ImageLoader {

    /**
     * Method for loading png image and returning it as BufferedImage.
     *
     * @param path Location of the file.
     * @return BufferedImage made of the file.
     */
    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
