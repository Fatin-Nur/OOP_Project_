package oopproject;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HomePage implements ChangeScene{
	
	Main main = new Main();
	
    @FXML
    public BorderPane pane;

    @FXML
    public MenuItem hmMenu;

    @FXML
    public MenuItem sc_Edit;

    @FXML
    public MenuItem sc_Show;

    @FXML
    public MenuItem AboutMenu;
    
    @FXML
    public Button logoutButton;

    @FXML
    public void displayAbout(ActionEvent event) throws IOException {
    	
    	main.changeScene("AboutScene.fxml");

    }

    @FXML
    public void displayHomePage(ActionEvent event) throws IOException {

    	main.changeScene("/HomePageScene.fxml");

    }


    @FXML
    public void sc_DisplayEdit(ActionEvent event) throws IOException {
    	
    	main.changeScene("/EditScoreScene.fxml");

    }

    @FXML
    public void sc_DisplayShow(ActionEvent event) throws IOException {
    	
    	main.changeScene("DisplayScoreScene.fxml");

    }
    
    @FXML
    public void studentDisplayAdd(ActionEvent event) throws IOException {
    	
    	main.changeScene("/AddStudent.fxml");

    }
    
    @FXML
    public void studentDisplayManage(ActionEvent event) throws IOException {
    	
    	main.changeScene("/ManageStudent.fxml");

    }
    
    @FXML
    public void courseDisplayManage(ActionEvent event) throws IOException {
    	
    	main.changeScene("/ManageCourse.fxml");

    }
    
    @FXML
    public void courseDisplayAdd(ActionEvent event) throws IOException {
    	
    	main.changeScene("/Addcouurse.fxml");

    }
  
    	
    

}
