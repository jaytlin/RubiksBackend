import java.io.*;
import java.util.Scanner;

public class ParseRubiks {

	public static final String FILEPATH = '/Users/christopherli/Documents/Rubiks/rubiks.txt'
	public static final int ROW_RESET = 2;
	public static final int SIZE = 3;

	import 

	File textfile = new File(FILEPATH);
	Scanner input = new Scanner(textfile);

	while (input.hasNext()) {
		String nextLine = input.nextLine();
		String[] blocks = nextLine.split(", ")
		int[][] face = new int[SIZE][SIZE];
		int row = 0;
		int col = 0;
		for (i = 0; i < blocks.length; i++) {
			face[row][col] = Integer.parseInt(blocks[i]);
			col = (col+1)%SIZE;
			if (i%SIZE == ROW_RESET) {
				row++;
			}
		}
}

input.close;