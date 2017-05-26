package LogicLayer;

import DataLayer.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;


/**
 * Created by Thomas on 07-05-2017.
 */
public class MainController extends ReadFromDatabase implements Initializable{

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
    @FXML
    private TextField searchField;
    @FXML
    private Button make_Debitor;


    private PropertyValues propertyValues = new PropertyValues();
    private OpenNewWindow openNewWindow = new OpenNewWindow();




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
        tableView.setItems(data);
        tableView.setEditable(true);




    }

    public void importFromExcel () {

        ImportToDB importToDB = new ImportToDB();
        importToDB.importExcel();

    }

    //method called on click of the save button
    public void saveData(){

        CustomerInformation entry = new CustomerInformation(invoiceInput.getText(), dateInput.getText(), customerNumberInput.getText(),
                debitorInput.getText(), nameInput.getText(), addressInput.getText(), priceInput.getText());

        //insert data in table
        data.add(entry);
        clearTextFields();
        //Insert data to database
        WriteToDatabase write = new WriteToDatabase();
        try {
            write.writeCustomer(entry);
        }
        catch (SQLException e){
            System.out.println(e + "SQL BROKE NIGGA FML");
        }

    }
    public void deleteData() throws InvocationTargetException {
        RemoveDataDB removeDataDB = new RemoveDataDB();
        ObservableList<CustomerInformation> customerSelected, allCustomers;
        allCustomers = tableView.getItems();
        customerSelected = tableView.getSelectionModel().getSelectedItems();



        int indexofinvoice = tableView.getSelectionModel().getSelectedIndex();
        //String number = customerSelected.get(indexofselectedcustomer).getrCustomerNumber();
        try {
            removeDataDB.deleteData(customerSelected.get(indexofinvoice).getInvoice_number());
        } catch (SQLException e) {
            System.out.println(e + "SQL BROKE DOWN AHHH");
        }
        customerSelected.forEach(allCustomers::remove);
        tableView.refresh();
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

    private void dataFromDatabase(){

      importData(data, tableView);


    }

    public void GetrowinTextfield () {

       /* ObservableList<CustomerInformation> selectedcustomer;
        selectedcustomer = tableView.getSelectionModel().getSelectedItems();
        int indexofSelection = tableView.getSelectionModel().getSelectedIndex();
        try {
            if (selectedcustomer != null) {

            invoiceInput.setText(selectedcustomer.get(indexofSelection).getInvoice_number());
            dateInput.setText(selectedcustomer.get(indexofSelection).getDate());
            customerNumberInput.setText(selectedcustomer.get(indexofSelection).getrCustomerNumber());
            debitorInput.setText(selectedcustomer.get(indexofSelection).getDebitor());
            nameInput.setText(selectedcustomer.get(indexofSelection).getName());
            addressInput.setText(selectedcustomer.get(indexofSelection).getAddress());
            priceInput.setText(selectedcustomer.get(indexofSelection).getPrice());
            }
        } catch (NullPointerException e) {
            System.out.println("you clicked nothing");
        }*/


    }

    public void Update() {

       /* ObservableList<CustomerInformation> selectedcustomer;
        selectedcustomer = tableView.getSelectionModel().getSelectedItems();
        int getindex = tableView.getSelectionModel().getSelectedIndex();
        if (tableView.getFocusModel().isFocused(getindex)) {
            System.out.println("The cell is in focus");
        } else {
            System.out.println("The cell is out of focus");
        }

        selectedcustomer.get(getindex).setInvoice_number(invoiceInput.getText());
        selectedcustomer.get(getindex).setrCustomerNumber(customerNumberInput.getText());
        selectedcustomer.get(getindex).setDate(dateInput.getText());
        selectedcustomer.get(getindex).setDebitor(debitorInput.getText());
        selectedcustomer.get(getindex).setName(nameInput.getText());
        selectedcustomer.get(getindex).setAddress(addressInput.getText());
        selectedcustomer.get(getindex).setPrice(priceInput.getText());

        clearTextFields();*/



    }

    public void searchForData(){

//        invoiceNumber.setCellValueFactory(cellData -> cellData.getValue().invoice_numberProperty());
//        date.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
//        customer.setCellValueFactory(cellData -> cellData.getValue().rCustomerNumberProperty());
//        debitor.setCellValueFactory(cellData -> cellData.getValue().debitorProperty());
//        name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
//        address.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
//        price.setCellValueFactory(cellData -> cellData.getValue().priceProperty());

        //This wraps the ObservableList(data) in a FilteredList.
        FilteredList<CustomerInformation> filteredData = new FilteredList<>(data, e -> true);

        // Set the filter Predicate whenever the filter changes.
        searchField.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(customerInfo -> {
            // If filter text is empty, display all persons.
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String lowerCaseFilter = newValue.toLowerCase();

            if (customerInfo.getInvoice_number().toLowerCase().contains(lowerCaseFilter)) {
                return true;

            }
            else if (customerInfo.getrCustomerNumber().toLowerCase().contains(lowerCaseFilter)) {
                return true;

            } else if(customerInfo.getDate().toLowerCase().contains(lowerCaseFilter))
                return true;

            else if(customerInfo.getDebitor().toLowerCase().contains(lowerCaseFilter))
                return true;

             if(customerInfo.getName().toLowerCase().contains(lowerCaseFilter))
                return true;

            else if(customerInfo.getAddress().toLowerCase().contains(lowerCaseFilter))
                return true;

            else if(customerInfo.getPrice().toLowerCase().contains(lowerCaseFilter))
                return true;

            return false; // Does not match.
        }));

        // Wrap the FilteredList in a SortedList.
        SortedList<CustomerInformation> sortedData = new SortedList<>(filteredData);

        //  Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());

        // Add sorted (and filtered) data to the table.
        tableView.setItems(sortedData);
        tableView.refresh();
    }
    public void openSearchWindow(){
        openNewWindow.newWindow("AdvancedSearching.fxml", "Searching in intervals");
    }

    public void makeDeb (){
        openNewWindow.newWindow("MakeDebitor.fxml", "debwindow");
    }


    public void setTableEditable(){
        System.out.println("Det virker");


        tableView.getSelectionModel().cellSelectionEnabledProperty().set(true);

        invoiceNumber.setCellFactory(TextFieldTableCell.forTableColumn());
        invoiceNumber.setOnEditCommit(event -> {
           TreeItem<CustomerInformation> customerInformationTreeItem = (TreeItem<CustomerInformation>)
                   tableView.getItems(); event.getTablePosition().getRow();
                   customerInformationTreeItem.getValue().setInvoice_number(event.getNewValue());
        });
        date.setCellFactory(TextFieldTableCell.forTableColumn());
        date.setOnEditCommit(event -> {
            TreeItem<CustomerInformation> customerInformationTreeItem = (TreeItem<CustomerInformation>)
                    tableView.getItems();event.getTablePosition().getRow();
            customerInformationTreeItem.getValue().setDate(event.getNewValue());
        });
        customer.setCellFactory(TextFieldTableCell.forTableColumn());
        customer.setOnEditCommit(event -> {
            TreeItem<CustomerInformation> customerInformationTreeItem = (TreeItem<CustomerInformation>)
                    tableView.getItems();event.getTablePosition().getRow();
            customerInformationTreeItem.getValue().setrCustomerNumber(event.getNewValue());
        });
        debitor.setCellFactory(TextFieldTableCell.forTableColumn());
        debitor.setOnEditCommit(event -> {
            TreeItem<CustomerInformation> customerInformationTreeItem = (TreeItem<CustomerInformation>)
                    tableView.getItems();event.getTablePosition().getRow();
            customerInformationTreeItem.getValue().setDebitor(event.getNewValue());
        });
       name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit(event -> {
            TreeItem<CustomerInformation> customerInformationTreeItem = (TreeItem<CustomerInformation>)
                    tableView.getItems();event.getTablePosition().getRow();
            customerInformationTreeItem.getValue().setName(event.getNewValue());
        });
        address.setCellFactory(TextFieldTableCell.forTableColumn());
        address.setOnEditCommit(event -> {
            TreeItem<CustomerInformation> customerInformationTreeItem = (TreeItem<CustomerInformation>)
                    tableView.getItems();event.getTablePosition().getRow();
            customerInformationTreeItem.getValue().setAddress(event.getNewValue());
        });
        price.setCellFactory(TextFieldTableCell.forTableColumn());
        price.setOnEditCommit(event -> {
            TreeItem<CustomerInformation> customerInformationTreeItem = (TreeItem<CustomerInformation>)
                    tableView.getItems();event.getTablePosition().getRow();
            customerInformationTreeItem.getValue().setPrice(event.getNewValue());
        });
    }

    public void backupToDB () {
        BackupDatabase backup = new BackupDatabase();

        backup.backUp();
    }


}


