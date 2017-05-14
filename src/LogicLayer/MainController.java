package LogicLayer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by Thomas on 07-05-2017.
 */
public class MainController extends OpenNewWindow implements Initializable{

    @FXML
    private TextField invoiceInput, dateInput, customerNumberInput, debitorInput, nameInput, addressInput, priceInput;

    @FXML
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
            new CustomerInformation("137379", "21-4-2017", "181564", "81564", "KAB", "Kab address", "8741.21"),
            new CustomerInformation("137378", "20-6-2017", "120573", "20566", "Navn på firma", "Firma address", "1560")
    );


    //method implemented from the initializble interface. This is what happens on start up of the window. (needed to connect to database on startup... probably)
    @Override
    public void initialize(URL location, ResourceBundle resources) {



        propertyValues.values(invoiceNumber, date, customer, debitor, name, address, price);
        tableView.setItems(data);


    }



    //method called on click of the save buttonROOT
    public void saveData(){

        CustomerInformation entry = new CustomerInformation(invoiceInput.getText(), dateInput.getText(), customerNumberInput.getText(),
                debitorInput.getText(), nameInput.getText(), addressInput.getText(), priceInput.getText());


        //insert data in table
        data.add(entry);
        clearTextFields();



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
}
