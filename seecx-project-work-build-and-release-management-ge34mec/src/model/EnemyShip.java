package model;

import java.awt.Point;

public class EnemyShip extends SpaceShip{

	public EnemyShip(Point position, String image) {
		super(position, image);
	}
	
	public EnemyShip(Point position, Size size) {
		super(position, size);
		this.setImageURL("@../../img/Alien-Space-Ship-Icon-Color-psd72702.png");
	}
	
	public EnemyShip() {
	}
	
	public void moveOneStep() {
		//TODO: In some Space Invaders games the enemy ships slowly move towards the player
	}

}
