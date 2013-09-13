Rubkis Backend
- Jessica Lin, Kevin Yang, Vikram Sreekanti

Our model of the Rubik's cube is as follows:
- Each face contains a 2d array of each block in the face
- The Rubik's cube holds references to all the faces and knows their relationship to each other
	- eg. The front face knows what's to it's top, right, bottom, and left, same for all the other faces
- Steps are composed of choosing a face and then placing the following operations:
	- Rotate the face's block
	- Swap sections of the neighboring faces that are affected


	

Face: Kevin
	- Needs to be able to store the data in the face
	- Able to pull sections of block values (top row, bottomw row, left column, etc.)
	- Rotate the values in the face
	
Cube: Vikram
  
  You choose a face to turn and a number to turn that face by
  It moves the adjacent colors accordingly
  Calls the Face.rotate() method to change the relative orientation of the colors
  Implements all the logic to figure out which colors to move

Parser: Jessica
Takes in a .txt file as an argument and converts each line into a Face object
Combines six Face objects into a Cube object and returns that