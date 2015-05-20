package game.ui;

import cards.Minion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * This class will handle the animations.
 * 
 * @author Eero Kuurne
 */
public class Animation implements ActionListener {

    private Timer timer;
    
    public Animation() {
        this.timer = new Timer(5, this);
    }

    
    
    public void meleeAnimation(Minion attacker, Minion defender) {
        timer.start();
        
        
        
        
        timer.stop();
    }

    public void rangedAnimation(Minion attacker, Minion defender) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
