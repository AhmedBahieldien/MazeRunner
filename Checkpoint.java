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
public class Checkpoint {
    
    private Image flag1;
        private Image flag2;

    public Checkpoint() {
        ImageIcon img = new ImageIcon("ch1.jpg");
        flag1 = img.getImage();
        img = new ImageIcon("ch2.jpg");
        flag2= img.getImage(); 
    }
    
     public Image getflag1() {
        return flag1;
    }

    public Image getflag2() {
        return flag2;
    }
    

        
        

    
}
