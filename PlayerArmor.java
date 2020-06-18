/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.game;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Ahmed Bahey
 */
public class PlayerArmor extends PlayerDecorator{

    protected int protectHeath = 5;
    protected Image sheild;
    protected boolean ison = false;
    public PlayerArmor(Armor playerDecorator) {
        super(playerDecorator);
        
         ImageIcon img = new ImageIcon("Shield.png");
        this.sheild = img.getImage();
    }
    
     
    @Override
    public void putarmor() {
      this.ison=true; 
        
    }
    
    public Image getimg() {
        return sheild;
    }

    public  boolean ison() {
        
        return ison;
    }

    public void setIson(boolean ison) {
        this.ison = ison;
    }
    
   
    
    
    
}
