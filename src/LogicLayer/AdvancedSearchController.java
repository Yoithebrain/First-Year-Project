package LogicLayer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Created by Thomas on 19-05-2017.
 */
public class AdvancedSearchController {
    @FXML
    private TextField firstSearch;
    @FXML
    private TextField nextSearch;

    @FXML
    private
    TableView<CustomerInformation> tableView;

    @FXML
    private TableColumn<CustomerInformation, String> date;

    final ObservableList<CustomerInformation> data = FXCollections.observableArrayList(
//            new CustomerInformation("137379", "21-4-2017", "181564",
//                    "81564", "KAB", "Kab address", "8741.21"),
//            new CustomerInformation("137378", "20-6-2017", "120573",
//                    "20566", "Navn på firma", "Firma address", "1560")
    );

    public void dataSearch() {


        date.setCellValueFactory(cellData -> cellData.getValue().dateProperty());

        FilteredList<CustomerInformation> filteredData = new FilteredList<>(data, p -> true);

        firstSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((CustomerInformation customerInfo) -> {

                String lowerCaseFilter = newValue.toLowerCase();

                if (customerInfo.getDate().toLowerCase().contains(lowerCaseFilter)) {
                    try {

                        int one = Integer.parseInt(firstSearch.getText());
                        int two = Integer.parseInt(nextSearch.getText());
                        if (one < two) {
                            return true;
                        }
                        return true;

                    } catch (NumberFormatException e) {

                        return false;

                    }
                }
                return true;

            });
        });

        SortedList<CustomerInformation> sortedData = new SortedList<>(filteredData);

        //  Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());

        // Add sorted (and filtered) data to the table.
        tableView.setItems(sortedData);

    }

}
