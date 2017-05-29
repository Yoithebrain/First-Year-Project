package LogicLayer;

import DataLayer.ReadFromDatabase;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by Thomas on 5/20/2017.
 */
public class DBDataInJavaFX extends ReadFromDatabase {

    private PropertyValues propertyValues;

    public void dataFromDatabase(ObservableList<CustomerInformation> data, TableView<CustomerInformation> tableView,
                                 TableColumn<CustomerInformation, String> invoiceNumber,
                                 TableColumn<CustomerInformation, String> date,
                                 TableColumn<CustomerInformation, String> customer,
                                 TableColumn<CustomerInformation, String> debitor,
                                 TableColumn<CustomerInformation, String> name,
                                 TableColumn<CustomerInformation, String> address,
                                 TableColumn<CustomerInformation, String> price) {

        selectAllData(data);

    //    propertyValues.values(invoiceNumber, date, customer, debitor, name, address, price);
        tableView.setItems(data);

    }
}
