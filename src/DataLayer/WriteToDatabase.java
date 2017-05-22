package DataLayer;


import LogicLayer.CustomerInformation;

import java.sql.*;

/**
 * Created by Thomas on 06-05-2017.
 */


public class WriteToDatabase extends ConnectToDatabase {
            // 1. Function that takes the costumerinformation object and writes the values that is kept within the object into the database.
    public void writeCustomer(CustomerInformation customerInformation) throws SQLException {
        //Here we can see the usage of our connecttodatabase object in action, including the function.
        Connection conn = connect();
        Statement stmt = null;

        try {


            //3. Execute Query
            stmt = conn.createStatement();
            //We both use DML and DDL in certain queries to modify and get data, in this case we chose where the data needs to be sent in the database. We, after choosing
            //the table and columns, modify the data that is entered into the column via our costuemrinformation object

            /*String sql = "BEGIN TRANSACTION; "  +
            " INSERT INTO costumer + VALUES " +
                    "('"+customerInformation.getrCustomerNumber()+"', '"+customerInformation.getName()+"', " +
                    "'"+customerInformation.getAddress()+"'); " +
                    "INSERT INTO faktura(faktura_nr., total, faktura_dato); " +
                    "VALUES ('"+customerInformation.getInvoice_number()+"', '"+customerInformation.getPrice()+"'," +
                    "'"+customerInformation.getDate()+"');" +
                    "INSERT INTO debitor(iddebitor); " +
                    "VALUE '"+customerInformation.getDebitor()+"';" +
                    "END TRANSACTION ;";
             *///The string we wanted but it kept failing

            String sql1 = "INSERT INTO costumer (idCostumer, Customer_name, Costumer_adress, iddebitor) " +
                    "VALUES ('"+customerInformation.getrCustomerNumber()+"', '"+customerInformation.getName()+"', '"+customerInformation.getAddress()+"', " +
                    "'"+customerInformation.getDebitor()+"');";
            String sql2 = "INSERT INTO faktura VALUES('"+customerInformation.getInvoice_number()+"', '"+customerInformation.getDate()+"', '"+customerInformation.getPrice()+"', " +
                    "'"+customerInformation.getrCustomerNumber()+"');";
            String sql3 = "INSERT INTO debitor (iddebitor) VALUE ('"+customerInformation.getDebitor()+"');";



            //stmt.execute(sql3);
            stmt.execute(sql1);
            stmt.execute(sql2);
            //4. Close everything up again, hopefully this works :D
            stmt.close();
            conn.close();

         //Try, final and catch block to make sure that any exceptions are handled proberely on the user end, for now though we use it for debugging purposes.
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
