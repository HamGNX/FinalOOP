package ListShapes;
import java.awt.Color;
import java.awt.Graphics;

import Game.Shape;

public class Rectangle extends Shape {
    private int width;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, height, color);
        this.width = width;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), width, getSize());
    }

    @Override
    public int getSize() {
        return width;
    }
}