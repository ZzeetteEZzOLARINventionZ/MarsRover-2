#MarsRover

##Problem

A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.

A rover’s position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.

In order to control a rover, NASA sends a simple string of letters. The possible letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’ makes the rover spin 90 degrees left or right respectively, without moving from its current spot. ‘M’ means move forward one grid point, and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).

###INPUT

The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.

The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover’s position, and the second line is a series of instructions telling the rover how to explore the plateau.

The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover’s orientation.

Each rover will be finished sequentially, which means that the second rover won’t start to move until the first one has finished moving.

###OUTPUT

The output for each rover should be its final co-ordinates and heading.

###Examples

Test Input:```
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```

Expected Output:```
1 3 N
5 1 E
```

##Solution

This is a classic problem about object "state". The "orientation" and "position" that the rovers is at is actually the rover's "state". The instructions, e.g. 'L' or 'M', initiate state transition for the rover. This solution is to maintain a "state machine" within each "MarsRover" object and the "state machine" changes its state every time a instruction is received. 

The `Plateau` class models the land/area on which the rover moves. It defines the concepts of "position" ('x' and 'y') and "orientation" (or direction). The `MarsRover` class models the actual rover which responds instructions. Each `MarsRover` instance is given a `Plateau` instance on which it moves. The `Plateau` instance will "remember" at which position the rover is currently stopped and the "MarsRover" instance itself keeps track of where its facing now.

This implemenation doesn't include any code for processing the "input" file described in the problem statement. This is intentionally left out since it's not something important for this problem.
