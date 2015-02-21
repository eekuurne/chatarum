package graphics;

/**
 *
 * @author Eero Kuurne
 */
public class Locations {

    // Background objects.
    public static final int tableSlotsX = 285;
    public static final int tableSlotsY = 306;
    
    public static final int endTurnX = 1590;
    public static final int endTurnY = 510;
    
    public static final int championFrameX = 1540;
    public static final int player1ChampionFrameY = 1080 - 208 - 282;
    public static final int player2ChampionFrameY = 282;
    
    // Decks.
    public static final int deckX = 75;
    public static final int player1DeckY = 565;
    public static final int player2DeckY = 317;
    
    // Hands.
    public static final int[] handX = {1337, 1209, 1081, 953, 825, 697, 569, 441, 313, 185};
    public static final int player1HandY = 1080 - 40 - Assets.smallHeight;
    public static final int player2HandY = 40;
    
    // Tables.
    public static final int[] tableX = {294, 444, 594, 744, 894, 1044, 1194, 1344};
    public static final int player1TableY = 1080 - tableSlotsY - 9 - Assets.smallHeight;
    public static final int player2TableY = tableSlotsY + 9;
}