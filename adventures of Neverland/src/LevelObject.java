/** 
 * Used to store data on level objects
 * 
 * By Peter Chen
 * By Tony Lee
 */

import java.awt.Graphics2D;
import java.awt.Rectangle;

class LevelObject {
    int x;
    int y;
    int id;
    Rectangle boundingBox;
    
    // Constructor
    public LevelObject(int x, int y) {
        this.x = x;
        this.y = y;
        boundingBox = new Rectangle(x, y, 32 ,32);
    }
    
    public Rectangle getBoundingBox(){
        return this.boundingBox;
    }
    
    public LevelObject(){
        
    }
    
    public void update(){
    }
    
    public void draw(Graphics2D g2d) {
    } 
    
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getID() {
        return this.id;
    }
    
} // End of class