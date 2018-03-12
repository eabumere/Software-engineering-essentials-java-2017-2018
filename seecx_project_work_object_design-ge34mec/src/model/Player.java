package model;

public class Player {
	private String name;
	private int score;
	
	public Player(String name) {
		this.name = name;
		this.score = 0;
	}

	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}

	/**
	 * GETTERS AND SETTERS
	 */
	
	public String getName() {
		return name;
	}

	//Not sure if we need it
	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}
