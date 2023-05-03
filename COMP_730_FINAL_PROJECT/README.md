# EVENT TICKET SYSTEM
## Table of Contents
1. [Welcome and Getting Started](#welcome-and-getting-started)
2. [VS Code Setup](#vs-code-setup)
3. [MySQL Setup](#mysql-setup)
4. [Cloning the Git Repository](#cloning-the-git-repository)
5. [Configuring Classpath](#configuring-classpath)
6. [Prepping the Database](#prepping-the-database)
7. [Last Steps](#last-steps)
    
***
### Welcome and Getting Started
Welcome to the Event Ticket System! This document serves as the main hub for information regarding our directories and subdirectories as well as steps you will need to take in order to run the application apporpriately. Please follow all of the below steps to ensure that you have everything you need to run our application. 
    
***
### VS Code Setup
    
Before you begin, please make sure you have the following extensions to ensure you are able to run all of the necessary components: 
    
* Debugger for Java
* Extension Pack for Java
* Maven for Java
* Project Manager for Java
* Test Runner for Java
* Language Support for Java(TM) by Red Hat
    
***   
### MySQL Setup
    
Before you can run any of the code, you will need to ensure that you have MySQL Workbench installed and setup with a root connection. When creating a connection, you need to make sure it is set to your local host IP (127.0.0.1). If you need to install MySQL Workbench, you can do so [here](https://dev.mysql.com/downloads/workbench/). Be sure to install the the four featues they provide.
    
***
### Cloning the Git Repository
    
In VS Code, follow these steps to open our repository:
1. Launch VS Code
2. In the upper tool bar, select **TERMINAL** and select **NEW TERMINAL**
3. On the right hand side of the terminal, select the **+** symbol and select **GIT BASH**
4. In the terminal, navigate using *cd* to the folder where you want the repository
5. Use the following command: *git clone https://github.com/Cjaudette64/730-FinalProject-Team4.git*
6. In the upper tool bar, select **FILE > OPEN FOLDER...** and select the folder where you cloned the repository
    
The full repository will appear on the right side EXPLORER tab (if this is not visible, use *CTRL + SHIFT + E*).
    
***
### Configuring Classpath
    
This is critical in order for our code to communicate with MySQL. To do this, follow these steps:
1. In the EXPLORER view, open the section called **JAVA PROJECTS**
2. Right click on the root project folder *730-FinalProject-Team4*
3. Select **Configure Classpath**
4. Under the *Path* section, navigate to this location: c:\Program Files (x86)\MySQL\Connector J 8.0
5. Select *mysql-connector-j-8.0.33.jar* and click **SELECT JAR FILE**

***
### Prepping the Database
    
Within our code, there is a subdirectory called *db_src*. Before you can run the code, you need to run this code in your SQL workbench first once you finished logging into your connection. You can run this by clicking the thunderbolt in the toolbar.
    
To ensure you have at least 1 user, please run the following code in a separate query tab (To do this, go to MySQL Workbench and go to File > New Query Tab, paste the below code, and run AFTER you run the **dbCreation.sql**):

> USE final_project730;

> INSERT INTO TicketEvents (EventName, EventCapacity) VALUES("TestEvent2", 333);
> SELECT * FROM TicketEvents;

> INSERT INTO Users (Username, UserPass) VALUES("root", "YES");
> SELECT * FROM Users;

> INSERT INTO Tickets (EventID, Username, TicketName, TicketPrice, AddOns, AddOnsCost) VALUES(1, "root", "Box", 200.99, 'Food,Merch', 148.50);
> SELECT * FROM Tickets;

> SELECT TicketEvents.EventName, Tickets.Username, Tickets.TicketName, Tickets.TicketPrice, Tickets.AddOns, Tickets.AddOnsCost
> FROM Tickets
> INNER JOIN TicketEvents ON Tickets.EventID = TicketEvents.EventID
> WHERE Tickets.Username = "root";

***
    
    
### Last Steps
    
The last step before you can run our code is to change the following files and lines to have YOUR root password. These need to be changed or it will NOT be able to access your connection:
    
> DatabaseLogin.java      
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LINE 17: "user=root&password=tY77nM-8o1gh" to "user=root&password=<!YOUR PASSWORD HERE!>"

> UserInterface.java      
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LINE 36: "user=root&password=tY77nM-8o1gh" to "user=root&password=<!YOUR PASSWORD HERE!>"

