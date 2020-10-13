/** 
 * Main Class
 * 
 * By Peter Chen
 * By Tony Lee
 *
 */

import java.io.PrintWriter; //explicit call to the PrintWriter class
import java.io.IOException;
import java.io.File; 
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JFrame;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class TimeWarp extends JFrame {
    JFrame frame  = new JFrame();
    JFrame frame1;
    String userName;
    
    /*
     * Constructor
     * This is where JFrame is made while intiating all sprite images
     * @param String userName 
     */
    
    TimeWarp(String userName){
        Map a = new Map();
        a.initializeImages();
        
        SpriteSheet.initializeImages();
        frame.setTitle("Adventures of Neverlands");
        frame.setSize(1728, 1024);   // Sets the window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // If closed
        frame.setResizable(true);
        frame.add(new GameFrame(userName));  // Adds the GameFrame panel
        frame.setVisible(true);  // Makes the GameFrame panel visible to user
        
    }
    
    /*
     * Constructor
     * This occurs when user has beaten the game
     * @param String userName, int Score
     */
    
    TimeWarp(String userName, int score){
        addScore(userName, score);
        
    }
    
    /*
     * addScore
     * method to check if userScore can make it to high score panel
     * @param String userName, int Score
     */
    
    public void addScore(String userName, int userScore) {  //method to add score and name
        // System.out.println("addScore()");
        File fileName = new File("HighScores.txt");
        System.out.println(userName + " " + userScore);
        String [] name = new String [10];
        int [] score = new int [10];
        
        int numHighScore = 10;
        
        
        
        try {
            // System.out.println("ewrer");
            
            Scanner inFile = new Scanner(fileName);
            
            
            for (int i=0;i<10;i++){
                name[i] = inFile.next();
                score[i] = inFile.nextInt();
                System.out.println(name[i] + score[i]);
            }
            
            FileWriter  fw = new FileWriter (fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            
            boolean add = false;
            
            for (int i=0;i<10;i++){
                if (score[i] < userScore && add == false){
                    //if user score beats a high score
                    System.out.println("score : " + score[i] + "userScore " + userScore);
                    out.println("");
                    out.print(userName);
                    System.out.println(userName);
                    
                    out.print(" ");
                    out.print(userScore);
                    System.out.println(userScore);
                    add = true;
                    i--;
                }else{
                    out.println("");
                    out.print(name[i]);
                    System.out.println(name [i] + score[i]);
                    
                    out.print(" ");
                    out.print(score[i]);
                    
                }
            }
            
            out.close(); //closes the printwriter
        }
        catch(IOException ex) {
            System.out.println("ERROR");
        }
        finally {  
        }
    }
}