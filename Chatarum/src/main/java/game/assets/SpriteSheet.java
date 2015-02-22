package game.assets;

import java.awt.image.BufferedImage;

/**
 * Class for cropping from a sprite sheet.
 *
 * @author Eero Kuurne
 */
public class SpriteSheet {

    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    /**
     * Crop item from the sprite sheet.
     *
     * @param x X of upper left corner of the item to be cropped.
     * @param y Y of upper left corner of the item to be cropped.
     * @param width Width of the item to be cropped.
     * @param height Height of the item to be cropped.
     */
    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }
}
