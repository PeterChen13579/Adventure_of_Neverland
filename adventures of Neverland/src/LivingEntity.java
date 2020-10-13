/** 
 * Abstract class applicable to the player character and all enemies
 * 
 * By Peter Chen
 * By Tony Lee
 */

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

abstract class LivingEntity {
    private int x;
    private int y;
    private int direction; 
    private int frameNumber;
    private boolean frozen;
    private Vector velocity;
    private Level currentLevel;
    private Rectangle boundingBox;
    
    /*
     * Constructor
     * All living things extend this
     * @param int x and y coordinates, int width, int height
     */
    public LivingEntity(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.frozen = false;
        this.direction = 1;
        this.velocity = new Vector(0, 0);
        boundingBox = new Rectangle(x, y, w, h);
    }
    
    
    /*
     * getBoundingBox
     * gets the bounding box of Living Entity
     * @param
     */
    public Rectangle getBoundingBox() {
        return boundingBox;
    }
    
    public void setVelocity(int velX, int velY) {
        velocity.set(velX, velY);
    }
    
    public void setVelocity(int mx, int my, int magnitude) {
        velocity.set(mx, my, magnitude);
    }
    
    
    /*
     * update
     * updates the bounding box of living Entity
     * @param int x, int y, int w, int h
     */
    public void update(int x, int y, int w, int h){
        getBoundingBox().setBounds(x, y, w, h);
    }
    
    public void draw(Graphics2D g2d){
    }
    
    
    /*
     * getX
     * gets the X coordinate of Living Entity
     * @param 
     * @return int X
     */
    public int getX() {
        return this.x;
    }
    
    /*
     * getY
     * gets the Y coordinate of Living Entity
     * @param 
     * @return int Y
     */
    public int getY() {
        return this.y;
    }
    
    
    /*
     * setLevel
     * sets the Y coordinate of Living Entity
     * @param newLevel
     */
    public void setLevel(Level newLevel) {
        this.currentLevel = newLevel;
    } // end of method
    
    public int getDirection() {
        return this.direction;
    }
    
    public void setDirection(int newDirection) {
        this.direction = newDirection;
    }
    
    public boolean isFrozen() {
        return this.frozen;
    }
    
    public void setX(int newX) {
        this.x = newX;
    }
    
    public void setY(int newY) {
        this.y = newY;
    }
    
    public void setCoordinates(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }
    
    public int getFrameNumber() {
        return this.frameNumber;
    }
    
    public int getVelX() {
        return velocity.getX();
    }
    
    public int getVelY() {
        return velocity.getY();
    }
    
    
    /*
     * move
     * moves a livingEntity
     * @param int velX, int velY
     */
    public void move(int velX, int velY) {
        this.x += velX;
        this.y += velY;
    }
    
    public void move() {
        this.x += velocity.getX();
        this.y += velocity.getX();
    }
    
    /*
     * updateFrameNumber
     * Updates the frame number of Living Entity
     * @ param
     */
    public void updateFrameNumber() {
        this.frameNumber = (frameNumber + 1) % 4;
    }
    
    public void updateFrameNumber(int increment, int limit) {
        this.frameNumber = (frameNumber + increment) % limit;
    }
    
    /*
     * getCurrentLevel
     * gets the current level of what the player is on
     * @ param
     */
    public Level getCurrentLevel() {
        return this.currentLevel;
    }
    
} // End of class