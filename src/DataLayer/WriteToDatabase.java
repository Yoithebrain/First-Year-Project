package DataLayer;


import LogicLayer.CustomerInformation;

import java.sql.*;

/**
 * Created by Thomas on 06-05-2017.
 */
public class WriteToDatabase {

            // 1. Function
    public void writeCustomer(CustomerInformation customerInformation){
        Connection conn = null;
        Statement stmt = null;


        try {
            //2. Connection
            Class.forName("com.mysql.jdbc.Driver");

            String DB_Url = System.getProperty("JDBC_CONNECTION_STRING");
            String DB_User = System.getProperty("JDBC_USER");
            String DB_Password = System.getProperty("JDBC_PASSWORD");
            String DB_Connection_String = DB_Url + "?user=" + DB_User + "&password=" + DB_Password;

            conn = DriverManager.getConnection(DB_Connection_String);

            //3. Execute Query
            stmt = conn.createStatement();
            String sql = "INSERT INTO customer" + "VALUES(customerInformation.get)";

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



}
