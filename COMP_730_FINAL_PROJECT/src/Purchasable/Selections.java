package Purchasable;

import java.sql.*;
import java.util.Scanner;

public class Selections {
    private final String connection;
    private final String prepStatement;

    public Selections(String connection, String prepStatement) {
        this.connection = connection;
        this.prepStatement = prepStatement;
    }

    public void ticketSelection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            if (connection == null || prepStatement == null) {
                return; // all are needed to write to the db efficiently and securely
            }

            Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/final_project730?" + connection); // rename final_project730 to your db name
            Statement dbStatement = dbConnection.createStatement();
            PreparedStatement dbPreparedStatement = dbConnection.prepareStatement(prepStatement);


            Scanner userInput = new Scanner(System.in);

            System.out.print("Enter the EventID: ");
            int eventId = userInput.nextInt();
            dbPreparedStatement.setInt(1, eventId);

            System.out.print("Enter the name: ");
            String Username = userInput.nextLine();
            dbPreparedStatement.setString(2, Username);

            /*userInput.nextLine(); */

            System.out.println("Select a seating type: ");
            System.out.println("1. Basic");
            System.out.println("2. Mid-Level");
            System.out.println("3. Front-Row");
            System.out.println("4. Box-Office");
            int seatingChoice = userInput.nextInt();

            System.out.println("How many seats would you like?: ");
            double seatingCount = userInput.nextDouble();
            double seatingCost = 0.00;

            switch (seatingChoice) {
                case 1:
                    dbPreparedStatement.setString(3, "Basic");
                    seatingCost = seatingCount * 75.00;
                    dbPreparedStatement.setDouble(4, seatingCost);
                    break;
                case 2:
                    dbPreparedStatement.setString(3, "Mid");
                    seatingCost = seatingCount * 125.00;
                    dbPreparedStatement.setDouble(4, seatingCost);
                    break;
                case 3:
                    dbPreparedStatement.setString(3, "FrontRow");
                    seatingCost = seatingCount * 200.00;
                    dbPreparedStatement.setDouble(4, seatingCost);
                    break;
                case 4:
                    dbPreparedStatement.setString(3, "Box");
                    seatingCost = seatingCount * 500.00;
                    dbPreparedStatement.setDouble(4, seatingCost);
                    break;
                default:
                    System.out.println("Invalid choice, selecting Standard seating");
                    dbPreparedStatement.setString(3, "Basic");
                    seatingCost = seatingCount * 75.00;
                    dbPreparedStatement.setDouble(4, seatingCost);

            }

            // userInput.nextLine(); // Consume the newline character left over by scanner.nextDouble()
            
            // Ask the user if they want parking and merchandise add-ons
            String eventExtras = "";
            double cost = 0.00;
            System.out.println("Do you want parking? (y/n)");
            boolean parking = userInput.next().equalsIgnoreCase("y");

            System.out.println("Do you want merchandise? (y/n)");
            boolean merchandise = userInput.next().equalsIgnoreCase("y");

            System.out.println("Do you want food? (y/n)");
            boolean food = userInput.next().equalsIgnoreCase("y");

            if (parking == true) {
                eventExtras = eventExtras + "Park,";
                cost += 25.00;
            }
            if (merchandise == true) {
                eventExtras = eventExtras + "Merch,";
                cost += 75.00;
            }
            if (food == true) {
                eventExtras = eventExtras + "Food,";
                cost += 40.00;
            }
            
            dbPreparedStatement.setString(5, eventExtras);
            dbPreparedStatement.setDouble(6, cost);

            userInput.close();

            dbPreparedStatement.executeUpdate();

            ResultSet resSet = dbStatement.executeQuery("SELECT * FROM Tickets");

            while (resSet.next()) {
                int resEventID = resSet.getInt("EventID");
                String resUsername = resSet.getString("Username");
                String resTicketName = resSet.getString("TicketName");
                Double resTicketPrice = resSet.getDouble("TicketPrice");
                String resAddOns = resSet.getString("AddOns");
                Double resAddOnsCost = resSet.getDouble("AddOnsCost");

                System.out.println(resEventID + ", " + resUsername + ", " + resTicketName + ", " + resTicketPrice + ", " + resAddOns + ", " + resAddOnsCost);
            }

            dbPreparedStatement.close();
            dbStatement.close();
            dbConnection.close();
        } catch (Exception e) {
            throw e;
        }
    }
}