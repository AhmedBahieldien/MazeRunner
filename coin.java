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
public class coin extends Gift {

    protected int incscore = 100;
    protected Image coins;

    public coin() {
        super("coin");
        ImageIcon img = new ImageIcon("coin.png");
        coins = img.getImage();
    }

    public Image getimg() {
        return coins;
    }

    public void increasescore() {
        Board.score += incscore;
    }

    @Override
    public void update() {
        increasescore();
    }
}
