package model;

import java.awt.Point;
import java.util.ArrayList;
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
	private String imageURL;
	private Size size;
	
	/**
	 * CONSTRUCTORS
	 * @param position
	 * @param imageURL
	 * @param width
	 * @param height
	 */
	public SpaceShip(Point position, String imageURL, Size size) {
		this.position = position;
		this.imageURL = imageURL;
		this.dead = false;
		this.size = size;
		rockets = new ArrayList<Rocket>();
	}
	
	public SpaceShip(Point position, Size size) {
		this.position = position;
		this.dead = false;
		this.size = size;
		rockets = new ArrayList<Rocket>();
	}
	
	public SpaceShip(Point position, String imageURL) {
		this.position = position;
		this.imageURL = imageURL;
		this.dead = false;
		//Define a standard size
		size = new Size(10, 10);
		rockets = new ArrayList<Rocket>();
	}
	
	public SpaceShip() {
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
	
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

}
