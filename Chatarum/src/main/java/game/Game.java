package game;

import game.assets.Assets;
import game.assets.ImageLoader;
import game.input.KeyboardInput;
import game.input.MouseInput;
import game.ui.Locations;
import game.ui.UserInterface;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * The base class of the game. 
 *
 * @author Eero Kuurne
 */
public class Game implements Runnable {

    private JFrame frame;

    private String title;
    private int width, height;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    @Override
    public void run() {
        frame = new JFrame(title);
        fullscreen(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Assets.init();
        Locations.init();
        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void fullscreen(boolean full) {
        if (full) {
            frame.setUndecorated(true); // Disables decorations for frame.
            frame.setExtendedState(frame.MAXIMIZED_BOTH); // Puts the frame to full screen.
        } else {
            frame.setSize(width, height);
            frame.setLocationRelativeTo(null); // Frame starts at middle.
            frame.setResizable(false); // The window isn't resizable by user.
        }
    }

    private void createComponents(Container container) {
        UserInterface ui = new UserInterface();
        container.add(ui);
        
        frame.addKeyListener(new KeyboardInput(ui));
        frame.addMouseListener(new MouseInput(ui));
    }

}
