/*
 * StartingFrame.java
 * By Peter Chen
 * 
 * Displays instructions
 */

//imports
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
import javax.swing.JTextField;
import javax.sound.sampled.*;

public class StartingFrame extends JFrame implements ActionListener{
    JFrame thisFrame;
    private JTextField textField1;
    public String Name;
    
    StartingFrame(){
        
        super("");
        this.thisFrame = this;  
        
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
        startButton.setFont(new Font("Andalus", Font.ITALIC, 16));
        startButton.setLocation (295,190);
        startButton.setSize (new Dimension(400,45));
        startButton.addActionListener(this);
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        
        
        //Title
        JLabel instructionsLabel = new JLabel("Please enter your name");  //title 
        instructionsLabel.setFont(new Font("Andalus", Font.BOLD, 28));  //sets the font and size
        instructionsLabel.setForeground(Color.WHITE);  //set the color of the text
        instructionsLabel.setSize (new Dimension(500,100));  //set the dimention size of JLabel
        instructionsLabel.setLocation (335,70);    //set the location of the JLabel
        
        //Title
        JLabel instructionsLabel2 = new JLabel("Do Not Leave Spaces");  //title 
        instructionsLabel2.setFont(new Font("Andalus", Font.BOLD, 15));  //sets the font and size
        instructionsLabel2.setForeground(Color.WHITE);  //set the color of the text
        instructionsLabel2.setSize (new Dimension(500,100));  //set the dimention size of JLabel
        instructionsLabel2.setLocation (420,100);    //set the location of the JLabel
        
        //textfield for user to enter their name
        textField1 = new JTextField();
        textField1.setBounds(445, 175, 106, 20);
        this.getContentPane().add(textField1);
        textField1.setColumns(10);
        
        
        this.add(textField1);
        this.add(instructionsLabel);
        this.add(instructionsLabel2);
        this.add(startButton);
        
        //Set all to visible
        this.setVisible(true);
        
    }
    
    //This is a method that is used to detect a button press
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        String userName = textField1.getText();
        
        thisFrame.dispose(); 
        if (command.equals("Start")){
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
            new TimeWarp(userName);
        }
    }
    
}