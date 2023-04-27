import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape {

    public Square(int x, int y, int size, Color color) {
        super(x, y, size, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getSize(), getSize());
    }
}
