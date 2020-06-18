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
public class bulletsgift extends Gift{
    
    
    protected Image bullet;
    public bulletsgift() {
        super("bullet Gift");
         ImageIcon img=new ImageIcon("B1.png");
        bullet=img.getImage();
    }
   
     public Image getimg() {
        return bullet;
    }
    
}
