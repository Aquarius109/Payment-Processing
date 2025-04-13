// Title: ElectronicPayment 
// Files: ElectronicPayment.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa

/** 
 * The class extends the Payment class to create a subclass of 
 * electronic payment instances.
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */
public class ElectronicPayment extends Payment 
{
    private long accountId;
    private String emailAddress;

    private static final String HIGH_LEVEL_TYPE = "ElectronicPayment";
    private static final String TYPE = "Untyped ElectronicPayment";

    /**
     * No-arg constructor of the ElectronicPayment class
     */
    public ElectronicPayment() {}

    /**
     * Constructs ElectronicPayment object instance.
     * 
     * @param transactionName name of transaction
     * @param amount value of amount transacted
     * @param timestamp time of transaction
     * @param accountId account identification number
     * @param emailAddress email address associated with payment method
     */
    public ElectronicPayment(String transactionName, double amount,
                             String timestamp, long accountId,
                             String emailAddress) 
    {
        super(transactionName, amount, timestamp);
        this.accountId = accountId;
        this.emailAddress = emailAddress;
    }

    /**
     * Gets account identification number.
     * @return long value of account ID
     */
    @Override
    public long getAccountId() 
    {
        return this.accountId;
    }

    /**
     * Gets email address associated with electronic payment method.
     * @return string value of email address
     */
    @Override
    public String getEmailAddress() 
    {
        return this.emailAddress;
    }

    /**
     * Gets high level type value of electronic payment instance.
     * @return string value of high level type
     */
    @Override
    public String getHighLevelType() 
    {
        return this.HIGH_LEVEL_TYPE;
    }

    /**
     * Gets type of electronic payment method.
     * @return string value of type
     */
    @Override
    public String getType() 
    {
        return this.TYPE;
    }

    /**
     * Determines whether object has same contents as ElectronicPayment 
     * instance.
     * @param object object to be compared
     * @return validation that the two objects are the same or not the same
     */
    @Override
    public boolean equals(Object object) 
    {
        if(object == null)
        {
            return false;
        }
        ElectronicPayment paymentObject = (ElectronicPayment) object;
        boolean isTransactionName = super.getTransactionName()
            .equals(paymentObject.getTransactionName());
        boolean isAmountEqual = super.getAmount() == paymentObject.getAmount();
        boolean isTimeStamp = super.getTimestamp()
            .equals(paymentObject.getTimestamp());
        boolean isAccountId = this.accountId == paymentObject.getAccountId();
        boolean isEmail = this.emailAddress
            .equals(paymentObject.getEmailAddress());

        return isTransactionName && isAmountEqual && isTimeStamp 
            && isAccountId && isEmail;
    }

    /**
     * Prints payment details.
     * @return a string value.
     */
    @Override
    public String toString() 
    {
        return "ElectronicPayment (" + getTransactionName() +
            ") accountId: " + getAccountId() + ", emailAddress: " +
                getEmailAddress();
    }

}
