/**
 * AccountRecord
 */
public class AccountRecord {
    private int account;
    private String firstName;
    private String lastName;
    private double balance;

    public AccountRecord() {
        this(0, "", "", 0.0);
    }

    /**
     * @param account
     * @param firstName
     * @param lastName
     * @param balance
     */
    public AccountRecord(int account, String firstName, String lastName, double balance) {
        setAccount(account);
        setFirstName(firstName);
        setLastName(lastName);
        setBalance(balance);
    }

    /**
     * @param account
     */
    public void setAccount(int account) {
        this.account = account;
    }

    /**
     * @return
     */
    public int getAccount() {
        return this.account;
    }

    /**
     * @param first
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return 
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}