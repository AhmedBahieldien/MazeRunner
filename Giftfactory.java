/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.game;

/**
 *
 * @author Ahmed Bahey
 */
public class Giftfactory {

    public Gift choosetype(String type) {
        Gift g = null;
        if (type.equalsIgnoreCase("Health gift")) {
            g = new HealthGift();
        } else if (type.equalsIgnoreCase("Bullet gift")) {
            g = new bulletsgift();
        } else if (type.equalsIgnoreCase("Shield Gift")) {
            g = new ShieldGift();
        } else if (type.equalsIgnoreCase("coin")) {
            g = new coin();
        } else if (type.equalsIgnoreCase("dollar")) {
            g = new dollar();
        }
        return g;
    }

}
