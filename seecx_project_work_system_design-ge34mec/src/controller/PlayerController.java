package controller;

import model.Player;

public class PlayerController {
	
	private Player player;
	
	public PlayerController(){}
	
	public PlayerController(Player player) {
		this.player = player;
	}

	public void submitHighScore() {
		//TODO
	}
	
	public void listHighScores(){
		//TODO
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}	
}
