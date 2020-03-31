package spaceinvaders;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class Board extends JPanel implements Runnable, MouseListener {

    private Dimension d;
    boolean inGame = true;
    private Timer timer;
    private Thread animator;
    String message = "Click to Start";
    String name = "Space Invaders";
    Player player;

    public Board() {
        addKeyListener(new TAdapter());
        addMouseListener(this);
        setFocusable(true);
        d = new Dimension(Sizes.BOARD_WIDTH, Sizes.BOARD_HEIGHT);
        player = new Player(Sizes.BOARD_WIDTH / 2, Sizes.BOARD_HEIGHT - 120, 5);
        if (animator == null || !inGame) {
            animator = new Thread(this);
            animator.start();
        }
        setDoubleBuffered(true);
    }

    public void paint(Graphics g) {
        //set color for background
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);

        //creates text "Click to start"
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

        if (inGame) {
            g.setColor(Color.green);
            g.drawLine(0, Sizes.GROUND,
                    Sizes.BOARD_WIDTH, Sizes.GROUND);

            //creates player
            g.setColor(Color.red);
            g.fillRect(player.x, player.y, 20, 20);
            if (player.moveRight == true) {
                player.x += player.speed;
            }
            if (player.moveLeft == true) {
                player.x -= player.speed;
            }

        } else {
            if (timer.isRunning()) {
                timer.stop();
            }
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void run() {
        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();
        int animationDelay = 20;
        long time
                = System.currentTimeMillis();
        while (true) {
            repaint();
            try {
                time += animationDelay;
                Thread.sleep(Math.max(0, time
                        - System.currentTimeMillis()));
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            player.moveRight = false;
            player.moveLeft = false;
        }

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_RIGHT) {
                player.moveRight = true;
            }
            if (key == KeyEvent.VK_LEFT) {
                player.moveLeft = true;
            }
        }

    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

}
