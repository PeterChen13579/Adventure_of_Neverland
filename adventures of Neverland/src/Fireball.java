/** 
 * Projectiles used by fire entities
 * 
 * Art heavily based on the works of @skeddles on pixeljoint
 * http://pixeljoint.com/pixelart/17892.htm
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

class Fireball extends Projectile {
    
    private int frameNumber = 0;
    private int speed = Constants.FIREBALL_SPEED;
    
    /*
     * Constructor
     * Creates Fireball based on the location of Fire Entity
     * @param gets where the FireEntity is created, int x, int y
     */
    public Fireball(LivingEntity source, int toX, int toY) { 
        super(source, toX, toY);
        this.setVelocity(new Vector(toX - source.getX(), toY - source.getY(), this.speed));
        // this.setHitbox(new CircleHitbox(this.getX(), this.getY(), 3));
    }
    
    /*
     * update
     * Updates the fireball to shoot it towards player
     * @param
     */
    public void update() {
        //System.out.println(getDirection());
        this.move(this.getDX(), this.getDY());
        //  this.hitbox.updatePosition(this.getVelocity());
        frameNumber = (frameNumber + 1) % 4; 
    }
    
    /*
     * draw
     * draw the fireball onto windows
     * @param Graphics 2D
     */
    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getFireballImg(), this.getX(), this.getY(), null);
    } 
    
    /*
     * getFireballImg
     * Gets the fireball image from sprite sheets
     * @param 
     */
    public Image getFireballImg(){ 
        return SpriteSheet.fireballSprite[this.frameNumber]; 
    }
    
} // end of class