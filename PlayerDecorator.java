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
public abstract class PlayerDecorator implements Armor {

    protected Armor  playerDecorator;
   

    public PlayerDecorator(Armor playerDecorator) {
        this.playerDecorator = playerDecorator;
       
    }

    @Override
    public void putarmor() {
        playerDecorator.putarmor();
    }

}


    
    
    
    
    

