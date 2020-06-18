/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.game;

import Model.game.Player;
import static View.game.MazeRunner.f;
import com.sun.prism.paint.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import mazerunner.Board;
import mazerunner.Map;

/**
 *
 * @author dell-pc
 */
public class MainMenu {

    public static JFrame startMenu = new JFrame();

    public MainMenu() {

        startMenu.setTitle("Main Menu");
        startMenu.setUndecorated(true);
        JButton btn1 = new JButton();
        btn1.setBounds(175, 150, 140, 50);
        btn1.setOpaque(false);
        btn1.setContentAreaFilled(false);
        btn1.setBorderPainted(false);
        btn1.setVisible(true);
        startMenu.add(btn1);
        startMenu.setSize(470, 470);
        startMenu.setLayout(null);
        startMenu.setLocationRelativeTo(null);
        ImageIcon backimg = new ImageIcon("themainmenu.png");
        JLabel backgroundmenu = new JLabel(backimg);
        backgroundmenu.setSize(500, 500);
        startMenu.add(backgroundmenu);
        startMenu.setVisible(true);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(true);
                startMenu.dispose();
            }
        });

        JButton btn2 = new JButton();
        btn2.setBounds(175, 200, 140, 50);
        btn2.setOpaque(false);
        btn2.setContentAreaFilled(false);
        btn2.setBorderPainted(false);
        btn2.setVisible(true);
        startMenu.add(btn2);
        startMenu.setSize(470, 470);
        startMenu.setLayout(null);
        startMenu.setLocationRelativeTo(null);
        //ImageIcon backimg=new ImageIcon("themainmenu.png");
        //JLabel backgroundmenu=new JLabel(backimg);
        backgroundmenu.setSize(500, 500);
        startMenu.add(backgroundmenu);
        startMenu.setVisible(true);

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    Scanner srscanner = null;
                    try {
                        srscanner = new Scanner(file);
                    } catch (FileNotFoundException err) {
                        System.out.println("Error Loading Map");
                    }

                    for (int i = 0; i < 31; i++) {
                        Board.m.Map[i] = srscanner.next();
                    }
                    Board.Health = srscanner.nextInt();
                    Board.score = srscanner.nextInt();
                    Board.bullet = srscanner.nextInt();
                    int place1 = srscanner.nextInt();
                    int place2 = srscanner.nextInt();

                    if (place1 != 0 && place2 != 0) {
                        Board.p.setTileX(place1);
                        Board.p.setTileY(place2);
                    } else {

                    }
                    int findarm = srscanner.nextInt();
                    if (findarm == 1) {
                        Board.haveArmour = true;
                    } else {
                        Board.haveArmour = false;
                    }
                 
                    int seemonalive=srscanner.nextInt();
                    if (seemonalive==1) {
                        Board.monalive=1;
                        
                    }else{
                        Board.monalive=0;
                    }
                     int seemonalive2=srscanner.nextInt();
                     if (seemonalive2==1) {
                        Board.monalive2=1;
                        
                    }else{
                        Board.monalive2=0;
                    }
                     
                       Board.time = srscanner.nextInt();
                    srscanner.close();

                }
                
                f.setVisible(true);
                startMenu.dispose();
            }
        });

        JButton btnS3 = new JButton();
        btnS3.setBounds(175, 250, 140, 50);
        btnS3.setOpaque(false);
        btnS3.setContentAreaFilled(false);
        btnS3.setBorderPainted(false);
        btnS3.setOpaque(false);

        btnS3.setVisible(true);
        startMenu.add(btnS3);
        startMenu.setSize(470, 470);
        startMenu.setLayout(null);
        startMenu.setLocationRelativeTo(null);
        // ImageIcon backimg=new ImageIcon("themainmenu.png");
        // JLabel backgroundmenu=new JLabel(backimg);
        backgroundmenu.setSize(500, 500);
        startMenu.add(backgroundmenu);
        startMenu.setVisible(true);

        btnS3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SettingsGui();

            }
        });

        JButton btn4 = new JButton();
        btn4.setBounds(175, 300, 140, 50);
        btn4.setOpaque(false);
        btn4.setContentAreaFilled(false);
        btn4.setBorderPainted(false);
        btn4.setVisible(true);
        startMenu.add(btn4);
        startMenu.setSize(470, 470);
        startMenu.setLayout(null);
        startMenu.setLocationRelativeTo(null);
        // ImageIcon backimg=new ImageIcon("themainmenu.png");
        // JLabel backgroundmenu=new JLabel(backimg);
        backgroundmenu.setSize(500, 500);
        startMenu.add(backgroundmenu);
        startMenu.setVisible(true);

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "CopyRight Ahmed Hamdi,Amr Akmal,Ahmed Bahey,Zeyad!");

            }
        });

    }

}
