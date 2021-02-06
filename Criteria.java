/*
    Nome: Antonio Garcia de Souza Neto
    NUSP: 11846501

    Nome: Juan Kineipe
    NUSP: 11894610 
*/
import java.util.*;
import java.text.DecimalFormat;

public class Criteria {
    LinkedList<Position> usedPositions;
    LinkedList<Item> item;
    double time;
    int itemsValue;
    int itemsWeight;
    int criteria;

    public Criteria (int criteria) {
        this.usedPositions = null;
        this.time = this.itemsValue = this.itemsWeight = 0;
        this.criteria = criteria;
    }

    public void setBestPathValue(LinkedList<Position> usedPositions, LinkedList<Item> item, double time, int itemsValue, int itemsWeight) {
        this.usedPositions = new LinkedList<Position>(usedPositions);
        this.item = new LinkedList<Item>(item);
        this.time = time;
        this.itemsValue = itemsValue;
        this.itemsWeight = itemsWeight;
    }

    public void setBestPath(LinkedList<Position> usedPositions, LinkedList<Item> item, double time, int itemsValue, int itemsWeight) {
        switch(this.criteria) {
            case 1:
                if(this.usedPositions == null || usedPositions.size() < this.usedPositions.size())
                    setBestPathValue(usedPositions, item, time, itemsValue, itemsWeight);
                break;
            case 2:
                if(this.usedPositions == null || this.usedPositions.size() != usedPositions.size() )
                    setBestPathValue(usedPositions, item, time, itemsValue, itemsWeight);
                break;
            case 3: 
                if(this.itemsValue == 0 || this.itemsValue < itemsValue) 
                    setBestPathValue(usedPositions, item, time, itemsValue, itemsWeight);
                break;
            case 4:
                if(this.time == 0 || this.time > time) 
                    setBestPathValue(usedPositions, item, time, itemsValue, itemsWeight);
                break;
            default:
                throw new IllegalArgumentException("Invalid criteria");
        }
    }

    public void printSolution() {
        DecimalFormat fomatedTime = new DecimalFormat("0.##"); 

        System.out.print(this.usedPositions.size()+" "+fomatedTime.format(time).replace(",", ".")+"\n");
        for(Position position : usedPositions) {
            position.printPosition();
        }
        System.out.println(this.item.size()+" "+this.itemsValue+" "+this.itemsWeight);
        for(Item item : item) {
            item.printPosition();
        }
    }

}
