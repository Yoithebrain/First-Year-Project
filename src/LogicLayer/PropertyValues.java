package LogicLayer;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by Thomas on 5/14/2017.
 */
public class PropertyValues {

    // PropertyValueFactory looks for the getters and setters in the "CustomerInformation" class
    //Meaning that "rInvoice" will look for "getrInovice() in the class speicifed class.

    void values(TableColumn<CustomerInformation, String> invoice,
                TableColumn<CustomerInformation, String> date,
                TableColumn<CustomerInformation, String> customer,
                TableColumn<CustomerInformation, String> debitor,
                TableColumn<CustomerInformation, String> name,
                TableColumn<CustomerInformation, String> address,
                TableColumn<CustomerInformation, String> price) {

        invoice.setCellValueFactory(new PropertyValueFactory<>("rInvoice"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        customer.setCellValueFactory(new PropertyValueFactory<>("rCustomerNumber"));
        debitor.setCellValueFactory(new PropertyValueFactory<>("debitor"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
