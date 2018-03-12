package database;

import java.util.List;

import model.Level;
import model.Player;
/**
 * We're making use of the bridge pattern in case more forms of storing the data is available
 * @author Timi
 *
 */
public interface DatabaseImplementor {
	public List<Level> readLevels();
	public void writeLevels(List<Level> levels);
	
	public List<Player> readHighscores();
	public void writeHighScore(List<Player> players);

}
