import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Shape {

    private int width;
    private int height;

    public Oval(int x, int y, int width, int height, Color color) {
        super(x, y, width, color);
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), width, height);
    }

    public int getHeight() {
        return height;
    }
}
