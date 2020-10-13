/** 
 * In-Game
 * 
 * By Peter Chen
 * By Tony Lee
 */

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Rectangle;
import java.io.File;
import javax.sound.sampled.*;

public class GameFrame extends JPanel implements ActionListener{
    
    private Timer mainTimer;
    private Player player;
    private Level[] levels;
    private int currentLevel;
    private TrackTime stopWatch;
    private boolean obstacleUp = false;
    private boolean obstacleDown = false;
    private boolean obstacleRight = false;
    private boolean obstacleLeft = false;
    private int playerX, playerY, impassableX, impassableY;
    private Rectangle[] bigImpassable;
    private int[][] map;
    private int[][] obstacles;
    private int xTile1;
    private int yTile1;
    private int xTile2;
    private int yTile2;
    private boolean lvl1 = false;
    private boolean lvl2 = false;
    private boolean lvl3 = false;
    private boolean lvl4 = false;
    private boolean lvl5 = false;
    private int health = 50;
    private int enemiesKilled = 0;
    private int numBullets = 0;
    private String userName;
    private int exitNum;
    Clip clip;
    
    public GameFrame(String userName) {
        
        this.userName = userName; //player name 
        stopWatch = new TrackTime();
        stopWatch.start();
        
        currentLevel = 0;
        levels = new Level[6];
        
        player = new Player(300, 300);
        
        for (int i = 0; i < 6; i++){
            levels[i] = new Level(i, player, health);
            
            player.setLevel(levels[currentLevel]);
            
        }
        
        player.setCoordinates(128, 192);
        
        KeyAdapt keyAdapter = new KeyAdapt(player);
        this.addKeyListener(keyAdapter);
        
        MouseAdapt mouseAdapter = new MouseAdapt(player);
        this.addMouseListener(mouseAdapter);
        
        setFocusable(true);
        
        mainTimer = new Timer(10, this);  //timer 
        mainTimer.start();
        
        turnOnSong(currentLevel);
        
    }
    
