import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeHolder {
    private List<Shape> shapes;
    private int shapeIndex;
    private boolean matched;

    public ShapeHolder() {
        shapes = new ArrayList<>();
        shapes.add(new Circle(80, 200, 50, Color.RED));
        shapes.add(new Triangle(200, 200, 50, Color.BLUE));
        shapes.add(new Square(320, 200, 50, Color.GREEN));
        shapes.add(new Rectangle(80, 320, 100, 50, Color.YELLOW));
        shapes.add(new Oval(260, 320, 100, 50, Color.ORANGE));
        shapeIndex = 0;
        matched = false;
        shuffleShapes();
        }public void draw(Graphics g) {
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
                } else {
                    shuffleShapes();
                }
                return true;
            }
            return false;
        }
        
        private void shuffleShapes() {
            Collections.shuffle(shapes);
            while (getCurrentShape().equals(shapes.get(0))) {
                Collections.shuffle(shapes);
            }
        }
        
        private Shape getCurrentShape() {
            return shapes.get(shapeIndex);
        }
        
        public boolean isMatched() {
            return matched;
        }
    }