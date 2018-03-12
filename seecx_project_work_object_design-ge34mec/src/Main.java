import controller.GameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.FXMLController;

public class Main extends Application{
	
	public static void main(String[] args) {

		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Space Invaders");
		FXMLLoader loader = new FXMLLoader();
		
		GameController game = new GameController();
		FXMLController fxmlController = new FXMLController(game);
		fxmlController.setStage(stage);
		
		loader.setLocation(getClass().getResource("view/Startup.fxml"));
		loader.setController(fxmlController);
		Scene scene = new Scene(loader.load());
		
        stage.setScene(scene);
        stage.show();
	}

}
