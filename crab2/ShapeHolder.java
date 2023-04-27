package crab2;
public class ShapeHolder {
    private List<Shape> shapes;

    public ShapeHolder() {
        shapes = new ArrayList<Shape>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public Shape getShape(int index) {
        return shapes.get(index);
    }

    public int getSize() {
        return shapes.size();
    }
}
