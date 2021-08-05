package oopproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddCourseController implements ChangeScene{

	@FXML
    public TextField textcoursecode;

    @FXML
    public TextField txt_CourseName;

    @FXML
    public TextField txt_CreditHour;
	
    int index = -1;
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	Main main = new Main();
	
	public void Add() {
		
		con= MySQLConnect.ConnectDB();
		String sql = " insert into courses(CourseCode,CourseName,CreditHour)values(?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			
			pst.setString(1, textcoursecode.getText());
			pst.setString(2, txt_CourseName.getText());
			pst.setString(3, txt_CreditHour.getText());
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Course Detail Add Success");
			
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
