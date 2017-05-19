package DataLayer;

import LogicLayer.CustomerInformation;

import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Thomas on 06-05-2017.
 */
public class ReadFromDatabase extends ConnectToDatabase{

    public void selectAllData(ObservableList dataList) {

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

    } //end of selectAllData



}

