package controller;

import java.util.List;

import model.EnemyShip;
import model.Level;
import model.Rocket;
import model.SpaceShip;
import strategy.CenterCollision;
import strategy.CollisionStrategy;
import strategy.SquareCollision;

public class LevelController {
	
	private Level level;
	//this class is the context of the strategy pattern
	private CollisionStrategy collisionStrategy;
	private boolean isPaused;
	
	public void startLevel() {
		configureCollision();
		runLevel();
	}
	
	public void runLevel() {
		while (!isPaused){
			//test if any of the player's rockets collides with any of the invaders
			for(EnemyShip invader: level.getEnemyShips()){
				for(Rocket rocket: level.getPlayerShip().getRockets()){
					if (testCollision(invader, rocket)){
						invader.explode();
						level.getEnemyShips().remove(invader);
						level.getPlayerShip().removeRocket(rocket);
					}	
					rocket.moveFurther();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			//TODO: test for invader rockets hitting the player\
			
			//TODO: UPDATE GUI
		}
	}
	
	/**
	 * Shoot a new rocket from the ship
	 * Both kinds of spaceships are capable of this, except maybe at different speeds
	 * @param direction a string stating either "up" or "down"
	 * @param speed animation of rocket can be faster or slower
	 */
	public void shootRocketFromSpaceship(){
		List<Rocket> rockets = level.getPlayerShip().getRockets();
		rockets.add(new Rocket(level.getPlayerShip().getPosition(), 100, "up"));
		level.getPlayerShip().setRockets(rockets);
	}
	
	public void steerPlayerShip(String direction) {
		if (direction.equals("left")) {
			level.getPlayerShip().moveLeft();
		} else if (direction.equals("right")) {
			level.getPlayerShip().moveRight();
		} else {
			System.out.println("Wrong direction passed");
		}
			
	}
	
	public void destroyPlayerShip() {
		//TODO
	}
	
	public void endLevel() {
		//TODO
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}

	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}

	private boolean testCollision(SpaceShip invader, Rocket rocket) {
		return collisionStrategy.isCollided(invader, rocket);
	}
	
	/*I didn't see the necessity of declaring a separate plocy class 
	 * for the policy only depends on the difficulty that is contained in Level
	 */
	
	private void configureCollision() {
		if (level.getDifficulty() == "simple")
			this.collisionStrategy = new SquareCollision();
		else if (level.getDifficulty() == "hard")
			this.collisionStrategy = new CenterCollision();
	}
}
