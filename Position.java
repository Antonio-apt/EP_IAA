/*
    Nome: Antonio Garcia de Souza Neto
    NUSP: 11846501

    Nome: Juan Kineipe
    NUSP: 11894610 
*/
public class Position {
    private int lin;
    private int col;
    private boolean isBlocked;
    private boolean isVisited;
    private Item item;

    private double timeToFinish;

    public Position(char c, int lin, int col) {
        this.lin = lin;
        this.col = col;

        this.isBlocked = c == 'X' ? true : false;
        this.isVisited = false;
        this.item = null;
        this.timeToFinish = 0;
    }

    public int getLine() {
        return this.lin;
    }

    public int getColumn() {
        return this.col;
    }

    public boolean getPositionStatus() {
        return this.isBlocked;
    }

    public Item getItem() {
        return hasItem() ? item : null;
    }

    public double getTimeToFinish() {
        return this.timeToFinish;
    }

    public boolean getIsVisited() {
        return this.isVisited;
    }

    public boolean hasItem() {
        return item != null;
    }

    public void setItem(int value, int weight) {
        item = new Item(getLine(), getColumn(), value, weight);
    }

    public void setTimeToFinish(double time) {
        this.timeToFinish = time;
    }   

    public void setIsVisisted(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public void printPosition() {
        System.out.println(getLine()+" "+getColumn());
    }
}
