package DataLayer;

import LogicLayer.CustomerInformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jakob on 16-05-2017.
 */
public class RemoveDataDB extends ConnectToDatabase{



    public void deleteData(String idNumber) throws SQLException {
    Connection conn = connect();
    Statement stmt = null;


        try {

        //3. Execute Query
        stmt = conn.createStatement();
        //String sql = "SELECT FROM costumerregistry.costumer WHERE idCostumer = '"+idNumber+"'";
        //String sql = "INSERT TO costumerregistry.costumer(idCostumer) = " +"VALUE'"+idNumber+"'";
            String sql = "INSERT INTO costumerregistry.costumer_deleted (idCostumer, Customer_name, Costumer_adress, Customer_date, Costumer_Debitor, Costumer_payment)" +
                            "SELECT idCostumer, Customer_name, Costumer_adress, Customer_date, Costumer_Debitor, Costumer_payment FROM costumerregistry.costumer " +
                            "WHERE idCostumer = '"+idNumber+"'";
            String deletion = "DELETE FROM costumerregistry.costumer WHERE idCostumer = '"+idNumber+"'";






        System.out.println(sql);
        stmt.execute(sql);
        stmt.execute(deletion);

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
