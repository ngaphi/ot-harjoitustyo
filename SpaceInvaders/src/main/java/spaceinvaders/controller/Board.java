package spaceinvaders.controller;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JPanel;
import spaceinvaders.data.Bullet;
import spaceinvaders.data.Invader;
import spaceinvaders.data.Player;
import spaceinvaders.data.Sizes;

public final class Board extends JPanel implements MouseListener {

    private final Dimension d;
    private boolean inGame = true;
    private final Timer timer;
    private Thread animator;
    String message = "Click to Start";
    String name = "Space Invaders";
    public PlayerService playerService;
    public InvaderService invaderService;
    public BulletService bulletService;

    public Board() {
        addKeyListener(new TAdapter());
        addMouseListener(this);
        setFocusable(true);
        d = new Dimension(Sizes.BOARD_WIDTH, Sizes.BOARD_HEIGHT);
        timer = new Timer(Sizes.DELAY, new GameCycle());
        timer.start();
        gameInit();

        setDoubleBuffered(true);
    }

    public void gameInit() {
        //represents player
        playerService = new PlayerService();

        //represents shot
        bulletService = new BulletService();

        //represents invaders
        invaderService = new InvaderService();

    }

    @Override
    public void paint(Graphics g) {
        //set color for background
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);

        if (inGame) {
            //draw line fot ground
            g.setColor(Color.green);
            g.drawLine(0, Sizes.GROUND,
                    Sizes.BOARD_WIDTH, Sizes.GROUND);

            //draw invaders
            paintInvaders(g);
            //draw player
            paintPlayer(g);
            //draw shot
            paintShot(g);
            //move player
            playerService.movePlayer();
            //move invaders
            invaderService.moveInvaders();

        } else {
            Font small = new Font("Helvetica", Font.BOLD, 20);
            FontMetrics metr = this.getFontMetrics(small);
            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(message, 190, d.height - 200);

            //creates text "Space Invaders"
            Font big = new Font("Helvetica", Font.BOLD, 50);
            FontMetrics metrics = this.getFontMetrics(small);
            g.setColor(Color.blue);
            g.setFont(big);
            g.drawString(name, d.width - 430, d.height - 260);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void paintPlayer(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(playerService.getPlayerX(), playerService.getPlayerY(), Sizes.PLAYER_WIDTH, Sizes.PLAYER_HEIGHT);
    }

    public void paintInvaders(Graphics g) {
        g.setColor(Color.blue);
        for (Invader in1 : invaderService.getInvaders()) {
            if (in1.visible) {
                g.fillRect(in1.x, in1.y, Sizes.INVADER_WIDTH, Sizes.PLAYER_HEIGHT);
            }
        }
    }

    public void paintShot(Graphics g) {
        for (Bullet bullet : bulletService.getBullets()) {
            if (bullet.visible) {
                g.setColor(Color.YELLOW);
                g.fillRect(bullet.x, bullet.y, 4, 8);
            }
        }
    }
    
    

    public class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
            bulletService.updateBullets();
            boolean gameWin = bulletService.collision(invaderService.getInvaders());

            if (gameWin) {
                timer.stop();
                JOptionPane.showMessageDialog(null, "You won!");
            }
            
            boolean gameLose = invaderService.invadersWon();
            
            if (gameLose) {
                timer.stop();
                JOptionPane.showMessageDialog(null, "Invasion!");
            }
        }
    }

    public class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            playerService.setMoveRight(false);
            playerService.setMoveLeft(false);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_RIGHT) {
                playerService.setMoveRight(true);
            }
            if (key == KeyEvent.VK_LEFT) {
                playerService.setMoveLeft(true);
            }
            if (key == KeyEvent.VK_SPACE) {
                bulletService.shoot(playerService.getPlayerX(), playerService.getPlayerY());
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

}
