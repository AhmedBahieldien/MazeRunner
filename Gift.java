package Model.game;

import java.awt.Image;
import mazerunner.Board;

/**
 *
 * @author Ahmed Bahey
 */
public abstract class Gift implements Update{

    protected String type;
    protected Image heart;
 protected Image sheild;
    public Gift(String type) {
        this.type = type;
    }

     public  void increaseHealth(){
        
     
    }
     public void increasescore(){
         
     }
 
    
      public boolean ison() {
        return false;
    }
      
       public void setIson(boolean ison) {
      
    }
    public Image getimg() {
        return heart;
    }
    public int getHealth()
    {
        return 0;
    }
    
    @Override
    public void update()
    {
        
    }
}
