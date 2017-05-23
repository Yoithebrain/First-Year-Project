package DataLayer;

import LogicLayer.CustomerInformation;

import javafx.collections.ObservableList;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Thomas on 06-05-2017.
 */
public class ReadFromDatabase extends ConnectToDatabase {

    public void selectAllData(ObservableList dataList) {

        try {

            Connection conn = connect();
            conn.setAutoCommit(false);
           /* String mySQL = ("START TRANSACTION WITH READ ONLY; " +
                    "SELECT idCostumer, Customer_name, Costumer_adress " +
                    "FROM Costumer; " +
                    "SELECT faktura_Nr, total_beløb, faktura_dato " +
                    "FROM faktura; " +
                    "SELECT iddebitor " +
                    "FROM debitor; " +
                    "COMMIT TRANSACTION; " +
                    "END TRANSACTION; ");*/
                    //Transactions in JDBC works differently from the way MySQL Transactions work so this was a days trial and error wasted on something completly unnecessary
            String mySQL = ("SELECT F.fakturaNr, F.faktura_dato, C.idCostumer, D.iddebitor, C.Customer_name, C.Costumer_adress, F.total_beløb " +
                    "FROM costumer C, faktura F, debitor D WHERE C.idCostumer = F.idCostumer AND C.iddebitor = D.iddebitor");
            System.out.println(mySQL);
            conn.setAutoCommit(true);
            ResultSet rs = conn.createStatement().executeQuery(mySQL);
            while (rs.next()){
                dataList.add(new CustomerInformation(rs.getString("fakturaNr"),rs.getString("faktura_dato"),
                        rs.getString("idCostumer"), rs.getString("iddebitor"), rs.getString("Customer_name"),
                        rs.getString("Costumer_adress"), rs.getString("total_beløb")));
            }
         rs.close();

        } catch (SQLException e){
            System.out.println(e + "IT BROOOOOOOOKE AHHH");
        }
        /*
        try {
            //connect() er nedarvet
            Connection conn = connect();
            ResultSet rs = conn.createStatement().executeQuery("SELECT idCostumer, Customer_name, Costumer_adress, Customer_date," +
                    "Costumer_Debitor, Costumer_payment " +
                    "FROM costumer");




            while (rs.next()) {

//The first information is currently N/A cause there's no invoice in the database.

                dataList.add(new CustomerInformation("N/A", rs.getString("Customer_date"),
                        rs.getString("idCostumer"), rs.getString("Costumer_debitor"), rs.getString("Customer_name"),
                        rs.getString("Costumer_adress"), rs.getString("Costumer_payment")));


            }

            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }

    } //end of selectAllData*/


    }
}

