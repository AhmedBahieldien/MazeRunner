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
public class dollar extends Gift{
    protected int incscore=500;
   protected Image dollars;
    public dollar() {
        super("dollar");
         ImageIcon img=new ImageIcon("Gems.jpg");
         dollars=img.getImage();
    }
    
     public Image getimg() {
        return dollars;
    }
     
       public void increasescore(){
           Board.score+=incscore;
     }
       
        @Override
    public void update() {
        increasescore();
    }
}
