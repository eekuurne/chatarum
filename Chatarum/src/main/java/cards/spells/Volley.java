package cards.spells;

import cards.OffensiveAOE;
import cards.minions.Archer;
import game.assets.Assets;
import game.logic.LogicHandler;
import game.logic.Player;
import game.ui.Locations;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Eero Kuurne
 */
public class Volley extends OffensiveAOE {

    public Volley() {
        super("Command: Volley", 70);
    }

    @Override
    public void clickEnemyTable(LogicHandler handler, Player playerA, Player playerB) {
        for (int i = 0; i < 8; i++) {
            if (playerB.getTable().getMinions()[i] != null) {
                playerB.getTable().getMinions()[i].changeHealth(-1);
                if (playerB.getTable().getMinions()[i].getHealth() <= 0) {
                    playerB.getTable().removeMinion(i);
                }
            }
        }
        
        int archers = 3;
        for (int i = 0; i < 8; i++) {
            if (archers > 0) {
                if (playerA.getTable().getMinions()[i] == null) {
                    playerA.getTable().getMinions()[i] = new Archer();
                    archers--;
                }
            }
        }
        playerA.changeRemainingResources(-playerA.getHand().getCards().get(handler.getChosenHandOffensiveAOESlot()).getCost());
        playerA.getHand().takeCard(handler.getChosenHandOffensiveAOESlot());

        handler.clearChosen();
        handler.updateCardPositions();
        handler.getUi().repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Assets.volleySmall, super.getX(), super.getY(), null);
    }
    
    public void paintHover(Graphics g) {
        if (super.getY() <= Locations.tableSlotsY) {
            g.drawImage(Assets.volleyBig, super.getX() - (Assets.bigWidth - Assets.smallWidth) 
                    / 2, super.getY(), null);
        } else {
            g.drawImage(Assets.volleyBig, super.getX() - (Assets.bigWidth - Assets.smallWidth) 
                    / 2, super.getY() - (Assets.bigHeight - Assets.smallHeight), null);
        }
    }
}
