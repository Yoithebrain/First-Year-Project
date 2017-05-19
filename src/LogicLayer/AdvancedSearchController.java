package LogicLayer;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by Thomas on 19-05-2017.
 */
public class AdvancedSearchController {
    @FXML
    private TextField firstSearch;
    @FXML
    private TextField nextSearch;

    public void dataSearch() {

        String get = "";

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

    }

}