    //Turn on song, depending on the currentLevel
    public void turnOnSong(int currentLevel) {
        if (currentLevel == 0) {
            
            try {
                
                File bgm = new File("Village.wav");
                AudioInputStream bgmStream = AudioSystem.getAudioInputStream(bgm);
                DataLine.Info info = new DataLine.Info(Clip.class, bgmStream.getFormat());
                clip = (Clip)AudioSystem.getLine(info);
                
                clip.open(bgmStream);
                
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-10.0f);
                
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if (currentLevel == 1) {
            
            try {
                
                File bgm = new File("Swamp.wav");
                AudioInputStream bgmStream = AudioSystem.getAudioInputStream(bgm);
                DataLine.Info info = new DataLine.Info(Clip.class, bgmStream.getFormat());
                clip = (Clip)AudioSystem.getLine(info);
                
                clip.open(bgmStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if (currentLevel == 2) {
            
            try {
                
                File bgm = new File("Desert.wav");
                AudioInputStream bgmStream = AudioSystem.getAudioInputStream(bgm);
                DataLine.Info info = new DataLine.Info(Clip.class, bgmStream.getFormat());
                clip = (Clip)AudioSystem.getLine(info);
                
                clip.open(bgmStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if (currentLevel == 3) {
            
            try {
                
                File bgm = new File("Forest.wav");
                AudioInputStream bgmStream = AudioSystem.getAudioInputStream(bgm);
                DataLine.Info info = new DataLine.Info(Clip.class, bgmStream.getFormat());
                clip = (Clip)AudioSystem.getLine(info);
                
                clip.open(bgmStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if (currentLevel == 4) {
            
            try {
                
                File bgm = new File("Snow.wav");
                AudioInputStream bgmStream = AudioSystem.getAudioInputStream(bgm);
                DataLine.Info info = new DataLine.Info(Clip.class, bgmStream.getFormat());
                clip = (Clip)AudioSystem.getLine(info);
                
                clip.open(bgmStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } 
    }
    
    public void paint(Graphics g){ //draws the screen
        
        if (health > 0 && health <= 50) {
            
            super.paint(g);  
            Graphics2D g2d = (Graphics2D) g;  //uses g2d to draw images
            levels[currentLevel].draw(g2d, currentLevel);
            player.draw(g2d);
            levels[currentLevel].displayHealth(g2d, levels[currentLevel].getHealth());
            stopWatch.draw(g,1500,15);
            map = levels[currentLevel].getLevelMap(currentLevel);
            obstacles = new int[map.length][map[0].length];
            
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (currentLevel == 0) {
                        if ((map[i][j] >= 4 && map[i][j] <= 22) || map[i][j] == 32) {
                            obstacles[i][j] = 1; //An obstacle
                        } else {
                            obstacles[i][j] = 0; //Not an obstacle
                        }
                    } else if (currentLevel == 1) { //Swamp
                        if ((i == 0) || (j == 0) || (i == 30) || (j == 52)) {
                            obstacles[i][j] = 1;
                        } else {
                            obstacles[i][j] = 0;
                        }
                    } else if (currentLevel == 2) { //Desert
                        if ((i == 0) || (j == 0) || (i == 30) || (j == 52)) {
                            obstacles[i][j] = 1;
                        } else {
                            obstacles[i][j] = 0;
                        }
                        if ((map[i][j] >= 5) && (map[i][j] <= 10)) {
                            obstacles[i][j] = 1;
                        }
                    } else if (currentLevel == 3) {
                        if ((map[i][j] >= 5) && (map[i][j] <= 8)) {
                            obstacles[i][j] = 1;
                        } else {
                            obstacles[i][j] = 0;
                        }
                    } else if (currentLevel == 4) {
                        if ((i == 0) || (j == 0) || (i == 30) || (j == 52)) {
                            obstacles[i][j] = 1;
                        } else {
                            obstacles[i][j] = 0;
                        }
                        if ((map[i][j] >= 2) && (map[i][j] <= 5)) {
                            obstacles[i][j] = 1;
                        }
                    }
                }
            }
            
            levels[currentLevel].setObstacleMap(obstacles);
            
            xTile1 = (int)(player.getX() / 32);
            yTile1 = (int)(player.getY() / 32); 
            xTile2 = (int)((player.getX() + 29) / 32);
            yTile2 = (int)((player.getY() + 48) / 32);
            //Player's top left is at (map[yTile1][xTile1])
            //Player's bottom right is at (map[yTile2][xTile2])
            if (xTile1 > 0 && yTile1 > 0 && xTile2 < 52 && yTile2 < 30) {
                if ((obstacles[yTile1 - 1][xTile1] == 1) || (obstacles[yTile1 - 1][xTile2] == 1)) { //Obstacle is above
                    if ((player.getY() - 8) <= (yTile1 * 32)) {
                        player.setY(player.getY() + 10); //Bump back
                    }
                }
                if ((obstacles[yTile1][xTile2 + 1] == 1) || (obstacles[yTile2][xTile2 + 1] == 1)) { //Obstacle is right
                    if ((player.getX() + 8) >= (xTile2 * 32)) {
                        player.setX(player.getX() - 10);
                    }
                }
                if ((obstacles[yTile2 + 1][xTile1] == 1) || (obstacles[yTile2 + 1][xTile2] == 1)) { //Obstacle is down
                    if ((player.getY() + 16 + 8) >= (yTile2 * 32)) {
                        player.setY(player.getY() - 10);
                    }
                }
                if ((obstacles[yTile1][xTile1 - 1] == 1) || (obstacles[yTile2][xTile1 - 1] == 1)) { //Obstacle is left
                    if ((player.getX() - 8) <= (xTile1 * 32)) {
                        player.setX(player.getX() + 10);
                    }
                }
            }
            if (player.getBoundingBox().intersects(levels[currentLevel].getExitBox())) {
                int timeTook = stopWatch.getSecondsPassed();  //get time 
                
                if (currentLevel != 5) {
                    currentLevel++;
                }
                if (currentLevel == 4) {
                    exitNum = (int)(Math.random() * ((7 - 1) + 1)) + 1; //Random exit number from 1 to 7, inclusive
                }
                try {
                    File portalSound = new File("ThroughPortal.wav");
                    AudioInputStream portal = AudioSystem.getAudioInputStream(portalSound);
                    DataLine.Info zoom = new DataLine.Info(Clip.class, portal.getFormat());
                    Clip zoomClip = (Clip)AudioSystem.getLine(zoom);
                    
                    zoomClip.open(portal);
                    zoomClip.start();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                clip.stop();
                turnOnSong(currentLevel);
                if (currentLevel == 1) { //Swamp
                    levels[0].removeAll();
                    enemiesKilled  += levels[0].getEnemiesKilled();
                    health = levels[0].getHealth();
                    levels[1] = new Level(1, player, health);
                    player.setLevel(levels[currentLevel]);
                    player.setCoordinates(1440, 64);
                    
                } else if (currentLevel == 2) { //Desert
                    levels[1].removeAll();
                    enemiesKilled  += levels[1].getEnemiesKilled();
                    health = levels[1].getHealth();
                    levels[2] = new Level(2, player, health);
                    player.setLevel(levels[currentLevel]);
                    player.setCoordinates(128, 64);
                    
                } else if (currentLevel == 3) { //Forest
                    levels[2].removeAll();
                    enemiesKilled  += levels[2].getEnemiesKilled();
                    health = levels[2].getHealth();
                    levels[3] = new Level(3, player, health);
                    player.setLevel(levels[currentLevel]);
                    player.setCoordinates(128, 64);
                    
                } else if (currentLevel == 4) { //Snow
                    levels[3].removeAll();
                    enemiesKilled += levels[3].getEnemiesKilled();
                    health = levels[3].getHealth();
                    levels[4] = new Level(4, player, health);
                    player.setLevel(levels[currentLevel]);
                    player.setCoordinates(64, 832);
                    levels[4].setExitNum(exitNum);
                    
                } else if (currentLevel == 5) { //end game
                    levels[5] = new Level(5, player, health);
                    player.setLevel(levels[currentLevel]);
                    enemiesKilled += levels[4].getEnemiesKilled();
                    numBullets += levels[4].getPlayer().getBulletFired();
                    health = levels[4].getHealth();
                    int realHealth = health;
                    health = -50;
                    new EndFrame (userName, timeTook, realHealth, enemiesKilled, numBullets);
                } 
            }
        }
        
        for (int i=0;i<5;i++){
            
            if (levels[i].getHealth() <= 0 && levels[i].getHealth() > -5) {
                new EndFrame();
                for (int j=0;j<5;j++){
                    levels[j].setHealth(-10);
                }
            }
        }  
        
    }
    
    @Override 
    public void actionPerformed(ActionEvent arg0){  //repaints screen
        try {
            Thread.sleep(60);
        } catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        player.update();
        if (player.isMoving()) {
            levels[currentLevel].update();
        }
        repaint();
    }
}