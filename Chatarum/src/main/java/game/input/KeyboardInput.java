package game.input;

import cards.Card;
import game.logic.LogicHandler;
import game.ui.UserInterface;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Eero Kuurne
 */
public class KeyboardInput implements KeyListener {

    private UserInterface ui;

    public KeyboardInput(UserInterface component) {
        this.ui = component;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        // ESC: Close the program.
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        } 
        // Q: Player 1 draw card.
        else if (ke.getKeyCode() == KeyEvent.VK_Q) {
            Card drawCard = ui.getHandler().getPlayer1().getDeck().takeCard();
            ui.getHandler().getPlayer1().getHand().addCard(drawCard);
            ui.getHandler().updateCardPositions();
        }
        // W: Player 1 remove card from hand.
        else if (ke.getKeyCode() == KeyEvent.VK_W) {
            ui.getHandler().getPlayer2().getHand().getCards().get(1).clickInHand(ui.getHandler());
        }
        // E: Click in hand
        else if (ke.getKeyCode() == KeyEvent.VK_E) {
            ui.getHandler().getPlayer1().getHand().getCards().get(1).clickInHand(ui.getHandler());
        }

        ui.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
