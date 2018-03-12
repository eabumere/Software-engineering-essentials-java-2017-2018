package de.tum.in.www1;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainViewController implements Initializable {

	@FXML private Button nextButton;

	//Task 1: Create a single javafx.scene.control.TextField
	@FXML private TextField textField;
	
	//Task 2: Delete all existing ComboBoxes
	
	@FXML private ImageView feedbackImageView;

	private Image redxImage = new Image(getClass().getResourceAsStream("view/redx.png"));
	private Image greencheckImage = new Image(getClass().getResourceAsStream("view/greencheck.png"));
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Task 2: Delete the setup of the combo boxes
		
		//Task 1: Add a textProperty() listener to the new textField and Task 3: invoke the validate method with the new string value of the textField
		textField.textProperty().addListener((observable, oldValue, newValue) -> { 
		    validate(newValue); 
		});
		
		nextButton.setDisable(true);
		feedbackImageView.setImage(redxImage);
	}
	
	//Task 2: Delete the method comboBoxValueChanged()
	
	public void validate(String matriculationNumber) {
		boolean isCorrect = isMatriculationNumber(matriculationNumber);
		nextButton.setDisable(!isCorrect);
		if (!isCorrect) {
			System.out.println("Validation fail");
			feedbackImageView.setImage(redxImage);
		}
		else {
			System.out.println("Validation success");
			feedbackImageView.setImage(greencheckImage);	
		}
	}

	@FXML
	private void next() {
		System.out.println("Next button clicked");
	}

	public boolean isMatriculationNumber(String matricalutionNumber) {
		return matricalutionNumber.matches("[0-9]+") && matricalutionNumber.length() == 8;
	}
}