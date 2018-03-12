package test;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import controller.LevelController;
import model.EnemyShip;
import model.Level;
import model.Player;
import model.PlayerShip;
import model.Rocket;
import strategy.CollisionStrategy;

@RunWith(EasyMockRunner.class)
public class LevelControllerTest {
	
	@TestSubject
	private LevelController levelController = new LevelController();
	
	@Mock
	private CollisionStrategy collisionMock;
	
	//Set up a generic level for the system under test
	/* So here is the problem:
	 * @BeforeClass requires the method to be static which is nonsense
	 * So I used @Before which is not practical but at least it doesn't mess 
	 * with the nonstatic fields
	 */
	@Before
	public void setupLevel() {
		Level level = new Level();
		List<Rocket> rockets = new ArrayList<Rocket>();
		PlayerShip playerShip = new PlayerShip();
		playerShip.setRockets(rockets);
		List<EnemyShip> invaders = new ArrayList<EnemyShip>();
		level.setPlayerShip(playerShip);
		level.setEnemyShips(invaders);
		levelController.setLevel(level);
		Player player = new Player();
		levelController.setPlayer(player);
	}

	//The next three test cases test FR4
	@Test
	public void testRunLevelIfRocketCollidesWithInvader() {
		//set up Mock property
		EnemyShip invader = new EnemyShip();
		Rocket rocket = new Rocket();
		expect(collisionMock.isCollided(invader, rocket)).andReturn(true);
		
		//add our invader and rocket which collide to the level
		Level level = levelController.getLevel();
		level.getEnemyShips().add(invader);
		level.getPlayerShip().getRockets().add(rocket);
		levelController.setLevel(level);
		levelController.setCollisionStrategy(collisionMock);
		
		replay(collisionMock);
		
		levelController.runLevel();
		
		//runLevel should do 3 things, we test them
		assertTrue("Player score not adjusted", levelController.getPlayer().getScore() == 50);
		assertTrue("Invader not removed from level layout", levelController.getLevel().getEnemyShips().size() == 0);
		assertTrue("Rocket not removed from Level layout", levelController.getLevel().getPlayerShip().getRockets().size() == 0);
		
	}
	
	@Test
	public void testRunLevelIfRocketDoesNotCollideWithInvader() {
		//set up Mock property
		EnemyShip invader = new EnemyShip();
		Rocket rocket = new Rocket();
		expect(collisionMock.isCollided(invader, rocket)).andReturn(false);
		
		//add our invader and rocket which collide to the level
		Level level = levelController.getLevel();
		level.getEnemyShips().add(invader);
		level.getPlayerShip().getRockets().add(rocket);
		levelController.setLevel(level);
		levelController.setCollisionStrategy(collisionMock);
		
		replay(collisionMock);
		
		levelController.runLevel();
		
		//runLevel should do 3 things, we test them
		assertTrue("Player score adjusted", levelController.getPlayer().getScore() == 0);
		assertTrue("Invader removed from level layout", levelController.getLevel().getEnemyShips().size() == 1);
		assertTrue("Rocket removed from Level layout", levelController.getLevel().getPlayerShip().getRockets().size() == 1);
		
	}

	@Test
	public void testShootRocketFromSpaceship() {
		levelController.shootRocketFromSpaceship();
		
		//test passes if there is one rocket in the playership
		//this is really really ugly code
		assertTrue(levelController.getLevel().getPlayerShip().getRockets().size() == 1);
	}

}
