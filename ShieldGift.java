/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.game;

import java.awt.Image;
import javax.swing.ImageIcon;
import mazerunner.Board;

/**
 *
 * @author Ahmed Bahey
 */
public class ShieldGift extends Gift{
protected  int protectHeath=5;
    protected Image sheild;
   
    protected boolean ison=false;
    public ShieldGift() {
         super("Shield Gift");
         ImageIcon img=new ImageIcon("Shield.png");
         this.sheild=img.getImage();
        
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
