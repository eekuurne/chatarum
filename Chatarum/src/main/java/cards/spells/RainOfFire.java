package cards.spells;

import cards.OffensiveAOE;
import game.assets.Assets;
import game.logic.LogicHandler;
import game.logic.Player;
import game.ui.Locations;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Eero Kuurne
 */
public class RainOfFire extends OffensiveAOE {

    public RainOfFire() {
        super("Rain of Fire", 50);
    }

    @Override
    public void clickEnemyTable(LogicHandler handler, Player playerA, Player playerB) {
        for (int i = 0; i < 8; i++) {
            if (playerB.getTable().getMinions()[i] != null) {
                playerB.getTable().getMinions()[i].changeHealth(-2);
                if (playerB.getTable().getMinions()[i].getHealth() <= 0) {
                    playerB.getTable().removeMinion(i);
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
        g.drawImage(Assets.rainOfFireSmall, super.getX(), super.getY(), null);
    }
    
    public void paintHover(Graphics g) {
        if (super.getY() <= Locations.tableSlotsY) {
            g.drawImage(Assets.rainOfFireBig, super.getX() - (Assets.bigWidth - Assets.smallWidth) 
                    / 2, super.getY(), null);
        } else {
            g.drawImage(Assets.rainOfFireBig, super.getX() - (Assets.bigWidth - Assets.smallWidth) 
                    / 2, super.getY() - (Assets.bigHeight - Assets.smallHeight), null);
        }
    }
}
