package controller;

import java.util.List;

import model.Level;
import model.Player;

/**
 * This is the main controller of the game. it will get data from the database and transform it into game object instances.
 * It works with the model and the view.
 * @author Timi
 *
 */
public class GameController{

	private String database = ""; //To signify that this class works with the database
	
	//moved levels from LevelController thus leaving LevelController to work with only a single level
	private List<Level> levels;
	//further model items are stored in the specific controller classes
	
	//other controllers
	private PlayerController playerController;
	private LevelController levelController;
	private MusicController musicController;
	
	//view is stored in fxml files
	
	//timer
	private long startTime;
	private long endTime;
	
	public void startTimer(){
		startTime = System.currentTimeMillis();
	}
	
	public void stopTimer(){
		endTime = System.currentTimeMillis();
	}
	
	public void initPlayer(String name) {
		Player player = new Player(name);
		playerController = new PlayerController(player);
	}
	
	/* FR1: Calling the next three functions will be from the UI or from the keyboard */
	public void startLevel(Level chosenLevel){
		startTimer();
		levelController.setLevel(chosenLevel);
		levelController.setPaused(false);
		levelController.startLevel();
	}
	
	public void pauseGame(){
		levelController.setPaused(true);
	}
	
	public void resumeLevel() {
		levelController.setPaused(false);
		levelController.runLevel();
	}

	/* FR3: This function is called when keyboard event occurs on the arrow keys 
	 * A KeyListener will be bound to the player's ship and whenever one of the left or right 
	 * arrowkeys are pressed, this function is called with a string stating either "left" or "right" */
	public void steerSpaceShip(String direction){
		levelController.steerPlayerShip(direction);
	}
	
	/* FR4: By hitting the space bar a user can shoot rockets towards the invaders. When a rocket hits 
	 * an invader, the invader as well as the rocket will be removed from the game board.
	 * This function is called from the UI when the KeyListener on the playership detected the spacebar
	 */
	public void shootRocket() {
		levelController.shootRocketFromSpaceship();
	}
	
	public void showHighScores() {
		playerController.submitHighScore();
	}
	
	public void submitHighScore() {
		playerController.submitHighScore();
	}
	
	public void calculateScore(){
		//TODO
	}
	
	public void quit(){
		//TODO
	}
	

}
