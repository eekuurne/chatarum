package game;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * The class for setting up the window (frame and canvas).
 *
 * @author Eero
 */
public class Display {

    private String title;
    private int width, height;

    private JFrame frame;
    private Canvas canvas;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    /**
     * Method for all the frame and canvas setup.
     *
     */
    private void createDisplay() {
        frame = new JFrame(title);

        // Change this to true to switch to fullscreen mode.
        fullscreen(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Program closes down properly when you close the window.
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack(); // Sizes the canvas properly compared to frame.
    }

    public JFrame getFrame() {
        return frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * Method which can change if fullscreen or windowed mode is used. Can be
     * done from settings later, now manually by changing parameter.
     *
     * @param full Is fullscreen mode used.
     */
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
}
