/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.game;

import java.awt.Image;

/**
 *
 * @author Ahmed Bahey
 */
public abstract class Bombs {

    protected int damage;
    protected Image Bombimg;

    public Bombs() {

        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Image getbomb() {
        return Bombimg;
    }

}
