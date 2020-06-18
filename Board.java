package mazerunner;

import Model.game.Armor;
import Model.game.ArmorState;
import Model.game.Bombfactory;
import Model.game.Bombs;
import Model.game.Bullets;
import Model.game.Checkpoint;
import Model.game.Gift;
import Model.game.Giftfactory;
import Model.game.Player;
import Model.game.PlayerArmor;
import Model.game.PlayerDecorator;
import Model.game.SmallBomb;
import Model.game.monster;
import View.game.MainMenu;
import View.game.PauseMenu;
import static View.game.SettingsGui.check1;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Board extends JPanel implements ActionListener {

    private static Board newBoard;
    public int currentArticle = 0;
    public static boolean isCheckPoint;
    CareTaker caretaker = new CareTaker();
    Originator originator = new Originator();
    private Timer timer;
    private Timer tm = new Timer(1000, this);
    JTextField jf = new JTextField(10);
    public static int time = 0;
    public static Map m;
    public static Player p;
    public static monster monster;
    public static monster monster2;
    private SmallBomb SB;
    Bombfactory bombfactory = new Bombfactory();
    Giftfactory giftfactory = new Giftfactory();
    private Bombs BB = bombfactory.choosetype("big bomb");
    private Gift HG = giftfactory.choosetype("Health gift");
    public Gift SG = giftfactory.choosetype("Shield Gift");
    private Gift BG = giftfactory.choosetype("Bullet gift");
    private Gift CG = giftfactory.choosetype("coin");
    private Gift DG = giftfactory.choosetype("dollar");
    private Checkpoint checkpoint = new Checkpoint();
    private String Finishstr = "";
    private boolean win = false;
    public static int Health = 100;
    public static int score = 0;
    public static int bullet = 6;
    private Image toolbar;
    private boolean up, down, right, left;
    public static String lastPressed = null;
    private ArrayList<Bullets> bullets = new ArrayList<>();
    private boolean flag = false;
    public static int xsave = 0, ysave = 0;
    public static boolean haveArmour = false;
    int startx, exit = 6,exit2=7;
    int starty;
    public static int monalive = 1;
    public static int monalive2 = 1;
    private ArmorState state = new ArmorState();

    private Board() {
        add(jf);
        SB = new SmallBomb();
        p = new Player(0, 0);
        Armor haveArmor = new PlayerArmor(p);
        monster = new monster();
        monster2 = new monster();
        monster2.setTileX(28);
             m = new Map();
        ImageIcon img = new ImageIcon("w.jpg");
        toolbar = img.getImage();
        addKeyListener(new Al());
        setFocusable(true);
        timer = new Timer(55, this);
        timer.start();

    }

    public static synchronized Board getInstance() {
        if (newBoard == null) {
            newBoard = new Board();
        }
        return newBoard;
    }

    public void actionPerformed(ActionEvent e) {
        if (m.getMap(p.getTileX(), p.getTileY()).equals("f")) {
            Finishstr = "Winner";
            win = true;
        }
        logic();
        try {
            music();
        } catch (IOException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();

    }

    public void paint(Graphics g) {
        super.paint(g);
        if (win == false && Health > 0) {
            for (int y = 0; y < 31; y++) {
                for (int x = 0; x < 31; x++) {
                    if (m.getMap(x, y).equals("e")) {
                        g.drawImage(toolbar, x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("f")) {
                        g.drawImage(m.getFinishLine(), x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("S")) {
                        g.drawImage(m.getStartLine(), x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("g")) {
                        g.drawImage(m.getGrass(), x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("w")) {
                        g.drawImage(m.getWall(), x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("s")) {
                        g.drawImage(SB.getbomb(), x * 32, y * 32, null);
                        // g.drawImage(SBB.getbomb(), x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("h")) {
                        g.drawImage(HG.getimg(), x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("A")) {
                        g.drawImage(SG.getimg(), x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("c")) {
                        g.drawImage(CG.getimg(), x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("d")) {
                        g.drawImage(DG.getimg(), x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("b")) {
                        g.drawImage(BB.getbomb(), x * 32, y * 32, null);
                        // g.drawImage(BBB.getbomb(), x * 32, y * 32, null);

                    }
                    if (m.getMap(x, y).equals("t")) {
                        g.drawImage(m.getgrassWall(), x * 32, y * 32, null);
                    }
                    if (m.getMap(x, y).equals("z")) {
                        g.drawImage(checkpoint.getflag1(), x * 32, y * 32, null);

                    }
                    if (m.getMap(x, y).equals("Z")) {
                        g.drawImage(checkpoint.getflag2(), x * 32, y * 32, null);

                    }
                    if (m.getMap(x, y).equals("B")) {
                        g.drawImage(BG.getimg(), x * 32, y * 32, null);

                    }

                }

            }

////////////////////////////monster
            if (monalive == 1) {
                if (!m.getMap(monster.getTileX(), monster.getTileY() + 1).equals("w") && !m.getMap(monster.getTileX(), monster.getTileY() + 1).equals("t") && exit < 15) {

                    monster.move(0, 1);
                    g.drawImage(monster.getPlayer1(), monster.getTileX() * 32, monster.getTileY() * 32, null);
                    exit++;
                } else {

                    if (!m.getMap(monster.getTileX(), monster.getTileY() - 1).equals("w") && !m.getMap(monster.getTileX(), monster.getTileY() - 1).equals("t")) {

                        monster.move(0, -1);
                        g.drawImage(monster.getPlayer1(), monster.getTileX() * 32, monster.getTileY() * 32, null);
                    }
                }

                if (monster.getTileY() == 6) {
                    exit = 6;
                }

                if (monster.getTileX() == p.getTileX() && monster.getTileY() == p.getTileY()) {
                    Health = 0;
                }
            }

///////////////////////////////
//////////////////////////////
 if (monalive2 == 1) {
                if (!m.getMap(monster2.getTileX(), monster2.getTileY() + 1).equals("w") && !m.getMap(monster2.getTileX(), monster2.getTileY() + 1).equals("t") && exit2 < 13) {

                    monster2.move(0, 1);
                    g.drawImage(monster2.getPlayer1(), monster2.getTileX() * 32, monster2.getTileY() * 32, null);
                    exit2++;
                } else {

                    if (!m.getMap(monster2.getTileX(), monster2.getTileY() - 1).equals("w") && !m.getMap(monster2.getTileX(), monster2.getTileY() - 1).equals("t")) {

                        monster2.move(0, -1);
                        g.drawImage(monster2.getPlayer1(), monster2.getTileX() * 32, monster2.getTileY() * 32, null);
                    }
                }

                if (monster2.getTileY() == 7) {
                    exit2 = 7;
                }

                if (monster2.getTileX() == p.getTileX() && monster2.getTileY() == p.getTileY()) {
                    Health = 0;
                }
            }
 ///////////////////////////////////////////

            if (left) {
                g.drawImage(p.getPlayer1(), p.getTileX() * 32, p.getTileY() * 32, null);
            }
            if (right) {
                g.drawImage(p.getPlayer2(), p.getTileX() * 32, p.getTileY() * 32, null);
            }
            if (up) {
                g.drawImage(p.getPlayer3(), p.getTileX() * 32, p.getTileY() * 32, null);
            }
            if (down) {
                g.drawImage(p.getPlayer4(), p.getTileX() * 32, p.getTileY() * 32, null);
            }

        }
        if (isCheckPoint && Health <= 0 && currentArticle >= 1) {
            Point aPoint = new Point();
            currentArticle--;
            aPoint = originator.restoreFromMemento(caretaker.getMemento(currentArticle));
            p.setTileX(aPoint.x);
            p.setTileY(aPoint.y);
            Health = 100;
            g.drawImage(p.getPlayer4(), aPoint.x * 32, aPoint.y * 32, null);

        }

        g.setColor(Color.red);
        if (win) {

            View.game.MazeRunner.f.dispose();
            JFrame startMenu = new JFrame();
            startMenu.setTitle("YOU WON");
            startMenu.setUndecorated(true);
            startMenu.setSize(700, 700);
            startMenu.setLayout(null);
            startMenu.setLocationRelativeTo(null);
            ImageIcon backimg = new ImageIcon("won.jpg");
            JLabel backgroundmenu = new JLabel(backimg);
            backgroundmenu.setSize(700, 700);
            startMenu.add(backgroundmenu);
            startMenu.setVisible(true);

            JOptionPane.showMessageDialog(null, "You Won ! Press Ok to Exit the game");
            System.exit(0);

        }
        if (Health <= 0 && isCheckPoint == false) {
            Health = 0;
            View.game.MazeRunner.f.dispose();

            JOptionPane.showMessageDialog(null, "You Lost ! Press ok to Exit the game");
            System.exit(0);

        }
        g.setColor(Color.BLACK);
        g.drawRect(40, 0, 100, 30);
        g.setColor(Color.GREEN);
        if (Health <= 50) {
            g.setColor(Color.RED);
        }
        if (Health <= 25) {
            g.setColor(Color.BLACK);
        }

        if (haveArmour) {

//            SG.setIson(true);
            state.setArmorToTrue(SG);
        } else {
//            SG.setIson(false);
            state.setArmortoFalse(SG);
        }
        if (SG.ison()) {
            g.drawImage(m.getArmour(), 165, 0, null);
        }
        Image clock;
        g.drawString(Finishstr, 500, 500);
        ImageIcon img = new ImageIcon("c.gif");
        clock = img.getImage();

        g.fillRect(40, 0, Health, 30);
        g.setColor(Color.BLACK);
        g.drawString("Health", 0, 20);
        g.drawString(Integer.toString(Health), 40, 20);
        g.drawString("Score", 220, 20);
        g.drawString(Integer.toString(score), 270, 20);
        g.drawImage(clock, 400, 0, null);
        g.drawString(Integer.toString(bullet), 650, 20);
        g.drawImage(m.getbicon(), 600, 0, null);
        int i = 0;
        if (flag) {

            while (i < bullets.size()) {
                g.drawImage(bullets.get(i).getBullet(), bullets.get(i).getX(), bullets.get(i).getY(), null);
                Bullets b = bullets.get(i);
                bullets.remove(i);
                b.move();
                try {
                    if (m.getMap(b.getX() / 32, b.getY() / 32).equals("t")) {

                        m.set(b.getX() / 32, b.getY() / 32);
                        bullets.remove(b);

                    } else if (m.getMap(b.getX() / 32, b.getY() / 32).equals("w")) {
                        bullets.remove(b);
                    } else {
                        if (b.isVisible()) {
                            bullets.add(b);
                        }
                        i++;
                    }

                    if (b.getX() / 32 == monster.getTileX() && b.getY() / 32 == monster.getTileY()) {
                        m.set(b.getX() / 32, b.getY() / 32);
                        monalive = 0;
                        bullets.remove(b);
                    }
                    
                     if (b.getX() / 32 == monster2.getTileX() && b.getY() / 32 == monster2.getTileY()) {
                        m.set(b.getX() / 32, b.getY() / 32);
                        monalive2 = 0;
                        bullets.remove(b);
                    }


                } catch (Exception e) {

                }
            }
        }
    }

    public class Al extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            if (check1.isSelected()) {
                if (keycode == KeyEvent.VK_W) {
                    if (!m.getMap(p.getTileX(), p.getTileY() - 1).equals("w") && !m.getMap(p.getTileX(), p.getTileY() - 1).equals("t")) {
                        p.move(0, -1);
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("s")) {
                            if (SG.ison()) {
                                Health = Health - 5;
//                                SG.setIson(false);
                                state.setArmortoFalse(SG);
                                haveArmour = false;

                            } else {
                                Health = Health - 10;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("h")) {
                            m.set(p.getTileX(), p.getTileY());
                            HG.update();
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("A")) {
//                            SG.setIson(true);
                            state.setArmorToTrue(SG);
                            p.putarmor();
                            haveArmour = true;
                            m.set(p.getTileX(), p.getTileY());
                        }

                        if (m.getMap(p.getTileX(), p.getTileY()).equals("c")) {
                            CG.update();
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("d")) {
                            DG.update();
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("b")) {
                            if (SG.ison()) {
                                Health = Health - 30;
//                                SG.setIson(false);
                                state.setArmortoFalse(SG);
                            } else {
                                Health = Health - 50;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("z")) {
                            m.setflag(p.getTileX(), p.getTileY());
                            Point mypoint = new Point();
                            mypoint.x = p.getTileX();
                            mypoint.y = p.getTileY();
                            originator.set(mypoint);
                            caretaker.addMemento(originator.storeInMemento());
                            isCheckPoint = true;
                            currentArticle++;

                            xsave = p.getTileX();
                            ysave = p.getTileY();

                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("B")) {
                            if (bullet >= 6) {
                            } else {
                                bullet = bullet + 1;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                    }
                    up = true;
                    down = false;
                    right = false;
                    left = false;
                    lastPressed = "up";
                }
                if (keycode == KeyEvent.VK_S) {
                    if (!m.getMap(p.getTileX(), p.getTileY() + 1).equals("w") && !m.getMap(p.getTileX(), p.getTileY() + 1).equals("t")) {
                        p.move(0, 1);
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("s")) {
                            if (SG.ison()) {
                                Health = Health - 5;
//                                SG.setIson(false);
                                state.setArmortoFalse(SG);
                                haveArmour = false;

                            } else {
                                Health = Health - 10;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("h")) {
                            m.set(p.getTileX(), p.getTileY());
                            //HG.increaseHealth();
                            HG.update();
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("A")) {
//                            SG.setIson(true);
                            state.setArmorToTrue(SG);
                            p.putarmor();
                            haveArmour = true;

                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("c")) {
                            CG.update();
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("d")) {
                            // CG.update();
                            DG.update();
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("b")) {
                            if (SG.ison()) {
                                Health = Health - 30;
//                                SG.setIson(false);
                                state.setArmortoFalse(SG);
                            } else {
                                Health = Health - 50;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("z")) {
                            m.setflag(p.getTileX(), p.getTileY());
                            Point mypoint = new Point();
                            mypoint.x = p.getTileX();
                            mypoint.y = p.getTileY();
                            originator.set(mypoint);
                            caretaker.addMemento(originator.storeInMemento());
                            isCheckPoint = true;
                            currentArticle++;

                            xsave = p.getTileX();
                            ysave = p.getTileY();
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("B")) {
                            if (bullet >= 6) {
                            } else {
                                bullet = bullet + 1;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                    }
                    up = false;
                    down = true;
                    right = false;
                    left = false;
                    lastPressed = "down";
                }
                if (keycode == KeyEvent.VK_A) {
                    if (!m.getMap(p.getTileX() - 1, p.getTileY()).equals("w") && !m.getMap(p.getTileX() - 1, p.getTileY()).equals("t")) {
                        p.move(-1, 0);
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("s")) {
                            if (SG.ison()) {
                                Health = Health - 5;
//                                SG.setIson(false);
                                state.setArmortoFalse(SG);
                                haveArmour = false;

                            } else {
                                Health = Health - 10;
                            }
                            m.set(p.getTileX(), p.getTileY());

                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("h")) {
                            m.set(p.getTileX(), p.getTileY());
                            //  HG.increaseHealth();
                            HG.update();
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("A")) {
//                            SG.setIson(true);
                            state.setArmorToTrue(SG);
                            p.putarmor();
                            haveArmour = true;

                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("c")) {
                            // CG.increasescore();
                            CG.update();
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("d")) {
                            DG.update();
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("b")) {
                            if (SG.ison()) {
                                Health = Health - 30;
//                                SG.setIson(false);
                                state.setArmortoFalse(SG);
                            } else {
                                Health = Health - 50;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("z")) {
                            m.setflag(p.getTileX(), p.getTileY());
                            Point mypoint = new Point();
                            mypoint.x = p.getTileX();
                            mypoint.y = p.getTileY();
                            originator.set(mypoint);
                            caretaker.addMemento(originator.storeInMemento());
                            isCheckPoint = true;
                            currentArticle++;

                            xsave = p.getTileX();
                            ysave = p.getTileY();
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("B")) {
                            if (bullet >= 6) {
                            } else {
                                bullet = bullet + 1;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                    }
                    up = false;
                    down = false;
                    right = false;
                    left = true;
                    lastPressed = "left";

                }
                if (keycode == KeyEvent.VK_D) {
                    if (!m.getMap(p.getTileX() + 1, p.getTileY()).equals("w") && !m.getMap(p.getTileX() + 1, p.getTileY()).equals("t")) {
                        p.move(1, 0);
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("s")) {

                            if (SG.ison()) {
                                Health = Health - 5;
//                                SG.setIson(false);
                                state.setArmortoFalse(SG);
                                haveArmour = false;

                            } else {
                                Health = Health - 10;
                            }
                            m.set(p.getTileX(), p.getTileY());

                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("h")) {
                            m.set(p.getTileX(), p.getTileY());
                            //   HG.increaseHealth();
                            HG.update();
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("A")) {
//                            SG.setIson(true);
                            state.setArmorToTrue(SG);
                            p.putarmor();
                            haveArmour = true;

                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("c")) {
                            CG.update();
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("d")) {
                            DG.update();
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("b")) {
                            if (SG.ison()) {
                                Health = Health - 30;
//                                SG.setIson(false);
                                state.setArmortoFalse(SG);
                            } else {
                                Health = Health - 50;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("z")) {
                            m.setflag(p.getTileX(), p.getTileY());
                            Point mypoint = new Point();
                            mypoint.x = p.getTileX();
                            mypoint.y = p.getTileY();
                            originator.set(mypoint);
                            caretaker.addMemento(originator.storeInMemento());
                            isCheckPoint = true;
                            currentArticle++;
                            xsave = p.getTileX();
                            ysave = p.getTileY();
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("B")) {
                            if (bullet >= 6) {
                            } else {
                                bullet = bullet + 1;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }

                    }
                    up = false;
                    down = false;
                    right = true;
                    left = false;
                    lastPressed = "right";

                }
            } else {
                if (keycode == KeyEvent.VK_UP) {
                    if (!m.getMap(p.getTileX(), p.getTileY() - 1).equals("w") && !m.getMap(p.getTileX(), p.getTileY() - 1).equals("t")) {
                        p.move(0, -1);
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("s")) {
                            if (SG.ison()) {
                                Health = Health - 5;
//                                SG.setIson(false);
                                state.setArmortoFalse(SG);
                                haveArmour = false;

                            } else {
                                Health = Health - 10;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("h")) {
                            m.set(p.getTileX(), p.getTileY());
                            /// HG.increaseHealth();
                            HG.update();
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("A")) {
//                            SG.setIson(true);
                            state.setArmorToTrue(SG);
                            p.putarmor();
                            haveArmour = true;

                            m.set(p.getTileX(), p.getTileY());
                        }

                        if (m.getMap(p.getTileX(), p.getTileY()).equals("c")) {
                            // CG.increasescore();
                            CG.update();
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("d")) {
                            DG.update();
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("b")) {
                            if (SG.ison()) {
                                Health = Health - 30;
//                                SG.setIson(false);
                                state.setArmortoFalse(SG);
                            } else {
                                Health = Health - 50;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("z")) {
                            m.setflag(p.getTileX(), p.getTileY());
                            Point mypoint = new Point();
                            mypoint.x = p.getTileX();
                            mypoint.y = p.getTileY();
                            originator.set(mypoint);
                            caretaker.addMemento(originator.storeInMemento());
                            isCheckPoint = true;
                            currentArticle++;

                            xsave = p.getTileX();
                            ysave = p.getTileY();

                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("B")) {
                            if (bullet >= 6) {
                            } else {
                                bullet = bullet + 1;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                    }
                    up = true;
                    down = false;
                    right = false;
                    left = false;
                    lastPressed = "up";
                }
                if (keycode == KeyEvent.VK_DOWN) {
                    if (!m.getMap(p.getTileX(), p.getTileY() + 1).equals("w") && !m.getMap(p.getTileX(), p.getTileY() + 1).equals("t")) {
                        p.move(0, 1);
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("s")) {
                            if (SG.ison()) {
                                Health = Health - 5;
//                                SG.setIson(false);
                                state.setArmortoFalse(SG);
                                haveArmour = false;

                            } else {
                                Health = Health - 10;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("h")) {
                            m.set(p.getTileX(), p.getTileY());
                            //  HG.increaseHealth();
                            HG.update();
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("A")) {
//                            SG.setIson(true);
                            state.setArmorToTrue(SG);
                            p.putarmor();
                            haveArmour = true;

                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("c")) {
                            //  CG.increasescore();
                            CG.update();
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("d")) {
                            DG.update();
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("b")) {
                            if (SG.ison()) {
                                Health = Health - 30;
//                                SG.setIson(false);
                                state.setArmortoFalse(SG);
                            } else {
                                Health = Health - 50;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("z")) {
                            m.setflag(p.getTileX(), p.getTileY());
                            Point mypoint = new Point();
                            mypoint.x = p.getTileX();
                            mypoint.y = p.getTileY();
                            originator.set(mypoint);
                            caretaker.addMemento(originator.storeInMemento());
                            isCheckPoint = true;
                            currentArticle++;

                            xsave = p.getTileX();
                            ysave = p.getTileY();
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("B")) {
                            if (bullet >= 6) {
                            } else {
                                bullet = bullet + 1;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                    }
                    up = false;
                    down = true;
                    right = false;
                    left = false;
                    lastPressed = "down";
                }
                if (keycode == KeyEvent.VK_LEFT) {
                    if (!m.getMap(p.getTileX() - 1, p.getTileY()).equals("w") && !m.getMap(p.getTileX() - 1, p.getTileY()).equals("t")) {
                        p.move(-1, 0);
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("s")) {
                            if (SG.ison()) {
                                Health = Health - 5;
//                                SG.setIson(false);
                                state.setArmortoFalse(SG);
                                haveArmour = false;

                            } else {
                                Health = Health - 10;
                            }
                            m.set(p.getTileX(), p.getTileY());

                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("h")) {
                            m.set(p.getTileX(), p.getTileY());
                            //  HG.increaseHealth();
                            HG.update();
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("A")) {
//                            SG.setIson(true);
                            state.setArmorToTrue(SG);
                            p.putarmor();
                            haveArmour = true;

                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("c")) {
                            //CG.increasescore();
                            CG.update();
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("d")) {
                            DG.update();
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("b")) {
                            if (SG.ison()) {
                                Health = Health - 30;
//                                SG.setIson(false);
                                state.setArmortoFalse(SG);
                            } else {
                                Health = Health - 50;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("z")) {
                            m.setflag(p.getTileX(), p.getTileY());
                            Point mypoint = new Point();
                            mypoint.x = p.getTileX();
                            mypoint.y = p.getTileY();
                            originator.set(mypoint);
                            caretaker.addMemento(originator.storeInMemento());
                            isCheckPoint = true;
                            currentArticle++;

                            xsave = p.getTileX();
                            ysave = p.getTileY();
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("B")) {
                            if (bullet >= 6) {
                            } else {
                                bullet = bullet + 1;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                    }
                    up = false;
                    down = false;
                    right = false;
                    left = true;
                    lastPressed = "left";

                }
                if (keycode == KeyEvent.VK_RIGHT) {
                    if (!m.getMap(p.getTileX() + 1, p.getTileY()).equals("w") && !m.getMap(p.getTileX() + 1, p.getTileY()).equals("t")) {
                        p.move(1, 0);
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("s")) {

                            if (SG.ison()) {
                                Health = Health - 5;
//                                SG.setIson(false);
                                state.setArmortoFalse(SG);
                                haveArmour = false;

                            } else {
                                Health = Health - 10;
                            }
                            m.set(p.getTileX(), p.getTileY());

                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("h")) {
                            m.set(p.getTileX(), p.getTileY());
                            //   HG.increaseHealth();
                            HG.update();
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("A")) {
//                            SG.setIson(true);
                            state.setArmorToTrue(SG);
                            p.putarmor();
                            haveArmour = true;

                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("c")) {
                            // CG.increasescore();
                            CG.update();
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("d")) {
                            DG.update();
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("b")) {
                            if (SG.ison()) {
                                Health = Health - 30;
//                                SG.setIson(false);
                                state.setArmortoFalse(SG);
                            } else {
                                Health = Health - 50;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("z")) {
                            m.setflag(p.getTileX(), p.getTileY());
                            Point mypoint = new Point();
                            mypoint.x = p.getTileX();
                            mypoint.y = p.getTileY();
                            originator.set(mypoint);
                            caretaker.addMemento(originator.storeInMemento());
                            isCheckPoint = true;
                            currentArticle++;

                            xsave = p.getTileX();
                            ysave = p.getTileY();
                        }
                        if (m.getMap(p.getTileX(), p.getTileY()).equals("B")) {
                            if (bullet >= 6) {
                            } else {
                                bullet = bullet + 1;
                            }
                            m.set(p.getTileX(), p.getTileY());
                        }

                    }
                    up = false;
                    down = false;
                    right = true;
                    left = false;
                    lastPressed = "right";

                }
            }
            if (keycode == KeyEvent.VK_SPACE) {
                if (bullet != 0) {
                    flag = true;
                    bullets.add(p.getBullet());
                    bullet--;
                }
            }
            if (keycode == KeyEvent.VK_ESCAPE) {
                new PauseMenu();
            }
        }

        public void keyReleased(KeyEvent e) {

        }

        public void keyTyped(KeyEvent e) {

        }
    }

    public void logic() {
        if (!View.game.MainMenu.startMenu.isVisible() && !View.game.PauseMenu.startMenu.isVisible()) {
            time++;
        }
        if (time == 3600) {
            JOptionPane.showMessageDialog(null, "Time is up");

            System.exit(0);

        }
        jf.setText("0" + time / 60);

    }

    public static void music() throws IOException {
        if (View.game.MainMenu.startMenu.isVisible() || View.game.PauseMenu.startMenu.isVisible()) {
            String filename = "mus.wav";
            ContinuousAudioDataStream loop = null;
            InputStream in = null;
            try {
                in = new FileInputStream(filename);
            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
            }
            try {
                AudioStream s = new AudioStream(in);
                AudioData MD;
                AudioPlayer.player.start(s);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}
