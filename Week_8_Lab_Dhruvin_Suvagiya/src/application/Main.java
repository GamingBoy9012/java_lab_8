package application;

import static javafx.geometry.Pos.CENTER;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();

		Label title = new Label("College student service");
		Label userlabel = new Label("JavaFX lab");
		HBox header = new HBox(title, userlabel);
		header.setAlignment(CENTER);
		header.setPadding(new Insets(15));
		header.setStyle("fx-background-color: #dceeff;");

		// navigation buttons
		Button dashboardButton = new Button("Dashboard");
		Button registrationButton = new Button("Registration");
		Button coursesButton = new Button("Courses");
		Button helpButton = new Button("Help");

		VBox left = new VBox(15, dashboardButton, registrationButton, coursesButton, helpButton);

		left.setPadding(new Insets(20));
		left.setAlignment(Pos.TOP_CENTER);

		// registration form fields
		TextField idField = new TextField();
		TextField nameField = new TextField();
		TextField emailField = new TextField();
		TextField programField = new TextField();

		// gridpane form
		GridPane form = new GridPane();
		form.setHgap(15);
		form.setVgap(15);

		form.add(new Label("Student ID:"), 0, 0);
		form.add(idField, 1, 0);
		form.add(new Label("Full Name:"), 0, 1);
		form.add(nameField, 1, 1);
		form.add(new Label("Email:"), 0, 2);
		form.add(emailField, 1, 2);
		form.add(new Label("Program:"), 0, 3);
		form.add(programField, 1, 3);
		form.setAlignment(CENTER);

		// buttons
		Button registerButton = new Button("Register");
		Button clearButton = new Button("Clear");
		HBox buttons = new HBox(10, registerButton, clearButton);
		buttons.setAlignment(CENTER);
		buttons.setPadding(new Insets(10));

		// status message after button clickking
		Label statusLabel = new Label();

		// center form fields
		Label formTitle = new Label("Student Registration");
		VBox center = new VBox(12, formTitle, form, buttons, statusLabel);
		center.setPadding(new Insets(20));
		center.setAlignment(CENTER);

		// Register button
		registerButton.setOnAction(event -> {

			String id = idField.getText().trim();
			String name = nameField.getText().trim();
			String email = emailField.getText().trim();
			String program = programField.getText().trim();

			if (id.isEmpty() || name.isEmpty() || email.isEmpty() || program.isEmpty()) {

				statusLabel.setText("Please fill in all required fields.");

			} else {

				statusLabel.setText("Registration accepted for " + name);
			}
		});
		clearButton.setOnAction(event -> {

			idField.clear();
			nameField.clear();
			emailField.clear();
			programField.clear();

			statusLabel.setText("Form cleared.");
		});

		// Scene and stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("ShowGridPane"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		pane.setTop(header);
		pane.setLeft(left);
		pane.setCenter(center);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
