package com.mindofprogramming.marsrover;

public class Plateau {

	public enum Orientation {
		NORTH {
			@Override
			public Orientation left() {
				return WEST;
			}

			@Override
			public Orientation right() {
				return EAST;
			}
		},

		EAST {
			@Override
			public Orientation left() {
				return NORTH;
			}

			@Override
			public Orientation right() {
				return SOUTH;
			}
		},

		SOUTH {
			@Override
			public Orientation left() {
				return EAST;
			}

			@Override
			public Orientation right() {
				return WEST;
			}
		},

		WEST {
			@Override
			public Orientation left() {
				return SOUTH;
			}

			@Override
			public Orientation right() {
				return NORTH;
			}
		};

		public abstract Orientation left();
		public abstract Orientation right();
	}

	public static class Position {
		private int posX;
		private int posY;

		public Position(int x, int y){
			posX = x;
			posY = y;
		}

		public int getX(){
			return posX;
		}

		public int getY(){
			return posY;
		}
	}

	private Position edge;
	private Position currentPos;

	public Plateau(int edgeX, int edgeY){
		edge = new Position(edgeX, edgeY);
		currentPos = new Position(0,0);
	}

	public Plateau setPosition(Position pos){
		this.currentPos = pos;
		return this;
	}

	public Plateau newMovement(Orientation direction, int distance){
		switch (direction) {
			case NORTH:
				this.currentPos = new Position(currentPos.getX(), currentPos.getY() + distance);
				break;
			case EAST:
				this.currentPos = new Position(currentPos.getX() + distance, currentPos.getY());
				break;
			case SOUTH:
				this.currentPos = new Position(currentPos.getX(), currentPos.getY() - distance);
				break;
			case WEST:
				this.currentPos = new Position(currentPos.getX() - distance, currentPos.getY());
				break;
			default:
				throw new UnsupportedOperationException("Unknown orientation value: " + direction);
		}

		return this;
	}

	public Position lastPosition(){
		return this.currentPos;
	}
}