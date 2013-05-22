package com.mindofprogramming.marsrover;

public class PlateauException extends Exception {
	private Plateau src;

	public PlateauException(Plateau src, String msg){
		super(msg);
		this.src = src;
	}

	public Plateau getSource(){
		return this.src;
	}
}