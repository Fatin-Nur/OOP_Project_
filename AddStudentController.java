package oopproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddStudentController implements ChangeScene {

	  	@FXML
	    public TextField txt_FirstName;

	    @FXML
	    public TextField txt_LastName;

	    @FXML
	    public TextField txt_Id;

	    @FXML
	    public TextField txtAdress;
	    
	    @FXML
	    public TextField txt_Gender;

	    @FXML
	    public TextField textphonenum;
	    
	    Main main = new Main();

	    int index = -1;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
	
		public void Add() {
		
		con= MySQLConnect.ConnectDB();
		String sql = " insert into students(Id,firstname,LastName,Gender,PhoneNum,Adress)values(?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			
			pst.setString(1, txt_Id.getText());
			pst.setString(2, txt_FirstName.getText());
			pst.setString(3, txt_LastName.getText());
			pst.setString(4, txt_Gender.getText());
			pst.setString(5, textphonenum.getText());
			pst.setString(6, txtAdress.getText());
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Student Add Success");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

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
