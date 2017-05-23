package LogicLayer;

import DataLayer.ReadFromDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.ResourceBundle;

/**
 * Created by Thomas on 19-05-2017.
 */
public class AdvancedSearchController extends ReadFromDatabase implements Initializable {
    @FXML
    private DatePicker date1Input;
    @FXML
    private DatePicker date2Input;

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

    @FXML
    private
    TableView<CustomerInformation> tableView;

    private PropertyValues propertyValues = new PropertyValues();

    //
    private final ObservableList<CustomerInformation> data = FXCollections.observableArrayList();

    public void searchForDate() {

        System.out.println("Date1 value: " + date1Input.getValue().toString());
        System.out.println("Date2 value: " + date2Input.getValue().toString());
        //certainData(date1Input.getValue().toString(), date2Input.getValue().toString(), data, tableView);
        tableView.getItems().clear();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


//        String date1 = date1Input.getValue().toString();
//        String date1Final;
//        String date2 = date2Input.getValue().toString();

        String date1 = date1Input.getValue().format(dateTimeFormatter);
        String date2 = date2Input.getValue().format(dateTimeFormatter);


        //gets all values of days, months d
       String days = date1.substring(0,2);
       String months = date1.substring(3,5);
       String years = date1.substring(6,10);
        System.out.println(days + " days");
        System.out.println(months + " months");
        System.out.println(years + " years");

        certainData(date1, date2, data, tableView);




    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        propertyValues.values(invoiceNumber, date, customer, debitor, name, address, price);
        dataFromDatabase();
        tableView.setItems(data);

    }
        private void dataFromDatabase () {

        importData(data, tableView);

        }
    }

