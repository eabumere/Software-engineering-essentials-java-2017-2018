package model;

import java.awt.Point;

public class PlayerShip extends SpaceShip{

	public PlayerShip(Point position, String imageURL) {
		super(position, imageURL);
	}
	
	public PlayerShip(Point position, Size size) {
		super(position, size);
		this.setImageURL("placeholder");
	}
	
	public PlayerShip() {
	}

	//step is 5 pixels, can be modified
	public void moveLeft(){
		this.position.setLocation(this.position.getX() - 5, this.position.getY());
	}
	
	public void moveRight(){
		this.position.setLocation(this.position.getX() + 5, this.position.getY());
	}
	
}
