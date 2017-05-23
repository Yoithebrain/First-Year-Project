package DataLayer;

import LogicLayer.CustomerInformation;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.*;
import java.util.ArrayList;
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


    } //end of selectAllData

    public void importData(ObservableList<CustomerInformation> data, TableView<CustomerInformation> tableView){

        selectAllData(data);

        tableView.setItems(data);


    }
    public void certainData(String date1, String date2, ObservableList<CustomerInformation> data, TableView<CustomerInformation> tableView){

        try {
            Connection conn = connect();
            ResultSet rs = conn.createStatement().executeQuery("SELECT F.fakturaNr, F.faktura_dato, C.idCostumer, D.iddebitor, C.Customer_name, C.Costumer_adress, F.total_beløb " +
                    "FROM costumer C, faktura F, debitor D WHERE C.idCostumer = F.idCostumer AND C.iddebitor = D.iddebitor AND faktura_dato BETWEEN '"+date1+"'AND'"+date2+"'");




            //"SELECT * FROM costumer WHERE Customer_date BETWEEN '"+date1+"'AND'"+date2+"'"
            //"SELECT * FROM costumer WHERE Customer_date BETWEEN '"+date1+"'AND'"+date2+"'"
            //"SELECT * FROM costumer WHERE Customer_date BETWEEN "+date1+" AND "+date2
            //"SELECT * FROM costumer WHERE Customer_date BETWEEN '20-04-2017' AND '25-05-2017'"
           // parsedDates.get(k) >date1 && parsedDates.get(k) < date2

            System.out.println(date1);
            System.out.println(date2);


            while(rs.next()) {

                data.add(new CustomerInformation(rs.getString("fakturaNr"),rs.getString("faktura_dato"),
                        rs.getString("idCostumer"), rs.getString("iddebitor"), rs.getString("Customer_name"),
                        rs.getString("Costumer_adress"), rs.getString("total_beløb")));
            }

            rs.close();
            tableView.setItems(data);
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }


    }


}

