/** 
 * To make using the sprites easier
 * By Peter Chen
 * By Tony Lee
 */

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class SpriteSheet {
    
    public static Image[][] playerWalkingSprite;
    private static BufferedImage playerWalkingSpriteSheet;
    
    public static Image[][] fireEntityWalkingSprite;
    private static BufferedImage fireEntityWalkingSpriteSheet;
    
    public static Image[][] waterEntityWalkingSprite;
    private static BufferedImage waterEntityWalkingSpriteSheet;
    
    public static Image[][] earthEntityWalkingSprite;
    private static BufferedImage earthEntityWalkingSpriteSheet;
    
    public static Image[] fireballSprite;
    private static BufferedImage fireballSpriteSheet;
    
    public static Image[] fireSprite;
    private static BufferedImage fireSpriteSheet;
    
    public static Image [] playerProjectileSprites;
    private static BufferedImage bulletSheet;
    
    public static Image [] bombSprites;
    private static BufferedImage bomb;
    
    public static void initializeImages() {
        try {
            
            playerProjectileSprites = new Image[1];
            bulletSheet = ImageIO.read(new File("images/bullet.png"));
            
            loadEntitySpriteSheet(playerProjectileSprites, bulletSheet);
            
            bombSprites = new Image[1];
            bomb = ImageIO.read(new File("images/Bomb.png"));
            
            loadEntitySpriteSheet(bombSprites, bomb, true);
            
            playerWalkingSprite = new Image[8][4];
            playerWalkingSpriteSheet = ImageIO.read(new File("images/PlayerWalking.png"));
            
            loadEntitySpriteSheet(playerWalkingSprite, playerWalkingSpriteSheet);
            
            fireEntityWalkingSprite = new Image[8][4];
            fireEntityWalkingSpriteSheet = ImageIO.read(new File("images/FireEntity.png"));
            
            loadEntitySpriteSheet(fireEntityWalkingSprite, fireEntityWalkingSpriteSheet);
            
            waterEntityWalkingSprite = new Image[8][4];
            waterEntityWalkingSpriteSheet = ImageIO.read(new File("images/WaterEntity.png"));
            
            loadEntitySpriteSheet(waterEntityWalkingSprite, waterEntityWalkingSpriteSheet);
            
            earthEntityWalkingSprite = new Image[8][4];
            earthEntityWalkingSpriteSheet = ImageIO.read(new File("images/EarthEntity.png"));
            
            loadEntitySpriteSheet(earthEntityWalkingSprite, earthEntityWalkingSpriteSheet);
            
            fireballSprite = new Image[4];
            fireballSpriteSheet = ImageIO.read(new File("images/Fireball.png"));
            
            loadSpriteSheet(fireballSprite, fireballSpriteSheet, 4, 16, 9);
            
            fireSprite = new Image[4];
            fireSpriteSheet = ImageIO.read(new File("images/Fire.png"));
            
            loadSpriteSheet(fireSprite, fireSpriteSheet, 4, 32, 32);
            
            
            
        }
        catch (IOException e) {
            System.out.println("Error: Failed to load an image");
        }
    }// end if method initializeImages()
    
    
    public static void loadEntitySpriteSheet(Image bombSprites[], BufferedImage bomb, boolean check){
        bombSprites[0] = bomb;
        
    }
    
    private static void loadEntitySpriteSheet(Image playerProjectileSprites [], BufferedImage bulletSheet){
        
        playerProjectileSprites [0]= bulletSheet;
    }
    
    private static void loadEntitySpriteSheet(Image[][] spriteSheetArray, BufferedImage spriteSheet) {
        for (int n = 0; n < 8; n++) {
            for (int i = 0; i < 4; i++) {
                spriteSheetArray[n][i] = spriteSheet.getSubimage(i * 32, n * 48, 32, 48);
            } // end of n for loop
        } // end of i for loop
    } // end of method
    
    
    private static void loadSpriteSheet(Image[][] spriteSheetArray, BufferedImage spriteSheet, int vertical, int height, int horizontal, int width) {
        for (int n = 0; n < vertical; n++) {
            for (int i = 0; i < horizontal; i++) {
                spriteSheetArray[n][i] = spriteSheet.getSubimage(i * width, n * height, width, height);
            } // end of n for loop
        } // end of i for loop
    } // end of method
    
    private static void loadSpriteSheet(Image[] spriteSheetArray, BufferedImage spriteSheet, int horizontal, int width, int height) {
        for (int i = 0; i < horizontal; i++) {
            spriteSheetArray[i] = spriteSheet.getSubimage(i * width, 0, width, height);
        } // end of i for loop
    } // end of method
    
} // end of class