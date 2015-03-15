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
    public static int deckCardDelta;

    // Hands.
    public static int[] handX;
    public static int player1HandY, player2HandY;
    public static int chooseCardDelta;

    // Tables.
    public static int[] tableX;
    public static int player1TableY, player2TableY;

    public static int statX, player1InfluenceTextY, player2InfluenceTextY,
            player1InfluenceBarY, player2InfluenceBarY, player1ResourceTextY,
            player2ResourceTextY, player1ResourceBarY, player2ResourceBarY;
    
    // Icons.
    public static int turnLeftX, turnLeftY, protectedX, protectedY, damageTakenX, 
            damageTakenY;
    
    // Ending text.
    public static int endTextX;
    public static int endTextY;
    
    // Hover.
    public static int hoverX;
    public static int hoverY;

    public static void init() {
        backgroundObjectLocations();
        deckLocations();
        handLocations();
        tableLocations();
        influenceAndResourceLocations();
        iconLocations();
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
        
        endTextX = Assets.backgroundWidth / 3 - 95;
        endTextY = 2 * (Assets.backgroundHeight / 3 + 5);
        
        hoverX = 50;
        hoverY = 540 - Assets.bigHeight / 2;
    }

    public static void deckLocations() {
        deckX = 110;
        player1DeckY = 565;
        player2DeckY = 317;
        deckCardDelta = 3;
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

        chooseCardDelta = 25;
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

    private static void iconLocations() {
        turnLeftX = 15;
        turnLeftY = 7;
        protectedX = 7;
        protectedY = 7;
        damageTakenX = 28; 
        damageTakenY = 40;
    }
    
    public static void scaleLocations(double scale) {
        tableSlotsX *= scale;
        tableSlotsY *= scale;
        endTurnX *= scale;
        endTurnY *= scale;
        turnNumberX *= scale;
        turnNumberY *= scale;
        player1TableSlotY *= scale;
        player2TableSlotY *= scale;

        deckX *= scale;
        player1DeckY *= scale;
        player2DeckY *= scale;
        deckCardDelta *= scale;

        player1HandY *= scale;
        player2HandY *= scale;
        chooseCardDelta *= scale;

        player1TableY *= scale;
        player2TableY *= scale;

        statX *= scale;
        player1InfluenceTextY *= scale;
        player2InfluenceTextY *= scale;

        player1InfluenceBarY *= scale;
        player2InfluenceBarY *= scale;
        player1ResourceTextY *= scale;

        player2ResourceTextY *= scale;
        player1ResourceBarY *= scale;
        player2ResourceBarY *= scale;

        for (int i = 0; i < tableX.length; i++) {
            tableX[i] *= scale;
            tableSlotX[i] *= scale;
        }
        for (int i = 0; i < handX.length; i++) {
            handX[i] *= scale;
        }
        
        turnLeftX *= scale;
        turnLeftY *= scale;
        protectedX *= scale;
        protectedY *= scale;
        damageTakenX *= scale;
        damageTakenY *= scale;
        
        endTextX *= scale;
        endTextY *= scale;
        
        hoverX *= scale;
        hoverY *= scale;
    }
}
