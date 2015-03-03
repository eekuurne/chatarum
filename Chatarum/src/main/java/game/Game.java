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

    private double scale;
    private boolean fullscreen;

    public Game(String title, int width, int height, boolean fullscreen) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.scale = (double) width / 1920;
        this.fullscreen = fullscreen;
    }

    @Override
    public void run() {
        frame = new JFrame(title);

        if (!fullscreen) { // Fixes the game to be right resolution instead of window size.
            height += 28;
            width += 6;
        }
        isFullscreen();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Assets.init(scale); // Load and crop images and set dimensions.
        Locations.init(); // Set locations.

        // Scales everything from original 1920x1080 resolution to the new resolution.
        Assets.scale(scale);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * If the launcher sets fullscreen to true, this method makes the game
     * full screen. If false, the game will be windowed.
     *
     */
    public void isFullscreen() {
        if (fullscreen) {
            frame.setUndecorated(true); // Disables decorations for frame.
            frame.setExtendedState(frame.MAXIMIZED_BOTH); // Puts the frame to full screen.
        } else {
            frame.setPreferredSize(new Dimension(width, height));
            //frame.setLocationRelativeTo(null); // Frame starts at middle.
            frame.setResizable(false); // The window isn't resizable by user.

        }
    }

    private void createComponents(Container container) {
        UserInterface ui = new UserInterface();
        MouseInput mouse = new MouseInput(ui);
        ui.addMouseListener(mouse);
        ui.addMouseMotionListener(mouse);
        container.add(ui);

        frame.addKeyListener(new KeyboardInput(ui));
        //frame.addMouseListener(new MouseInput(ui, fullscreen));
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }
}
