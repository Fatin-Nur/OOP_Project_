package oopproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import oopproject.CreateDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MySQLConnect {

	Connection con= null;
	
	public static Connection ConnectDB() {
		String url = "jdbc:sqlite:C:/Users/User/Documents/UTP/4.0 part 3/OBJECT ORIENTED PROGRAMMING/project/Project2.db";
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url);
			JOptionPane.showMessageDialog(null,"Connection Established");
			createNewTable();
			
			return con;
		} catch (Exception e)
		{
		JOptionPane.showMessageDialog(null,e);
		return null;
		}
	}
public static void createNewTable() {
		
		String url2 = "jdbc:sqlite:C:/Users/User/Documents/UTP/4.0 part 3/OBJECT ORIENTED PROGRAMMING/project/Project2.db";
				
		String sql = "CREATE TABLE IF NOT EXISTS students(\n"
				+ " Id integer PRIMARY KEY, \n"
				+ " firstname text NOT NULL, \n"
				+ " LastName text NOT NULL, \n"
				+ " Gender text NOT NULL, \n"
				+ " PhoneNum text NOT NULL, \n"
				+ " Adress text NOT NULL\n"
				+ ");";
		
		String sql2 = "CREATE TABLE IF NOT EXISTS courses(\n"
				+ " CourseCode text NOT NULL, \n"
				+ " CourseName text NOT NULL, \n"
				+ " CreditHour integer NOT NULL \n"
				+ ");";
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url2);
			
			Statement stmt = con.createStatement();
			stmt.execute(sql);
			stmt.close();
			stmt.execute(sql2);
			
			if(con !=null) {
				System.out.println("A new table has been created");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public static ObservableList<Student> getDatausers(){
			
			ObservableList<Student> list = FXCollections.observableArrayList();
			String url3 = "jdbc:sqlite:C:/Users/User/Documents/UTP/4.0 part 3/OBJECT ORIENTED PROGRAMMING/project/Project2.db";
			String Sql = "SELECT * FROM students";
			try {
				
				Class.forName("org.sqlite.JDBC");
				Connection con= DriverManager.getConnection(url3);
				Statement ps = con.createStatement();
				ResultSet rs = ps.executeQuery(Sql);
//				ps.close();
//				con.close();
							
				while(rs.next()) {
					list.add(new Student(Integer.parseInt(rs.getString("Id")),rs.getString("firstname"),rs.getString("LastName"), rs.getString("Gender"), rs.getString("Adress"), rs.getString("PhoneNum")) );
				}
				
			} catch (Exception e) {
				
			}
			return list;
		}

public static ObservableList<Course> getDataCourses(){
	
	ObservableList<Course> list1 = FXCollections.observableArrayList();
	String url3 = "jdbc:sqlite:C:/Users/User/Documents/UTP/4.0 part 3/OBJECT ORIENTED PROGRAMMING/project/Project2.db";
	String Sql2 = "SELECT * FROM courses";
	try {
		
		Class.forName("org.sqlite.JDBC");
		Connection con= DriverManager.getConnection(url3);
		Statement ps1 = con.createStatement();
		ResultSet rs1 = ps1.executeQuery(Sql2);
//		ps1.close();
//		con.close();
					
		while(rs1.next()) {
			list1.add(new Course(rs1.getString("CourseCode"),rs1.getString("CourseName"),Integer.parseInt(rs1.getString("CreditHour"))) );
		}
		
	} catch (Exception e) {
		
	}
	return list1;
}
}

