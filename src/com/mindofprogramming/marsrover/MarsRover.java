package com.mindofprogramming.marsrover;

public class MarsRover {
	private Plateau land;
	private Plateau.Orientation currentOrientation;

	public MarsRover(Plateau land, Plateau.Orientation initialDirection, Plateau.Position initPos){
		this.land = land;
		this.currentOrientation = initialDirection;
		this.land.setPosition(initPos);
	}

	public MarsRover move(int distance){
		this.land.newMovement(this.currentOrientation,distance);
		return this;
	}

	public MarsRover turnLeft(){
		this.currentOrientation = this.currentOrientation.left();
		return this;
	}

	public MarsRover turnRight(){
		this.currentOrientation = this.currentOrientation.right();
		return this;
	}

	public Plateau.Position currentPosition(){
		return this.land.lastPosition();
	}

	public Plateau.Orientation currentOrientation(){
		return this.currentOrientation;
	}
}