package game;

import graphics.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
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
    
    // States
    private State gameState;
    private State menuState;
    private State settingsState;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    /**
     * Method which handles the things that happen at start of the game only.
     *
     */
    private void init() {
        display = new Display(title, width, height);
        Assets.init();
        
        gameState = new GameState();
        menuState = new MenuState();
        settingsState = new SettingsState();
        State.setState(gameState);
    }

    private void tick() {
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
     * Method which starts, runs and stops the game loop.
     *
     */
    @Override
    public void run() {
        init();

        int fps = 60;
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
                System.out.println("FPS: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
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
