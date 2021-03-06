package rubiksbackend;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class ParseRubiks {

	public static final int ROW_RESET = 2;
	public static final int SIZE = 3;
	public static final int TOTAL_FACES = 6;

/*	public static final int TOP = 0
	public static final int LEFT = 1
	public static final int FRONT = 2
	public static final int RIGHT = 3
	public static final int BACK = 4
	public static final int BOTTOM = 5*/

	public static Cube main(String[] argv) {
		ParseRubiks parser = new ParseRubiks(argv[0]);
		Cube output = parser.lineByLine();
		emit("Rubiks text parsed into Cube.");
	}

	public ParseRubiks(String filepath) {
		File textfile = new File(filepath);
	}

	/*	Parses text file line by line, creating a Face object for each line. 
		Returns Rubiks as a Cube object. */
	public final Cube lineByLine() {
		Scanner input = new Scanner(new FileReader(textfile));
		Face[] faces = new Face[6];
		int whichFace = 0;
		try {
			while (input.hasNextLine()) {
				faces[whichFace] = processLine(input.nextLine());
				whichFace++;
				emit("Faces parsed: " + whichFace+1 + "out of " + TOTAL_FACES);
			}
		} finally {
			input.close();
		}
		Cube outputCube = new Cube();
		for (int i = 0; i < TOTAL_FACES; i++) {
			outputCube[i] = faces[i];
		}
		return outputCube;
	}

	/*  Processes each line into a 2D array which then is taken in as param for Face object.
		Parameter is a String.
		Returns line as a Face object. */
	protected Face processLine(String line) {
		String[] blocks = line.split(",");
		int[][] faceArray = new int[SIZE][SIZE];
		int row = 0;
		int col = 0;
		for (int i = 0; i < blocks.length; i++) {
			faceArray[row][col] = Integer.parseInt(blocks[i]);
			col = (col+1)%SIZE;
			if (i%SIZE == ROW_RESET) {
				row++;
			}
		}
		System.out.println(Arrays.toString(faceArray));
		Face outputFace = new Face(faceArray);
		return outputFace;
	}

	/* Emits a string to command line. */
	private static void emit(Object aObject) {
		System.out.println(String.valueOf(aObject));
	}
		
}