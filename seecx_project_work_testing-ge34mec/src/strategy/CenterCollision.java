package strategy;

import java.awt.Point;

import model.Rocket;
import model.SpaceShip;

/*
 * It would make sense to relate the center of collision to the image of the spaceship.
 * The requirements ask for the center of "the square".
 * For it is much more useful and logical, here the implementation relies on the size of the image
 * of the spaceship (which of course can be a square)
 */
public class CenterCollision implements CollisionStrategy{

	//in this case we take the center of the image
	@Override
	public boolean isCollided(SpaceShip invader, Rocket rocket) {
		//(posX + width) /2 , (posY + height) /2
		int spaceshipCenterX = (int)(invader.getPosition().getX() + invader.getSize().getWidth()) / 2;
		int spaceshipCenterY = (int)(invader.getPosition().getY() + invader.getSize().getHeight()) / 2;
		Point spaceshipCenter = new Point(spaceshipCenterX, spaceshipCenterY);
		if (spaceshipCenter == rocket.getPosition())
			return true;
		return false;
	}

}
