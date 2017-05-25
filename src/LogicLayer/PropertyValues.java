package LogicLayer;

import DataLayer.ReadFromDatabase;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Calendar;

/**
 * Created by Thomas on 5/14/2017.
 */
public class PropertyValues {

    private ReadFromDatabase readFromDatabase = new ReadFromDatabase();

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


       setColors(date);


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

    private void setColors(TableColumn<CustomerInformation, String> dateColumn){

        dateColumn.setCellFactory((TableColumn<CustomerInformation, String> column) -> new TableCell<CustomerInformation, String>() {
            @Override
            protected void updateItem(String item, boolean empty){
                super.updateItem(item, empty);

                setText(empty ? "" : getItem());
                setGraphic(null);

                TableRow<CustomerInformation> currentRow = getTableRow();

                //Gets the current year and converts to a string
                String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
                String lastYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)-1);

                if(!isEmpty()) {
                    //the item is the full value of whatever is shown in faktura_date. This gets the last 4 digits, AKA the year.
                    //try catch to avoid any exceptions if  findYear is outta bounce
                    try {
                        String findYear = item.substring(0,4);


                        if (findYear.equals(currentYear))
                        {
                            currentRow.setStyle("-fx-background-color:lightgreen");
                        }

                        else if (findYear.equals(lastYear))
                        {
                            currentRow.setStyle("-fx-background-color:yellow");
                        }
                        else
                        {
                            currentRow.setStyle("-fx-background-color:orangered");
                        }

                    }catch(Exception e) {
                        System.out.println("Can't find 4 substrings in string: " + e);
                }

                }


            }
        });

    }


    }


