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
public class Bulletgift extends Gift{
    
    
    protected Image bullet;
    public Bulletgift() {
        super("bullet Gift");
         ImageIcon img=new ImageIcon("bullet.jpg");
        heart=img.getImage();
    }
   
     public Image getimg() {
        return bullet;
    }
    
}
