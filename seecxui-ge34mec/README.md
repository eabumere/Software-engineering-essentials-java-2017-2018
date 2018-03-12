# SEECX User Interface Exercise

Please import the given exercise project into your IDE and have a look at the following java files:

* **Main.java:** Starts the Java FX environment and sets up the Scene and primary Stage
* **MainViewController.java:** Controls the user interface elements and behavior
* **RootLayout.fxml:** Specifies the user interface Elements of the scene (Use Scenebuilder for easy modification)


# Prerequisites:
* SceneBuilder app installed and configured
* Newest version of Java 8 installed

Please watch the corresponding video and read the instructions in the edX course if one of the prerequisites is not fulfilled.

# You have the following tasks:

The current project includes an unfriendly user interface where the user has to select each single number in a dropdown menu (called ComboBox). You should improve the usability and apply the following changes.

1. **Create one Textfield**
	* Add one unique ``javafx.scene.control.TextField`` with ``fx:id="textField"`` into the file **RootLayout.fxml** using the SceneBuilder application for the matriculation number
	* Add an attribute ``textField`` of type ``javafx.scene.control.TextField`` into **MainViewController.java** using the ``@FXML`` annotation
	* Add the following code into the ``initialize(...)`` method to add a listener to the ``textField`` that is invoked each time the user enters a ``newValue``:
	```
	textField.textProperty().addListener((observable, oldValue, newValue) -> {
	    validate(newValue);
	});
	``` into **MainViewController.java**

	
2. **Delete all Comboboxes**
	* Delete all 8 entries of type ``<ComboBox.../>``es in **RootLayout.fxml**
	* Delete all 8 attributes **m1, ..., m8** of type ``javafx.scene.control.ComboBox`` in **MainViewController.java**
	* Delete the method ``comboBoxValueChanged()`` in **MainViewController.java**
	* Detete the setup of the combo boxes in the method ``initialize(...)`` in **MainViewController.java**

	
3. **Test the validation of the matriculation number**
	* The code above already invokes ``public void validate(String matricelNumber)``
		* The length of the matriculation number should be exactly 8 digits
		* The matriculation number should only contain digits
	* Start the Java app using the ``Main class`` and test if the behavior is correct
