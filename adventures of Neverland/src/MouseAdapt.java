/** 
 * For use of mouse controls
 * 
 * By Peter Chen
 * By Tony Lee
 */

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseAdapt extends MouseAdapter {
    
    
    /*
     * Constructor
     * sets mouseAdapt to player
     * @param player
     */
    public MouseAdapt(Player player){
        p = player;
    }
    
    Player p;
    
    /*
     * mouseClicked
     * detects if user has clicked
     * @param MouseEvent
     */
    public void mouseClicked(MouseEvent e) {
        // debug
        p.shoot(e.getX(), e.getY());
    }
    
    public void mousePressed(MouseEvent e) {
    }
    
    public void mouseReleased(MouseEvent e) {
    }
    
    public void mouseEntered(MouseEvent e) {
    }
    
    public void mouseExited(MouseEvent e) {
    }
    
} // End of class