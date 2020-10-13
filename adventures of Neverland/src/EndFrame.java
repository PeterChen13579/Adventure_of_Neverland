/*
 * This screen occurs when the game is completed
 * 
 * By Peter Chen
 * By Tony Lee
 */


import javax.swing.JPanel;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class EndFrame extends JFrame {
    JFrame endFrame;
    JFrame died;
    
    
    EndFrame(String userName, int timeTook, int healthLeft, int enemiesKilled, int numBullets){
        endFrame = new JFrame();
        endFrame.setTitle("Adventures of Neverland");
        
        //configure the window
        endFrame.setBounds(460, 170, 1000, 700);   
        endFrame.setLocationRelativeTo(null); //start the frame in the center of the screen
        endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        endFrame.setResizable (false);
        
        JLabel done = new JLabel("Congratulations on Beating Adventures of NeverLands!");
        done.setFont(new Font("Andalus", Font.BOLD, 29));
        done.setForeground(Color.BLACK);
        done.setSize (new Dimension(800,400));
        done.setLocation (100,40);
        
        JLabel done1 = new JLabel("Please check if Your Name is on the High Score List!");
        done1.setFont(new Font("Andalus", Font.BOLD, 25));
        done1.setForeground(Color.BLACK);
        done1.setSize (new Dimension(900,400));
        done1.setLocation (110,300);
        
        System.out.println("healthLeft = " + healthLeft);
        System.out.println("enemiesKilled = " + enemiesKilled);
        System.out.println("timeTook = " + timeTook);
        System.out.println("numBullets = " + numBullets);
        
        int score = (1000) + (healthLeft * 100) + (enemiesKilled*5) - (timeTook) - (numBullets/2);
        
        JLabel done2 = new JLabel("Your final score is " + score);
        done2.setFont(new Font("Andalus", Font.BOLD, 25));
        done2.setForeground(Color.BLACK);
        done2.setSize(new Dimension(900, 400));
        done2.setLocation(340, 90);
        
        ImageIcon image1 = new ImageIcon("Images/score.png"); 
        JLabel picLabel1 = new JLabel(image1);
        picLabel1.setLocation (387,335);   //sets the location of the picture
        picLabel1.setSize(new Dimension(200,100));  //set the pictures dimensions
        
        
        
        //background
        try{
            System.out.println("BACKGROUND RAN 1");
            BufferedImage backgroundImg = ImageIO.read(new File("images/Background.png"));
            ImageIcon backgroundIcon = new ImageIcon(backgroundImg);
            JLabel background = new JLabel(backgroundIcon);
            endFrame.setContentPane(background);
        }catch(IOException ex){
        } 
        
        endFrame.add(picLabel1);
        endFrame.add(done);
        endFrame.add(done1);
        endFrame.add(done2);
        endFrame.setVisible(true);
        
        new TimeWarp(userName, score);
        
    }
    
    
    
    EndFrame(){
        died = new JFrame();
        died.setTitle("Adventures of Neverland");
        died.setBounds(460, 170, 1000, 700);   
        died.setLocationRelativeTo(null); //start the frame in the center of the screen
        died.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        died.setResizable (false);
        
        
        JLabel diedLabel = new JLabel("You Have Died");
        diedLabel.setFont(new Font("Andalus", Font.BOLD, 30));
        diedLabel.setForeground(Color.BLACK);
        diedLabel.setSize (new Dimension(800,400));
        diedLabel.setLocation (380,40);
        
        JLabel diedLabel2 = new JLabel("Good Luck Next Time!");
        diedLabel2.setFont(new Font("Andalus", Font.BOLD, 28));
        diedLabel2.setForeground(Color.BLACK);
        diedLabel2.setSize (new Dimension(800,400));
        diedLabel2.setLocation (335,100);
        
        JLabel diedLabel3 = new JLabel("Please Close the Program to Try Again!");
        diedLabel3.setFont(new Font("Andalus", Font.BOLD, 27));
        diedLabel3.setForeground(Color.BLACK);
        diedLabel3.setSize (new Dimension(800,400));
        diedLabel3.setLocation (220,200);
        
        ImageIcon image1 = new ImageIcon("Images/Death.png");  
        JLabel picLabel1 = new JLabel(image1);  
        picLabel1.setLocation (450,325);   //sets the location 
        picLabel1.setSize(new Dimension(51,51));   //sets the dimensions
        
        
        //background
        try{
            System.out.println("BACKGROUND RAN 2");
            BufferedImage backgroundImg = ImageIO.read(new File("images/Background.png"));
            ImageIcon backgroundIcon = new ImageIcon(backgroundImg);
            JLabel background = new JLabel(backgroundIcon);
            died.setContentPane(background);
        }catch(IOException ex){
        }
        
        died.add(diedLabel);
        died.add(diedLabel2);
        died.add(diedLabel3);
        died.add(picLabel1);
        died.setVisible(true);
        
    }
    
}