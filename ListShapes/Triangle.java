package ListShapes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import Game.Shape;

public class Triangle extends Shape {

    public Triangle(int x, int y, int size, Color color) {
        super(x, y, size, color);
    }

    @Override
    public void draw(Graphics g) {
        int[] xPoints = {getX(), getX() + getSize(), getX() + getSize() / 2};
        int[] yPoints = {getY() + getSize(), getY() + getSize(), getY()};
        Polygon triangle = new Polygon(xPoints, yPoints, 3);
        g.setColor(getColor());
        g.fillPolygon(triangle);
    }
}
