package Database;

import java.sql.*;
import java.util.Scanner;

public class DatabaseAccess {
    private final String connection;
    private final String prepStatement;

    public DatabaseAccess(String connection, String prepStatement) {
        this.connection = connection;
        this.prepStatement = prepStatement;
    }

    public void runInsertQuery() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            if (connection == null || prepStatement == null) {
                return; // all are needed to write to the db efficiently and securely
            }

            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/final_project730?" + connection); // rename final_project730 to your db name

            Statement dbStatement = dbConnection.createStatement();

            PreparedStatement dbPreparedStatement = dbConnection.prepareStatement(prepStatement);

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the EventID: ");
            int eventId = scanner.nextInt();
            dbPreparedStatement.setInt(1, eventId);

            System.out.print("Enter the UserID: ");
            int userId = scanner.nextInt();
            dbPreparedStatement.setInt(2, userId);

            scanner.nextLine(); // Consume the newline character left over by scanner.nextInt()

            System.out.print("Enter the TicketName (Basic - 1, Mid - 2, FrontRow - 3, Box - 4): ");
            String ticketName = scanner.nextLine();
            dbPreparedStatement.setString(3, ticketName);

			System.out.print("Enter total number of seat tickets: ");
			double ticketNum = scanner.nextInt();
			double ticketPrice = 0.0;
			if (ticketName.equals("Basic") || ticketName.equals("1")) {
				ticketPrice = 75.00 * ticketNum;
			}
			if (ticketName.equals("Mid") || ticketName.equals("2")) {
				ticketPrice = 125.00 * ticketNum;
			}
			if (ticketName.equals("FrontRow") || ticketName.equals("3")) {
				ticketPrice = 200.00 * ticketNum;
			}
			if (ticketName.equals("Box") || ticketName.equals("4")) {
				ticketPrice = 500.00 * ticketNum;
			}
			dbPreparedStatement.setDouble(4, ticketPrice);
			

            scanner.nextLine(); // Consume the newline character left over by scanner.nextDouble()

            System.out.print("Enter the AddOns (comma-separated list): ");
            String addons = scanner.nextLine();
            dbPreparedStatement.setString(5, addons);

            System.out.print("Enter the AddOnsCost: ");
            double addonsCost = scanner.nextDouble();
            dbPreparedStatement.setDouble(6, addonsCost);

            dbPreparedStatement.executeUpdate();

            ResultSet resSet = dbStatement.executeQuery("SELECT * FROM Tickets");

            while (resSet.next()) {
                int resEventID = resSet.getInt("EventID");
                int resUserID = resSet.getInt("UserID");
                String resTicketName = resSet.getString("TicketName");
                Double resTicketPrice = resSet.getDouble("TicketPrice");
                String resAddOns = resSet.getString("AddOns");
                Double resAddOnsCost = resSet.getDouble("AddOnsCost");

                System.out.println(resEventID + ", " + resUserID + ", " + resTicketName + ", " + resTicketPrice + ", " + resAddOns + ", " + resAddOnsCost);
            }

            dbPreparedStatement.close();
            dbStatement.close();
            dbConnection.close();
        } catch (Exception e) {
            throw e;
        }
    }
}
