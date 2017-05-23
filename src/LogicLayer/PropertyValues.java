package LogicLayer;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by Thomas on 5/14/2017.
 */
public class PropertyValues {

    // PropertyValueFactory looks for the getters and setters in the "CustomerInformation" class
    //Meaning that "invoice" will look for "getInvoice() in the class speicifed class.

    void values(TableColumn<CustomerInformation, String> invoice,
                TableColumn<CustomerInformation, String> customer,
                TableColumn<CustomerInformation, String> name,
                TableColumn<CustomerInformation, String> debitor,
                TableColumn<CustomerInformation, String> date,
                TableColumn<CustomerInformation, String> address,
                TableColumn<CustomerInformation, String> price) {

        invoice.setCellValueFactory(new PropertyValueFactory<>("Invoice_number"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        customer.setCellValueFactory(new PropertyValueFactory<>("rCustomerNumber"));
        debitor.setCellValueFactory(new PropertyValueFactory<>("debitor"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        /*invoice.setCellValueFactory(new PropertyValueFactory<CustomerInformation, String>("Invoice_number"));
        customer.setCellValueFactory(new PropertyValueFactory<CustomerInformation, String>("rCustomerNumber"));
        name.setCellValueFactory(new PropertyValueFactory<CustomerInformation, String>("name"));
        address.setCellValueFactory(new PropertyValueFactory<CustomerInformation, String>("address"));
        date.setCellValueFactory(new PropertyValueFactory<CustomerInformation, String>("date"));
        debitor.setCellValueFactory(new PropertyValueFactory<CustomerInformation, String>("debitor"));
        price.setCellValueFactory(new PropertyValueFactory<CustomerInformation, String>("price"));
        */
    }
    void dateValue(TableColumn<CustomerInformation, String> date){
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

    }
}
