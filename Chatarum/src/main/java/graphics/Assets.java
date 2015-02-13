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
    
    public static BufferedImage swordmanBig, two, three, four, five, six, seven,
            eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen;
    
    public static final int smallWidth = 125, smallHeight = 198;
    
    // Small pictures of cards
    public static BufferedImage swordmanSmall;
    
    public static BufferedImage background;
    
    /**
     * Method which loads all the images and crops all the single items from the 
     * sprite sheets. (I will divide it to more methods if it gets too messy.)
     *
     */
    public static void init() {
        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("resources/textures/card_sheet_1.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("resources/textures/card_sheet_2.png"));
        
        background = ImageLoader.loadImage("resources/textures/background_1728x972.png");
        
        swordmanBig = sheet1.crop(0, 0, bigWidth, bigHeight);
        two = sheet1.crop(bigWidth, 0, bigWidth, bigHeight);
        three = sheet1.crop(bigWidth * 2, 0, bigWidth, bigHeight);
        four = sheet1.crop(bigWidth * 3, 0, bigWidth, bigHeight);
        five = sheet1.crop(bigWidth * 4, 0, bigWidth, bigHeight);
        six = sheet1.crop(bigWidth * 5, 0, bigWidth, bigHeight);
        seven = sheet1.crop(bigWidth * 6, 0, bigWidth, bigHeight);
        eight = sheet1.crop(bigWidth * 7, 0, bigWidth, bigHeight);
        nine = sheet1.crop(0, bigHeight, bigWidth, bigHeight);
        ten = sheet1.crop(bigWidth, bigHeight, bigWidth, bigHeight);
        eleven = sheet1.crop(bigWidth * 2, bigHeight, bigWidth, bigHeight);
        twelve = sheet1.crop(bigWidth * 3, bigHeight, bigWidth, bigHeight);
        thirteen = sheet1.crop(bigWidth * 4, bigHeight, bigWidth, bigHeight);
        fourteen = sheet1.crop(bigWidth * 5, bigHeight, bigWidth, bigHeight);
        fifteen = sheet1.crop(bigWidth * 6, bigHeight, bigWidth, bigHeight);
        sixteen = sheet1.crop(bigWidth * 7, bigHeight, bigWidth, bigHeight);
        
        swordmanSmall = sheet2.crop(0, 0, smallWidth, smallHeight);
        
        
        
    }
}
