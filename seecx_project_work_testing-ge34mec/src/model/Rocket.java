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
		this.position = position;
		this.speed = speed;
		this.direction = direction;
	}
	
	public Rocket() {
		this.position = new Point(0, 0);
		this.speed = 0;
		this.direction = "up";
	}
	
	public void moveFurther(){
		position.setLocation(position.getX(), position.getY() - 5); //I am not sure but I think the y coordinates go from up to down
		//TODO: make propagation relative to speed
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
