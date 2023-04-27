import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Shape {

    private int width;

    public Oval(int x, int y, int width, int height, Color color) {
        super(x, y, height, color);
        this.width = width;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), width, getSize());
    }
}
