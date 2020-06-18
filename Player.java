/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.game;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author dell-pc
 */
public class Player  extends Observable implements Armor{

    private int tileX, tileY;
    private Image player1, player2, player3, player4;
    private int score, health;

    public Player(int score, int health) {
        player1 = Toolkit.getDefaultToolkit().createImage("Playerside1.png");
        player2 = Toolkit.getDefaultToolkit().createImage("Playerside2.png");
        player3 = Toolkit.getDefaultToolkit().createImage("Playerup.png");
        player4 = Toolkit.getDefaultToolkit().createImage("Playerdown.png");
        tileX = 1;
        tileY = 1;

        this.health = health;
        this.score = score;
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

    public int getScore() {
        return score;
    }

    public int getHealth() {
        return health;
    }

    public void setScore(int score) {
        this.score = score;
        setChanged();
        notifyObservers(new Integer(this.score));

    }

    public void setHealth(int health) {
        this.health = health;
        setChanged();
        notifyObservers(new Integer(this.health));

    }
    public Bullets getBullet(){
        Bullets b = new Bullets(this.tileX,this.tileY);
          System.out.println(b.getX() + "  " + this.tileX);
        return b;
    }

    @Override
    public void putarmor() {
       
    }
    
    



}
