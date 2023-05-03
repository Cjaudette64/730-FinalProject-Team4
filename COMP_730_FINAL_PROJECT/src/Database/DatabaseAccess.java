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

    public boolean runLoginQuery(String username, String password) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            if (connection == null) {
                return false;
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


    public void InterfaceEventViewer() throws Exception
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
    } //end InterfaceEventViewer

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
           
            System.out.println("Ticket purchase successful!");

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

    public void EventInterfaceEventInsert() throws Exception
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            if (connection == null) {
                return;
            }

            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/final_project730?" + connection);
            Statement dbStatement = dbConnection.createStatement();
            dbStatement.executeUpdate(prepStatement);
           
            System.out.println("Event creation successful!");

            dbStatement.close();
            dbConnection.close();
        } catch (Exception e)
        {
            throw e;
        }
    } //end EventInterfaceEventInsert

    public void EventInterfaceEventUpdate() throws Exception
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            if (connection == null) {
                return;
            }

            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/final_project730?" + connection);
            Statement dbStatement = dbConnection.createStatement();
            dbStatement.executeUpdate(prepStatement);
           
            System.out.println("Event information update successful!");

            dbStatement.close();
            dbConnection.close();
        } catch (Exception e)
        {
            throw e;
        }
    } //end EventInterfaceEventUpdate


} //end DatabaseAccess
