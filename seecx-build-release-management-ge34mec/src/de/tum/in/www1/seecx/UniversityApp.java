package de.tum.in.www1.seecx;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class UniversityApp extends Application {

	static final Logger logger = Logger.getLogger(UniversityApp.class);
	
	@Override
    public void start(Stage primaryStage) {
		
		final StackPane stackPane = new StackPane();
		final Scene scene = new Scene(stackPane, 300, 250);
		
        final Button button = new Button();
        button.setText(getButtonText());
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                logger.debug("Button clicked");
            	final Alert alert = new Alert(AlertType.INFORMATION);
            	alert.setTitle("University App");
            	alert.setContentText(button.getText());
            	alert.showAndWait();
            }
        });
        
        stackPane.getChildren().add(button);

        primaryStage.setTitle("University App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public String getButtonText() {
        return "SEECx";
    }

	public static void main(String[] args) {
		BasicConfigurator.configure();
        logger.debug("App started");
        launch(args);
    }
}
