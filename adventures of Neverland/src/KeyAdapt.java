/** 
 * For use of key controls
 * 
 * By Peter Chen
 * By Tony Lee
 */

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyAdapt extends KeyAdapter {
    
    Player p;
    
    /*
     * KeyAdapt
     * Sets Keyadapt to player
     * @param player
     */
    public KeyAdapt(Player player){
        p = player;
    }
    
    /*
     * keyPressed
     * detects when a key is pressed
     * @param KeyEvent
     * @Goes into player to activate keypressed method
     */
    
    public void keyPressed(KeyEvent e){
        p.keyPressed(e);
    }
    
    /*
     * keyPressed
     * detects when a key is released
     * @param KeyEvent
     * @Goes into player to activate keyReleased method
     */
    public void keyReleased(KeyEvent e){
        p.keyReleased(e);
    }
    
}