/*
    Nome: Antonio Garcia de Souza Neto
    NUSP: 11846501

    Nome: Juan Kineipe
    NUSP: 11894610 
*/
import java.io.*;

public class EP2 {

	public static void main(String [] args) throws IOException {
		
		if(args.length < 2) {
			System.out.println("Use: java EP2 <map definition file> <criteria>");
			return;
		} else {
			Criteria criteria = new Criteria(Integer.parseInt(args[1]));
			new FindPath(args[0], criteria);
			criteria.printSolution();
		}
		
	}
}