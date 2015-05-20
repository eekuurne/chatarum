/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.ui;

import cards.Minion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Eero Kuurne
 */
public class MeleeAnimation implements ActionListener{

    private Timer timer;
    private int velocity;

    public MeleeAnimation() {
        this.timer = new Timer(velocity, this);
        this.velocity = 5;
    }
    
    public void meleeAttack(Minion attacker, Minion defender) {
        
        if (attacker.getX() > defender.getX()) {
            
        }
        
        
        timer.start();
        
        
        
        
        timer.stop();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }

}
