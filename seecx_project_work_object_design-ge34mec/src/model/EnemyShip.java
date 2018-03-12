package model;

import java.awt.Image;
import java.awt.Point;

public class EnemyShip extends SpaceShip{

	public EnemyShip(Point position, Image image) {
		super(position, image);
	}
	
	public void moveOneStep() {
		//TODO: In some Space Invaders games the enemy ships slowly move towards the player
	}

}
