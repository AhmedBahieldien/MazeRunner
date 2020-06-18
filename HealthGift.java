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
public class HealthGift extends Gift{

    protected  int aids=10;
    protected Image heart;
    public HealthGift() {
        super("Health Gift");
         ImageIcon img=new ImageIcon("Heart.jpg");
        heart=img.getImage();
    }
    public  void increaseHealth(){
        
        if(Board.Health!=100){
            Board.Health+=aids;
            if(Board.Health>100)
            {
                Board.Health=100;
            }
        }
    }
     public Image getimg() {
        return heart;
    }
     @Override
    public void update()
    {
        increaseHealth();
    }
    
     
    
}
