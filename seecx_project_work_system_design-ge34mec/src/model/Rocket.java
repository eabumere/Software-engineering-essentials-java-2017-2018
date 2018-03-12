package model;

import java.awt.Point;

/**
 * Rocket object to be shot from spaceships
 * @author Timi
 *
 */
public class Rocket {
	private Point position;
	private float speed;
	private String direction;
	
	public Rocket(Point position, float speed, String direction) {
		super();
		this.position = position;
		this.speed = speed;
		this.direction = direction;
	}
	
	public void moveFurther(){
		//TODO
	}
	
	/**
	 * GETTERS (we probably only need getters but to be seen during the development)
	 */
	public Point getPosition() {
		return position;
	}

	public float getSpeed() {
		return speed;
	}

	public String getDirection() {
		return direction;
	}
}
