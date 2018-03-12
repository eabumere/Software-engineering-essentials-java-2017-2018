package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import controller.GameController;

public class GameControllerTest {

	private GameController gameController = new GameController();
	
	//FR2: 5 different levels are stored in the database, test if reading is right
	@Test(timeout=1000)
	public void testInitGame() {
		gameController.initGame();
		assertNotNull("Levels list is empty", gameController.getLevels());
		assertNotNull("HighScore list is empty", gameController.getHighScores());
	}

	@Test
	public void testInitPlayer() {
		String playerName = "Janis";
		assertTrue(gameController.initPlayer(playerName));
		assertEquals("Name not equal to player name", playerName, gameController.getPlayer().getName());
	}
	
	@Test
	public void testWrongInitPlayer() {
		String playerName = "";
		assertFalse(gameController.initPlayer(playerName));
	}

	//The next 3 tests are testing FR1
	@Test
	public void testStartLevel() {
		GameController gameController = new GameController();
		gameController.initGame();
		gameController.startLevel(gameController.getLevels().get(0));
		assertFalse(gameController.isPaused());
	}

	@Test
	public void testPauseGame() {
		GameController gameController = new GameController();
		gameController.initGame();
		gameController.startLevel(gameController.getLevels().get(0));
		gameController.pauseGame();
		assertTrue(gameController.isPaused());
	}

	@Test
	public void testResumeLevel() {
		GameController gameController = new GameController();
		gameController.initGame();
		gameController.startLevel(gameController.getLevels().get(0));
		gameController.pauseGame();
		gameController.resumeLevel();
		assertFalse(gameController.isPaused());
	}

	/*@Test
	public void testShowHighScores() {
		fail("Not yet implemented");
	}

	@Test
	public void testSubmitHighScore() {
		fail("Not yet implemented");
	}*/

}
