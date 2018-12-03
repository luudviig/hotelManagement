package hotelManagement;

import java.util.ArrayList;

public class Customer {

     String ssn;
     String name;
    String address;
    String telephoneNumber;
    String email;

    //ArrayList för Costumer

    ArrayList<String> customer = new ArrayList<>();

    public Customer (String ssn, String name, String address, String telephoneNumber, String email) {

        this.ssn = ssn;
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    //En jävla massa getters

    public String getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getCustomer() {
        return customer;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomer(ArrayList<String> customer) {
        this.customer = customer;
    }
}