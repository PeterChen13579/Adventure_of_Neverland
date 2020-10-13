/** 
 * Abstract class applicable to all sources of projectile damage
 * 
 * By Peter Chen
 * By Tony Lee
 */

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

abstract class Projectile{
    private LivingEntity source;
    private int x;
    private int y;
    private Vector velocity;
    Rectangle boundingBox;
    Rectangle bulletBox;
    Rectangle bombBox;
    private double xPosition,yPosition;
    
    /*
     * Constructor
     * Creates Projectile based on where the LivingEntity source is
     * @param LivingEntity source, int X, int Y
     */
    public Projectile(LivingEntity source, int toX, int toY) {
        super();
        this.x = source.getX();
        this.y = source.getY();
        boundingBox = new Rectangle(x-1, y, 12 ,9);
        bulletBox = new Rectangle (x+1 , y+1, 12, 12);
        bombBox = new Rectangle(x+1, y+1, 17,17);
    }
    
    /*
     * boundingBox
     * Gets BoundingBox to detect collision
     * @param
     * @return bounding box
     */
    public Rectangle getBoundingBox() {
        return boundingBox;
    }
    
    /*
     * getBulletBox
     * Gets BoundingBox to detect collision
     * @param
     * @return bulletBox
     */
    public Rectangle getBulletBox(){
        return bulletBox; 
    }
    
    /*
     * getBombBox
     * Gets BombBox to detect collision
     * @param
     * @return BombBox
     */
    public Rectangle getBombBox(){
        return bombBox;
    }
    
    /*
     * move
     * moves towards where the projectile is going
     * @param
     * @return BombBox
     */
    public void move(int velX, int velY) {
        this.x += velX;
        this.y += velY;
        xPosition += velX;
        yPosition += velY;
        getBoundingBox().setBounds(x-1, y, 12 ,9);
        getBulletBox().setBounds(x+1 , y+1, 12, 12);
        getBombBox().setBounds(x+1, y+1, 17,17);
        // System.out.println("Hitbox-Projectile (x,y) --> (" + getBoundingBox().getX() + "," + getBoundingBox().getY() + ")");
    }
    
    
    /*
     * update
     * updates where the projectiles are going
     * @param
     */
    public void update() {
        this.x += velocity.getX();
        this.y += velocity.getY();
        xPosition += velocity.getX();
        yPosition += velocity.getY();
    }
    
    public void draw(Graphics2D g2d) {
    } 
    
    public int getDX() {
        return velocity.getX();
    }
    
    public int getDY() {
        return velocity.getY();
    }
    
    /*
     * getX
     * getX coordinate of the projectile
     * @param 
     * @return X coordinate
     */
    public int getX() {
        return this.x;
    }
    
    public Vector getVelocity() {
        return this.velocity;
    }
    
    /*
     * getY
     * getY coordinate of the projectile
     * @param 
     * @return Y coordinate
     */
    public int getY() {
        return this.y;
    }
    
    /*
     * setX
     * setX coordinates of the projectile
     * @param int X
     */
    public void setX(int newX) {
        this.x = newX;
    }
    
    /*
     * setY
     * setY coordinate of the projectile
     * @param int Y
     */
    public void setY(int newY) {
        this.y = newY;
    }
    
    public void setVelocity(Vector newVelocity) {
        this.velocity = newVelocity;
    }
    
} // End of class