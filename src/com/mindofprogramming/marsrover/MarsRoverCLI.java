package com.mindofprogramming.marsrover;

public class MarsRoverCLI {
	public static void main(String[] args){
		Plateau land = new Plateau(5,5);

		MarsRover rover = new MarsRover(land,Plateau.Orientation.NORTH, new Plateau.Position(1,2));
		try {
			rover.turnLeft().move(1).turnLeft().move(1).turnLeft().move(1).turnLeft().move(1).move(1);
			Plateau.Position pos = rover.currentPosition();
			System.out.println("x: " + pos.getX() + " " + "y: " + pos.getY() + " " + rover.currentOrientation());

			rover = new MarsRover(new Plateau(5,5), Plateau.Orientation.EAST, new Plateau.Position(3,3));
			rover.move(1).move(1).turnRight().move(1).move(1).turnRight().move(1).turnRight().turnRight().move(1);
		
			pos = rover.currentPosition();
			System.out.println("x: " + pos.getX() + " " + "y: " + pos.getY() + " " + rover.currentOrientation());
		} catch (PlateauException ex){
			System.out.println(ex.getMessage());
			System.exit(1);
		}
	}
}