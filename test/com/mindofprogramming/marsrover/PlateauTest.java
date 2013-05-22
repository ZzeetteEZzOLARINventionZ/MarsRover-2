package com.mindofprogramming.marsrover;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PlateauTest {
	@Test
	public void changeOrientation(){
		assertEquals(Plateau.Orientation.NORTH.left().left().left(), Plateau.Orientation.EAST);

		assertEquals(Plateau.Orientation.NORTH.right().right().right(), Plateau.Orientation.WEST);
	}

	@Test
	public void moveOneStepToNorth() throws PlateauException {
		Plateau p = new Plateau(5,5);

		p.newMovement(Plateau.Orientation.NORTH, 1);
		assertEquals(p.lastPosition(),new Plateau.Position(0,1));
	}

	@Test
	public void moveToEdge() throws PlateauException {
		Plateau p = new Plateau(5,5);

		p.newMovement(Plateau.Orientation.NORTH, 5);
		assertEquals(p.lastPosition(), new Plateau.Position(0,5));

		p.newMovement(Plateau.Orientation.EAST, 5);
		assertEquals(p.lastPosition(),p.getEdge());

	}

	@Test(expected=PlateauException.class)
	public void moveBeyondPlateau() throws PlateauException {
		Plateau p = new Plateau(5,5);

		p.newMovement(Plateau.Orientation.NORTH, 6);
	}
}