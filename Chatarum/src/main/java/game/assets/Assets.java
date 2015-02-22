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
    public static BufferedImage background;
    public static BufferedImage tableSlots;
    
    public static final int endTurnWidth = 200, endTurnHeight = 60;
    public static BufferedImage endTurn;

    // Width and height of the big cards.
    public static final int bigWidth = 224, bigHeight = 355;

    // Big pictures of cards.
    public static BufferedImage swordmanBig, archerBig, watchmanBig, militiaBig,
            raiderBig, peasantBig;

    // Width and height of the small cards.
    public static final int smallWidth = 125, smallHeight = 198;

    // Small pictures of cards.
    public static BufferedImage swordmanSmall, archerSmall, watchmanSmall,
            militiaSmall, raiderSmall, peasantSmall;

    // Cardbacks.
    public static BufferedImage neutralCardBack;

    /**
     * Method which loads all the images and crops all the single items from the
     * sprite sheets.
     *
     */
    public static void init() {
        loadBackgroundObjects();

        neutralCrops();
    }

    private static void loadBackgroundObjects() {
        background = ImageLoader.loadImage("resources/textures/background_1920x1080.png");
        tableSlots = ImageLoader.loadImage("resources/textures/table_slots.png");
        endTurn = ImageLoader.loadImage("resources/textures/end_turn.png");
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
}
