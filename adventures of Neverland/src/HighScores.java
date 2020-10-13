/*
 * HighScores.java
 * By Peter Chen
 * By Tony Lee
 * @Class made to display high scores
 */

//imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.lang.Integer; 
import javax.swing.table.TableColumn;
import java.io.File;    
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Font;
import javax.sound.sampled.*;


public class HighScores extends JFrame implements ActionListener{ 
    
    //this variable show up in 2 different method so declear it here 
    static String [][] newData = new String [2][10];
    
    //method for reading score from a file
    static String [][] scoreReading ()  {
        try{ //ioexception
            File file = new File("HighScores.txt");
            Scanner input = new Scanner(file);
            String [][] newData = new String [10][2];
            //use arraylist because don't know how many scores in the file
            List<String> nameList = new ArrayList<String>();
            List<String> scoreList = new ArrayList<String>();
            
            //read the scores in the array list
            while (input.hasNext()){
                nameList.add(input.next());
                scoreList.add(input.next());
            }
            
            //convert arraylist to array
            String [] subData1 = nameList.toArray(new String[0]);
            String [] subData2 = scoreList.toArray(new String[0]);
            
            int total = nameList.size();
            
            //put the scores in a 2d array
            String data[][] = new String[2][total];
            data[0] = subData1;
            data[1] = subData2;
            
            //matrix transpose the array for sorting
            String [][] transposedData = new String [total][2];
            for(int row=0;row<total;row++) {
                for(int col=0;col<2;col++) {
                    transposedData[row][col] = data[col][row];
                }
            }
            
            //sort the 2d array in decending order
            Arrays.sort(transposedData, new Comparator<String[]>() {
                @Override
                public int compare(String[] entry1,  String[] entry2) {  //compares the string and their scores
                    String time1 = entry1[1];
                    int result1 = Integer.parseInt(time1);
                    String time2 = entry2[1];
                    int result2 = Integer.parseInt(time2);
                    return Integer.compare(result2,result1);  
                }
            });
            
            //only need the top 10 scores
            for (int i = 0; i < 10; i++){
                newData[i] = transposedData[i];
            }
            
            input.close();
            return newData;
        }catch(IOException  exception){  //catch exception
            System.out.println("ERROR!!");
        }
        
        return newData;
    }
    
    
    JFrame thisFrame;
    
    /*
     * Constructor
     * Shows high score panel
     * @ param
     * Shows the top 10 scores user acheived for this game
     */
    HighScores() { 
        super("High Score");
        this.thisFrame = this;
        
        this.setSize(800,700);    
        this.setLocationRelativeTo(null); 
        this.setResizable (false);
        
        JPanel mainPanel = new JPanel();
        
        mainPanel.setLayout(null);
        
        //buttons
        JButton startButton = new JButton("Main Menu");
        startButton.setLocation (50,570);
        startButton.setSize (new Dimension(300,25));
        startButton.addActionListener(this);
        
        JButton exitButton = new JButton("Exit");
        exitButton.setSize (new Dimension(300,25));
        exitButton.setLocation (450,570);
        exitButton.addActionListener(this);
        
        //title
        JLabel instructionsLabel = new JLabel("High Scores...");
        instructionsLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        instructionsLabel.setSize (new Dimension(400,100));
        instructionsLabel.setLocation (0,30);
        
        //a table to show the top 10 scores
        String[] columnNames = {"Rank", "Name", "Score"};
        String[][]data = new String [10][3];
        for (int i = 1; i<=10; i++){
            String ii = Integer.toString(i);
            data[i-1][0] = ii;
        }
        String[][] score = scoreReading();
        for (int i = 0; i < 10; i ++){
            data[i][1] = score[i][0];
            data[i][2] = score[i][1];
        }
        JTable scoreTable = new JTable(data, columnNames);
        scoreTable.setSize (new Dimension(600,400));
        scoreTable.setLocation (100,100);
        scoreTable.setCellSelectionEnabled(false);
        scoreTable.setRowHeight(38);
        
        
        
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = scoreTable.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(1); 
            } else {
                column.setPreferredWidth(250);
            }
        }
        
        //put the JTable into a JScrollPane
        JScrollPane scrollPane = new JScrollPane(scoreTable);
        scrollPane.setSize (new Dimension(600,400));
        scrollPane.setLocation (100,100);   
        
        //add everything to the frame
        this.add(instructionsLabel);
        this.add(startButton);
        this.add(exitButton);
        
        //the table is not showing if i don't put it in a panel
        mainPanel.add(scrollPane);
        this.add(mainPanel);
        
        
        //Start the app
        this.setVisible(true);
    }
    
    //This is a method that is used to detect if a is button press
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("Exit")) {  //if user presses play again button
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
        }else if (command.equals("Main Menu")){   //if user clicks exit button
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
            thisFrame.dispose();
            new MainMenu();
            
        }
        
    }
    
    

}