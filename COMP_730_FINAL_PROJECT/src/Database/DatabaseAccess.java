package Database;

import java.sql.*;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

public class DatabaseAccess {
    private final String connection;
    private final String prepStatement;

    public DatabaseAccess(String connection, String prepStatement) {
        this.connection = connection;
        this.prepStatement = prepStatement;
    }

    public boolean runLoginQuery(String username, String password) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            if (connection == null) {
                return false; // all are needed to write to the db efficiently and securely
            }

            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/final_project730?" + connection);

            Statement dbStatement = dbConnection.createStatement();

            //PreparedStatement dbPreparedStatement = dbConnection.prepareStatement(prepStatement);

            Scanner scanner = new Scanner(System.in);
        
            ResultSet resSet = dbStatement.executeQuery("SELECT Username, UserPass FROM Users WHERE Username='" +username+"'");
            //if(password.equals(resSet.getString("UserPass"))) {
            //    System.out.println("Login Successful");
            //}

            while (resSet.next()) {
                //int resUserID = resSet.getInt("UserID");
                String resUsername = resSet.getString("Username");
                String resPassword = resSet.getString("UserPass");
                //System.out.println("I get here 1");
                if(password.equals(resPassword)) {
                        System.out.println("Login Successful");
                        return true;
                    }
                else {
                    System.out.println("Incorrect Login Try Again:");
                }
                //System.out.println("I get here");
                System.out.println(resUsername + ", " + resPassword);
            }

        }
        catch (Exception e) {
            throw e;
        }

        return false;

    }

    public void runInsertQuery() throws Exception {             //WE CAN PROBABLY DELETE THIS LATER
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            if (connection == null) {
                return;
            }

            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/final_project730?" + connection);

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
    } //end runInsertQuery


    public void UserInterfaceEventViewer() throws Exception
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            if (connection == null) {
                return;
            }

            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/final_project730?" + connection);
            Statement dbStatement = dbConnection.createStatement();
            ResultSet resSet = dbStatement.executeQuery("SELECT * FROM TicketEvents");
           
            while (resSet.next()) {
                int EventID = resSet.getInt("EventID");
                String EventName = resSet.getString("EventName");
                int EventCap = resSet.getInt("EventCapacity");
                System.out.println(String.format("%d \t\t %s \t\t %d", EventID, EventName, EventCap));
            }

            dbStatement.close();
            dbConnection.close();
        } catch (Exception e)
        {
            throw e;
        }
    } //end UserInterfaceEventViewer

    public void UserInterfaceTicketInsert() throws Exception
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            if (connection == null) {
                return;
            }

            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/final_project730?" + connection);
            Statement dbStatement = dbConnection.createStatement();
            dbStatement.executeUpdate(prepStatement);
           
            System.out.println("Ticket purchase succesful!");

            dbStatement.close();
            dbConnection.close();
        } catch (Exception e)
        {
            throw e;
        }
    } //end UserInterfaceTicketInsert

    public void UserInterfaceTicketViewer() throws Exception
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            if (connection == null || prepStatement == null) {
                return;
            }

            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/final_project730?" + connection);
            Statement dbStatement = dbConnection.createStatement();

            ResultSet resSet = dbStatement.executeQuery(prepStatement);
           
            while (resSet.next()) {
                String eventName = resSet.getString("EventName");
                String Username = resSet.getString("Username");
                String TicketName = resSet.getString("TicketName");
                double TicketPrice = resSet.getDouble("TicketPrice");
                String AddOns = resSet.getString("AddOns");
                double AddOnsCost = resSet.getDouble("AddOnsCost");
                System.out.println(String.format("%s | %s | %s | %.2f | %s | %.2f", eventName, Username, TicketName, TicketPrice, AddOns, AddOnsCost));
            }

            dbStatement.close();
            dbConnection.close();
        } catch (Exception e)
        {
            throw e;
        }
    } //end UserInterfaceTicketViewer

    public void UserInterfaceTicketRefund() throws Exception
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            if (connection == null || prepStatement == null) {
                return;
            }

            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/final_project730?" + connection);
            PreparedStatement dbStatement = dbConnection.prepareStatement(prepStatement);
            dbStatement.executeUpdate();

            System.out.println("Refunded ticket!");
        } catch (Exception e)
        {
            throw e;
        }
    } //end UserInterfaceTicketRefund


} //end DatabaseAccess
