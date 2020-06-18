
package Model.game;
import java.awt.Image;
import java.awt.Toolkit;
import mazerunner.Board;

/**
 *
 * @author Ahmed Bahey
 */
public class Bullets {
    
    private int x,y;
    private final float speed= 1 *32;
    private final int width=1000;
    private final int height=1000;
    private boolean visible;
    private Image bullet;
    private String direction;
    

    public Bullets(int x, int y) {
        this.x = x * 32;
        this.y = y * 32;
        this.visible = true;
        bullet =Toolkit.getDefaultToolkit().createImage("bullet.jpg");
        direction = Board.lastPressed;
    }
    
    public  void putbullet(){
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void move(){
        
        switch(direction)
        {
            case "up":
                this.y -= speed;
                break;
            case "down":
                this.y += speed;
                break;
            case "right":
                this.x += speed;
                break;
            case "left":
                this.x -= speed;
                break; 
        }
        if(x < 0 || x> width || y <0 || y>height)
        {
            visible = false;
        }
        
    }

    public Image getBullet() {
        return bullet;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }
    
    
    
    
}