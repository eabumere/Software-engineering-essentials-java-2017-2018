package controller;

import java.util.List;

import database.DatabaseImplementor;
import database.XMLDatabase;
import model.Level;
import model.Player;

/**
 * This is the main controller of the game. it will get data from the database
 * and transform it into game object instances. It works with the model and the
 * view.
 * 
 * @author Timi
 *
 */
public class GameController {

	private DatabaseImplementor database;
	private String databaseType = "XMLfiles";

	// model elements
	private Player player;
	private List<Level> levels;
	private List<Player> highScores;
	
	// other controllers
	private LevelController levelController;
	private MusicController musicController;

	// view is stored in fxml files

	// timer
	private long startTime;
	private long endTime;
	
	private boolean isPaused;

	public void initGame() {
		readDatabase();
		levelController = new LevelController();
	}

	public void startTimer() {
		startTime = System.currentTimeMillis();
	}

	public void stopTimer() {
		endTime = System.currentTimeMillis();
	}

	public boolean initPlayer(String name) {
		if (!name.isEmpty()) {
			// TODO: Validate name
			this.player =  new Player(name);
			return true;
		} 
		return false;
	}

	/*
	 * FR1: Calling the next three functions will be from the UI or from the
	 * keyboard
	 */
	public void startLevel(Level chosenLevel) {
		startTimer();
		levelController.setPlayer(player);
		levelController.setLevel(chosenLevel);
		setPaused(false);
		levelController.startLevel();
	}

	public void pauseGame() {
		setPaused(true);
	}

	public void resumeLevel() {
		setPaused(false);
		levelController.runLevel();
	}

	/*
	 * FR3: This function is called when keyboard event occurs on the arrow keys A
	 * KeyListener will be bound to the player's ship and whenever one of the left
	 * or right arrowkeys are pressed, this function is called with a string stating
	 * either "left" or "right"
	 */
	public void steerSpaceShip(String direction) {
		levelController.steerPlayerShip(direction);
	}

	/*
	 * FR4: By hitting the space bar a user can shoot rockets towards the invaders.
	 * When a rocket hits an invader, the invader as well as the rocket will be
	 * removed from the game board. This function is called from the UI when the
	 * KeyListener on the playership detected the spacebar
	 */
	public void shootRocket() {
		levelController.shootRocketFromSpaceship();
	}

	public void showHighScores() {
		//TODO Display all highscores in descending order
		//TODO Display only top 10?
	}

	public void submitHighScore() {
		//TODO See if in top 10?
		this.highScores.add(player);
	}

	public void calculateScore() {
		// TODO
	}

	public void quit() {
		// TODO
	}

	public Player getPlayer() {
		return player;
	}

	public List<Level> getLevels() {
		return levels;
	}

	public List<Player> getHighScores() {
		return highScores;
	}

	public DatabaseImplementor getDatabase() {
		return database;
	}

	public void setDatabase(DatabaseImplementor database) {
		this.database = database;
	}
	
	public boolean isPaused() {
		return isPaused;
	}

	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}

	public LevelController getLevelController() {
		return levelController;
	}

	public void setLevelController(LevelController levelController) {
		this.levelController = levelController;
	}

	private void readDatabase() {
		if (databaseType.equals("XMLfiles")) {
			database = new XMLDatabase();
			levels = database.readLevels();
			highScores = database.readHighscores();
		}
	}
}
