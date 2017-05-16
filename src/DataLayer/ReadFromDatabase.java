package DataLayer;

import LogicLayer.CustomerInformation;
import com.mysql.jdbc.Connection;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Thomas on 06-05-2017.
 */
public class ReadFromDatabase {

    public void selectAllData(ObservableList<CustomerInformation> data) {
        try {
            Connection conn = ConnectToDatabase.connect();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM costumer");


            while (rs.next()) {

//The first information is currently N/A cause there's no invoice in the database.

                data.add(new CustomerInformation("N/A", rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6)));
            }

        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }

}

