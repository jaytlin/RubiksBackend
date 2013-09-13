/**
* Face
* Represents a rubik's cube face as a 3x3 char array
* 
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
		switch(section) {
			case section.TOP:
				return face[0];
			
			case section.HORIZONTAL_MIDDLE:
				return face[1];
		
			case section.BOTTOM:
				return face[2];
		
		
		
		
			case section.LEFT:
				char[] turnface = new char[3];
				for(int i = 0; i < face.length; i++) {
					turnface[i] = face[i][0];
				}
				return turnface;
			
			case section.VERTICAL_MIDDLE:
				char[] turnface = new char[3];
				for(int i = 0; i < face.length; i++) {
					turnface[i] = face[i][1];
				}
				return turnface;
			
			case section.RIGHT:
				char[] turnface = new char[3];
				for(int i = 0; i < face.length; i++) {
					turnface[i] = face[i][2];
				}
				return turnface;
		}
		
		return null;
	}
	
	/**
	* 
	*/
	public void setTurnSection(CubeSection section, char[] section) {
		switch(section) {
			case section.TOP:
				face[0] = section;
				break;
			
			case section.HORIZONTAL_MIDDLE:
				face[1] = section;
				break;
			
			case section.BOTTOM:
				face[2] = section;
				break;
				
				
				
				
			case section.LEFT:
				for(int i=0; i<section.length; i++) {
					face[i][0] = section[i];
				}
				break;
				
			case section.VERTICAL_MIDDLE:
				for(int i=0; i<section.length; i++) {
					face[i][1] = section[i];
				}
				break;
				
			case section.RIGHT:
				for(int i=0; i<section.length; i++) {
					face[i][2] = section[i];
				}
				break;
		}
	}
	
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