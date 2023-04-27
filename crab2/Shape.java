package crab2;
public abstract class Shape {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color color;

    public Shape(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public abstract boolean contains(int x, int y);

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(this.getShape());
        g2.setColor(Color.BLACK);
        g2.draw(this.getShape());
    }

    public Shape copy() {
        return this;
    }

    protected abstract Shape getShape();
}
