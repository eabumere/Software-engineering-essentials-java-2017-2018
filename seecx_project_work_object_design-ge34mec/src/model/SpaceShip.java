package model;

import java.awt.Image;
import java.awt.Point;
import java.util.List;

/**
 * Superclass of space ship type objects, namely the enemy and the player's ship
 * @author Timi
 *
 */
public class SpaceShip {
	
	private List<Rocket> rockets;
	protected Point position;  //upper left corner
	private boolean dead;
	private Image image;
	private Size size;
	
	/**
	 * CONSTRUCTORS
	 * @param position
	 * @param image
	 * @param width
	 * @param height
	 */
	public SpaceShip(Point position, Image image, Size size) {
		this.position = position;
		this.image = image;
		this.dead = false;
		this.size = size;
	}
	
	public SpaceShip(Point position, Image image) {
		this.position = position;
		this.image = image;
		this.dead = false;
		//Define a standard size
		size = new Size(10, 10);
	}
	
	/**
	 * Upon being hit, explode
	 */
	public void explode() {
		this.dead = true;
	}
	
	public void removeRocket(Rocket rocket){
		rockets.remove(rocket);
	}
	
	/**
	 * GETTERS AND SETTERS
	 */
	public List<Rocket> getRockets() {
		return rockets;
	}
	public void setRockets(List<Rocket> rockets) {
		this.rockets = rockets;
	}
	
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	
	public boolean isDead() {
		return dead;
	}
	
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

}
