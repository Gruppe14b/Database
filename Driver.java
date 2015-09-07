package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import GUI.Brugere;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class Driver {
	
	//Fields
	private ArrayList<Brugere> array = new ArrayList<Brugere>();
	
public void readFromDatabase() {

	try {

		// 0.1 Make Java project called DatabaseExample

		// 0.2 Install MySQL jar file and copy into folder "lib" then write
		// code

		// 1. Get a connection to database
		Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8889/a", "root", "root");

		// 2. Create a statement
		Statement myStatement = (Statement) myConn.createStatement();

		// 3.2 Execute Select SqL state
		ResultSet myRs = myStatement.executeQuery("SELECT * FROM Member");

		// 4. Process the result set
		while (myRs.next()) {
			array.add(new Brugere(myRs.getInt("id"), 
					myRs.getString("fornavn"), myRs.getString("efternavn"),
					myRs.getInt("alder")));
		}


		// 5. Close connection
		myConn.close();

	} catch (Exception ex) {
		System.out.println("Error: " + ex);
	}
}

public void writeToDatabase(String fornavn, String efternavn, int alder) {
	
	try {
		Connection myConn =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8889/a", "root", "root");

		Statement myStatement = (Statement) myConn.createStatement();

		myStatement.executeUpdate("INSERT INTO Member"
				+ "(fornavn, efternavn, alder)" + "VALUES ('" + fornavn
					+ "', '" + efternavn + "', '" + alder + "')" + ";");
	
		myConn.close();
	
	} catch (SQLException e) {e.printStackTrace();}
}

public ArrayList<Brugere> hentBrugere() {
	readFromDatabase();
	return (array);
}

public void deleteFromDatabase(int id) {
	
	
	
	try {
	Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8889/a", "root", "root");
	
	Statement myStatement = (Statement) myConn.createStatement();
	
	String selectQuery = "SELECT * FROM Member WHERE id = " + id;
	ResultSet myRs = myStatement.executeQuery(selectQuery);
	
	if(!myRs.next()) {
		JOptionPane.showMessageDialog(null, "Ingen brugere med dette id eksisterer", "Error", JOptionPane.ERROR_MESSAGE);
	}
	else {
		String ps = myRs.getString("fornavn") + " " + myRs.getString("efternavn");
		String query = "DELETE FROM Member WHERE id = " + id;
		myStatement.executeUpdate(query);
		JOptionPane.showMessageDialog(null, "Brugeren: " + ps + "Er nu slettet fra databasen", "Error", JOptionPane.INFORMATION_MESSAGE);
	}
	myConn.close();
	
	} catch (SQLException e) {e.printStackTrace();}
	

}


//END OF CLASS
}
	
		

