import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The StartMenu class displays the game's main menu with instructions and navigation buttons.
 * It allows players to start the game or exit the application.
 */
public class StartMenu extends JPanel {
    private JFrame f;
    private JLabel title;
    private JLabel objectiveTitle;
    private JLabel objective1;
    private JLabel objective2;
    private JLabel objective3;
    private JLabel objective4;
    private JLabel objective5;
    private JLabel objective6;
    private JButton start;
    private JButton exit;

    /**
     * Constructs the start menu interface with game title, rules, and action buttons.
     * Initializes all UI components and sets up event listeners for navigation.
     */
    public StartMenu() {

        setLayout(null);
        setPreferredSize(new Dimension(1000, 600));
        setBackground(Color.BLACK);
        title = new JLabel("ShapeRush");
        title.setBounds(410, 20, 320, 50);
        title.setForeground(new Color(0x00FFFF));
        title.setFont(new Font("Open Sans", Font.BOLD, 28));
        objectiveTitle = new JLabel(" Rules/Objective Of The Game: ");
        objectiveTitle.setBounds(130, 100, 900, 50);
        objectiveTitle.setFont(new Font("Open Sans", Font.BOLD, 22));
        objectiveTitle.setForeground(new Color(0xFFFFFF));
        objective1 = new JLabel(
                "Click the shapes as fast as you can! Score as many points as possible in 30 seconds");
        objective1.setBounds(135, 150, 900, 30);
        objective1.setFont(new Font("Open Sans", Font.ITALIC, 20));
        objective1.setForeground(new Color(0xFFFFFF));
        objective2 = new JLabel(
                "How to Play:");
        objective2.setBounds(135, 200, 900, 30);
        objective2.setFont(new Font("Open Sans", Font.BOLD, 20));
        objective2.setForeground(new Color(0xFFFFFF));
        objective3 = new JLabel(
                "1. Click on the shapes as the appear on the screen");
        objective3.setBounds(135, 230, 900, 30);
        objective3.setFont(new Font("Open Sans", Font.ITALIC, 20));
        objective3.setForeground(new Color(0xFFFFFF));
        objective4 = new JLabel(
                "2. Each shape you click earns you a point");
        objective4.setBounds(135, 260, 900, 30);
        objective4.setFont(new Font("Open Sans", Font.ITALIC, 20));
        objective4.setForeground(new Color(0xFFFFFF));
        objective5 = new JLabel(
                "3. Be quick! The shapes will disappear after a short time");
        objective5.setBounds(135, 290, 900, 30);
        objective5.setFont(new Font("Open Sans", Font.ITALIC, 20));
        objective5.setForeground(new Color(0xFFFFFF));
        objective6 = new JLabel(
                "4. The game ends when the timer runs out");
        objective6.setBounds(135, 320, 900, 30);
        objective6.setFont(new Font("Open Sans", Font.ITALIC, 20));
        objective6.setForeground(new Color(0xFFFFFF));
        
        start = new JButton("Start Game");
        start.setBounds(340, 400, 300, 40);
        start.setFont(new Font("Open Sans", Font.BOLD, 18));
        start.setBackground(new Color(0x51f90e));
        start.setForeground(new Color(0xFFFFFF));
        exit = new JButton("Exit");
        exit.setBounds(340, 450, 300, 40);
        exit.setFont(new Font("Open Sans", Font.BOLD, 18));
        exit.setBackground(new Color(0xFF0000));
        exit.setForeground(new Color(0xFFFFFF));

        start.addActionListener(new ActionListener() {

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
        

        add(title);
        add(start);
        add(exit);
        add(objectiveTitle);
        add(objective1);
        add(objective2);
        add(objective3);
        add(objective4);
        add(objective5);
        add(objective6);

        
        f = new JFrame();
        f.add(this);
        f.setSize(1000, 600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
