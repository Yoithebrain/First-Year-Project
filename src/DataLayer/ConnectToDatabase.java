package DataLayer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Thomas on 16-05-2017.
 */
public class ConnectToDatabase {
    // Our database stuff
    private static Connection conn;
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/costumerregistry";

//    //  Database credentials
    private static final String USER = "JWock";
    private static final String PASS = "Madhat";

    public static Connection connect() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }catch (ClassNotFoundException notFoundException) {
            System.err.println("Error: " + notFoundException.getMessage());
        }catch(InstantiationException ie) {
            System.err.println("Error: " + ie.getMessage());
        }catch (IllegalAccessException iae){
            System.err.println("Error: " + iae.getMessage());
        }

        conn= (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        return conn;

    }

    }

    //Source: http://blog.ngopal.com.np/2011/10/19/dyanmic-tableview-data-from-database/comment-page-1/


