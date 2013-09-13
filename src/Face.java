/**
* Face
* Represents a rubik's cube face as a 3x3 char array
*/

public class Face {
	// Face is internally represented as a 3x3 char matrix
	private char[][] face;
	
	/**
	* Creates a Face object given a 3x3 char matrix
	*/
	public Face(final char[][] face) {
		this.face = face;
	}
	
	/**
	* Returns a 3x3 char matrix of the face
	*/
	public char[][] getFace() {
		return face;
	}
	
	/**
	* Sets the face, given in a 3x3 char matrix
	*/
	public void setFace(final char[][] face) {
		this.face = face;
	}
	
	/**
	* Returns a 3-length char array for that secion of the cube
	*/
	public char[] getTurnSection(CubeSection section) {
		char[] turnface = new char[3];
		switch(section) {
			case TOP:
				return face[0];
			
			case HORIZONTAL_MIDDLE:
				return face[1];
		
			case BOTTOM:
				return face[2];
		
		
		
		
			case LEFT:
				for(int i = 0; i < face.length; i++) {
					turnface[i] = face[i][0];
				}
				return turnface;
			
			case VERTICAL_MIDDLE:
				for(int i = 0; i < face.length; i++) {
					turnface[i] = face[i][1];
				}
				return turnface;
			
			case RIGHT:
				for(int i = 0; i < face.length; i++) {
					turnface[i] = face[i][2];
				}
				return turnface;
		}
		
		return null;
	}
	
	/**
	* Makes changes to the turn section given which section of the face, and the values to update it with
	*/
	public void setTurnSection(CubeSection section, char[] sectionValues) {
		switch(section) {
			case TOP:
				face[0] = sectionValues;
				break;
			
			case HORIZONTAL_MIDDLE:
				face[1] = sectionValues;
				break;
			
			case BOTTOM:
				face[2] = sectionValues;
				break;
				
				
				
				
			case LEFT:
				for(int i=0; i<sectionValues.length; i++) {
					face[i][0] = sectionValues[i];
				}
				break;
				
			case VERTICAL_MIDDLE:
				for(int i=0; i<sectionValues.length; i++) {
					face[i][1] = sectionValues[i];
				}
				break;
				
			case RIGHT:
				for(int i=0; i<sectionValues.length; i++) {
					face[i][2] = sectionValues[i];
				}
				break;
		}
	}
	
	/**
	* Performs a point-wise rotation around the middle block. It will only rotate to the right, however achieving a rotate to the left
	* can be achieved by same rotation to the right
	*/
	public void rotate(int turns) {
		// This is rotating to the right
		turns = turns % 4;
		
		char[][] newFace = new char[3][3];
		newFace[1][1] = face[1][1];
		for(int i=0; i<turns; i++) {
			for(int j=0; j<newFace.length-1; j++) {
				newFace[j]    [2]     = face[0]    [j]; // top -> right
				newFace[2]    [2 - j] = face[j]    [2]; // right -> bottom
				newFace[2 - j][0]     = face[2]    [2 - j]; // bottom -> left
				newFace[0]    [j]     = face[2 - j]    [0]; // left -> top
			}
		}
		
		face = newFace;
	}
	
	/**
	* Gives the string representation of the Face given as:
	*
	* abc\n
	* def\n
	* ghi\n
	*
	* where a,b,c,d,e,f,g,h,i are all different blocks
	*/
	public String toString() {
		String string = "";
	
		for(int i=0; i<face.length; i++) {
			for(int j=0; j<face.length; j++) {
				string += face[i][j];
			}
			
			string += "\n";
		}
		
		return string;
	}
}