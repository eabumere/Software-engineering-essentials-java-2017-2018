package strategy;

import model.Rocket;
import model.SpaceShip;

public interface CollisionStrategy {
	
	/* In case we implement the game in such a way that invaders can also shoot, 
	 * then we can reuse this method for collision checking.
	 * That is why we use SpaceShip superclass and not the subclass EnemyShip
	 */
	public boolean isCollided(SpaceShip invader, Rocket rocket);

}
