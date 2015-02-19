package graphics;

import graphics.ImageLoader;
import java.awt.image.BufferedImage;

/**
 * Class for saving the single items from sprite sheets and containing all images. 
 * Will be run at the start of the game and the variables are public.
 *
 * @author Eero
 */
public class Assets {

    // Width and height of the big cards.
    public static final int bigWidth = 224, bigHeight = 355;
    
    public static BufferedImage swordmanBig, archerBig, watchmanBig, militiaBig, 
            raiderBig, peasantBig; 
            //seven, eight, nine, ten, eleven, twelve, 
            //thirteen, fourteen, fifteen, sixteen;
    
    public static final int smallWidth = 125, smallHeight = 198;
    
    // Small pictures of cards
    public static BufferedImage swordmanSmall, archerSmall, watchmanSmall, 
            militiaSmall, raiderSmall, peasantSmall;
    
    public static BufferedImage background;
    public static BufferedImage tableSlots;
    public static BufferedImage endTurn;

    public static BufferedImage cultBack;
    public static BufferedImage brotherhoodBack;

    public static BufferedImage cultChampionFrame;
    public static BufferedImage brotherhoodChampionFrame;
    /**
     * Method which loads all the images and crops all the single items from the 
     * sprite sheets. (I will divide it to more methods if it gets too messy.)
     *
     */
    public static void init() {
        SpriteSheet neutralBig = new SpriteSheet(ImageLoader.loadImage("resources/textures/neutral_cards_big.png"));
        SpriteSheet neutralSmall = new SpriteSheet(ImageLoader.loadImage("resources/textures/neutral_cards_small.png"));
        SpriteSheet brotherhoodSmall = new SpriteSheet(ImageLoader.loadImage("resources/textures/brotherhood_cards_small.png"));
        SpriteSheet brotherhoodBig = new SpriteSheet(ImageLoader.loadImage("resources/textures/brotherhood_cards_small.png"));
        SpriteSheet cultSmall = new SpriteSheet(ImageLoader.loadImage("resources/textures/cult_cards_small.png"));
        SpriteSheet cultBig = new SpriteSheet(ImageLoader.loadImage("resources/textures/cult_cards_small.png"));
        
        background = ImageLoader.loadImage("resources/textures/background2_1920x1080.png");
        tableSlots = ImageLoader.loadImage("resources/textures/table_slots.png");
        endTurn = ImageLoader.loadImage("resources/textures/end_turn.png");
        cultChampionFrame = ImageLoader.loadImage("resources/textures/cult_champion_frame.png");
        brotherhoodChampionFrame = ImageLoader.loadImage("resources/textures/brotherhood_champion_frame.png");
        
        cultBack = cultSmall.crop(0, 0, smallWidth, smallHeight);
        brotherhoodBack = brotherhoodSmall.crop(0, 0, smallWidth, smallHeight);
        
        
        swordmanBig = neutralBig.crop(0, 0, bigWidth, bigHeight);
        archerBig = neutralBig.crop(bigWidth, 0, bigWidth, bigHeight);
        watchmanBig = neutralBig.crop(bigWidth * 2, 0, bigWidth, bigHeight);
        militiaBig = neutralBig.crop(bigWidth * 3, 0, bigWidth, bigHeight);
        raiderBig = neutralBig.crop(bigWidth * 4, 0, bigWidth, bigHeight);
        peasantBig = neutralBig.crop(bigWidth * 5, 0, bigWidth, bigHeight);
        
        /*seven = sheetBig.crop(bigWidth * 6, 0, bigWidth, bigHeight);
        eight = sheetBig.crop(bigWidth * 7, 0, bigWidth, bigHeight);
        nine = sheetBig.crop(0, bigHeight, bigWidth, bigHeight);
        ten = sheetBig.crop(bigWidth, bigHeight, bigWidth, bigHeight);
        eleven = sheetBig.crop(bigWidth * 2, bigHeight, bigWidth, bigHeight);
        twelve = sheetBig.crop(bigWidth * 3, bigHeight, bigWidth, bigHeight);
        thirteen = sheetBig.crop(bigWidth * 4, bigHeight, bigWidth, bigHeight);
        fourteen = sheetBig.crop(bigWidth * 5, bigHeight, bigWidth, bigHeight);
        fifteen = sheetBig.crop(bigWidth * 6, bigHeight, bigWidth, bigHeight);
        sixteen = sheetBig.crop(bigWidth * 7, bigHeight, bigWidth, bigHeight);*/
        
        swordmanSmall = neutralSmall.crop(0, 0, smallWidth, smallHeight);
        archerSmall = neutralSmall.crop(smallWidth, 0, smallWidth, smallHeight);
        watchmanSmall = neutralSmall.crop(smallWidth * 2, 0, smallWidth, smallHeight);
        militiaSmall = neutralSmall.crop(smallWidth * 3, 0, smallWidth, smallHeight);
        raiderSmall = neutralSmall.crop(smallWidth * 4, 0, smallWidth, smallHeight);
        peasantSmall = neutralSmall.crop(smallWidth * 5, 0, smallWidth, smallHeight);
        
        
    }
    
}
