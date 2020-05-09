package spaceinvaders.controller;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JPanel;
import spaceinvaders.data.Bullet;
import spaceinvaders.data.Invader;
import spaceinvaders.data.Sizes;

/**
 * The class creates game board and functionalities in it
 */
public final class Board extends JPanel{

    private final Dimension d;
    private final Timer timer;
    String message = "Game Over";
    public PlayerService playerService;
    public InvaderService invaderService;
    public BulletService bulletService;
    private int score = 0;
    boolean newGameCanBeStarted = true;

    public Board() {
        JOptionPane.showMessageDialog(null, "Space Invaders"
                + "\n" + "Click OK to start a game!");

        addKeyListener(new TAdapter());
//        addMouseListener(this);
        setFocusable(true);
        d = new Dimension(Sizes.BOARD_WIDTH, Sizes.BOARD_HEIGHT);
        timer = new Timer(Sizes.DELAY, new GameCycle());
        timer.start();

        playerService = new PlayerService();
        bulletService = new BulletService();
        invaderService = new InvaderService(Sizes.INVADER_INITIAL_SPEED);

        setDoubleBuffered(true);
    }

    /*
     * This method will set color for the background
     */
    @Override
    public void paint(Graphics g) {
        //set color for background                   
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);

        g.setColor(Color.green);
        g.drawLine(0, Sizes.GROUND,
                Sizes.BOARD_WIDTH, Sizes.GROUND);

        paintScore(g);
        paintHighScore(g);
        paintInvaders(g);
        paintPlayer(g);
        paintShot(g);
        
        playerService.movePlayer();
        invaderService.moveInvaders();

        boolean gameLose = invaderService.invadersWon();
        if (gameLose) {
            timer.stop();
            paintGameOver(g);
        }
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    private void paintPlayer(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(playerService.getPlayerX(), playerService.getPlayerY(), Sizes.PLAYER_WIDTH, Sizes.PLAYER_HEIGHT);
    }

    private void paintInvaders(Graphics g) {
        g.setColor(Color.blue);
        for (Invader in1 : invaderService.getInvaders()) {
            if (in1.visible) {
                g.fillRect(in1.x, in1.y, Sizes.INVADER_WIDTH, Sizes.PLAYER_HEIGHT);
            }
        }
    }

    private void paintShot(Graphics g) {
        for (Bullet bullet : bulletService.getBullets()) {
            if (bullet.visible) {
                g.setColor(Color.YELLOW);
                g.fillRect(bullet.x, bullet.y, 4, 8);
            }
        }
    }

    private void paintGameOver(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, Sizes.BOARD_WIDTH, Sizes.BOARD_HEIGHT);

        g.setColor(new Color(0, 32, 48));
        g.fillRect(50, Sizes.BOARD_WIDTH / 2 - 30, Sizes.BOARD_WIDTH - 100, 50);
        g.setColor(Color.white);
        g.drawRect(50, Sizes.BOARD_WIDTH / 2 - 30, Sizes.BOARD_WIDTH - 100, 50);

        //"Game Over"
        var small = new Font("Helvetica", Font.BOLD, 14);
        var fontMetrics = this.getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(message, (Sizes.BOARD_WIDTH - fontMetrics.stringWidth(message)) / 2,
                Sizes.BOARD_HEIGHT / 2);

        //"Your score"
        var s = new Font("Helvetica", Font.BOLD, 20);
        var fontMetrics2 = this.getFontMetrics(s);
        g.setColor(Color.white);
        g.setFont(s);
        g.drawString("Your score: " + score, (Sizes.BOARD_WIDTH - fontMetrics2.stringWidth(message)) / 2 - 10,
                Sizes.BOARD_HEIGHT / 2 + 60);

        int recentHighScore = FilesService.readFromFile();
        if (score > recentHighScore) {
            FilesService.writeToFile(score);
        }

        //"High Score"
        var highScore = new Font("Helvetica", Font.BOLD, 20);
        var fontMetrics3 = this.getFontMetrics(highScore);
        g.setColor(Color.ORANGE);
        g.setFont(highScore);
        if (score > recentHighScore) {
            g.drawString("Highest score: " + score, (Sizes.BOARD_WIDTH - fontMetrics2.stringWidth(message)) / 2 - 10,
                    Sizes.BOARD_HEIGHT / 2 + 100);
        } else {
            g.drawString("Highest score: " + recentHighScore, (Sizes.BOARD_WIDTH - fontMetrics2.stringWidth(message)) / 2 - 10,
                    Sizes.BOARD_HEIGHT / 2 + 100);
        }
    }

    private void paintScore(Graphics g) {
        var s = new Font("Helvetica", Font.BOLD, 20);
        var fontMetrics = this.getFontMetrics(s);
        g.setColor(Color.white);
        g.setFont(s);
        g.drawString("Score: " + score, 20, 450);
    }

    private void paintHighScore(Graphics g) {
        var best = new Font("Helvetica", Font.BOLD, 20);
        var fontMetrics = this.getFontMetrics(best);
        g.setColor(Color.orange);
        g.setFont(best);
        g.drawString("Best: " + FilesService.readFromFile(), 400, 450);
    }

    /**
     * This class will update the game
     */
    public class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
            bulletService.updateBullets();
            boolean hit = bulletService.collision(invaderService.getInvaders());

            if (hit) {
                score++;
            }

            boolean gameWin = score != 0 && score % Sizes.NUMBER_OF_INVADERS_TO_DESTROY == 0;

            if (gameWin == true) {
                if (newGameCanBeStarted) {
                    int newSpeed = Sizes.INVADER_INITIAL_SPEED + score / Sizes.NUMBER_OF_INVADERS_TO_DESTROY * 2;
                    invaderService = new InvaderService(newSpeed);
                    newGameCanBeStarted = false;
                }
            } else {
                newGameCanBeStarted = true;
            }

        }
    }

    /**
     * This class will control the key codes that are used in the game
     */
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

//    @Override
//    public void mousePressed(MouseEvent e) {
//        int x = e.getX();
//        int y = e.getY();
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//
//    }

}
