package DataLayer;


import LogicLayer.CustomerInformation;

import java.sql.*;

/**
 * Created by Thomas on 06-05-2017.
 */
public class WriteToDatabase {
// Our database stuff
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/costumerregistry";

    //  Database credentials
    static final String USER = "user";
    static final String PASS = "root";
            // 1. Function
    public void writeCustomer(CustomerInformation customerInformation){
        Connection conn = null;
        Statement stmt = null;


        try {
            //2. Connection
            Class.forName("com.mysql.jdbc.Driver");

           /* String DB_Url = System.getProperty("DJDBC_CONNECTION_STRING");
            String DB_User = System.getProperty("DJDBC_USER");
            String DB_Password = System.getProperty("DJDBC_PASSWORD");
            String DB_Connection_String = DB_Url + "?user=" + DB_User + "&password=" + DB_Password;*/
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //conn = DriverManager.getConnection(DB_Connection_String);

            //3. Execute Query
            stmt = conn.createStatement();
            String sql = "INSERT INTO costumerregistry.costumer(idCostumer, Customer_name, Costumer_adress, Customer_date, Costumer_Debitor, Costumer_payment)"+
                    "VALUES('"+customerInformation.getrCustomerNumber()+"','"+
                    customerInformation.getName()+"','"+customerInformation.getAddress()+"','"+customerInformation.getDate()+"'," +
                    "'"+customerInformation.getDebitor()+"','"+customerInformation.getPrice()+"');";
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
