package DataLayer;


import LogicLayer.CustomerInformation;

import java.sql.*;

/**
 * Created by Thomas on 06-05-2017.
 */


public class WriteToDatabase extends ConnectToDatabase {
            // 1. Function
    public void writeCustomer(CustomerInformation customerInformation) throws SQLException {

        Connection conn = connect();
        Statement stmt = null;

        try {


            //3. Execute Query
            stmt = conn.createStatement();
            String sql = "INSERT INTO costumerregistry.costumer(idCostumer, Customer_name, Costumer_adress," +
                    " Customer_date, Costumer_Debitor, Costumer_payment)"+
                    "VALUES('"+customerInformation.getrCustomerNumber()+"','"+
                    customerInformation.getName()+"','"+customerInformation.getAddress()+"','"+customerInformation.getDate()+"'," +
                    "'"+customerInformation.getDebitor()+"','"+customerInformation.getPrice()+"');";
            stmt.execute(sql);

            //4. Close everything up again, hopefully this works :D
            stmt.close();
            conn.close();

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
