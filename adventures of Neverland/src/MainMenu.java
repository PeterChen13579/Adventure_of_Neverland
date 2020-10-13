/*
 * MainMenu.java
 * Created by Peter Chen 
 * 
 * Main Menu for Freeze Game
 */

//Imports
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.sound.sampled.*;

public class MainMenu extends JFrame implements ActionListener { 
    
    JFrame thisFrame;
    Clip clip;
    
    /*
     * Constructer
     * This runs when the program starts
     * @param
     * @shows main menu of the game
     */
    MainMenu() { 
        
        super("Adventures of Neverland");
        this.thisFrame = this;  
        
        try {
            
            File menuBGM = new File("Main_Menu.wav");
            AudioInputStream menuStream = AudioSystem.getAudioInputStream(menuBGM);
            DataLine.Info info = new DataLine.Info(Clip.class, menuStream.getFormat());
            clip = (Clip)AudioSystem.getLine(info);
            clip.open(menuStream);
            clip.start();
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //configure the window
        this.setBounds(460, 170, 1000, 700);   
        this.setLocationRelativeTo(null); //start the frame in the center of the screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setResizable (false);
        
        //background
        try{
            BufferedImage backgroundImg = ImageIO.read(new File("images/Background.png"));
            ImageIcon backgroundIcon = new ImageIcon(backgroundImg);
            JLabel background = new JLabel(backgroundIcon);
            this.setContentPane(background);
        }catch(IOException ex){
        }
        
        //buttons
        JButton startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Andalus", Font.BOLD, 26));
        startButton.setLocation (420,120);
        startButton.setSize (new Dimension(400,45));
        startButton.addActionListener(this);
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        
        JButton HighScoreButton = new JButton("High Scores");
        HighScoreButton.setBackground(Color.black);
        HighScoreButton.setForeground(Color.WHITE);
        HighScoreButton.setFont(new Font("Andalus", Font.BOLD, 26));
        HighScoreButton.setLocation (420,250);
        HighScoreButton.setSize (new Dimension(400,45));
        HighScoreButton.addActionListener(this);
        HighScoreButton.setOpaque(false);
        HighScoreButton.setContentAreaFilled(false);
        HighScoreButton.setBorderPainted(false);    
        
        JButton instuctionButton = new JButton("Instructions");
        instuctionButton.setBackground(Color.black);
        instuctionButton.setForeground(Color.WHITE);
        instuctionButton.setFont(new Font("Andalus", Font.BOLD, 26));
        instuctionButton.setSize (new Dimension(400,45));
        instuctionButton.setLocation (420,380);
        instuctionButton.addActionListener(this);
        instuctionButton.setOpaque(false);
        instuctionButton.setContentAreaFilled(false);
        instuctionButton.setBorderPainted(false);    
        
        
        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.black);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Andalus", Font.BOLD, 26));
        exitButton.setSize (new Dimension(400,45));
        exitButton.setLocation (420,530);
        exitButton.addActionListener(this);
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);    
        
        //title
        JLabel startLabel = new JLabel("Adventures of NeverLand");
        startLabel.setFont(new Font("Andalus", Font.BOLD, 25));
        startLabel.setForeground(Color.WHITE);
        startLabel.setSize (new Dimension(400,100));
        startLabel.setLocation (50,50);
        
        //Add all panels to the mainPanel according to border layout
        this.add(startLabel);
        this.add(instuctionButton);
        this.add(startButton);
        this.add(exitButton);
        this.add(HighScoreButton);
        
        //Set all to visible
        this.setVisible(true);
        
    }
    
    /*
     * actionPerformed
     * this is a method that detects if a button is pressed
     * @ param
     */
    public void actionPerformed(ActionEvent event) {
        
        String command = event.getActionCommand();
        thisFrame.dispose(); 
        
        if (command.equals("Start")){
            clip.stop();
            try {
                File clickSound = new File("Button_Click.wav");
                AudioInputStream buttonSound = AudioSystem.getAudioInputStream(clickSound);
                DataLine.Info click = new DataLine.Info(Clip.class, buttonSound.getFormat());
                Clip clickClip = (Clip)AudioSystem.getLine(click);
                
                clickClip.open(buttonSound);
                clickClip.start();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            new StartingFrame();
        }else if (command.equals("Instructions")){  //if user clicks on instructions
            clip.stop();
            try {
                File clickSound = new File("Button_Click.wav");
                AudioInputStream buttonSound = AudioSystem.getAudioInputStream(clickSound);
                DataLine.Info click = new DataLine.Info(Clip.class, buttonSound.getFormat());
                Clip clickClip = (Clip)AudioSystem.getLine(click);
                
                clickClip.open(buttonSound);
                clickClip.start();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Instructions();
        }  
        else if (command.equals("High Scores")){  //if user clicks on High Scores
            thisFrame.dispose();
            clip.stop();
            try {
                File clickSound = new File("Button_Click.wav");
                AudioInputStream buttonSound = AudioSystem.getAudioInputStream(clickSound);
                DataLine.Info click = new DataLine.Info(Clip.class, buttonSound.getFormat());
                Clip clickClip = (Clip)AudioSystem.getLine(click);
                
                clickClip.open(buttonSound);
                clickClip.start();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            new HighScores();  
        }
        else if (command.equals("Exit")) {   //if user clicks on Exit 
            try {
                File clickSound = new File("Button_Click.wav");
                AudioInputStream buttonSound = AudioSystem.getAudioInputStream(clickSound);
                DataLine.Info click = new DataLine.Info(Clip.class, buttonSound.getFormat());
                Clip clickClip = (Clip)AudioSystem.getLine(click);
                
                clickClip.open(buttonSound);
                clickClip.start();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
    }
    
    //Main method starts this application
    public static void main(String[] args) { 
        new MainMenu();
    }
    
}  //end of class


