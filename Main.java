package oopproject;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;


public class Main extends Application {
	
	private static Stage stg;
	@Override
	public void start(Stage stage) throws IOException{ 
		
		stg = stage;
		Parent root =FXMLLoader.load(getClass().getResource("/HomePageScene.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Universiti Teknologi PETRONAS Student Information System"); //important
		Image image = new Image("utp.png"); //important
		stage.setScene(scene);
		stage.getIcons().add(image);
		stage.show();
	}

	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		
		stg.getScene().setRoot(pane);
		
	}
	public static void main(String[] args) {
		launch(args);
	}

	
}


