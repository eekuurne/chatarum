package game.ui;

import game.assets.Assets;

/**
 * Stores all the locations of the objects that are drawn on the screen. Makes
 * it easier to change them and use them in different actions.
 *
 * @author Eero Kuurne
 */
public class Locations {

    // Background objects.
    public static int tableSlotsX, tableSlotsY, endTurnX, endTurnY, 
            turnNumberX, turnNumberY;

    public static int player1TableSlotY, player2TableSlotY;
    public static int[] tableSlotX;
    
    // Decks.
    public static int deckX, player1DeckY, player2DeckY;

    // Hands.
    public static int[] handX;
    public static int player1HandY, player2HandY;

    // Tables.
    public static int[] tableX;
    public static int player1TableY, player2TableY;
    
    public static int statX, player1InfluenceTextY, player2InfluenceTextY, 
            player1InfluenceBarY, player2InfluenceBarY, player1ResourceTextY, 
            player2ResourceTextY, player1ResourceBarY, player2ResourceBarY;

    public static void init() {
        backgroundObjectLocations();
        deckLocations();
        handLocations();
        tableLocations();
        influenceAndResourceLocations();
    }

    public static void backgroundObjectLocations() {
        tableSlotsX = 363; // Width: 1194
        tableSlotsY = 306; // Height: 468

        endTurnX = 1610; // Width: 200
        endTurnY = 510; // Height: 60
        turnNumberX = 1830;
        turnNumberY = 551;
        
        player1TableSlotY = tableSlotsY + Assets.tableSlotHeight + 34;
        player2TableSlotY = tableSlotsY;
        
        tableSlotX = new int[8];
        for (int i = 0; i < 8; i++) {
            tableSlotX[i] = tableSlotsX + i * (Assets.tableSlotWidth + 6);
        }
    }

    public static void deckLocations() {
        deckX = 110;
        player1DeckY = 565;
        player2DeckY = 317;
    }

    public static void handLocations() {
        player1HandY = 1080 - 40 - Assets.smallHeight; // Height: 198
        player2HandY = 40;

        handX = new int[10];
        /*for (int i = 0; i < 10; i++) {
            handX[i] = 1920 - 438 - i * (Assets.smallWidth + 5); // Width: 125
        }*/
        
        int[] middleStyle = {832, 962, 702, 1092, 572, 1222, 442, 1352, 312, 1482};
        
        for (int i = 0; i < 10; i++) {
            handX[i] = middleStyle[i];
        }
        
    }

    public static void tableLocations() {
        player1TableY = 1080 - tableSlotsY - 9 - Assets.smallHeight;
        player2TableY = tableSlotsY + 9;

        tableX = new int[8];
        for (int i = 0; i < 8; i++) {
            tableX[i] = 372 + i * (Assets.smallWidth + 25);
        }
    }
    
    public static void influenceAndResourceLocations() {
        statX = endTurnX;
        
        player1InfluenceTextY = tableSlotsY + 468 - 108;
        player1ResourceTextY = player1InfluenceTextY + 80;
        
        player1InfluenceBarY = player1InfluenceTextY - 18 - 35;
        player1ResourceBarY = player1ResourceTextY - 18 - 35;
        
        
        player2InfluenceTextY = tableSlotsY + 108 + 18;
        player2ResourceTextY = player2InfluenceTextY - 80;
        
        player2InfluenceBarY = player2InfluenceTextY - 18 + 35;
        player2ResourceBarY = player2ResourceTextY - 18 + 35;

    }
}
