package hotelManagement;

public class Customer {

    private final int accountNumber;
    private static String ssn;
    private String name;
    private String address;
    private String telephoneNumber;
    private String email;
    private String username;
    private String password;

    public Customer(String ssn, String name, String address, String telephoneNumber, String email, int accountNumber, String username, String password) {
        this.ssn = ssn;
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.accountNumber = accountNumber;
        this.username = username;
        this.password = password;
    }


    //En jävla massa getters-Kristian
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

