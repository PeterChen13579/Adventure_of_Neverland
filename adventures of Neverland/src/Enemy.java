

import java.awt.Graphics2D;
import java.awt.Rectangle;

abstract class Enemy extends LivingEntity{
    
    /*
     * Constructor
     * Creates enemies
     * @param int x, int y, int width, int height
     */
    public Enemy(int x, int y, int w, int h) {
        super(x, y, 32, 32);
    }
    
    
    public void draw(Graphics2D g2d) {
    } 
    
    public void setCoordinates(){
        
    }
    
    /*
     * update
     * Updates enemies 
     * @param
     */
    public void update() {
        //System.out.println(getDirection());
        this.move();
        this.updateFrameNumber();
    } 
}