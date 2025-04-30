import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * The GameScreen class handles the main gameplay logic including shape rendering,
 * click detection, score tracking, and countdown timer.
 */
public class GameScreen extends JPanel {
    private JFrame f;
    private JLabel scoreLabel;
    private JLabel timeLabel;
    private Random random;
    private int currentShape;
    private int currentX;
    private int currentY;
    private int currentWidth;
    private int currentHeight;
    private boolean shapeVisible;
    private Timer shapeTimer;
    private Timer countDownTimer;
    private int timeLeft;
    private static int score;
    
    /**
     * Initializes the game screen with score display, timer, and sets up the game loop.
     * Creates random shapes and handles player click events.
     */
    public GameScreen() {
        random = new Random();
        setLayout(null);
        setPreferredSize(new Dimension(1000, 750));
        setBackground(Color.BLACK);
        score = 0;
        timeLeft = 30;

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setBounds(20, 20, 200, 40);
        scoreLabel.setFont(new Font("Open Sans", Font.BOLD, 20));
        scoreLabel.setForeground(new Color(0xFFFFFF));

        timeLabel = new JLabel("Time Left: " + timeLeft + "s");
        timeLabel.setBounds(20, 60, 200, 40);
        timeLabel.setFont(new Font("Open Sans", Font.BOLD, 20));
        timeLabel.setForeground(new Color(0xFFFFFF));

        shapeTimer = new javax.swing.Timer(750, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!shapeVisible) {
                    currentShape = random.nextInt(2);
                    currentWidth = generateRandomSize();
                    currentHeight = generateRandomSize();
                    currentX = generateRandomX();
                    currentY = generateRandomY();
                }
                shapeVisible = !shapeVisible;
                repaint();
            }

        });

        countDownTimer = new javax.swing.Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timeLabel.setText("Time Left: " + timeLeft + "s");

                if (timeLeft <= 0) {
                    countDownTimer.stop();
                    f.dispose();
                    new StopGame();
                }
            }

        });

        shapeTimer.start();
        countDownTimer.start();

        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (timeLeft > 0 && shapeVisible && clickOnShape(e.getX(), e.getY())) {
                    score++;
                    updateScore();
                    shapeVisible = false;
                    repaint();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
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

        });

        add(scoreLabel);
        add(timeLabel);

        f = new JFrame();
        f.add(this);
        f.setSize(1000, 750);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    /**
     * Renders the game graphics including the current shape when visible.
     * The Graphics object used for rendering
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (shapeVisible) {
            g.setColor(generateRandomColor());
            if (currentShape == 0) {
                g.fillRect(currentX, currentY, currentWidth, currentHeight);
            } else if (currentShape == 1) {
                g.fillOval(currentX, currentY, currentWidth, currentWidth);
            }
        }
    }
    
    /**
     * Checks if a click occurred within the bounds of the current shape.
     * clickX The x-coordinate of the click
     * clickY The y-coordinate of the click
     * Returns true if the click hit the shape, false otherwise
     */
    private boolean clickOnShape(int clickX, int clickY) {
        if (!shapeVisible)
            return false;

        // Shape boundaries
        int left = currentX;
        int right = currentX + currentWidth;
        int top = currentY;
        int bottom = currentY + currentHeight;

        if (clickX < left || clickX > right || clickY < top || clickY > bottom) {
            return false;
        }

        if (currentShape == 1) { // Circle
            int radius = currentWidth / 2;
            int centerX = currentX + radius;
            int centerY = currentY + radius;
            int dx = clickX - centerX;
            int dy = clickY - centerY;
            return (dx * dx + dy * dy) <= (radius * radius);
        } else { // Rectangle (currentShape == 0)
            return true;
        }
    }

     /**
     * Updates the score display on the screen.
     */
     private void updateScore() {
         scoreLabel.setText("Score: " + score);
     }

    
     public static int getScore() {
         return score;
     }
    
    /**
     * Generates a random color for shapes.
     * Returns a random Color object
     */
    private Color generateRandomColor() {
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    /**
     * Generates a random size for shapes.
     * Returns a random size between 20 and 75 pixels
     */
    private int generateRandomSize() {
        return random.nextInt(75 - 20) + 20;
    }

    /**
     * Generates a random x-coordinate within game bounds.
     * Returns a random x-position between 100 and 900 pixels (within JPanel x-size)
     */
    private int generateRandomX() {
        return random.nextInt(900 - 100) + 100;
    }

    /**
     * Generates a random y-coordinate within game bounds.
     * Returns a random y-position between 100 and 650 pixels (within JPanel y-size)
     */
    private int generateRandomY() {
        return random.nextInt(650 - 100) + 100;
    }  
}