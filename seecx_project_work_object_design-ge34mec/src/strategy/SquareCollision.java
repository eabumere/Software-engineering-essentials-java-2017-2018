package strategy;

import model.Rocket;
import model.SpaceShip;

public class SquareCollision implements CollisionStrategy {
	
	/* For easy modifiability, we define a square field 
	 * which basically consists of a single number representing both the with and the height
	 */
	private int squareSize = 10;

	@Override
	public boolean isCollided(SpaceShip invader, Rocket rocket) {
		//could have written in one line but that is bad coding style
		if (rocket.getPosition().getX() >= invader.getPosition().getX()) {
			if (rocket.getPosition().getX() <= invader.getPosition().getX() + squareSize) {
				if (rocket.getPosition().getY() >= invader.getPosition().getY()) {
					if (rocket.getPosition().getY() <= invader.getPosition().getY() + squareSize)
						return true;
				}
			}
		}
		return false;
	}
	
	

}
