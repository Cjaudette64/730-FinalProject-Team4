package Database;

import java.sql.*;

public class DatabaseAccess {
	private final String connection;
	private final String statement;
	private final String prepStatement;
	private final String resSet;
	
	public DatabaseAccess(String connection, String statement, String prepStatement, String resSet) {
		//
		this.connection = connection;
		this.statement = statement;
		this.prepStatement = prepStatement;
		this.resSet = resSet;

	}
	
	public void runQuery() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			

			if (connection == null)
			{
				return; //no connection means we can't connection to the database
			}

			Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/feedback?"+connection);

			Statement dbStatement = dbConnection.createStatement();

			PreparedStatement dbPreparedStatement = dbConnection.prepareStatement(prepStatement); 
			//write a simple select query to test above, and create a write function to output to console

			//close all of the statement(s) and the connection(s) here instead, since we changed to having string instead of the sql data-types which probably wouldn't work
		}
		catch (Exception e) {
			throw e;
		} 
	} //end runQuery
	
} //end DatabaseAccess