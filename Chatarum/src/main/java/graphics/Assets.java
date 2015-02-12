package graphics;

import graphics.ImageLoader;
import java.awt.image.BufferedImage;

/**
 *
 * @author Eero
 */
public class Assets {

    // Width and height of the big cards.
    public static final int bigWidth = 224, bigHeight = 355;
    
    // Biggest pictures of the cards.
    public static BufferedImage swordman, two, three, four, five, six, seven,
            eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen;
    
    public static final int smallWidth = 224, smallHeight = 355;
    
    // Small pictures of cards
    // public static BufferedImage 
    
    public static BufferedImage background;
    
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("resources/textures/card_sheet_1.png"));
        
        background = ImageLoader.loadImage("resources/textures/background.png");
        
        swordman = sheet.crop(0, 0, bigWidth, bigHeight);
        two = sheet.crop(bigWidth, 0, bigWidth, bigHeight);
        three = sheet.crop(bigWidth * 2, 0, bigWidth, bigHeight);
        four = sheet.crop(bigWidth * 3, 0, bigWidth, bigHeight);
        five = sheet.crop(bigWidth * 4, 0, bigWidth, bigHeight);
        six = sheet.crop(bigWidth * 5, 0, bigWidth, bigHeight);
        seven = sheet.crop(bigWidth * 6, 0, bigWidth, bigHeight);
        eight = sheet.crop(bigWidth * 7, 0, bigWidth, bigHeight);
        nine = sheet.crop(0, bigHeight, bigWidth, bigHeight);
        ten = sheet.crop(bigWidth, bigHeight, bigWidth, bigHeight);
        eleven = sheet.crop(bigWidth * 2, bigHeight, bigWidth, bigHeight);
        twelve = sheet.crop(bigWidth * 3, bigHeight, bigWidth, bigHeight);
        thirteen = sheet.crop(bigWidth * 4, bigHeight, bigWidth, bigHeight);
        fourteen = sheet.crop(bigWidth * 5, bigHeight, bigWidth, bigHeight);
        fifteen = sheet.crop(bigWidth * 6, bigHeight, bigWidth, bigHeight);
        sixteen = sheet.crop(bigWidth * 7, bigHeight, bigWidth, bigHeight);
    }
}
