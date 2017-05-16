package LogicLayer;

import DataLayer.ConnectToDatabase;
import DataLayer.RemoveDataDB;
import DataLayer.WriteToDatabase;
import com.mysql.jdbc.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**
 * Created by Thomas on 07-05-2017.
 */
public class MainController implements Initializable{

    @FXML
    private TextField invoiceInput, dateInput, customerNumberInput, debitorInput, nameInput, addressInput, priceInput;

    @FXML
    private
    TableView<CustomerInformation> tableView;

    @FXML
    private TableColumn<CustomerInformation, String> invoiceNumber;
    @FXML
    private TableColumn<CustomerInformation, String> date;
    @FXML
    private TableColumn<CustomerInformation, String> customer;
    @FXML
    private TableColumn<CustomerInformation, String> debitor;
    @FXML
    private TableColumn<CustomerInformation, String> name;
    @FXML
    private TableColumn<CustomerInformation, String> address;
    @FXML
    private TableColumn<CustomerInformation, String> price;

    private PropertyValues propertyValues = new PropertyValues();



    //ObservableList: A list that allows listeners to track changes when they occur
    //Source: https://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableList.html

    final ObservableList<CustomerInformation> data = FXCollections.observableArrayList(
//            new CustomerInformation("137379", "21-4-2017", "181564",
//                    "81564", "KAB", "Kab address", "8741.21"),
//            new CustomerInformation("137378", "20-6-2017", "120573",
//                    "20566", "Navn på firma", "Firma address", "1560")
    );
    //method implemented from the initializble interface. This is what happens on start up of the window. (needed to connect to database on startup... probably)

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        propertyValues.values(invoiceNumber, date, customer, debitor, name, address, price);
        dataFromDatabase();
    }

    //method called on click of the save buttonROOT
    public void saveData(){

        CustomerInformation entry = new CustomerInformation(invoiceInput.getText(), dateInput.getText(), customerNumberInput.getText(),
                debitorInput.getText(), nameInput.getText(), addressInput.getText(), priceInput.getText());

        //insert data in table
        data.add(entry);
        clearTextFields();
        //Insert data to database
        WriteToDatabase write = new WriteToDatabase();
        write.writeCustomer(entry);

    }
    public void deleteData() {

        RemoveDataDB removeDataDB = new RemoveDataDB();
        ObservableList<CustomerInformation> customerSelected, allCustomers;
        allCustomers = tableView.getItems();
        customerSelected = tableView.getSelectionModel().getSelectedItems();
        for (int i = 0; i < allCustomers.size(); i++) {

            String number = customerSelected.get(i).getrCustomerNumber();
            removeDataDB.deleteData(number);
            customerSelected.forEach(allCustomers::remove);

        }
    }
    private void clearTextFields(){

        invoiceInput.clear();
        dateInput.clear();
        customerNumberInput.clear();
        debitorInput.clear();
        nameInput.clear();
        addressInput.clear();
        priceInput.clear();
    }

    public void dataFromDatabase(){

        try{
            Connection conn = ConnectToDatabase.connect();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM costumer");

            while (rs.next()) {

//The first information is currently N/A cause there's no invoice in the database.

                data.add(new CustomerInformation("N/A", rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6)));
            }

        } catch(SQLException ex) {
            System.err.println("Error: " + ex);
        }

        propertyValues.values(invoiceNumber, date, customer, debitor, name, address, price);

        tableView.setItems(data);


    }
}
