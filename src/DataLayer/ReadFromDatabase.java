package DataLayer;

import LogicLayer.CustomerInformation;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Thomas on 06-05-2017.
 */
public class ReadFromDatabase extends ConnectToDatabase {

    public void selectAllData(ObservableList<CustomerInformation> dataList) {

        try {

            Connection conn = connect();
           /* String mySQL = ("START TRANSACTION WITH READ ONLY; " +
                    "SELECT idCostumer, Customer_name, Costumer_adress " +
                    "FROM Costumer; " +
                    "SELECT faktura_Nr, total_beløb, faktura_dato " +
                    "FROM faktura; " +
                    "SELECT iddebitor " +
                    "FROM debitor; " +
                    "COMMIT TRANSACTION; " +
                    "END TRANSACTION; ");*/
                    //Transactions in JDBC works differently from the way MySQL Transactions work so this was a days trial and error wasted on something completly unnecessary
            String mySQL = ("SELECT F.fakturaNr, F.faktura_dato, C.idCostumer, D.iddebitor, C.Customer_name, C.Costumer_adress, F.total_beløb " +
                    "FROM costumer C, faktura F, debitor D WHERE C.idCostumer = F.idCostumer AND C.iddebitor = D.iddebitor");
            System.out.println(mySQL);
            ResultSet rs = conn.createStatement().executeQuery(mySQL);
            while (rs.next()){
                dataList.add(new CustomerInformation(rs.getString("fakturaNr"),rs.getString("faktura_dato"),
                        rs.getString("idCostumer"), rs.getString("iddebitor"), rs.getString("Customer_name"),
                        rs.getString("Costumer_adress"), rs.getString("total_beløb")));
            }
         rs.close();

        } catch (SQLException e){
            System.out.println(e + "IT BROOOOOOOOKE AHHH");
        }


    } //end of selectAllData

    public void importData(ObservableList<CustomerInformation> data, TableView<CustomerInformation> tableView){

        selectAllData(data);

        tableView.setItems(data);


    }
    public void yearsInCalendar(String date1, String date2, ObservableList<CustomerInformation> data, TableView<CustomerInformation> tableView){
//
//        String finalString= "";
//        String finalString2 = "";
//        System.out.println("This is date1: " + date1);
//        System.out.println("This is date2: " + date2);
        try {
//            if(date1.length() >= 10 && date2.length() >= 10) {

//               // String days1 = date1.substring(0, 2);
//                String months1 = date1.substring(3, 5);
//                String years1 = date1.substring(6, 10);
//
//                int yearNum = Integer.parseInt(years1);
//                int monrg1Num = Integer.parseInt(months1);
////
////                finalString = years1 + months1 + days1;
////
////                String days2 = date2.substring(0, 2);
//                String months2 = date2.substring(3, 5);
//                String years2 = date2.substring(6, 10);
//
//            int month2Num = Integer.parseInt(months2);
//            int year2Num = Integer.parseInt(years2);

                //                finalString2 = years2 + months2 + days2;
//            }

            Connection conn = connect();
            ResultSet rs = conn.createStatement().executeQuery("SELECT F.fakturaNr, F.faktura_dato, C.idCostumer, D.iddebitor, C.Customer_name, C.Costumer_adress, F.total_beløb " +
                    "FROM costumer C, faktura F, debitor D WHERE C.idCostumer = F.idCostumer AND C.iddebitor = D.iddebitor AND faktura_dato BETWEEN CAST('"+date1+"' AS DATE) AND CAST('"+date2+"' AS DATE)");

            //"SELECT F.fakturaNr, F.faktura_dato, C.idCostumer, D.iddebitor, C.Customer_name, C.Costumer_adress, F.total_beløb " +
            //"FROM costumer C, faktura F, debitor D WHERE C.idCostumer = F.idCostumer AND C.iddebitor = D.iddebitor AND faktura_dato BETWEEN '"+finalString+"'AND'"+finalString2+"'"



            //"SELECT * FROM costumer WHERE Customer_date BETWEEN '"+date1+"'AND'"+date2+"'"
            //"SELECT * FROM costumer WHERE Customer_date BETWEEN '"+date1+"'AND'"+date2+"'"
            //"SELECT * FROM costumer WHERE Customer_date BETWEEN "+date1+" AND "+date2
            //"SELECT * FROM costumer WHERE Customer_date BETWEEN '20-04-2017' AND '25-05-2017'"
           // parsedDates.get(k) >date1 && parsedDates.get(k) < date2


            while(rs.next()) {




                    data.add(new CustomerInformation(rs.getString("fakturaNr"), rs.getString("faktura_dato"),
                            rs.getString("idCostumer"), rs.getString("iddebitor"), rs.getString("Customer_name"),
                            rs.getString("Costumer_adress"), rs.getString("total_beløb")));

            }

            rs.close();
            tableView.setItems(data);
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }


    }




    public ArrayList<String> getDates(){
        ArrayList<String> list = new ArrayList<>();
        try {
            Connection conn = connect();
            ResultSet rs = conn.createStatement().executeQuery("SELECT faktura_dato FROM faktura");


            while(rs.next()) {

                list.add(rs.getString("faktura_dato"));
            }

            rs.close();
           return list;
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
        return null;
    }


}

