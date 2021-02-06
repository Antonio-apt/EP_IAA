/*
    Nome: Antonio Garcia de Souza Neto
    NUSP: 11846501

    Nome: Juan Kineipe
    NUSP: 11894610 
*/
public class Item {
    private int lin, col, value, weight;
	public Item(int lin, int col, int value, int weight){

		this.lin = lin;
		this.col = col;
		this.value = value;
		this.weight = weight;
	}

	public int getLin(){

		return lin;
	}

	public int getCol(){

		return col;
	}

	public int getValue(){

		return value;
	}

	public int getWeight(){

		return weight;
	}

	public void printPosition() {
        System.out.println(lin+" "+col);
    }
}
