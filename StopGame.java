import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The StopGame class displays the game over screen with final score
 * and options to play again or exit
 */
public class StopGame extends JPanel {
    private JFrame f;
    private JLabel timeUp;
    private JLabel score;
    private JButton tryAgain;
    private JButton exit;
    
    /**
     * Constructs the game over screen with score summary and navigation buttons
     * Provides options to restart the game or exit the window
     */
    public StopGame() {

        setLayout(null);
        setPreferredSize(new Dimension(500, 250));
        setBackground(Color.BLACK);

        timeUp = new JLabel("Time's Up!");
        timeUp.setBounds(180, 20, 150, 50);
        timeUp.setFont(new Font("Open Sans", Font.BOLD, 22));
        timeUp.setForeground(new Color(0xFFFFFF));

        score = new JLabel("Your Score is: " + GameScreen.getScore());
        score.setBounds(160, 60, 200, 50);
        score.setFont(new Font("Open Sans", Font.BOLD, 20));
        score.setForeground(new Color(0xFFFFFF));

        tryAgain = new JButton("Try Again");
        tryAgain.setBounds(115, 110, 250, 40);
        tryAgain.setFont(new Font("Open Sans", Font.BOLD, 18));
        tryAgain.setBackground(new Color(0xB200FF));
        tryAgain.setForeground(new Color(0xFFFFFF));

        exit = new JButton("Exit");
        exit.setBounds(115, 160, 250, 40);
        exit.setFont(new Font("Open Sans", Font.BOLD, 18));
        exit.setBackground(new Color(0xFF0000));
        exit.setForeground(new Color(0xFFFFFF));

        tryAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new GameScreen();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        add(timeUp);
        add(score);
        add(tryAgain);
        add(exit);

        f = new JFrame();
        f.add(this);
        f.setSize(500, 300);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
