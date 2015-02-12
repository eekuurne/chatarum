package graphics;

import java.awt.image.BufferedImage;

/**
 *
 * @author Eero
 */
public class SpriteSheet {

    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    /**
     *
     *
     * @param x X of upper left corner of the item to be cropped.
     * @param y Y of upper left corner of the item to be cropped.
     * @param width
     * @param height
     */
    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }
}
