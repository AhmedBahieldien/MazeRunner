package View.game;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import mazerunner.Board;

public class MazeRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {

        new MazeRunner();

    }
//new postision here

    public static JFrame f = new JFrame();

    public MazeRunner() throws InterruptedException, IOException {

       
        new MainMenu();
        f.setTitle("Maze Game");
        //f.add(new Board());
        f.add(Board.getInstance());
        f.setSize(1000, 1000);
        f.setLocationRelativeTo(null);
        f.setUndecorated(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
