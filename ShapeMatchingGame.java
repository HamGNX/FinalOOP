import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShapeMatchingGame extends JPanel {

    private ShapeHolder shapeHolder;
    private long startTime;
    private long bestTime = Long.MAX_VALUE;

    private Shape[] leftShapes = {
        new Circle(80, 100, 50, Color.RED),
        new Oval(80, 200, 100, 50, Color.ORANGE),
        new Square(80, 300, 50, Color.GREEN),
        new Rectangle(80, 400, 100, 50, Color.YELLOW),
        new Triangle(80, 500, 50, Color.BLUE)
    };

    private JButton startButton;
    private JLabel timerLabel;
    private Timer timer;
    private AtomicBoolean timerRunning;

    public ShapeMatchingGame() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        shapeHolder = new ShapeHolder();
        timerRunning = new AtomicBoolean(false);

        startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            if (!timerRunning.get()) {
                startTime = System.currentTimeMillis();
                timerRunning.set(true);
                timer.start();
            }
        });

        timerLabel = new JLabel("0.00 seconds");
        timer = new Timer(100, e -> {
            long currentTime = System.currentTimeMillis();
            double elapsedTime = (currentTime - startTime) / 1000.0;
            timerLabel.setText(String.format("%.2f seconds", elapsedTime));
        });

        JPanel topPanel = new JPanel();
        topPanel.add(startButton);
        topPanel.add(timerLabel);

        add(topPanel, BorderLayout.NORTH);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (shapeHolder.checkMatch(e.getPoint())) {
                    if (shapeHolder.isMatched()) {
                        timer.stop();
                        timerRunning.set(false);
                        long time = System.currentTimeMillis() - startTime;
                        bestTime = Math.min(bestTime, time);
                        String message = String.format("You matched all the shapes in %.2f seconds. Best time: %.2f seconds",
                                time / 1000.0, bestTime / 1000.0);
                        JOptionPane.showMessageDialog(ShapeMatchingGame.this, message, "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
                        shapeHolder.reset();
                    }
                    repaint();
                }
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        shapeHolder.draw(g);
        // Draw the shapes on the left side
        for (Shape shape : leftShapes) {
            shape.draw(g);
        }
    }

    public void start() {
        JFrame frame = new JFrame("Shape Matching Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ShapeMatchingGame game = new ShapeMatchingGame();
        game.start();
    }
}
