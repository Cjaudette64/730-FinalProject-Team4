package Database;

public class DatabaseAccessBuilder {
	private String connection = null;
	private String prepStatement = null;
	
	public DatabaseAccessBuilder setConnection(String connection) {
		this.connection = connection;
		return this;
	} //end setConnection
	
	public DatabaseAccessBuilder setPreparedStatement(String prepStatement) {
		this.prepStatement = prepStatement;
		return this;
	} //end setPreparedStatement
	
	
	public DatabaseAccess build() {
		return new DatabaseAccess(connection, prepStatement);
	} //end build
	
} //end DatabaseAccessBuilder