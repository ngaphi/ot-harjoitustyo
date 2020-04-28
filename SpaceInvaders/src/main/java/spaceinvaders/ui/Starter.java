package spaceinvaders.ui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import spaceinvaders.controller.Board;
import spaceinvaders.data.Sizes;

public final class Starter extends JFrame {
    
      public Starter() {
        UI();
    }
    
    public void UI() {
        add(new Board());
        setTitle("Space Invaders");
        setSize(Sizes.BOARD_WIDTH, Sizes.BOARD_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

            var ex = new Starter();
            ex.setVisible(true);
        });
    }
}
