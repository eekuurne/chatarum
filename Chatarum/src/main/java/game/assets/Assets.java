package game.assets;

import java.awt.image.BufferedImage;

/**
 * Class for containing all the resources of the game (textures, sounds).
 * 
 * Uses ImageLoader to load all the images at start and crops all the sprites
 * from sprite sheets.
 * 
 * All the asset variables are public static.
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
    
    // Icons.
    public static BufferedImage guardianIcon;
    public static BufferedImage turnLeftIcon;
   

    /**
     * Method which loads all the images and crops all the single items from the
     * sprite sheets.
     *
     */
    public static void init() {
        loadBackgroundObjects();
        loadIcons();

        neutralCrops();
    }

    private static void loadBackgroundObjects() {
        background = ImageLoader.loadImage("resources/textures/background_1920x1080.png");
        tableSlots = ImageLoader.loadImage("resources/textures/table_slots.png");
        endTurn = ImageLoader.loadImage("resources/textures/end_turn.png");
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

    private static void loadIcons() { // MAKES SPRITESHEET LATER AND CROP
        guardianIcon = ImageLoader.loadImage("resources/textures/guardian_icon.png");
        turnLeftIcon = ImageLoader.loadImage("resources/textures/turn_left_icon.png");
    }
}
