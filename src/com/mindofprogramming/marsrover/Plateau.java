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
			if(x < START_X || y < START_Y)
				throw new IllegalArgumentException("Position's coordinates can't be less than plateau's starting position!");

			posX = x;
			posY = y;
		}

		public int getX(){
			return posX;
		}

		public int getY(){
			return posY;
		}

		@Override
		public boolean equals(Object obj){
			if(!(obj instanceof Position))
				return false;

			Position p = (Position)obj;
			return this.getX() == p.getX() && this.getY() == p.getY();
		}
	}

	public static final int START_X = 0;
	public static final int START_Y = 0;

	private Position edge;
	private Position currentPos;

	public Plateau(int edgeX, int edgeY){
		if(edgeX < START_X || edgeY < START_Y)
			throw new IllegalArgumentException("Plateau's edge can't be less than its starting point at (" + START_X + "," + START_Y + ")!");

		edge = new Position(edgeX, edgeY);
		currentPos = new Position(START_X, START_Y);
	}

	public Position getEdge(){
		return this.edge;
	}

	public Plateau setPosition(Position pos){
		if(pos.getX() > this.getEdge().getX() || pos.getY() > this.getEdge().getY()){
			throw new IllegalArgumentException("The supplied position is beyond this plateau!");
		}

		this.currentPos = pos;
		return this;
	}

	public Plateau newMovement(Orientation direction, int distance) throws PlateauException {
		switch (direction) {
			case NORTH:
				if(currentPos.getY() + distance > getEdge().getY())
					throw new PlateauException(this, "You are moving beyond the area of plateau!");

				this.currentPos = new Position(currentPos.getX(), currentPos.getY() + distance);
				break;
			case EAST:
				if(currentPos.getX() + distance > getEdge().getX())
					throw new PlateauException(this, "You are moving beyond the area of plateau!");

				this.currentPos = new Position(currentPos.getX() + distance, currentPos.getY());
				break;
			case SOUTH:
				if(currentPos.getY() - distance < START_Y)
					throw new PlateauException(this, "You are moving beyond the area of plateau!");

				this.currentPos = new Position(currentPos.getX(), currentPos.getY() - distance);
				break;
			case WEST:
				if(currentPos.getX() - distance < START_X)
					throw new PlateauException(this, "You are moving beyond the area of plateau!");

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