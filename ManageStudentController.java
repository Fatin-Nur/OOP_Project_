package oopproject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import oopproject.MySQLConnect;
import oopproject.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ManageStudentController implements Initializable, ChangeScene,Operations{

	@FXML
    public TableView<Student> table_student;

    @FXML
    public TableColumn<Student, Integer> col_Id;

    @FXML
    public TableColumn<Student, String> col_FirstName;

    @FXML
    public TableColumn<Student, String> col_LastName;

    @FXML
    public TableColumn<Student, String> col_Gender;

    @FXML
    public TableColumn<Student, String> col_PhoneNum;

    @FXML
    public TableColumn<Student, String> col_Adress;
    
    @FXML
    public TextField txt_FirstName;

    @FXML
    public TextField txt_LastName;

    @FXML
    public TextField txt_Id;

    @FXML
    public TextField txt_Adress;
    
    @FXML
    public TextField txt_Gender;

    @FXML
    public TextField txt_PhoneNum;
    
    Main main = new Main();

   
    
      
	ObservableList<Student> ListOfStudent;
	
	
	int index = -1;
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	private MouseEvent event;
    
	public void Add() {
		
		con= MySQLConnect.ConnectDB();
		String sql = " insert into students(Id,firstname,LastName,Gender,PhoneNum,Adress)values(?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			
			pst.setString(1, txt_Id.getText());
			pst.setString(2, txt_FirstName.getText());
			pst.setString(3, txt_LastName.getText());
			pst.setString(4, txt_Gender.getText());
			pst.setString(5, txt_PhoneNum.getText());
			pst.setString(6, txt_Adress.getText());
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Student Add Success");
			UpdateTable();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	@FXML
    public void getSelected (MouseEvent event){
		
		index= table_student.getSelectionModel().getSelectedIndex();
		if(index<=-1) {
			return;
		}
		
		txt_Id.setText(col_Id.getCellData(index).toString());
		txt_FirstName.setText(col_FirstName.getCellData(index).toString());
		txt_LastName.setText(col_LastName.getCellData(index).toString());
		txt_Gender.setText(col_Gender.getCellData(index).toString());
		txt_PhoneNum.setText(col_PhoneNum.getCellData(index).toString());
		txt_Adress.setText(col_Adress.getCellData(index).toString());
		
	}
	
	public void Edit() {
		con= MySQLConnect.ConnectDB();
		try {
			
			String value1=txt_Id.getText();
			String value2=txt_FirstName.getText();
			String value3=txt_LastName.getText();
			String value4=txt_Gender.getText();
			String value5=txt_PhoneNum.getText();
			String value6=txt_Adress.getText();
			
			String sql= "update students set Id = '"+value1+"',firstname = '"+value2+"', LastName = '"+value3+
					"',Gender = '"+value4+"',PhoneNum = '"+value5+"',Adress = '"+value6+"' where Id = '"+value1+"' ";
					
			 pst= con.prepareStatement(sql);
		     pst.execute();
		     JOptionPane.showMessageDialog(null, "Edited");
		     UpdateTable();
	           
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null, e);
		}
	}
	
	   public void Remove(){
		    con = MySQLConnect.ConnectDB();
		    String sql = "delete from students where Id = ?";
		        try {
		            pst = con.prepareStatement(sql);
		            pst.setString(1, txt_Id.getText());
		            pst.execute();
		            JOptionPane.showMessageDialog(null, "Removed");
		            UpdateTable();
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null, e);
		        }
		    
		    }
	
	public void   UpdateTable() {
		
		col_Id.setCellValueFactory( new PropertyValueFactory<Student,Integer>("Id"));
		col_FirstName.setCellValueFactory( new PropertyValueFactory<Student,String>("firstname"));
    	col_LastName.setCellValueFactory( new PropertyValueFactory<Student,String>("LastName"));
    	col_Gender.setCellValueFactory( new PropertyValueFactory<Student,String>("Gender"));
    	col_PhoneNum.setCellValueFactory( new PropertyValueFactory<Student,String>("PhoneNum"));
    	col_Adress.setCellValueFactory( new PropertyValueFactory<Student,String>("Adress"));
    	
    	
    	ListOfStudent = MySQLConnect.getDatausers();
    	table_student.setItems(ListOfStudent);
	}
	   
	   
	@FXML
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
