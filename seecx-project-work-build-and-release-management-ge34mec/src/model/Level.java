package model;

import java.util.List;

public class Level {

	private int id;
	private String difficulty;
	
	private List<EnemyShip> enemyShips;
	private PlayerShip playerShip;


	public Level(){
	}
	
	public Level(int id, String difficulty, List<EnemyShip> enemyShips, PlayerShip playerShip) {
		this.enemyShips = enemyShips;
		this.playerShip = playerShip;
		this.id = id;
		this.difficulty = difficulty;
	}
	
	public List<EnemyShip> getEnemyShips() {
		return enemyShips;
	}

	public void setEnemyShips(List<EnemyShip> enemyShips) {
		this.enemyShips = enemyShips;
	}

	public PlayerShip getPlayerShip() {
		return playerShip;
	}

	public void setPlayerShip(PlayerShip playerShip) {
		this.playerShip = playerShip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
}
