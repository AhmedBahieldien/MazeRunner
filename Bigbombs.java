/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.game;

import javax.swing.ImageIcon;

/**
 *
 * @author Ahmed Bahey
 */
public class Bigbombs extends Bombs{

    public Bigbombs() {
         super();
        ImageIcon img = new ImageIcon("BigB.jpg");
        super.Bombimg = img.getImage();
        setDamage(20);
    }

   
   
    
    
}
