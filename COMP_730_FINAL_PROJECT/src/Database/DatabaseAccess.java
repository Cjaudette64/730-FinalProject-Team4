package Database;

import java.sql.*;

public class DatabaseAccess {
	private final Connection connection;
	private final Statement statement;
	private final PreparedStatement prepStatement;
	private final ResultSet resSet;
	
	public DatabaseAccess(Connection connection, Statement statement, PreparedStatement prepStatement, ResultSet resSet) {
		//
		this.connection = connection;
		this.statement = statement;
		this.prepStatement = prepStatement;
		this.resSet = resSet;

	}
	
	public void runQuery() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			/*	
			 	May have to adjust the Builder class and/or remove it entirely depending on how passing these SQL import keywords through works
			 	connection -> setup through the DatabaseAccessBuilder class
				statement -> setup through the DatabaseAccessBuilder class ( statement = connect.createStatement() )
				. . .
			*/
		}
		catch (Exception e) {
			throw e;
		} finally {
			close(); //close the connection to the database once done with query
		}
	} //end runQuery
	
	public void close() {
		try {
			//implement closing of the resSet, statement(s), and connection 
			//check if they're null first before trying to close them
		} catch (Exception e) {
			throw e;
		}
	} //end close
	
} //end DatabaseAccess