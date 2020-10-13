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

class PlayerProjectile extends Projectile {
    
    private int frameNumber = 0;
    private int speed = Constants.FIREBALL_SPEED;;
    
    
    /*
     * Constructor
     * Creates PlayerProjectile based on where player is
     * @param LivingEntity source, int X, int Y
     */
    public PlayerProjectile(LivingEntity source, int toX, int toY) { 
        super(source, toX, toY);
        this.setVelocity(new Vector(toX - source.getX(), toY - source.getY(), this.speed));
    }
    
    /*
     * update
     * udpate PlayerProjectile based on where  the user clicked
     * @param
     */
    public void update() {
        this.move(this.getDX(), this.getDY());
    }
    
    /*
     * draw
     * Draws playerProjectile on map
     * @param Graphics g2d
     */
    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getBulletImg(), this.getX(), this.getY(), null);
        
    } 
    
    /*
     * getBulletImg
     * Draws playerProjectile on map
     * @param Graphics g2d
     */
    public Image getBulletImg(){ 
        return SpriteSheet.playerProjectileSprites[this.frameNumber]; 
    }
    
} // end of class