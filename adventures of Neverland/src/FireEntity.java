

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

class FireEntity extends Enemy{
    private int speed = Constants.FIRE_ENTITY_SPEED;
    private boolean moving = false;
    private Level currentLevel;
    private int id;
    private int cooldown;
    
    /*
     * Constructor
     * Creates FireEntity (enemies)
     * @param int id, int direction, int x and int y coordinates
     */
    public FireEntity(int id, int direction, int x, int y) {
        super(x, y, 32, 32);
        this.id = id;
        this.setDirection(direction);
        this.cooldown = Constants.PROJECTILE_COOLDOWN;
    }
    
    /*
     * update
     * updates FireEntity to see when it shoots
     * @param 
     * @FireEntity shoots when cool down his 0
     */
    @Override
    public void update(){
        if (moving) {
            //  this.updateHitbox();
        }
        this.updateFrameNumber();
        if (cooldown > 0) {
            cooldown--;
        } else {
            this.shoot(getCurrentLevel().getPlayer());
        } 
    }
    
    
    /*
     * shoot
     * shoots Fireball towards player 
     * @param player
     * @Gets where FireEntity currently is and shoots fireball towards player 
     */
    public void shoot(Player p) {
        getCurrentLevel().add(new Fireball(this, p.getX(), p.getY()));
        cooldown = Constants.PROJECTILE_COOLDOWN;
    }
    
    
    /*
     * boundingBox
     * Gets BoundingBox to detect collision
     * @param
     * @return boundingBox
     */
    public Rectangle boundingBox() {
        return boundingBox();
    }
    /*
     * draw
     * draws FireEntity on map
     * @param Graphics 2D g2d
     */
    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getFireEntityImg(), this.getX(), this.getY(), null);
    } 
    
    /*
     * getFireEntityImg
     * Gets FireEntityImg from sprite sheets
     * @param
     */
    public Image getFireEntityImg(){ 
        return SpriteSheet.fireEntityWalkingSprite[this.getDirection()][this.getFrameNumber()];  
    }
} // end of class