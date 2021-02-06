/*
    Nome: Antonio Garcia de Souza Neto
    NUSP: 11846501

    Nome: Juan Kineipe
    NUSP: 11894610 
*/
import java.io.*;

public class Map {
	private Position[][] map;
	private Position startPosition;
	private Position endPosition;
	private int nItems, nLin, nCol;

	public Map(String fileName){

		try{

			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String[] firstLine = in.readLine().split(" ");

			nLin = Integer.parseInt(firstLine[0]);
			nCol = Integer.parseInt(firstLine[1]);

			this.map = new Position[nLin][nCol];

			for(int i = 0; i < nLin; i++){
				char[] columns = in.readLine().toCharArray();
				for(int j = 0; j < nCol; j++){
					this.map[i][j] = new Position(columns[j], i, j);
				}
			}

			nItems = Integer.parseInt(in.readLine());
			String[] item;

			int itemLin;
            int itemCol;
            int itemValue;
            int itemWeight;

			for(int i = 0; i < nItems; i++){
				item = in.readLine().split(" ");
				itemLin = Integer.parseInt(item[0]);
                itemCol = Integer.parseInt(item[1]);

                itemValue = Integer.parseInt(item[2]);
				itemWeight = Integer.parseInt(item[3]);
				
				Position position = this.map[itemLin][itemCol];
				position.setItem(itemValue, itemWeight);
			}

			String[] startPosition = in.readLine().split(" ");
			this.startPosition = this.map[Integer.parseInt(startPosition[0])] [Integer.parseInt(startPosition[1])];
			String[] endPosition = in.readLine().split(" ");
			this.endPosition = this.map[Integer.parseInt(endPosition[0])] [Integer.parseInt(endPosition[1])];
		}
		catch(IOException e){

			System.out.println("Error loading map... :(");
			e.printStackTrace();
		}
	}

	public Position getPosition(int lin, int col) {
		return map[lin][col];
	}

	public int getMaxLines(){
		return this.map.length-1; 
	}

	public int getMaxColumns(){
		return this.map[0].length-1; 
	}

	public Position getStart(){
		return this.startPosition;
	}

	public Position getEnd(){
		return this.endPosition;
	}
}
