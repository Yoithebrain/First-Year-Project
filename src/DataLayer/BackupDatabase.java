package DataLayer;


import javax.naming.CommunicationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Thomas on 06-05-2017.
 */
public class BackupDatabase {


    //Local connection
    private Connection localconn;
    //Local values for local database
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String LocalDB_URL = "jdbc:mysql://localhost/costumerregistry";
    private static String Local_DB_USER = "root";
    private static String Local_DB_PASS = "tocrazy547";

    public void backUp () {

        //Creating connection to local hosted database first
        try {
            Class.forName("com.mysql.jdbc.Driver");
            localconn = DriverManager.getConnection(LocalDB_URL, Local_DB_USER, Local_DB_PASS);
            String MySQL = ("SELECT * FROM costumer");
            ResultSet rs_customer = localconn.createStatement().executeQuery(MySQL);
            MySQL = ("SELECT * FROM faktura");
            ResultSet rs_faktura = localconn.createStatement().executeQuery(MySQL);
            MySQL = ("SELECT * FROM debitor");
            ResultSet rs_debitor = localconn.createStatement().executeQuery(MySQL);
            localconn.close();
            localconn = null;
            //Creation of cloud connection
            Connection onlineconn;
            Class.forName(JDBC_DRIVER);

            String cloud_DB_URL = "jdbc:mysql://yearproject.ceumid9pylis.eu-west-2.rds.amazonaws.com:3306/costumerregistry";
            String cloud_DB_USER = "root";
            String cloud_DB_PASS = "root1234";

            onlineconn = DriverManager.getConnection(cloud_DB_URL, cloud_DB_USER, cloud_DB_PASS);

            //Dropping of tables, individually for now
            String Sql = ("DROP TABLE faktura");
            onlineconn.createStatement().execute(Sql);
            Sql = ("DROP TABLE costumer");
            onlineconn.createStatement().execute(Sql);
            Sql = ("DROP TABLE debitor");
            onlineconn.createStatement().execute(Sql);
            //Creation of table
            String create_table = ("CREATE TABLE costumer(idCostumer, Customer_name, Costumer_adress, iddebitor)");
            onlineconn.createStatement().execute(create_table);
            create_table = ("CREATE TABLE debitor(iddebitor) ");
            onlineconn.createStatement().execute(create_table);
            create_table = ("CREATE TABLE costumerregistry.faktura(fakturaNr, total_beløb, faktura_dato, idCostumer)");
            onlineconn.createStatement().execute(create_table);

            //Insertion of values into faktura
            Sql = ("INSERT INTO faktura VALUES '"+rs_faktura.getString("fakturaNr")+"', '"+rs_faktura.getString("total_beløb")+"', " +
                    " '"+rs_faktura.getString("faktura_dato")+"', '"+rs_faktura.getString("idCostumer")+"';");
            onlineconn.createStatement().execute(Sql);
            //SQL insertion into costumer
            Sql = ("INSERT INTO costumer VALUES '"+rs_customer.getString("idCostumer")+"', '"+rs_customer.getString("Customer_name")+"'," +
                    "'"+rs_customer.getString("Costumer_adress")+"', '"+rs_customer.getString("iddebitor")+"';");
            onlineconn.createStatement().execute(Sql);
            //SQL insertion of debitor
            Sql = ("INSERT INTO debitor VALUE '"+rs_debitor.getString("iddebitor")+"';");
            onlineconn.createStatement().execute(Sql);



            onlineconn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("You wanna hear the most annoying sound in the world?");
            System.out.println(e);
            System.out.println("EHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");

        } catch (SQLException e) {
            System.out.println(e);
        }


    }




}
