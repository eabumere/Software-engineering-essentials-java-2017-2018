package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

import org.junit.Test;

import model.PlayerShip;
/**
 * Test the steering: FR3
 * @author Timi
 *
 */
public class PlayerShipTest {

	@Test(timeout=100)
	public void testMoveLeft() {
		PlayerShip playerShip = new PlayerShip();
		Point position = new Point(100, 100);
		playerShip.setPosition(position);
		//this will be the expected value:
		position.setLocation(position.getX() - 5, position.getY());
		//perform action:
		playerShip.moveLeft();
		assertEquals(position, playerShip.getPosition());
	}

	@Test(timeout=100)
	public void testMoveRight() {
		PlayerShip playerShip = new PlayerShip();
		Point position = new Point(100, 100);
		playerShip.setPosition(position);
		//this will be the expected value:
		position.setLocation(position.getX() + 5, position.getY());
		//perform action:
		playerShip.moveLeft();
		assertEquals(position, playerShip.getPosition());
	}

}
