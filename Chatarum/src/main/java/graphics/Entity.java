package graphics;

import java.awt.Graphics;

/**
 * Abstract class for every single (movable) item that is drawn in the screen during a 
 * match. Tells where to draw and what happens on tick and render.
 *
 * @author Eero
 */
public abstract class Entity {
    
    protected float x, y;
    
    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
}
