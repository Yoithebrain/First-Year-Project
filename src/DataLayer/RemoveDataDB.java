package DataLayer;

import LogicLayer.CustomerInformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jakob on 16-05-2017.
 */
public class RemoveDataDB {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/costumerregistry";

    //  Database credentials
    static final String USER = "user";
    static final String PASS = "root";

    public void deleteData(String idNumber){
    Connection conn = null;
    Statement stmt = null;


        try {
        Class.forName("com.mysql.jdbc.Driver");


        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        //3. Execute Query
        stmt = conn.createStatement();
        String sql = "DELETE FROM costumerregistry.costumer WHERE idCostumer =  + '"+idNumber+"'";
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
