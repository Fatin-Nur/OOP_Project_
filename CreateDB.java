package oopproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
	
	public static void createNewDatabase(String filename) {
		String url = "jdbc:sqlite:C:/Users/User/Documents/UTP/4.0 part 3/OBJECT ORIENTED PROGRAMMING/project/" + filename;
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(url);
			
			if(con!= null) {
				System.out.println(" A new database has been created");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		createNewDatabase("Project2.db");
		createNewTable();
	}

}