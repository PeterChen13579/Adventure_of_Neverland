

import java.awt.Graphics2D;
import java.awt.Image;

class EarthEntity extends Enemy{
    private int speed = Constants.EARTH_ENTITY_SPEED;
    private boolean moving = false;
    private int id;
    private int cooldown;
    
    /*
     * Constructor
     * Creates EarthEntity
     * @param id, direction, x and y coordinates
     */
    public EarthEntity(int id, int direction, int x, int y) {
        super(x, y, 32, 32);
        this.id = id;
        this.setDirection(direction);
        this.cooldown = Constants.BOMB_COOLDOWN;
    }
    
    /*
     * update
     * Shoots bombs when cooldown hits 0
     * @ param
     */
    @Override
    public void update(){
        if (moving) {
            
            //  this.updateHitbox();
        }
        this.updateFrameNumber();
        //System.out.println(this.getFrameNumber()); // debug
        if (cooldown > 0) {
            cooldown--;
        } else {
            this.shoot(getCurrentLevel().getPlayer());
        }
    }
    
    /*
     * shoot
     * Shoots bombs towards player
     * @param player
     */
    public void shoot(Player p) {
        getCurrentLevel().add(new Bomb(this, p.getX(), p.getY()));
        cooldown = Constants.PROJECTILE_COOLDOWN;
    }
    
    /*
     * draw
     * Draws Earth Entity to map
     * @param Graphics2D
     */
    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getEarthEntityImg(), this.getX(), this.getY(), null);
        //System.out.println("Drawing FireEntity " + id); // debug
    } 
    
    /*
     * getEarthEntityImg
     * gets the earth entity image from spritesheets
     * @param
     */
    public Image getEarthEntityImg(){ 
        //System.out.println("Getting new image for FireEntity " + id); // debug
        return SpriteSheet.earthEntityWalkingSprite[this.getDirection()][this.getFrameNumber()];  
    }
} // end of class