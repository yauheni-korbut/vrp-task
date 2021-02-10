package business_objects;

public class Account {

    public Account(String accountName, String phone) {
        this.accountName = accountName;
        this.phone = phone;
    }

    private String accountName;
    private String phone;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
