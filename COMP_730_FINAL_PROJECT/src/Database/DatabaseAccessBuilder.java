package Database;

import java.sql.*;

public class DatabaseAccessBuilder {
	private String connection = null;
	private String statement = null;
	private String prepStatement = null;
	private String resSet = null;
	
	public DatabaseAccessBuilder setConnection(String connection) {
		this.connection = connection;
		return this;
	} //end setConnection
	
	public DatabaseAccessBuilder setStatement(String statement) {
		this.statement = statement;
		return this;
	} //end setStatement
	
	public DatabaseAccessBuilder setPreparedStatement(String prepStatement) {
		this.prepStatement = prepStatement;
		return this;
	} //end setPreparedStatement
	
	public DatabaseAccessBuilder setResultSet(String resSet) {
		this.resSet = resSet;
		return this;
	} //end setResultSet
	
	public DatabaseAccess build() {
		return new DatabaseAccess(connection, statement, prepStatement, resSet);
	} //end build
	
} //end DatabaseAccessBuilder