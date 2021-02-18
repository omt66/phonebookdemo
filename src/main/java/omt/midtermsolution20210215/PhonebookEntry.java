package omt.midtermsolution20210215;

/**
 * A simple class to model a phone book entry.
 * @author omt
 */
public class PhonebookEntry {
    private String firstName;
    private String lastName;
    private String homePhone;
    private String workPhone;
    private String mobilePhone;

    public PhonebookEntry(String firstName, String lastName, 
            String homePhone, String workPhone, String mobilePhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.mobilePhone = mobilePhone;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getHomePhone() {
        return homePhone;
    }
    
    public String getWorkPhone() {
        return workPhone;
    }
    
    public String getMobilePhone() {
        return mobilePhone;
    }
    
    @Override
    public String toString() {
        String formatStr = "Name: %s %s.\n Home phone: %s\n Work phone: %s\n Mobile phone: %s";
        return String.format(formatStr, firstName, lastName, homePhone, workPhone, mobilePhone);
    }
    
}
