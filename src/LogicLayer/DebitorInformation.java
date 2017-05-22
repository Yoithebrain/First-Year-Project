package LogicLayer;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by jakob on 19-05-2017.
 */
public class DebitorInformation {

    public String getIddebitor() {
        return iddebitor.get();
    }

    public void setIddebitor(String iddebitor) {
        this.iddebitor.set(iddebitor);
    }

    public void setDebitor_name(String debitor_name) {
        this.debitor_name.set(debitor_name);
    }

    public void setDebitor_phonenumber(String debitor_phonenumber) {
        this.debitor_phonenumber.set(debitor_phonenumber);
    }

    public void setDebitor_contactPerson(String debitor_contactPerson) {
        this.debitor_contactPerson.set(debitor_contactPerson);
    }

    public SimpleStringProperty iddebitorProperty() {
        return iddebitor;
    }

    public String getDebitor_name() {
        return debitor_name.get();
    }

    public SimpleStringProperty debitor_nameProperty() {
        return debitor_name;
    }

    public String getDebitor_phonenumber() {
        return debitor_phonenumber.get();
    }

    public SimpleStringProperty debitor_phonenumberProperty() {
        return debitor_phonenumber;
    }

    public String getDebitor_contactPerson() {
        return debitor_contactPerson.get();
    }

    public SimpleStringProperty debitor_contactPersonProperty() {
        return debitor_contactPerson;
    }

    private final SimpleStringProperty iddebitor;



    public DebitorInformation(String id_debitor, String debitor_name,
                              String debitor_phonenumber, String debitor_contactPerson) {
        this.iddebitor = new SimpleStringProperty(id_debitor);
        this.debitor_name = new SimpleStringProperty(debitor_name);
        this.debitor_phonenumber = new SimpleStringProperty(debitor_phonenumber);
        this.debitor_contactPerson = new SimpleStringProperty(debitor_contactPerson);
    }

    private final SimpleStringProperty debitor_name;
    private final SimpleStringProperty debitor_phonenumber;
    private final SimpleStringProperty debitor_contactPerson;



}
