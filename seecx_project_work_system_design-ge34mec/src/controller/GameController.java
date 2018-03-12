package controller;

import model.Player;
import view.MainGameScreen;

/**
 * This is the main controller of the game. it will get data from the database and transform it into game object instances.
 * It works with the model and the view.
 * @author Timi
 *
 */
public class GameController {

	private String database; //To signify that this class works with the database
	
	//other controllers
	private PlayerController playerController;
	private LevelController levelController;
	private MusicController musicController;
	
	//model items are stored in the specific controller classes
	
	//view
	private MainGameScreen view;
	
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
	
	public void startLevel(){
		startTimer();
		//TODO
	}
	
	public void showHighScores() {
		playerController.submitHighScore();
	}
	
	public void submitHighScore() {
		playerController.submitHighScore();
	}
	
	public void pauseGame(){
		//TODO
	}
	
	public void calculateScore(){
		//TODO
	}
	
	public void quit(){
		//TODO
	}
}
