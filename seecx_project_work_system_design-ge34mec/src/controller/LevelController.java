package controller;

import java.util.List;

import model.Level;
import model.Rocket;

public class LevelController {
	
	private List<Level> levels;
	
	public LevelController(){}
	
	public LevelController(List<Level> levels){
		this.levels = levels;
	}
	
	public void startLevel(){
		//TODO
	}
	
	/**
	 * Shoot a new rocket from the ship
	 * Both kinds of spaceships are capable of this, except maybe at different speeds
	 * @param direction a string stating either "up" or "down"
	 * @param speed animation of rocket can be faster or slower
	 */
	public void shootRocketFromSpaceship(){
		//TODO
	}
	
	public void steerPlayerShip() {
		//TODO
		/*methods moveLeft and moveRight from the PlayerShip class are used here for setting the position
		  modification on the view should also be done here*/
	}
	
	public void destroySpaceShip() {
		//TODO
	}
	
	public void endLevel() {
		//TODO
	}
}
