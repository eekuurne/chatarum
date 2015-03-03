package cards;

import game.logic.LogicHandler;
import game.logic.Player;
import game.ui.Locations;
import java.awt.Graphics;

/**
 * Offensive Area-of-effect spells. Can be clicked in player's hand and targeted
 * to the enemy table.
 *
 * @author Eero Kuurne
 */
public abstract class OffensiveAOE extends Card {

    public OffensiveAOE(String name, int cost) {
        super(name, cost);
    }

    @Override
    public void clickInHand(LogicHandler handler, int slot) {
        handler.clearChosen();
        handler.setChosenHandOffensiveAOE(this);
        handler.setChosenHandOffensiveAOESlot(slot);
        if (handler.getTurn() % 2 != 0) {
            setLocation(getX(), Locations.player1HandY - Locations.chooseCardDelta);
        } else {
            setLocation(getX(), Locations.player2HandY + Locations.chooseCardDelta);
        }
    }
    
    public abstract void clickEnemyTable(LogicHandler handler, Player playerA, Player playerB);

}
