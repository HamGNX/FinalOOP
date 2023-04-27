import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

    public Circle(int x, int y, int size, Color color) {
        super(x, y, size, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getSize(), getSize());
    }
}
