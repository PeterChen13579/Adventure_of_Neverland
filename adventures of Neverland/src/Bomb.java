/** 
 * The class where player shoots its projectiles
 * 
 * By Peter Chen
 * By Tony Lee
 */


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class Bomb extends Projectile {
    
    private int frameNumber = 0;
    private int speed = Constants.FIREBALL_SPEED;;
    
    
    /*
     * Constructor
     * Takes in location of where the bomb is made, x and y coordinates
     * @ param LivingEntity source, int x, int y
     */
    public Bomb(LivingEntity source, int toX, int toY) { 
        super(source, toX, toY);
        this.setVelocity(new Vector(toX - source.getX(), toY - source.getY(), this.speed));
    }
    
    
    /*
     * update
     * updates the bomb to move 
     * @param
     */
    public void update() {
        this.move(this.getDX(), this.getDY());
    }
    
    /*
     * draw
     * Draws the bomb to the map
     * @param graphics g2d
     */
    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getBombImg(), this.getX(), this.getY(), null);
        
    } 
    
    
    /*
     * getBombImg
     * Gets the bomb image 
     * @param
     */
    public Image getBombImg(){ 
        return SpriteSheet.bombSprites[this.frameNumber]; 
    }
    
} // end of class