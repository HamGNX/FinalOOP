package crab2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GameBoard extends JPanel {
    
    private final int width;
    private final int height;
    private final Color backgroundColor;
    
    public GameBoard(int width, int height, Color backgroundColor) {
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        setPreferredSize(new Dimension(width, height));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background color
        g.setColor(backgroundColor);
        g.fillRect(0, 0, width, height);
    }
    
}
