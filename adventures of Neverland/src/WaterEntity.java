

import java.awt.Graphics2D;
import java.awt.Image;

class WaterEntity extends Enemy{
    private int speed = Constants.WATER_ENTITY_SPEED;
    private boolean moving = false;
    private int id;
    
    /*
     * Constructor
     * Creates WaterEntity (enemies)
     * @param int id, int direction, int x and int y coordinates
     */
    public WaterEntity(int id, int direction, int x, int y) {
        super(x, y, 32, 32);
        this.id = id;
        this.setDirection(direction);
    }
    
    
    /*
     * update
     * updates Water Entity
     * @param 
     */
    @Override
    public void update(){
        if (moving) {
            //  this.updateHitbox();
        }
        this.updateFrameNumber();
        //System.out.println(this.getFrameNumber()); // debug
    }
    
    
    /*
     * draw
     * draws Water Entity on screen
     * @param graphics g2d
     */
    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getWaterEntityImg(), this.getX(), this.getY(), null);
        //System.out.println("Drawing WaterEntity " + id); // debug
    } 
    
    
    /*
     * getWaternEntityImg
     * Gets getWaternEntityImg from sprite sheets
     * @param
     */
    public Image getWaterEntityImg(){ 
        //System.out.println("Getting new image for WaterEntity " + id); // debug
        return SpriteSheet.waterEntityWalkingSprite[this.getDirection()][this.getFrameNumber()];  
    }
} // end of class