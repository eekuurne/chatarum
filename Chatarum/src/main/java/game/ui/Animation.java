
package game.ui;

import cards.Minion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Eero Kuurne
 */
public class Animation implements ActionListener {

    Timer timer = new Timer(5, this);
    
    
    public void meleeAnimation(Minion attacker, Minion defender) {
        timer.start();
        
        
        
        
    }
    
    public void rangedAnimation(Minion attacker, Minion defender) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
