/** 
 * For fire
 * 
 * By Peter Chen
 * By Tony Lee
 */


import java.awt.Graphics2D;
import java.awt.Image;

class Fire extends LevelObject {
    int lifeSpan;
    int frameNumber;
    boolean frozen;
    private int x, y;
    
    /*
     * Constructor
     * Creates a new fire object level
     * @param int x int y coordinates
     */
    public Fire(int x, int y){
        super(x, y);
        lifeSpan = 40; // for 5 seconds TODO: Constants
    }
    
    // Draws fireball in the window
    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getFireImg(), this.getX(), this.getY(), null);
    } 
    
    //Gets image from SpriteSheet
    public Image getFireImg(){ 
        return SpriteSheet.fireSprite[this.frameNumber]; 
    }
    
    public void update() {
        if (!frozen) {
            frameNumber = (frameNumber + 1) % 4;
            lifeSpan--;
        }
    } // end of method
    
    public void extinguish() {
    }
    
    public boolean isFrozen() {
        return this.frozen;
    }
    
    public void moveLeft(){
        
    }
    
    public void moveRight(){
        
    }
    
    public void moveDiagonalRight(){
        
    }
    
    public void moveDiagonalLeft(){
    }
    
    
    
} // End of class