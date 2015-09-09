#MARS ROVER CHALLENGE

An application that takes a rectangular landscape and initial position and direction of a rover and return the final position and direction.



##DESIGN AND ASSUMPTIONS

This application follows object-oriented design principles and utilizes many single responsibility methods and classes. The classes include:

- a Rotate class to hold a string array method that rotates the array by X number of elements/indeces. (Created this class for future separation of concerns in regards to the rotate method.)

- a Terrain class so different landscapes can be created and store information about their max coordinates (x and y)* for the rectangular landscape. After implementing stretch goals, it will also store information about where obstacles are located on it.

- a Rover class which stores information about each rover object and the methods associated with controlling it and moving it's location on the current terrain.

- a Mars Rover class that runs the application by pulling in data from a text file. It creates instances of the terrain and rovers and calls the methods to be executed (based on the input file).


*Note: I chose to just have X and Y fields instead of a nested array to simulate the grid system. I did this to make it simpler to navigate the landscape (up/down/left/right), to use less space/memory, and to avoid having to traverse a 2D array to check if a position is filled or move to that position, etc.



##HOW TO RUN THE APPLICATION:

1. Compile the java files by running
``` javac MarsRover.java ```

2. Run the MarsRover file
``` java MarsRover input.txt ```

*Note: MarsRover gets its input data from the 'input.txt' file. The file can be changed by replacing 'input.txt' with another file path.



##RUNNING JUNIT TESTS:

To run JUnit tests against individual files (aka classes), first compile each java file.
``` javac Terrain.java && javac Rover.java && javac Rotate.java ```

Then run the commands below to compile the test file and run the tests replacing 'NameOfFile' with the file you want to test. JUnit tests are available for the following classes: Terrain, Rover, and Rotate.

```
javac -cp .:junit-4.12.jar NameOfFile.java
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore NameOfFile
```



##STRETCH GOALS

###Terrain Class Refactoring
Create a method that keeps track of where obstacles are (i.e. rovers, boulders, etc). Then refactor the Rover moveForwards() method to have the rover check to see if the space is free before moving.

###Rover/Rotate Class Refactoring
Add error messages for invalid instructions and unfeasible movements.

Remove embedded rotate method from the Rover class and use the one written in the Rotate class.

###Input File

Write tests to check that the input data follows the established pattern of:

1. Terrain
2. Rover's Location
3. Rover's Instruction
4. Another Rover's Location
5. Other Rover's Location

Or rewrite the program to automatically check for these patterns.



###JUnit Test Additions/Improvements
Write tests for failing cases to ensure application raises error messages.

