package view;

import java.io.IOException;

import controller.GameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Level;

public class FXMLController {
	
	private GameController controller;
	private Stage stage;
	private Scene mainMenuScene, levelScene;
	
	public FXMLController(GameController controller) {
		this.controller = controller;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}


	@FXML
	private TextField nameField;
	
	@FXML
	private void submitNameButtonClicked(ActionEvent event) {
		//TODO: Validate name
		String name = nameField.getText();
		controller.initPlayer(name);
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
			
			if (mainMenuScene == null)
				this.mainMenuScene = new Scene(root);
			stage.setScene(mainMenuScene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//BIG BIG TODO: add updates on GUI while playing the game
	
	@FXML
	private void levelChosenButtonClicked(ActionEvent event) {
		
		Level level = new Level(); //TODO: = get what level was clicked (through the controller obviously)
		controller.startLevel(level);
		
		/*try {
			Parent root = FXMLLoader.load(getClass().getResource("LevelLayout.fxml"));
			
			if (levelScene == null)
				this.levelScene = new Scene(root);*/
		
			levelScene.setOnKeyPressed(keyListener);
		/*
			stage.setScene(levelScene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	/* FR1 & FR3 & FR4 */
	private EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
	    @Override
	    public void handle(KeyEvent event) {
	        if(event.getCode() == KeyCode.RIGHT) {
	            controller.steerSpaceShip("right");
	        } else if (event.getCode() == KeyCode.LEFT) {
	        	controller.steerSpaceShip("left");
	        } else if(event.getCode() == KeyCode.SPACE) {
	            controller.shootRocket();
	        } else if(event.getCode() == KeyCode.P) {
	        	controller.pauseGame();
	        } else if(event.getCode() == KeyCode.R) {
	        	controller.resumeLevel();
	        }
	        event.consume();
	    }
	};

}
