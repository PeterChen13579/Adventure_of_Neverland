/** 
 * Helps store information on direction, velocity, and location
 * 
 * By Peter Chen
 * By Tony Lee
 */

import java.lang.Math;

class Vector {
    private int dx; // delta x
    private int dy; // delta y
    private double angle; // angle in radians
    
    // Constructors
    public Vector() {
        dx = 0;
        dy = 0;
    }
    
    public Vector(double angle, int magnitude) {
        dx = (int)(Math.cos(angle) * magnitude);
        dy = (int)(Math.sin(angle) * magnitude);
    }
    
    // takes slope and desired magnitude as input
    public Vector(int mx, int my, int magnitude) {
        dx = (int)(mx / (Math.sqrt((Math.pow(mx, 2) + Math.pow(my, 2))) / magnitude));
        dy = (int)(my / (Math.sqrt((Math.pow(mx, 2) + Math.pow(my, 2))) / magnitude));
    }
    
    
    public int getX() {
        return this.dx;
    }
    
    public int getY() {
        return this.dy;
    }
    
    // takes slope and desired magnitude as input
    public void set(int mx, int my, int magnitude) {
        dx = (int)(mx / (Math.sqrt((Math.pow(mx, 2) + Math.pow(my, 2))) / magnitude));
        dy = (int)(my / (Math.sqrt((Math.pow(mx, 2) + Math.pow(my, 2))) / magnitude));
    }
    
    public void set(int newDX, int newDY) {
        dx = newDX;
        dy = newDY;
        angle = Math.atan(dx/dx); 
    }
    
    public void setDeltaX(int newDeltaX) {
        this.dx = newDeltaX;
    }
    
    public void setDeltaY(int newDeltaY) {
        this.dy = newDeltaY;
    }
    
} // End of class