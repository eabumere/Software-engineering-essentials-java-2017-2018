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
	private Point position;
	private boolean dead;
	private Image image;
	private int width;
	private int height;	
	
	/**
	 * CONSTRUCTORS
	 * @param position
	 * @param image
	 * @param width
	 * @param height
	 */
	public SpaceShip(Point position, Image image, int width, int height) {
		this.position = position;
		this.image = image;
		this.dead = false;
		this.width = width;
		this.height = height;
	}
	
	public SpaceShip(Point position, Image image) {
		this.position = position;
		this.image = image;
		this.dead = false;
		//Define a standard size
		setSize(100, 100);
	}
	
	/**
	 * Upon being hit, explode
	 */
	public void explode() {
		this.dead = true;
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
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	

}
