package awesomecucumber.domain;

public class BillingPage {

    private String firstName;
    private String lastName;
    private String address;
    private String town;
    private String stateId;
    private String zipCode;
    private String emailAddress;
    private String phoneNumber;

    // Constructor
    public BillingPage(String firstName, String lastName, String address, String town,
                       String stateId, String zipCode, String emailAddress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.town = town;
        this.stateId = stateId;
        this.zipCode = zipCode;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getTown() {
        return town;
    }

    public String getStateId() {
        return stateId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setters (optional, but useful)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
