
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ShapeMatchingGame extends JPanel {

    private ShapeHolder shapeHolder;
    private long startTime;
    private long bestTime = Long.MAX_VALUE;

    public ShapeMatchingGame() {
        setBackground(Color.WHITE);
        shapeHolder = new ShapeHolder();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (shapeHolder.checkMatch(e.getPoint())) {
                    if (shapeHolder.isMatched()) {
                        long time = System.currentTimeMillis() - startTime;
                        bestTime = Math.min(bestTime, time);
                        String message = String.format("You matched all the shapes in %.2f seconds. Best time: %.2f seconds",
                                time / 1000.0, bestTime / 1000.0);
                        JOptionPane.showMessageDialog(ShapeMatchingGame.this, message, "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
                        shapeHolder = new ShapeHolder();
                    }
                    repaint();
                }
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(480, 480);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        shapeHolder.draw(g);
    }

    public void start() {
        JFrame frame = new JFrame("Shape Matching Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        startTime = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        ShapeMatchingGame game = new ShapeMatchingGame();
        game.start();
    }
}
