package oopproject;

import java.io.IOException;

import javafx.event.ActionEvent;

public interface ChangeScene {
	
	
	public void displayAbout(ActionEvent event) throws IOException;
	public void displayHomePage(ActionEvent event) throws IOException;
	public void sc_DisplayEdit(ActionEvent event) throws IOException;
	public void sc_DisplayShow(ActionEvent event) throws IOException;
	public void studentDisplayAdd(ActionEvent event) throws IOException;
	public void studentDisplayManage(ActionEvent event) throws IOException;
	public void courseDisplayManage(ActionEvent event) throws IOException;
	public void courseDisplayAdd(ActionEvent event) throws IOException;

}
