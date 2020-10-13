/** 
 * Used to keep track of time
 * By Peter Chen
 * By Tony Lee
 * 
 */

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Graphics;

public class TrackTime{
    
    int secondsPassed = 0;
    String second = "";
    Timer myTimer = new Timer();   //initiate object 
    
    /*
     * run
     * This occurs at the beginning of gameFrame to initialize timer
     * @param
     */ 
    TimerTask task = new TimerTask()  { 
        public void run(){   //method to track the seconds passed
            secondsPassed++;
            second = "Time:   " + secondsPassed + "  seconds";
        }
    };
    
    /*
     * getSecondsPassed
     * gets the number of seconds passed the user has played the game for
     * @param
     * @return secondsPassed
     */
    public int getSecondsPassed(){
        return secondsPassed;
    }
    
    /*
     * start
     * starts the timer at a fix rate
     * @param
     */ 
    public void start(){  //method to start the timer 
        //first integer is for how long you want before it starts. second one is for the speed of timer.
        myTimer.scheduleAtFixedRate(task, 1000, 1000);  //starts the timer   
    }
    
    /*
     * draw
     * draws the timer on screen
     * @param Graphics G, int X, int Y
     */ 
    public void draw(Graphics g, int x, int y) {
        g.drawString(second,x,y); //display the frameRate
    }
    
}