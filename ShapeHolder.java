import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeHolder {
    private List<Shape> shapes;
    private int shapeIndex;
    private boolean matched;

    public ShapeHolder() {
        shapes = new ArrayList<>();
        shapes.add(new Oval(480, 100, 100, 50, Color.BLACK));
        shapes.add(new Square(480, 200, 50, Color.BLACK));
        shapes.add(new Rectangle(480, 300, 100, 50, Color.BLACK));
        shapes.add(new Triangle(480, 400, 50, Color.BLACK));
        shapes.add(new Circle(480, 500, 50, Color.BLACK));

        shapeIndex = 0;
        matched = false;
    }

    public void draw(Graphics g) {
        if (matched) {
            return;
        }
        getCurrentShape().draw(g);
    }

    public boolean checkMatch(Point point) {
        if (matched) {
            return false;
        }
        Shape currentShape = getCurrentShape();
        if (currentShape.getX() <= point.getX() && point.getX() <= currentShape.getX() + currentShape.getSize()
                && currentShape.getY() <= point.getY() && point.getY() <= currentShape.getY() + currentShape.getSize()) {
            shapeIndex++;
            if (shapeIndex >= shapes.size()) {
                matched = true;
            }
            return true;
        }
        return false;
    }

    private Shape getCurrentShape() {
        return shapes.get(shapeIndex);
    }

    public boolean isMatched() {
        return matched;
    }

    public void reset() {
        shapeIndex = 0;
        matched = false;
    }
}
