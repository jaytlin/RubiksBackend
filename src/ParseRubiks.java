package src;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class ParseRubiks {

	public static final int ROW_RESET = 2;
	public static final int SIZE = 3;
	public static final int TOTAL_FACES = 6;

	public static final int TOP = 0;
	public static final int LEFT = 1;
	public static final int FRONT = 2;
	public static final int RIGHT = 3;
	public static final int BACK = 4;
	public static final int BOTTOM = 5;

  private File textfile;

	public static void main(String[] argv) throws FileNotFoundException {
		ParseRubiks parser = new ParseRubiks(argv[0]);
		Cube output = parser.lineByLine();
		emit("Rubiks text parsed into Cube.");
		emit(output);
	}

	public ParseRubiks(String filepath) {
		File textfile = new File(filepath);
	}

	/*	Parses text file line by line, creating a Face object for each line. 
		Returns Rubiks as a Cube object. */
	public final Cube lineByLine() throws FileNotFoundException {
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
		Cube outputCube = new Cube(faces[TOP],faces[LEFT],faces[FRONT],faces[RIGHT],faces[BACK],faces[BOTTOM]);
		return outputCube;
	}

	/*  Processes each line into a 2D array which then is taken in as param for Face object.
		Parameter is a String.
		Returns line as a Face object. */
	protected Face processLine(String line) {
		char[] tempblocks = line.toCharArray();
    char[] blocks = new char[line.split(",").length];
    int counter = 0;
    for(char block : tempblocks) {
      if(block != ',') {
        blocks[counter] = block;
        counter++;
      }
    }

		char[][] faceArray = new char[SIZE][SIZE];
		int row = 0;
		int col = 0;
		for (int i = 0; i < blocks.length; i++) {
			faceArray[row][col] = blocks[i];
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
