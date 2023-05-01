package Database;
import Database.DatabaseAccess;
import Database.DatabaseAccessBuilder;

public class DatabaseLogin {
    String username="";
    String password="";

    public DatabaseLogin(String user, String pass){
        this.username = user;
        this.password = pass;

    }

    public boolean tryLogin() throws Exception{
        DatabaseAccess dbTest = new DatabaseAccessBuilder()
        .setConnection("user=root&password=tY77nM-8o1gh")//rename root and password to your username and password for the database login, NOT USER TABLE (SET AS CAMERONS INFO)
        .setPreparedStatement("")
        .build();
        try {
            return dbTest.runLoginQuery(username, password);
        }
        catch (Exception e) {
            throw e;
        }

    }
}

    

