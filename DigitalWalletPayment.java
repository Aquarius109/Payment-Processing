// Title: DigitalWalletPayment 
// Files: DigitalWalletPayment.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa

/** 
 * The DigitalWalletPayment class extends the ElectronicPayment class 
 * to create a subclass of digital payment instances.
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */
public class DigitalWalletPayment extends ElectronicPayment 
{
    private String walletId;
    private int previousNumTransactions;

    private static final String TYPE = "DigitalWalletPayment";

    /**
     * No-arg constructor of the DigitalWalletPayment class
     */
    public DigitalWalletPayment() {}

    /**
     * Constructs DigitalPayment object instance.
     * 
     * @param transactionName name of transaction
     * @param amount value of amount transacted
     * @param timestamp time of transaction
     * @param accountId account identification number
     * @param emailAddress email address associated with payment method
     * @param walletId digital wallet ID
     * @param previousNumTransactions number of previous transactions
     */
    public DigitalWalletPayment(String transactionName, double amount,
                                String timestamp, long accountId,
                                String emailAddress, String walletId,
                                int previousNumTransactions) 
    {
        super(transactionName, amount, timestamp, accountId, emailAddress);
        this.walletId = walletId;
        this.previousNumTransactions = previousNumTransactions;
    }

    /**
     * Gets wallet Id.
     * @return digital wallet Id
     */
    @Override
    public String getWalletId() 
    {
        return this.walletId;
    }

    /**
     * Gets number of previous transactions.
     * @return number of previous transactions
     */
    @Override
    public int getPreviousNumTransactions() 
    {
        return this.previousNumTransactions;
    }

    /**
     * Gets type of payment.
     * @return type of payment
     */
    @Override
    public String getType() 
    {
        return this.TYPE;
    }

    /**
     * Determines whether object has same contents as DigitalWalletPayment 
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
        DigitalWalletPayment paymentObject = (DigitalWalletPayment) object;
        boolean isTransactionName = super.getTransactionName()
            .equals(paymentObject.getTransactionName());
        boolean isAmountEqual = super.getAmount() == paymentObject.getAmount();
        boolean isTimeStamp = super.getTimestamp()
            .equals(paymentObject.getTimestamp());
        boolean isAccountId = super.getAccountId() == 
            paymentObject.getAccountId();
        boolean isEmail = super.getEmailAddress()
            .equals(paymentObject.getEmailAddress());
        boolean isWalletId = this.walletId.equals(paymentObject.getWalletId());
        boolean isPreviousTrans = this.previousNumTransactions == 
            paymentObject.getPreviousNumTransactions();

        return isTransactionName && isAmountEqual && isTimeStamp 
            && isAccountId && isEmail && isWalletId && isPreviousTrans;
    }

    /**
     * Calculates risk of digital payment.
     * @return double value of digital payment risk
     */
    @Override
    public double calculateDigitalRisk() 
    {
        return super.getAmount()/this.previousNumTransactions;
    }

    /**
     * Prints payment details.
     * @return a string value
     */
    @Override
    public String toString() 
    {
        return "DigitalWalletPayment (" + getTransactionName() +
            ") walletId: " + getWalletId() + ", previousNumTransactions: " +
                getPreviousNumTransactions();
    }
}
