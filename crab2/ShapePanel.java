package crab2;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShapePanel extends JPanel {
    private ArrayList<ShapeHolder> shapeHolders;
    
    public ShapePanel(ArrayList<ShapeHolder> shapeHolders) {
        this.shapeHolders = shapeHolders;
        setPreferredSize(new Dimension(500, 500));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ShapeHolder sh : shapeHolders) {
            sh.draw(g);
        }
    }
}
