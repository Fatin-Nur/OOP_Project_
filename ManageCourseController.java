package oopproject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ManageCourseController implements Initializable,Operations,ChangeScene{

	
		@FXML
	    public TableView<Course> Table_Course;
		
	    @FXML
	    public TableColumn<Course, String> col_CourseCode;

	    @FXML
	    public TableColumn<Course, Integer> col_CreditHour;

	    @FXML
	    public TableColumn<Course, String> col_CodName;
	    
	    @FXML
	    public TextField textcoursecode;

	    @FXML
	    public TextField txt_CourseName;

	    @FXML
	    public TextField txt_CreditHour;
	   
	    
	    ObservableList<Course> listCourse;
	    
	    int index = -1;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		Main main = new Main();
		 
		public MouseEvent event;
		
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
				UpdateTable();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	    
	    
	    @FXML
	    public void getSelected(MouseEvent event) {

	    	index= Table_Course.getSelectionModel().getSelectedIndex();
	 		if(index<=-1) {
	 			return;
	 		}
	 		
	 		textcoursecode.setText(col_CourseCode.getCellData(index).toString());
	 		txt_CourseName.setText(col_CodName.getCellData(index).toString());
	 		txt_CreditHour.setText(col_CreditHour.getCellData(index).toString());
	 		
	    }
	    
	   
	    public void Edit() {
	    	
	    	con= MySQLConnect.ConnectDB();
			try {
				
				String value1=textcoursecode.getText();
				String value2=txt_CourseName.getText();
				String value3=txt_CreditHour.getText();
								
				String sql= "update courses set CourseCode = '"+value1+"',CourseName = '"+value2+"', CreditHour = '"+value3+"' where CourseCode = '"+value1+"' ";
						
				 pst= con.prepareStatement(sql);
			     pst.execute();
			     JOptionPane.showMessageDialog(null, "Update");
			     UpdateTable();
		           
			} catch (Exception e) {
				 JOptionPane.showMessageDialog(null, e);
			}

	    }

	  
	   public void Remove() {
	    	 con = MySQLConnect.ConnectDB();
			    String sql = "delete from courses where CourseCode = ?";
			        try {
			            pst = con.prepareStatement(sql);
			            pst.setString(1, textcoursecode.getText());
			            pst.execute();
			            JOptionPane.showMessageDialog(null, "Delete");
			            UpdateTable();
			        } catch (Exception e) {
			            JOptionPane.showMessageDialog(null, e);
			        }

	    }

	    public void UpdateTable() {
			
	    	col_CourseCode.setCellValueFactory( new PropertyValueFactory<Course,String>("CourseCode"));
	    	col_CodName.setCellValueFactory( new PropertyValueFactory<Course,String>("CourseName"));
	    	col_CreditHour.setCellValueFactory( new PropertyValueFactory<Course,Integer>("CreditHour"));
	    	    	
	    	listCourse = MySQLConnect.getDataCourses();
	    	Table_Course.setItems(listCourse);
		}
	   
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		 UpdateTable();
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
