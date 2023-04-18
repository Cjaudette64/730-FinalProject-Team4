package Database;

import java.sql.*;

public class DatabaseAccess {
	private final String connection;
	private final String prepStatement;
	
	public DatabaseAccess(String connection, String prepStatement) {
		//
		this.connection = connection;
		this.prepStatement = prepStatement;

	}
	

	//GOING TO NEED TO RE-WRITE THIS TO ALLOW FOR PARAMETERS FOR INSERTION INTO THE DATABASE
	public void runInsertQuery() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			if (connection == null || prepStatement == null)
			{
				return; //all are needed to write to the db efficiently and securely
			}

			Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/final_project730?"+connection); //rename final_project730 to your db name
			
			Statement dbStatement = dbConnection.createStatement();

			PreparedStatement dbPreparedStatement = dbConnection.prepareStatement(prepStatement);

			//"INSERT INTO Tickets (EventID, UserID, TicketName, TicketPrice, AddOns, AddOnsCost) VALUES(?, ?, ?, ?, ?, ?)"
			//Structure: TicketID (AUTO-INCREMENT DON'T PASS THRU), EventID, UserID, TicketName, TicketPrice, AddOns (SET TYPE), AddOnsCost

			dbPreparedStatement.setInt(1, 1); //this is the EventID
			dbPreparedStatement.setInt(2, 1); //this is the UserID
			dbPreparedStatement.setString(3, "Seat - 2"); //this is ticket name
			dbPreparedStatement.setDouble(4, 20.10); //this is ticket price
			dbPreparedStatement.setString(5, "Food,Park"); //this is AddOns
			dbPreparedStatement.setDouble(6, 30.10); //this is AddOnsCost
			//System.out.println(dbPreparedStatement);
			dbPreparedStatement.executeUpdate();
			ResultSet resSet = dbPreparedStatement.executeQuery();

			while (resSet.next())
			{
				int resEventID = resSet.getInt("EventID");
				int resUserID = resSet.getInt("UserID");
				String resTicketName = resSet.getString("TicketName");
				Double resTicketPrice = resSet.getDouble("TicketPrice");
				String resAddOns = resSet.getString("AddOns");
				Double resAddOnsCost = resSet.getDouble("AddOnsCost");

				System.out.println(resEventID + "\n" + resUserID + "\n" + resTicketName + "\n" + resTicketPrice + "\n" + resAddOns + "\n" + resAddOnsCost); //might want to separate this into another function ???
			}

			dbPreparedStatement.close();
			dbStatement.close();
			dbConnection.close();
		}
		catch (Exception e) {
			throw e;
		} 
		finally {

		}
	} //end runQuery
	

} //end DatabaseAccess