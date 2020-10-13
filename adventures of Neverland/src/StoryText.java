/*
 * StoryText.java
 * Created by Peter Chen & Tony Lee
 * Story text for game
 * Main Menu for Time_Warp
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
import java.awt.Graphics;
import javax.swing.JComponent;
import java.util.Timer;
import java.util.TimerTask;

public class StoryText extends JFrame{ 
  
  StoryText(){
    
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(460, 170, 1000, 700);
    window.getContentPane().add(new MyCanvas());
    window.setVisible(true);
    //starts time
    TrackTime trackTime = new TrackTime();
    trackTime.start();
    
    //GameWindow game = new GameWindow();
    
    //Load map
    
  }
}


class MyCanvas extends JComponent {
  
  public void paint(Graphics g) {
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect (10, 450, 965, 200);  
    g.setColor(Color.black);
    g.drawRect(10, 450, 965, 200);
  }
}


