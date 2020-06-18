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
public class Bombfactory {
    
    public Bombs choosetype(String type){
        Bombs b=null;
        if(type.equalsIgnoreCase("small bomb")){
          b=new SmallBomb();
        }
        else if(type.equalsIgnoreCase("big bomb")){
          b=new Bigbombs();
        }
        return b;
    }
    
}


//public class Bombfactory {
//    
//   
//    
//}
