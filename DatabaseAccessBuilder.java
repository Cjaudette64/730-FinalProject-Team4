package finalProjectTeam4;

import java.sql.*;

public class DatabaseAccessBuilder {
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement prepStatement = null;
	private ResultSet resSet = null;
	
	public DatabaseAccessBuilder setConnection(String connection) {
		try {
			this.connection = DriverManager.getConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this;
	} //end setConnection
	
	public DatabaseAccessBuilder setStatement(Statement statement) {
		this.statement = statement;
		return this;
	} //end setStatement
	
	public DatabaseAccessBuilder setPreparedStatement(PreparedStatement prepStatement) {
		this.prepStatement = prepStatement;
		return this;
	} //end setPreparedStatement
	
	public DatabaseAccessBuilder setResultSet(ResultSet resSet) {
		this.resSet = resSet;
		return this;
	} //end setResultSet
	
	public DatabaseAccess build() {
		return new DatabaseAccess(connection, statement, prepStatement, resSet);
	} //end build
	
} //end DatabaseAccessBuilder
