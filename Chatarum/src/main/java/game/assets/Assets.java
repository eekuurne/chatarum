package game.assets;

import game.ui.Locations;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.coobird.thumbnailator.Thumbnails;

/**
 * Class for containing all the resources of the game (textures, sounds).
 * All the asset variables are public static.
 * 
 * Uses ImageLoader to load all the images at start and crops all the sprites
 * from sprite sheets using SpriteSheet.
 *
 * (This class will be divided to Dimensions and Assets later when I have time
 * for refactoring)
 *
 * @author Eero Kuurne
 */
public class Assets {

    // Background objects.
    public static int backgroundWidth = 1920, backgroundHeight = 1080;
    public static BufferedImage background;

    // Table slots.
    public static int tableSlotsWidth = 1194, tableSlotsHeight = 468;
    public static int tableSlotWidth = 144, tableSlotHeight = 217;
    public static BufferedImage tableSlots;

    // End turn -button.
    public static int endTurnWidth = 200, endTurnHeight = 60;
    public static BufferedImage endTurn;
    public static BufferedImage startTurn;

    // Big pictures of cards.
    public static int bigWidth = 224, bigHeight = 355;
    public static BufferedImage swordmanBig, archerBig, watchmanBig, militiaBig,
            raiderBig, peasantBig;

    // Small pictures of cards.
    public static int smallWidth = 125, smallHeight = 198;
    public static BufferedImage swordmanSmall, archerSmall, watchmanSmall,
            militiaSmall, raiderSmall, peasantSmall;

    // Cardbacks.
    public static BufferedImage neutralCardBack;

    // Statistic bar.
    public static BufferedImage statBar;
    public static int statBarWidth = 197; // Without borders.
    public static int statBarHeight = 17; // Without borders.

    // Icons.
    public static BufferedImage guardianIcon;
    public static BufferedImage turnLeftIcon;

    public static double scale;
    
    // Fonts.
    public static int statTextFont = 20;
    public static int turnTextFont = 36;
    public static int healthLostFont = 18;

    
    /**
     * Method which loads all the images and crops all the single items from the
     * sprite sheets.
     *
     */
    public static void init(double startingScale) {
        scale = startingScale;
        loadBackgroundObjects();
        loadIcons();

        neutralCrops();
    }

    private static void loadBackgroundObjects() {
        background = ImageLoader.loadImage("resources/textures/background_1920x1080.png");
        tableSlots = ImageLoader.loadImage("resources/textures/table_slots.png");
        endTurn = ImageLoader.loadImage("resources/textures/end_turn.png");
        startTurn = ImageLoader.loadImage("resources/textures/start_turn.png");
        statBar = ImageLoader.loadImage("resources/textures/stat_bar.png");
    }

    private static void neutralCrops() {
        SpriteSheet neutralBig = new SpriteSheet(ImageLoader.loadImage("resources/textures/neutral_cards_big.png"));
        SpriteSheet neutralSmall = new SpriteSheet(ImageLoader.loadImage("resources/textures/neutral_cards_small.png"));

        neutralCardBack = neutralSmall.crop(smallWidth * 7, 0, smallWidth, smallHeight);

        swordmanBig = neutralBig.crop(0, 0, bigWidth, bigHeight);
        archerBig = neutralBig.crop(bigWidth, 0, bigWidth, bigHeight);
        watchmanBig = neutralBig.crop(bigWidth * 2, 0, bigWidth, bigHeight);
        militiaBig = neutralBig.crop(bigWidth * 3, 0, bigWidth, bigHeight);
        raiderBig = neutralBig.crop(bigWidth * 4, 0, bigWidth, bigHeight);
        peasantBig = neutralBig.crop(bigWidth * 5, 0, bigWidth, bigHeight);

        swordmanSmall = neutralSmall.crop(0, 0, smallWidth, smallHeight);
        archerSmall = neutralSmall.crop(smallWidth, 0, smallWidth, smallHeight);
        watchmanSmall = neutralSmall.crop(smallWidth * 2, 0, smallWidth, smallHeight);
        militiaSmall = neutralSmall.crop(smallWidth * 3, 0, smallWidth, smallHeight);
        raiderSmall = neutralSmall.crop(smallWidth * 4, 0, smallWidth, smallHeight);
        peasantSmall = neutralSmall.crop(smallWidth * 5, 0, smallWidth, smallHeight);
    }

    private static void loadIcons() { // MAKE SPRITESHEET LATER AND CROP
        guardianIcon = ImageLoader.loadImage("resources/textures/guardian_icon.png");
        turnLeftIcon = ImageLoader.loadImage("resources/textures/turn_left_icon.png");
    }

    public static void scaleDimensions(double scale) {
        backgroundWidth *= scale;
        backgroundHeight *= scale;
        tableSlotsWidth *= scale;
        tableSlotsHeight *= scale;
        tableSlotWidth *= scale;
        tableSlotHeight *= scale;
        endTurnWidth *= scale;
        endTurnHeight *= scale;
        bigWidth *= scale;
        bigHeight *= scale;
        smallWidth *= scale;
        smallHeight *= scale;
        statBarWidth *= scale;
        statBarHeight *= scale;
        statTextFont *= scale;
        healthLostFont *= scale;
        turnTextFont *= scale;
    }

    public static BufferedImage resize(BufferedImage img, double scale) {
        int newWidth = (int) ((double) img.getWidth() * scale);
        int newHeight = (int) ((double) img.getHeight() * scale);
        
        try {
            img = Thumbnails.of(img).size(newWidth, newHeight).asBufferedImage();
        } catch (IOException ex) {
            Logger.getLogger(Assets.class.getName()).log(Level.SEVERE, null, ex);
        }

        return img;
    }

    public static void scaleImages(double scale) {
        background = resize(background, scale);
        tableSlots = resize(tableSlots, scale);
        endTurn = resize(endTurn, scale);
        startTurn = resize(startTurn, scale);
        statBar = resize(statBar, scale);
        
        neutralCardBack = resize(neutralCardBack, scale);

        swordmanBig = resize(swordmanBig, scale);
        archerBig = resize(archerBig, scale);
        watchmanBig = resize(watchmanBig, scale);
        militiaBig = resize(militiaBig, scale);
        raiderBig = resize(raiderBig, scale);
        peasantBig = resize(peasantBig, scale);

        swordmanSmall = resize(swordmanSmall, scale);
        archerSmall = resize(archerSmall, scale);
        watchmanSmall = resize(watchmanSmall, scale);
        militiaSmall = resize(militiaSmall, scale);
        raiderSmall = resize(raiderSmall, scale);
        peasantSmall = resize(peasantSmall, scale);
        
        guardianIcon = resize(guardianIcon, scale);
        turnLeftIcon = resize(turnLeftIcon, scale);
    }
    
    public static void scale(double scale) {
        scaleDimensions(scale);
        scaleImages(scale);
        Locations.scaleLocations(scale);
    }
}
