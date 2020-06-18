/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.game;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Ahmed Bahey
 */
public class monster {
    
     private int tileX, tileY;
    private Image player1, player2, player3, player4;
    private int score, health;

    public monster() {
        player1 = Toolkit.getDefaultToolkit().createImage("mo.jpg");
        player2 = Toolkit.getDefaultToolkit().createImage("mo.jpg");
        player3 = Toolkit.getDefaultToolkit().createImage("mo.jpg");
        player4 = Toolkit.getDefaultToolkit().createImage("mo.jpg");
        tileX = 1;
        tileY = 1;

        
    }

    public Image getPlayer1() {
        return player1;
    }

    public Image getPlayer2() {
        return player2;
    }

    public Image getPlayer3() {
        return player3;
    }

    public Image getPlayer4() {
        return player4;
    }

    public int getTileX() {
        return tileX;
    }

    public void setTileX(int tileX) {
        this.tileX = tileX;
    }

    public void setTileY(int tileY) {
        this.tileY = tileY;
    }

    public int getTileY() {
        return tileY;
    }

    public void move(int dx, int dy) {

        tileX += dx;
        tileY += dy;
    }

     public void movem(double dx, double dy) {

        tileX += dx;
        tileY += dy;
    }
    public int getScore() {
        return score;
    }

    public int getHealth() {
        return health;
    }

    public void setScore(int score) {
        this.score = score;
       

    }

    public void setHealth(int health) {
        this.health = health;
     
    }
    public Bullets getBullet(){
        Bullets b = new Bullets(this.tileX,this.tileY);
          System.out.println(b.getX() + "  " + this.tileX);
        return b;
    }
    
   

    
}
