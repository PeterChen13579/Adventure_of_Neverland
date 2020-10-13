/** 
 * Class representing the player's character
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
import javax.sound.sampled.*;

class Player extends LivingEntity {
    private int velX = 0;
    private int velY = 0;
    private int frameNumber = 0;
    private int speed = Constants.PLAYER_SPEED;
    private boolean moving = false;
    private boolean obstacleUp, obstacleDown, obstacleLeft, obstacleRight = false;
    private int bulletFired = 0;
    
    /*
     * Constructor
     * Creates player 
     * @param int x, int y coordinates
     */
    public Player(int x, int y) {
        super(x, y, 29, 48);
        //this.setHitbox(new AABB(this.getX(), this.getY(), Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT));
    }
    
    private void die() {
    }
    
    /*
     * setObstacle
     * setsObstacle if it is beside the player
     * @param boolean obstacleUp, boolean obstacleRight, boolean obstacleDown, boolean obstacleLeft
     */
    public void setObstacle(boolean obstacleUp, boolean obstacleRight, boolean obstacleDown, boolean obstacleLeft) {
        this.obstacleUp = obstacleUp;
        this.obstacleRight = obstacleRight;
        this.obstacleDown = obstacleDown;
        this.obstacleLeft = obstacleLeft;
    }
    
    /*
     * update
     * updates the player when they move
     * @param
     */
    public void update() {
        //System.out.println(getDirection());
        this.move(velX, velY);
        //System.out.println(velX + "hihi " + velY);
        //    this.updateHitbox();
        if (moving) {
            frameNumber = (frameNumber + 1) % 4;
        }
        update(getX()+1, getY()+1, 27, 46);
    } 
    
    /*
     * shoot
     * player shoots bullet towards where they are clicking
     * @param int X, int Y
     */
    public void shoot(int toX, int toY) {
        this.getCurrentLevel().add(new PlayerProjectile(this, toX, toY));
        try {
            File shoot = new File("Player_Shoot.wav");
            AudioInputStream shootSound = AudioSystem.getAudioInputStream(shoot);
            DataLine.Info shooting = new DataLine.Info(Clip.class, shootSound.getFormat());
            Clip shootClip = (Clip)AudioSystem.getLine(shooting);
            
            shootClip.open(shootSound);
            FloatControl gainControl = (FloatControl) shootClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10.0f);
            shootClip.start();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        bulletFired++;
    }
    
    /*
     * getBulletFired
     * gets the number of bullet fired
     * @param 
     * @return number of bullets fired
     */
    
    public int getBulletFired(){
        return this.bulletFired;
        
    }
    
    // Runs whenever a player attempts an attack
    // Returns true upon success
    public boolean melee(LivingEntity target, SourceOfDamage weaponUsed) {
        return false;
    } 
    
    // Draws player in the window
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getPlayerImg(), this.getX(), this.getY(), null);
    } 
    
    // Gets image
    public Image getPlayerImg(){ 
        return SpriteSheet.playerWalkingSprite[this.getDirection()][this.frameNumber];  
    }
    
    public boolean isMoving() {
        return this.moving;
    }
    
    // Runs when a key is pressed
    public void keyPressed(KeyEvent e) {
        this.moving = true;
        int key = e.getKeyCode();
        //   System.out.println("obstacleUp = " + obstacleUp);
        //   System.out.println("obstacleRight = " + obstacleRight);
        //   System.out.println("obstacleDown = " + obstacleDown);
        //   System.out.println("obstacleLeft = " + obstacleLeft);
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP && !obstacleUp){   //if user press W or up arrow key
            velY = -speed;
            this.setDirection(7);
            obstacleDown = false;
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN && !obstacleDown){   //if user press S or down arrow key
            velY = speed;
            this.setDirection(1);
            obstacleUp = false;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT && !obstacleRight){  //if user press D or right arrow key
            velX = speed;
            this.setDirection(5);
            obstacleLeft = false;
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT && !obstacleLeft){   //if user press A or left arrow key
            velX = -speed;
            this.setDirection(3);
            obstacleRight = false;
        }
        
        
        // For diagonal direction
        if (!( velY == 0 || velX == 0)) {
            if (velY == -speed) {
                if (velX == -speed) {
                    this.setDirection(4);
                } else if (velX == speed) {
                    this.setDirection(6);
                } else {
                    System.out.println("Error in player velX");
                }
            } else if (velY == speed) {
                if (velX == -speed) {
                    this.setDirection(0);
                } else if (velX == speed) {
                    this.setDirection(2);
                } else {
                    System.out.println("Error in player velX");
                }
            } else {
                System.out.println("Error in player velY");
            }
        }
    }
    
    
    // Runs when a key is released
    public void keyReleased(KeyEvent e){  
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP){   //if user releases w or up arrow key
            velY = 0;
        }else if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN){  //if user releases S or down arrow key
            velY = 0;
        }else if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){  //if user releases A or left arrow key
            velX = 0;
        }else if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){  //if user releases D or right arrow key
            velX = 0;
        }
        // For horizontal/vertical direction
        if (velX != 0) {
            if (velX == -speed) {
                this.setDirection(3);
            } else if (velX == speed) {
                this.setDirection(5);
            } else {
                System.out.println("Error in player velX");
            }
        } else if (velY != 0) {
            if (velY == -speed) {
                this.setDirection(7);
            } else if (velY == speed) {
                this.setDirection(1);
            } else  {
                System.out.println("Error in player velY");
            } 
        } else {
            this.frameNumber = 0;
            this.moving = false;
        }
    }
    
} // End of class