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
            String sql = "INSERT INTO customer" + "VALUES(CAST(customerInformation.getInvoice_number AS int(10)), costumerInformation.getDate," +
                    "CAST(costumerInformation.getrCustomerNumber AS int(10), CAST(costumerInformation.getdebitor AS int(10), customerInformation.getname," +
                    "costumerInformation.getaddress, CAST(costumerInformation.getprice AS int(10))";
            System.out.println(sql);
            stmt.execute(sql);

            //4. Close everything up again, hopefully this works :D
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try


    }



}
