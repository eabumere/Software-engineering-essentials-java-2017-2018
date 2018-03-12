package controller;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.EnemyShip;
import model.Level;
import model.Player;
import model.PlayerShip;
import model.Rocket;
import model.Size;
import model.SpaceShip;
import strategy.CenterCollision;
import strategy.CollisionStrategy;
import strategy.SquareCollision;

public class LevelController {

	private Player player;
	private Level level;
	// this class is the context of the strategy pattern
	private CollisionStrategy collisionStrategy;

	public void initPlayerShip() {
		Point position = new Point(374, 519);
		Size size = new Size(76, 103);
		PlayerShip playerShip = new PlayerShip(position, size);
		level.setPlayerShip(playerShip);
	}

	public void startLevel() {
		configureCollision();
		initPlayerShip();
		runLevel();
	}

	public void runLevel() {
		// test if any of the player's rockets collides with any of the invaders
		// we have to create copies of the arrays
		List<EnemyShip> initialEnemyShips = new ArrayList<EnemyShip>();
		if (!level.getEnemyShips().isEmpty()) {
			initialEnemyShips.addAll(level.getEnemyShips());
		}
		List<Rocket> initialRockets = new ArrayList<Rocket>();
		for (EnemyShip invader : initialEnemyShips) {
			if (!level.getPlayerShip().getRockets().isEmpty()) {
				initialRockets.addAll(level.getPlayerShip().getRockets());
			}
			for (Rocket rocket : initialRockets) {
				if (testCollision(invader, rocket)) {
					player.setScore(player.getScore() + 50);
					invader.explode();
					level.getEnemyShips().remove(invader);
					level.getPlayerShip().removeRocket(rocket);
				} else {
					rocket.moveFurther();
				}

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		// TODO: test for invader rockets hitting the player\

		// TODO: UPDATE GUI
	}

	/**
	 * Shoot a new rocket from the ship Both kinds of spaceships are capable of
	 * this, except maybe at different speeds
	 * 
	 * @param direction
	 *            a string stating either "up" or "down"
	 * @param speed
	 *            animation of rocket can be faster or slower
	 */
	public void shootRocketFromSpaceship() {
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
		// TODO
	}

	public void endLevel() {
		// TODO
	}

	public Player getPlayer() {
		return player;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	

	public CollisionStrategy getCollisionStrategy() {
		return collisionStrategy;
	}

	public void setCollisionStrategy(CollisionStrategy collisionStrategy) {
		this.collisionStrategy = collisionStrategy;
	}

	private boolean testCollision(SpaceShip invader, Rocket rocket) {
		return collisionStrategy.isCollided(invader, rocket);
	}

	/*
	 * I didn't see the necessity of declaring a separate plocy class for the policy
	 * only depends on the difficulty that is contained in Level
	 */

	private void configureCollision() {
		if (level.getDifficulty() == "simple")
			this.collisionStrategy = new SquareCollision();
		else if (level.getDifficulty() == "hard")
			this.collisionStrategy = new CenterCollision();
	}
}
