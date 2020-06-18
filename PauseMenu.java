/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.game;

import Model.game.ShieldGift;
import static View.game.MazeRunner.f;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import mazerunner.Board;

/**
 *
 * @author dell-pc
 */
public class PauseMenu {
    public static JFrame startMenu = new JFrame();
    public PauseMenu() {
        
          
      
     startMenu.getContentPane().setBackground(Color.BLUE);

        startMenu.setTitle("Main Menu");
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(150, 200, 140, 50);
        startMenu.add(btnSave);
     //   startMenu.setUndecorated(true);
        JButton btn1 = new JButton("Continue");
        btn1.setFocusable(false);
        btn1.setBounds(150, 100, 140, 50);
        startMenu.add(btn1);
        startMenu.setSize(470, 470);
        startMenu.setLayout(null);
        JButton btnexit = new JButton("Exit");
        btnexit.setBounds(150, 300, 140, 50);
        startMenu.add(btnexit);
        startMenu.setLocationRelativeTo(null);
        startMenu.setVisible(true);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(true);
                startMenu.dispose();
            }
        });

        btnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int playerx = 0;
                int playery = 0;
                int mon=Board.monalive;
                int mon2=Board.monalive2;
                int savehealth = Board.Health;
                int savescore = Board.score;
                int savebullets = Board.bullet;
                boolean arm = Board.haveArmour;
                String[] savemap = new String[31];
                for (int i = 0; i < 31; i++) {
                    savemap[i] = Board.m.Map[i];

                }
                if (Board.isCheckPoint) {
                    playerx = Board.xsave;
                    playery = Board.ysave;
                }
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        for (int i = 0; i < 31; i++) {
                            writer.write(savemap[i] + System.lineSeparator());
                        }

                        writer.write(savehealth + System.lineSeparator());
                        writer.write(savescore + System.lineSeparator());
                        writer.write(savebullets + System.lineSeparator());
                        writer.write(playerx + System.lineSeparator());
                        writer.write(playery + System.lineSeparator());
                        if (arm) {
                            writer.write(1 + System.lineSeparator());
                        } else {
                            writer.write(0 + System.lineSeparator());
                        }
                        if(mon==1){
                             writer.write(1 + System.lineSeparator()); 
                        }else{
                              writer.write(0 + System.lineSeparator()); 
                        
                        }
                        
                         if(mon2==1){
                             writer.write(1 + System.lineSeparator()); 
                        }else{
                              writer.write(0 + System.lineSeparator()); 
                        
                        }
                        
writer.write(Board.time+System.lineSeparator());
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }

                System.exit(0);
            }
        });

    }

}
