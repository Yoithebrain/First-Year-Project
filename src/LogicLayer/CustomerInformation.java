package LogicLayer;

import javafx.beans.property.SimpleStringProperty;


/**
 * Created by Thomas on 11-05-2017.
 */
public class CustomerInformation {

    private final SimpleStringProperty rInvoice;
    private final SimpleStringProperty date;
    private final SimpleStringProperty rCustomerNumber;
    private final SimpleStringProperty debitor;
    private final SimpleStringProperty name;
    private final SimpleStringProperty address;
    private final SimpleStringProperty price;


    public CustomerInformation(String invoice, String date, String customerNumber, String debitor, String name, String address, String price) {

        this.rInvoice = new SimpleStringProperty(invoice);
        this.date = new SimpleStringProperty(date);
        this.rCustomerNumber = new SimpleStringProperty(customerNumber);
        this.debitor = new SimpleStringProperty(debitor);
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.price = new SimpleStringProperty(price);
    }

    public String getrInvoice() {
        return rInvoice.get();
    }

    public SimpleStringProperty rInvoiceProperty() {
        return rInvoice;
    }

    public void setrInvoice(String rInvoice) {
        this.rInvoice.set(rInvoice);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getrCustomerNumber() {
        return rCustomerNumber.get();
    }

    public SimpleStringProperty rCustomerNumberProperty() {
        return rCustomerNumber;
    }

    public void setrCustomerNumber(String rCustomerNumber) {
        this.rCustomerNumber.set(rCustomerNumber);
    }

    public String getDebitor() {
        return debitor.get();
    }

    public SimpleStringProperty debitorProperty() {
        return debitor;
    }

    public void setDebitor(String debitor) {
        this.debitor.set(debitor);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }
}


