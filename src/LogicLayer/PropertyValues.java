package LogicLayer;

import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Thomas on 5/14/2017.
 */
public class PropertyValues {

    private List<CustomerInformation> list = new ArrayList();
    private List<String> ids = new ArrayList();
    private List<String> idsRed= new ArrayList();
    private String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    private String lastYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)-1);

    // PropertyValueFactory looks for the getters and setters in the "CustomerInformation" class
    //Meaning that "invoice" will look for "getInvoice() in the class speicifed class.

    void values(TableColumn<CustomerInformation, String> invoice,
                TableColumn<CustomerInformation, String> customer,
                TableColumn<CustomerInformation, String> name,
                TableColumn<CustomerInformation, String> debitor,
                TableColumn<CustomerInformation, String> date,
                TableColumn<CustomerInformation, String> address,
                TableColumn<CustomerInformation, String> price,
                TableColumn<CustomerInformation,String> colorColumn,
                ObservableList<CustomerInformation> data,
                TableView<CustomerInformation> tableView){

        invoice.setCellValueFactory(new PropertyValueFactory<>("Invoice_number"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        customer.setCellValueFactory(new PropertyValueFactory<>("rCustomerNumber"));
        debitor.setCellValueFactory(new PropertyValueFactory<>("debitor"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        colorColumn.setCellValueFactory(cellData -> cellData.getValue().getColor());

        setVariables(data,tableView);
        setColors(colorColumn);


    }
    public void setVariables(ObservableList<CustomerInformation> data, TableView<CustomerInformation> tableView) {

        list = data;
        for(int i = 0; i < list.size(); i++){

            String findYear= list.get(i).getDate().substring(0,4);

            if(currentYear.equals(findYear)){
                ids.add(list.get(i).getrCustomerNumber());
            }
        }

        for(int i = 0; i < list.size(); i++){

            String findYear= list.get(i).getDate().substring(0,4);

            if(lastYear.equals(findYear) && !ids.contains(list.get(i).getrCustomerNumber())){
                idsRed.add(list.get(i).getrCustomerNumber());
            }
        }

        for(int i = 0; i < list.size(); i++){
            if(ids.contains(list.get(i).getrCustomerNumber())){
                list.get(i).setColor("G");
            }else{
                if(idsRed.contains(list.get(i).getrCustomerNumber())){
                    list.get(i).setColor("Y");
                }else{
                    list.get(i).setColor("R");
                }
            }
        }

        tableView.setItems(data);

    }


    void setColors(TableColumn<CustomerInformation, String> colorColumn){


        colorColumn.setCellFactory(column -> {
            return new TableCell<CustomerInformation, String>(){

                @Override
                protected void updateItem(String item, boolean empty){

                    super.updateItem(item, empty);
                    TableRow<CustomerInformation> currentRow = getTableRow();

                    if(!isEmpty()) {

                        if("G".equals(item))
                        {
                            currentRow.setStyle("-fx-background-color:lightgreen");
                        }

                        else if("Y".equals(item))
                        {
                            currentRow.setStyle("-fx-background-color: yellow");
                        }

                        else if("R".equals(item))

                        {
                            currentRow.setStyle("-fx-background-color: red");
                        }
                    }
                }
            };
        });


//        colorColumn.setCellFactory((TableColumn<CustomerInformation, String> column) -> new TableCell<CustomerInformation, String>() {
//            @Override
//            protected void updateItem(String item, boolean empty){
//                super.updateItem(item, empty);
//
//                setText(empty ? "" : getItem());
//                setGraphic(null);
//
//                TableRow<CustomerInformation> currentRow = getTableRow();
//
//                //Gets the current year and converts to a string
//                System.out.println(item);
//                if(!isEmpty()) {
//                    //the item is the full value of whatever is shown in faktura_date. This gets the last 4 digits, AKA the year.
//                    //try catch to avoid any exceptions if  findYear is outta bounce
//
//
//
//                        if("G".equals(item)){
//                            currentRow.setStyle("-fx-background-color:lightgreen");
//                        }else if("Y".equals(item)){
//                            currentRow.setStyle("-fx-background-color: yellow");
//                        }else if("R".equals(item)){
//                            currentRow.setStyle("-fx-background-color: red");
//                        }
//
////                        if (findYear.equals(currentYear))
////                        {
////
////                            currentRow.setStyle("-fx-background-color:lightgreen");
////                        }
////
////                        else if (findYear.equals(lastYear))
////                        {
////                            currentRow.setStyle("-fx-background-color:yellow");
////                        }
////                        else
////                        {
////                            currentRow.setStyle("-fx-background-color:orangered");
////                        }
//
//
//                }
//
//
//            }
//        });

    }

    }


