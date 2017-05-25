package LogicLayer;

import DataLayer.ReadFromDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
    private Label priceLabel;

    @FXML
    private
    TableView<CustomerInformation> tableView;

    private PropertyValues propertyValues = new PropertyValues();

    private final ObservableList<CustomerInformation> data = FXCollections.observableArrayList();

    public void searchForDate() {

        tableView.getItems().clear();
       // DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


//        String date1 = date1Input.getValue().toString();
//        String date1Final;
//        String date2 = date2Input.getValue().toString();

        String date1 = date1Input.getValue().format(dateTimeFormatter);
        String date2 = date2Input.getValue().format(dateTimeFormatter);


//        //gets all values of days, months d
//       String days = date1.substring(0,2);
//       String months = date1.substring(3,5);
//       String years = date1.substring(6,10);
//        System.out.println(days + " days");
//        System.out.println(months + " months");
//        System.out.println(years + " years");
//        String finalString = years+months+days;
//        System.out.println("Final string 1:" +finalString);
//
//        String days2 = date2.substring(0,2);
//        System.out.println("days 2:" + days2);
//        System.out.println("Days 1:" + days);
//        String months2 = date2.substring(3,5);
//        String years2 = date2.substring(6,10);
//        String finalString2 = years2+months2+days2;
//        System.out.println("Final string 2:" +finalString2);
//
//
//        System.out.println("years; "+years);
//        System.out.println("years2; "+years2);

            yearsInCalendar(date1, date2, data, tableView);


            //refreshing makes it so the colours dont stick to empty fields.
        tableView.refresh();
        double totalPrice = 0;

        for (int i = 0; i < data.size(); i++) {
            totalPrice = totalPrice + Double.parseDouble(data.get(i).getPrice());
        }

        priceLabel.setText("Omsætning for valgt periode: " + totalPrice + " kr");




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

