package game;

import cards.containers.Deck;
import game.input.KeyManager;
import game.input.MouseManager;
import graphics.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import states.GameState;
import states.MenuState;
import states.SettingsState;
import states.State;

/**
 * "Main" class of the game.
 *
 * @author Eero
 */
public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;

    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;
    // private GraphicsContext gc;
    
    // States
    private State gameState;
    private State menuState;
    private State settingsState;

    // Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.keyManager = new KeyManager();
    }

    /**
     * Method which handles the things that happen at start of the game only.
     *
     */
    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        Assets.init();
        
        // gc = display.getCanvas().getGraphicsContext2D();

        gameState = new GameState(this);
        menuState = new MenuState(this);
        settingsState = new SettingsState(this);
        State.setState(gameState);
    }

    /**
     * What needs to happen on every game loop (30/s). Input controllers and
     * animations mostly.
     *
     */
    private void tick() {
        keyManager.tick();
        
        
        if (true) {
            
        }
        
        

        if (State.getState() != null) {
            State.getState().tick();
        }
    }

    /**
     * The base method for rendering what the state has to render.
     *
     */
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        // Clear screen.
        g.clearRect(0, 0, width, height);

        if (State.getState() != null) {
            State.getState().render(g);
        }

        bs.show();
        g.dispose();
    }

    /**
     * Method which starts, runs and stops the game loop. The frames per second
     * is hardcoded to 30.
     *
     */
    @Override
    public void run() {
        init();

        int fps = 30;
        double timePerTick = 1000000000 / fps;
        double delta = 0; // Time left before we have to render again
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                delta--;
                ticks++;
            }

            if (timer >= 1000000000) {
                // System.out.println("FPS: " + ticks); // prints FPS to output
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    /**
     * Method for starting the thread.
     *
     */
    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * Method for stopping the thread.
     *
     */
    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
