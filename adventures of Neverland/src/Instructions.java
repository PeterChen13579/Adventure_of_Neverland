/*
 * Instructions.java
 * By Peter Chen
 * 
 * Displays instructions
 */

//imports
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;

public class Instructions extends JFrame{
    JFrame thisFrame;
    private JFrame frame1;
    private JFrame frame2;

    /*
     * Constructor
     * Shows the first page of Instructions
     * @param
     */
    Instructions() { 
        super("Instructions");  
        this.thisFrame = this;
        this.setBounds(460, 170, 1000, 700);     //sets the screen size
        this.setLocationRelativeTo(null);  
        this.setResizable (false);
        
        //background
        try{ 
            BufferedImage backgroundImages = ImageIO.read(new File("images/Background.png")); //path to image
            ImageIcon backgroundIcon = new ImageIcon(backgroundImages);  
            JLabel background = new JLabel(backgroundIcon);  
            this.setContentPane(background);  //add the background picture to Jpanel
        }catch(IOException ex){
        }
        
        //buttons//
        
        JButton Button1 = new JButton ("Next"); 
        Button1.setFont(new Font("Andalus", Font.BOLD, 20));  //set the font and size
        Button1.setForeground(Color.BLACK);    //changes button background to black
        Button1.setOpaque(false);   //sets the background of the button transparent
        Button1.setContentAreaFilled(false);
        Button1.setSize (new Dimension(90,65));   //dimensions of the button
        Button1.setLocation (558,570);     //location of the button
        
        Button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.dispose();
                try {
                    File clickSound = new File("Button_Click.wav");
                    AudioInputStream buttonSound = AudioSystem.getAudioInputStream(clickSound);
                    DataLine.Info click = new DataLine.Info(Clip.class, buttonSound.getFormat());
                    Clip clickClip = (Clip)AudioSystem.getLine(click);
                    
                    clickClip.open(buttonSound);
                    clickClip.start();
                    
                } catch (Exception ep) {
                    ep.printStackTrace();
                }
                Instructions2();
            }
        });
        
        //main menu button//
        JButton mainMenu = new JButton("Main Menu");
        mainMenu.setFont(new Font("Andalus", Font.BOLD, 25));  //sets the font and size
        mainMenu.setForeground(Color.BLACK);   //changes button background to BLACK
        mainMenu.setOpaque(false);    //sets the background of the button transparent
        mainMenu.setContentAreaFilled(false);  
        mainMenu.setSize (new Dimension(230,60));  //dimensions of the button
        mainMenu.setLocation (30,570);  //location of the button
        
        mainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thisFrame.dispose();
                try {
                    File clickSound = new File("Button_Click.wav");
                    AudioInputStream buttonSound = AudioSystem.getAudioInputStream(clickSound);
                    DataLine.Info click = new DataLine.Info(Clip.class, buttonSound.getFormat());
                    Clip clickClip = (Clip)AudioSystem.getLine(click);
                    
                    clickClip.open(buttonSound);
                    clickClip.start();
                    
                } catch (Exception ep) {
                    ep.printStackTrace();
                }
                new MainMenu();
            }
        });
        
        //Title
        JLabel instructionsLabel = new JLabel("Instructions");  //title 
        instructionsLabel.setFont(new Font("Andalus", Font.BOLD, 75));  //sets the font and size
        instructionsLabel.setForeground(Color.BLACK);  //set the color of the text
        instructionsLabel.setSize (new Dimension(500,100));  //set the dimention size of JLabel
        instructionsLabel.setLocation (280,0);    //set the location of the JLabel
        
        //Image for arrow keys
        ImageIcon image1 = new ImageIcon("Images/ArrowKeys.png");
        JLabel picLabel1 = new JLabel(image1);
        picLabel1.setLocation (90,100);    //sets the location of the image
        picLabel1.setSize(new Dimension(200,100));
        
        //Image for WASD 
        ImageIcon image2 = new ImageIcon("Images/WASD.png");
        JLabel picLabel2 = new JLabel(image2);
        picLabel2.setLocation (90,190);    //sets the location of the image
        picLabel2.setSize(new Dimension(200,100));  
        
        //Image for Mouse Cursor
        ImageIcon image3 = new ImageIcon("Images/MouseCursor.png");  
        JLabel picLabel3 = new JLabel(image3); 
        picLabel3.setLocation (570,240);  //sets the location of the image
        picLabel3.setSize(new Dimension(200,100));
        
        
        ImageIcon image4 = new ImageIcon("Images/Snow/Snow_Portal.png");
        JLabel picLabel4 = new JLabel(image4);
        picLabel4.setLocation (788,420);    //sets the location of the image
        picLabel4.setSize(new Dimension(200,100));
        
        
        //Instructions
        JTextArea instructionText1 = new JTextArea("Use arrow keys or WASD to move your character.");
        instructionText1.setLineWrap(true);
        instructionText1.setWrapStyleWord(true);
        instructionText1.setEditable(false);
        instructionText1.setFont(new Font("Times New Roman", Font.BOLD, 22));  //sets the font and font size
        instructionText1.setOpaque(false);   //sets the background of the text to transparents
        instructionText1.setForeground(Color.BLACK);  //sets the colour of the text
        instructionText1.setSize(new Dimension(700,200));  //sets the size of the text
        instructionText1.setLocation (300,170);  //sets the location 
        
        //instructions text 2 for the mouse cursor image
        JTextArea instructionText2 = new JTextArea("Left click to fire");
        instructionText2.setLineWrap(true);
        instructionText2.setWrapStyleWord(true);
        instructionText2.setEditable(false);
        instructionText2.setFont(new Font("Times New Roman", Font.BOLD, 22));
        instructionText2.setOpaque(false);   //sets the background of the text to transparents
        instructionText2.setForeground(Color.BLACK);   //sets the colour of the text
        instructionText2.setSize(new Dimension(300,200));    //sets the size of the text
        instructionText2.setLocation (420,270);  //sets the location 
        
        //Shows the page numbers at the bottom
        JTextArea instructionText3 = new JTextArea("1/3");  //shows page # the user is on for instructions
        instructionText3.setLineWrap(true);
        instructionText3.setWrapStyleWord(true);
        instructionText3.setEditable(false);
        instructionText3.setFont(new Font("Times New Roman", Font.BOLD, 25));
        instructionText3.setOpaque(false);   //sets the background of the text to transparents
        instructionText3.setForeground(Color.BLACK);   //sets the colour of the text
        instructionText3.setSize(new Dimension(300,200));    //sets the size of the text
        instructionText3.setLocation (470,590);  //sets the location 
        
        JTextArea instructionText4 = new JTextArea ("Time stops when you stop moving, including projectiles and enemies");
        instructionText4.setLineWrap(true);
        instructionText4.setWrapStyleWord(true);
        instructionText4.setEditable(false);
        instructionText4.setFont(new Font("Times New Roman", Font.BOLD, 22));
        instructionText4.setOpaque(false);   //sets the background of the text to transparents
        instructionText4.setForeground(Color.BLACK);   //sets the colour of the text
        instructionText4.setSize(new Dimension(1000,200));    //sets the size of the text
        instructionText4.setLocation (165,380);  //sets the location 
        
        JTextArea instructionText5 = new JTextArea ("You start with 50 Health. Arrive at the BluePortal to move on to the next level");
        instructionText5.setLineWrap(true);
        instructionText5.setWrapStyleWord(true);
        instructionText5.setEditable(false);
        instructionText5.setFont(new Font("Times New Roman", Font.BOLD, 22));
        instructionText5.setOpaque(false);   //sets the background of the text to transparents
        instructionText5.setForeground(Color.BLACK);   //sets the colour of the text
        instructionText5.setSize(new Dimension(1000,200));    //sets the size of the text
        instructionText5.setLocation (135,450);  //sets the location 
        
        
        
        //add everything to the frame
        this.add(instructionsLabel); 
        this.add(Button1);
        this.add(mainMenu);
        this.add(picLabel1);
        this.add(picLabel2);
        this.add(picLabel3);
        this.add(picLabel4);
        this.add(instructionText1);
        this.add(instructionText2);;
        this.add(instructionText3);
        this.add(instructionText4);
        this.add(instructionText5);
        //Start the program
        this.setVisible(true);
    }
    
    /*
     * Instructions2
     * Shows the second page of Instructions
     * @param
     */
    public void Instructions2(){
        
        frame1 = new JFrame();
        frame1.setTitle("Instructions2");
        frame1.setBounds(460, 170, 1000, 700);   
        frame1.setLocationRelativeTo(null); 
        frame1.setResizable (false);
        
        //background
        try{ 
            BufferedImage backgroundImages = ImageIO.read(new File("images/Background.png")); //path to image
            ImageIcon backgroundIcon = new ImageIcon(backgroundImages);  
            JLabel background = new JLabel(backgroundIcon);  
            frame1.setContentPane(background);  //add the background picture to Jpanel
        }catch(IOException ex){
        }
        
        //buttons//
        
        JButton Button1 = new JButton ("Next");
        Button1.setFont(new Font("Andalus", Font.BOLD, 20));  //set the font and size
        Button1.setForeground(Color.BLACK);    //changes button background to BLACK
        Button1.setOpaque(false);   //sets the background of the button transparent
        Button1.setContentAreaFilled(false);
        Button1.setSize (new Dimension(90,65));   //dimensions of the button
        Button1.setLocation (558,570);     //location of the button
        
        Button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                try {
                    File clickSound = new File("Button_Click.wav");
                    AudioInputStream buttonSound = AudioSystem.getAudioInputStream(clickSound);
                    DataLine.Info click = new DataLine.Info(Clip.class, buttonSound.getFormat());
                    Clip clickClip = (Clip)AudioSystem.getLine(click);
                    
                    clickClip.open(buttonSound);
                    clickClip.start();
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                Instructions3();
            }
        });
        
        JButton Button2 = new JButton ("Last");
        Button2.setFont(new Font("Andalus", Font.BOLD, 20));  //set the font and size
        Button2.setForeground(Color.BLACK);  //changes button background to BLACK
        Button2.setOpaque(false);   //sets the background of the button transparent when being clicked
        Button2.setContentAreaFilled(false);
        Button2.setSize (new Dimension(90,65));   //dimensions of the button
        Button2.setLocation (333,568);     //location of the button
        Button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                try {
                    File clickSound = new File("Button_Click.wav");
                    AudioInputStream buttonSound = AudioSystem.getAudioInputStream(clickSound);
                    DataLine.Info click = new DataLine.Info(Clip.class, buttonSound.getFormat());
                    Clip clickClip = (Clip)AudioSystem.getLine(click);
                    
                    clickClip.open(buttonSound);
                    clickClip.start();
                    
                } catch (Exception ei) {
                    ei.printStackTrace();
                }
                new Instructions();
            }
        });
        
        //main menu button//
        JButton mainMenu = new JButton("Main Menu");
        mainMenu.setFont(new Font("Andalus", Font.BOLD, 25));   //set the font and size
        mainMenu.setForeground(Color.BLACK);   //changes button background to BLACK
        mainMenu.setOpaque(false);     //sets the background of the button transparent when being clicked
        mainMenu.setContentAreaFilled(false);   
        mainMenu.setSize (new Dimension(230,60));  //dimensions of the button
        mainMenu.setLocation (30,570);   //location of the button
        mainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                try {
                    File clickSound = new File("Button_Click.wav");
                    AudioInputStream buttonSound = AudioSystem.getAudioInputStream(clickSound);
                    DataLine.Info click = new DataLine.Info(Clip.class, buttonSound.getFormat());
                    Clip clickClip = (Clip)AudioSystem.getLine(click);
                    
                    clickClip.open(buttonSound);
                    clickClip.start();
                    
                } catch (Exception ep) {
                    ep.printStackTrace();
                }
                new MainMenu();
            }
        });
        
        //Title
        JLabel instructionsLabel = new JLabel("Instructions");  //title 
        instructionsLabel.setFont(new Font("Andalus", Font.BOLD, 75));  //sets the font and size
        instructionsLabel.setForeground(Color.BLACK);  //set the color of the text
        instructionsLabel.setSize (new Dimension(500,100));  //set the dimention size of JLabel
        instructionsLabel.setLocation (280,0);    //set the location of the JLabel
        
        //Image for door
        ImageIcon image1 = new ImageIcon("Images/FireEntity.1.png");  
        JLabel picLabel1 = new JLabel(image1);  
        picLabel1.setLocation (385,276);   //sets the location 
        picLabel1.setSize(new Dimension(200,100));   //sets the dimensions
        
        //Image for the Water Surface
        ImageIcon image2 = new ImageIcon("Images/EarthPic.png");
        JLabel picLabel2 = new JLabel(image2);
        picLabel2.setLocation (155,276);   //sets the location 
        picLabel2.setSize(new Dimension(200,100));  //sets the dimensions
        
        //Image for the Ground Surface
        ImageIcon image3 = new ImageIcon("Images/WaterPic.png");
        JLabel picLabel3 = new JLabel(image3);
        picLabel3.setLocation (495,276);   //sets the location 
        picLabel3.setSize(new Dimension(450,100));  //sets the dimensions
        
        //Image for the bomb
        ImageIcon image4 = new ImageIcon("Images/Bomb.png");
        JLabel picLabel4 = new JLabel(image4);
        picLabel4.setLocation (155,306);   //sets the location 
        picLabel4.setSize(new Dimension(200,100));  //sets the dimensions
        
        //Image for the fireball
        ImageIcon image5 = new ImageIcon("Images/Fireball.png");
        JLabel picLabel5 = new JLabel(image5);
        picLabel5.setLocation (275,306);   //sets the location 
        picLabel5.setSize(new Dimension(450,100));  //sets the dimensions
        
        //Instructions
        JTextArea instructionText1 = new JTextArea("There will be many enemies you encounter");
        instructionText1.setLineWrap(true);
        instructionText1.setWrapStyleWord(true);
        instructionText1.setEditable(false);
        instructionText1.setFont(new Font("Times New Roman", Font.BOLD, 25));  //sets the font and font size
        instructionText1.setOpaque(false);   //sets the background of the text to transparents
        instructionText1.setForeground(Color.BLACK);  //sets the colour of the text
        instructionText1.setSize(new Dimension(1000,200));  //sets the size of the text
        instructionText1.setLocation (265,188);  //sets the location 
        
        
        //instructions text 2 for the different types of surfaces
        JTextArea instructionText2 = new JTextArea("Bullets you shoot destroys the enemy projectiles (along with your own)");
        instructionText2.setLineWrap(true);
        instructionText2.setWrapStyleWord(true);
        instructionText2.setEditable(false);
        instructionText2.setFont(new Font("Times New Roman", Font.BOLD, 25));
        instructionText2.setOpaque(false);   //sets the background of the text to transparents
        instructionText2.setForeground(Color.BLACK);   //sets the colour of the text
        instructionText2.setSize(new Dimension(800,200));    //sets the size of the text
        instructionText2.setLocation (200,120);  //sets the location 
        
        
        //instructions text 3 for the description of the different types of surfaces
        JTextArea instructionText3 = new JTextArea("You die when your health reaches zero");
        instructionText3.setLineWrap(true);
        instructionText3.setWrapStyleWord(true);
        instructionText3.setEditable(false);
        instructionText3.setFont(new Font("Times New Roman", Font.BOLD, 25));
        instructionText3.setOpaque(false);   //sets the background of the text to transparents
        instructionText3.setForeground(Color.BLACK);   //sets the colour of the text
        instructionText3.setSize(new Dimension(800,200));    //sets the size of the text
        instructionText3.setLocation (260,250);  //sets the location 
        
        
        JTextArea instructionText4 = new JTextArea("Bomb takes away 2 health; Fireball takes away 1. Water enemies acts as barricades");  
        instructionText4.setLineWrap(true);
        instructionText4.setWrapStyleWord(true);
        instructionText4.setEditable(false);
        instructionText4.setFont(new Font("Times New Roman", Font.BOLD, 25));
        instructionText4.setOpaque(false);   //sets the background of the text to transparents
        instructionText4.setForeground(Color.BLACK);   //sets the colour of the text
        instructionText4.setSize(new Dimension(3000,200));    //sets the size of the text
        instructionText4.setLocation (60,450);  //sets the location 
        
        JTextArea instructionText5 = new JTextArea("2/3");  //shows page # the user is on for instructions
        instructionText5.setLineWrap(true);
        instructionText5.setWrapStyleWord(true);
        instructionText5.setEditable(false);
        instructionText5.setFont(new Font("Times New Roman", Font.BOLD, 25));
        instructionText5.setOpaque(false);   //sets the background of the text to transparent
        instructionText5.setForeground(Color.BLACK);   //sets the colour of the text
        instructionText5.setSize(new Dimension(300,200));    //sets the size of the text
        instructionText5.setLocation (470,590);  //sets the location 
        
        //add everything to the frame
        frame1.add(instructionsLabel);
        frame1.add(Button1);
        frame1.add(Button2);
        frame1.add(mainMenu);
        frame1.add(picLabel1);
        frame1.add(picLabel2);
        frame1.add(picLabel3);
        frame1.add(picLabel4);
        frame1.add(picLabel5);
        frame1.add(instructionText1);
        frame1.add(instructionText2);
        frame1.add(instructionText3);
        frame1.add(instructionText4);
        frame1.add(instructionText5);
        
        //Start the program
        frame1.setVisible(true);
    }
    
    /*
     * Instructions3
     * Shows the third page of Instructions
     * @param
     */
    public void Instructions3(){
        frame2 = new JFrame();
        frame2.setTitle("Instructions3");
        frame2.setBounds(460, 170, 1000, 700);    
        frame2.setLocationRelativeTo(null); 
        frame2.setResizable (false);
        
        //background
        try{ 
            BufferedImage backgroundImages = ImageIO.read(new File("images/Background.png"));  
            ImageIcon backgroundIcon = new ImageIcon(backgroundImages);
            JLabel background = new JLabel(backgroundIcon);
            frame2.setContentPane(background);   //sets the background picture 
        }catch(IOException ex){
        }
        
        //buttons//
        
        JButton Button2 = new JButton ("Last");
        Button2.setFont(new Font("Andalus", Font.BOLD, 20));  //set the font and size
        Button2.setForeground(Color.BLACK);  //changes button background to BLACK
        Button2.setOpaque(false);   //sets the background of the button transparent when being clicked
        Button2.setContentAreaFilled(false);
        Button2.setSize (new Dimension(90,65));   //dimensions of the button
        Button2.setLocation (333,568);     //location of the button
        
        Button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();
                try {
                    File clickSound = new File("Button_Click.wav");
                    AudioInputStream buttonSound = AudioSystem.getAudioInputStream(clickSound);
                    DataLine.Info click = new DataLine.Info(Clip.class, buttonSound.getFormat());
                    Clip clickClip = (Clip)AudioSystem.getLine(click);
                    
                    clickClip.open(buttonSound);
                    clickClip.start();
                    
                } catch (Exception ep) {
                    ep.printStackTrace();
                }
                Instructions2();
            }
        });
        
        //main menu button//
        JButton mainMenu = new JButton("Main Menu");
        mainMenu.setFont(new Font("Andalus", Font.BOLD, 25));  //set the font and size
        mainMenu.setForeground(Color.BLACK);   //changes button background to BLACK
        mainMenu.setOpaque(false);     //sets the background of the button transparent when being clicked
        mainMenu.setContentAreaFilled(false);
        mainMenu.setSize (new Dimension(230,60));  //dimensions of the button
        mainMenu.setLocation (30,570);   //location of the button
        
        mainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();
                try {
                    File clickSound = new File("Button_Click.wav");
                    AudioInputStream buttonSound = AudioSystem.getAudioInputStream(clickSound);
                    DataLine.Info click = new DataLine.Info(Clip.class, buttonSound.getFormat());
                    Clip clickClip = (Clip)AudioSystem.getLine(click);
                    
                    clickClip.open(buttonSound);
                    clickClip.start();
                    
                } catch (Exception ep) {
                    ep.printStackTrace();
                }
                new MainMenu();
            }
        });
        
        //Title
        JLabel instructionsLabel = new JLabel("Instructions");  //title 
        instructionsLabel.setFont(new Font("Andalus", Font.BOLD, 75));  //sets the font and size
        instructionsLabel.setForeground(Color.BLACK);  //set the color of the text
        instructionsLabel.setSize (new Dimension(500,100));  //set the dimention size of JLabel
        instructionsLabel.setLocation (280,0);    //set the location of the JLabel
        
        //Image for Trophy
        ImageIcon image1 = new ImageIcon("Images/score.png"); 
        JLabel picLabel1 = new JLabel(image1);
        picLabel1.setLocation (387,465);   //sets the location of the picture
        picLabel1.setSize(new Dimension(200,100));  //set the pictures dimensions
        
        //Instructions
        JTextArea instructionText1 = new JTextArea("Your score when you have reached the end is affected by 4 factors:");
        instructionText1.setLineWrap(true);
        instructionText1.setWrapStyleWord(true);
        instructionText1.setEditable(false);
        instructionText1.setFont(new Font("Times New Roman", Font.BOLD, 28));  //sets the font and font size
        instructionText1.setOpaque(false);   //sets the background of the text to transparents
        instructionText1.setForeground(Color.BLACK);  //sets the colour of the text
        instructionText1.setSize(new Dimension(600,200));  //sets the size of the text
        instructionText1.setLocation (257,130);  //sets the location 
        
        //instructions text 2 for the fire enemies
        JTextArea instructionText2 = new JTextArea("1. The number of enemies you kill.");
        instructionText2.setLineWrap(true);
        instructionText2.setWrapStyleWord(true);
        instructionText2.setEditable(false);
        instructionText2.setFont(new Font("Times New Roman", Font.BOLD, 25));
        instructionText2.setOpaque(false);   //sets the background of the text to transparents
        instructionText2.setForeground(Color.BLACK);   //sets the colour of the text
        instructionText2.setSize(new Dimension(1000,200));    //sets the size of the text
        instructionText2.setLocation (290,200);  //sets the location 
        
        //instructions text 3 for the water enemies
        JTextArea instructionText3 = new JTextArea("2. The health points you lost");
        instructionText3.setLineWrap(true);
        instructionText3.setWrapStyleWord(true);
        instructionText3.setEditable(false);
        instructionText3.setFont(new Font("Times New Roman", Font.BOLD, 25));
        instructionText3.setOpaque(false);   //sets the background of the text to transparents
        instructionText3.setForeground(Color.BLACK);   //sets the colour of the text
        instructionText3.setSize(new Dimension(1000,200));    //sets the size of the text
        instructionText3.setLocation (292,250);  //sets the location 
        
        //instructions text 3 for the water enemies
        JTextArea instructionText4 = new JTextArea("3. The number of bullets you have shot");
        instructionText4.setLineWrap(true);
        instructionText4.setWrapStyleWord(true);
        instructionText4.setEditable(false);
        instructionText4.setFont(new Font("Times New Roman", Font.BOLD, 25));
        instructionText4.setOpaque(false);   //sets the background of the text to transparents
        instructionText4.setForeground(Color.BLACK);   //sets the colour of the text
        instructionText4.setSize(new Dimension(1000,200));    //sets the size of the text
        instructionText4.setLocation (285,300);  //sets the location 
        
        
        //instructions text 3 for the water enemies
        JTextArea instructionText5 = new JTextArea("4. Most importantly, the time it took for you to complete the game.");
        instructionText5.setLineWrap(true);
        instructionText5.setWrapStyleWord(true);
        instructionText5.setEditable(false);
        instructionText5.setFont(new Font("Times New Roman", Font.BOLD, 25));
        instructionText5.setOpaque(false);   //sets the background of the text to transparents
        instructionText5.setForeground(Color.BLACK);   //sets the colour of the text
        instructionText5.setSize(new Dimension(1000,200));    //sets the size of the text
        instructionText5.setLocation (156,360);  //sets the location 
        
        //instruction text *hint
        JTextArea instructionText6 = new JTextArea("Hint: Try not to stand still too much throughout the game*");
        instructionText6.setLineWrap(true);
        instructionText6.setWrapStyleWord(true);
        instructionText6.setEditable(false);
        instructionText6.setFont(new Font("Times New Roman", Font.BOLD, 19));
        instructionText6.setOpaque(false);   //sets the background of the text to transparents
        instructionText6.setForeground(Color.BLACK);   //sets the colour of the text
        instructionText6.setSize(new Dimension(1000,200));    //sets the size of the text
        instructionText6.setLocation (280,400);  //sets the location 
        
        //Shows the page numbers at the bottom
        JTextArea instructionText7 = new JTextArea("3/3");  //shows page # the user is on for instructions
        instructionText7.setLineWrap(true);
        instructionText7.setWrapStyleWord(true);
        instructionText7.setEditable(false);
        instructionText7.setFont(new Font("Times New Roman", Font.BOLD, 25));
        instructionText7.setOpaque(false);   //sets the background of the text to transparents
        instructionText7.setForeground(Color.BLACK);   //sets the colour of the text
        instructionText7.setSize(new Dimension(300,200));    //sets the size of the text
        instructionText7.setLocation (470,590);  //sets the location 
        
        //add everything to the frame
        frame2.add(instructionsLabel);
        frame2.add(Button2);
        frame2.add(mainMenu);
        frame2.add(picLabel1);
        frame2.add(instructionText1);
        frame2.add(instructionText2);
        frame2.add(instructionText3);
        frame2.add(instructionText4);
        frame2.add(instructionText5);
        frame2.add(instructionText6);
        frame2.add(instructionText7);
        
        //Start the program
        frame2.setVisible(true);
    }
    
    
} //end of class 
