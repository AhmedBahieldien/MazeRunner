/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.game;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author dell-pc
 */
public class SettingsGui {
       public static JRadioButton check2 = new JRadioButton("Arrows");
        public static JRadioButton check1 = new JRadioButton("KeyBoard");
    public SettingsGui() {
        JFrame frmSettings = new JFrame("Settings");
        ButtonGroup bG = new ButtonGroup();
        ImageIcon ic1 = new ImageIcon("wasd.png");
        ImageIcon ic2 = new ImageIcon("arrows.png");
        JLabel arrowpic = new JLabel(ic2);
        JLabel keyboardic = new JLabel(ic1);
        arrowpic.setBounds(250, 250, 100, 100);
        keyboardic.setBounds(50, 250, 100,100);
        frmSettings.add(arrowpic);
        frmSettings.add(keyboardic);

           
      
        frmSettings.setLayout(null);
        check1.setBounds(50, 100, 100, 100);
        check2.setBounds(250, 100, 100, 100);
        check2.setSelected(true);
        frmSettings.setSize(400, 400);
        JLabel lbl = new JLabel("Choose the Controls");
        bG.add(check1);
        bG.add(check2);
        lbl.setBounds(150, 0, 150, 150);
        frmSettings.add(lbl);
        frmSettings.add(check1);
        frmSettings.add(check2);
        frmSettings.setLocationRelativeTo(null);
        frmSettings.setVisible(true);
    }
}
