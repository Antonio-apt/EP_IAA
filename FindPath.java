/*
    Nome: Antonio Garcia de Souza Neto
    NUSP: 11846501

    Nome: Juan Kineipe
    NUSP: 11894610 
*/
import java.util.*;

public class FindPath {
    private LinkedList<Item> items;
    private LinkedList<Position> usedPositions;
    private Criteria criteria;
    private Map map;

    private double elapsedTime;
    private int itemsWeight;
    private int itemsValue;

    public FindPath(String map, Criteria criteria) {
        this.items = new LinkedList<Item>();
        this.usedPositions = new LinkedList<Position>();
        this.criteria = criteria;
        this.map = new Map(map);
        
        this.elapsedTime = this.itemsWeight = this.itemsValue = 0;

        Position startPosition = this.map.getStart();
        if(startPosition != null) {
            nextStep(startPosition.getLine(), startPosition.getColumn());
        } else {
            throw new IllegalArgumentException("The map was not found or is invalid. Check the file and try again");
        }
    }

    public double timeToFinish() {
        return Math.pow((1.0 +  (itemsWeight / 10.0)), 2);
    }

    public int getItemsWeight() {
        return this.itemsWeight;
    }

    public double getElapsedTime() {
        return this.elapsedTime;
    }

    public int getItemsValue() {
        return this.itemsValue;
    }

    public void nextStep(int lin, int col) {
        if(lin > this.map.getMaxLines()   || 
           col > this.map.getMaxColumns() ||
           col < 0                        ||
           lin < 0
        ) return;

        Position position = map.getPosition(lin, col);
        if(position.getPositionStatus() || position.getIsVisited()) return;

        if(position != this.map.getStart()) {
            position.setTimeToFinish(this.timeToFinish());
            this.elapsedTime += timeToFinish();
        }

        usedPositions.add(position);
        position.setIsVisisted(true);

        if(position.hasItem()) {
            Item item = position.getItem();
            this.itemsWeight += item.getWeight();
            this.itemsValue += item.getValue();
            this.items.add(item);
        }

        boolean ehDestino = this.map.getEnd() == position ? true : false;
        
        if(ehDestino) {
            criteria.setBestPath(usedPositions, items, getElapsedTime(), getItemsValue(), getItemsWeight());
        } else {
            nextStep(lin-1, col);
            nextStep(lin, col+1);
            nextStep(lin+1, col);
            nextStep(lin, col-1);
        }
        leavePosition(position);
    }

    public void leavePosition(Position position) {
        if(position.hasItem()) {
            Item item = position.getItem();
            this.itemsValue -= item.getValue();
            this.itemsWeight -= item.getWeight();
            this.items.remove(item);
        }
        position.setIsVisisted(false);
        this.elapsedTime -= position.getTimeToFinish();
        this.usedPositions.remove(position);
    }
}
