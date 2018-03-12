package model;

import java.awt.Image;
import java.awt.Point;

public class PlayerShip extends SpaceShip{

	public PlayerShip(Point position, Image image) {
		super(position, image);
	}

	//step is 5 pixels, can be modified
	public void moveLeft(){
		this.position.setLocation(this.position.getX() - 5, this.position.getY());
	}
	
	public void moveRight(){
		this.position.setLocation(this.position.getX() + 5, this.position.getY());
	}
	
}
