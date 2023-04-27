package crab2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameLogic {
    
    private List<Shape> shapesList;
    private ShapeHolder shapeHolder;
    private boolean isRunning;
    private long startTime;
    private long endTime;
    
    public GameLogic() {
        shapesList = new ArrayList<Shape>();
        shapesList.add(new Circle(0, 0));
        shapesList.add(new Triangle(0, 0));
        shapesList.add(new Square(0, 0));
        shapesList.add(new Rectangle(0, 0));
        shapesList.add(new Oval(0, 0));
        
        shapeHolder = new ShapeHolder(200, 200);
        isRunning = false;
    }
    
    public void startGame() {
        shuffleShapes();
        shapeHolder.removeAllShapes();
        shapeHolder.addShapes(shapesList);
        startTime = System.currentTimeMillis();
        isRunning = true;
    }
    
    public boolean isRunning() {
        return isRunning;
    }
    
    public long getElapsedTime() {
        if (isRunning) {
            return System.currentTimeMillis() - startTime;
        } else {
            return endTime - startTime;
        }
    }
    
    public boolean checkMatch(List<Shape> selectedShapes) {
        if (selectedShapes.size() != shapesList.size()) {
            return false;
        }
        
        List<Shape> sortedShapesList = new ArrayList<Shape>(shapesList);
        Collections.sort(sortedShapesList);
        
        List<Shape> sortedSelectedShapes = new ArrayList<Shape>(selectedShapes);
        Collections.sort(sortedSelectedShapes);
        
        for (int i = 0; i < sortedShapesList.size(); i++) {
            if (!sortedShapesList.get(i).equals(sortedSelectedShapes.get(i))) {
                return false;
            }
        }
        
        endTime = System.currentTimeMillis();
        isRunning = false;
        return true;
    }
    
    private void shuffleShapes() {
        Collections.shuffle(shapesList);
    }
}
