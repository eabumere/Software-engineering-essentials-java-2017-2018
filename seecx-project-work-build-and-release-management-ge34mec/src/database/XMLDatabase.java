package database;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.EnemyShip;
import model.Level;
import model.Player;
import model.Size;

public class XMLDatabase implements DatabaseImplementor {
	private String levelFileLocation = "src\\database\\LevelsData.xml";
	private String playerFileLocation = "src\\database\\HighScoresData.xml";

	@Override
	public List<Level> readLevels() {
		try {
			File levelFile = new File(levelFileLocation);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(levelFile);
			doc.getDocumentElement().normalize();

			// Create List to be returned
			List<Level> levelsList = new ArrayList<Level>();

			NodeList levelNodes = doc.getElementsByTagName("level");

			for (int i = 0; i < levelNodes.getLength(); i++) {
				Element levelElement = (Element) levelNodes.item(i);

				// Create Level object
				Level level = new Level();
				level.setId(Integer.parseInt(levelElement.getAttribute("id")));
				level.setDifficulty(levelElement.getAttribute("difficulty"));

				// Create invader list
				List<EnemyShip> enemyShipsList = new ArrayList<EnemyShip>();
				NodeList invaderNodes = levelElement.getChildNodes();

				for (int j = 0; j < invaderNodes.getLength(); j++) {
					Node invader = invaderNodes.item(j);
					if (invader.getNodeType() == Node.ELEMENT_NODE) {
						Element invaderElement = (Element) invader;

						// get attributes of ship
						int xPosition = Integer.parseInt(invaderElement.getAttribute("x"));
						int yPosition = Integer.parseInt(invaderElement.getAttribute("y"));
						int width = Integer.parseInt(invaderElement.getAttribute("width"));
						int height = Integer.parseInt(invaderElement.getAttribute("height"));
						Point position = new Point(xPosition, yPosition);
						Size size = new Size(width, height);

						// Create EnemyShip object
						EnemyShip enemyShip = new EnemyShip(position, size);
						// Add it to the Level
						enemyShipsList.add(enemyShip);
					}
				}
				level.setEnemyShips(enemyShipsList);
				// Add the Level to the levelsList
				levelsList.add(level);
			}

			return levelsList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void writeLevels(List<Level> levels) {
		// TODO Implement writing the xml level file if necessary

	}

	@Override
	public List<Player> readHighscores() {
		try {
			File playerFile = new File(playerFileLocation);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(playerFile);
			doc.getDocumentElement().normalize();

			// Create List to be returned
			List<Player> playersList = new ArrayList<Player>();

			NodeList playerNodes = doc.getElementsByTagName("player");

			for (int i = 0; i < playerNodes.getLength(); i++) {
				Element playerElement = (Element) playerNodes.item(i);

				// Create Player object
				Player player = new Player();
				player.setName(playerElement.getAttribute("name"));
				player.setScore(Integer.parseInt(playerElement.getAttribute("score")));

				// Add the Player to the playersList
				playersList.add(player);
			}

			return playersList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void writeHighScore(List<Player> players) {
		try {
			File playerFile = new File(playerFileLocation);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			// root element
			Document doc = dBuilder.newDocument();
			Element rootElement = doc.createElement("score");
			doc.appendChild(rootElement);

			// player elements
			for (Player player : players) {
				Element playerElement = doc.createElement("player");
				rootElement.appendChild(playerElement);
				playerElement.setAttribute("name", player.getName());
				playerElement.setAttribute("score", player.getScore() + "");
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			transformerFactory.setAttribute("indent-number", 2);
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(playerFile);

			transformer.transform(source, result);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}

	}
}
