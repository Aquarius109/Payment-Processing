// Title: Payment 
// Files: Payment.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa

/** 
 * The Payment class contains accessor and mutator methods that use the
 * instance variables transactionName, amount, and timestamp.
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */

public class Payment 
{
    private String transactionName;
    private double amount;
    private String timestamp;

    private static final String HIGH_LEVEL_TYPE = "Untyped High Level Payment";
    private static final String TYPE = "Untyped Payment";

    /**
     * No-arg constructor of the Payment class
     */
    public Payment() {}

    /**
     * Constructs Payment object instance.
     * 
     * @param transactionName name of transaction
     * @param amount value of amount transacted
     * @param timestamp time of transaction
     */
    public Payment(String transactionName, double amount, String timestamp) 
    {
        this.transactionName = transactionName;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    /**
     * Gets transaction name
     * @return transaction name
     */
    public String getTransactionName() 
    {
        return this.transactionName;
    }

    /**
     * Gets amount
     * @return value of amount
     */
    public double getAmount() 
    {
        return this.amount;
    }

    /**
     * Gets time of transaction
     * @return time stamp of transaction
     */
    public String getTimestamp() 
    {
        return this.timestamp;
    }

    /**
     * Gets high level type notification
     * @return string value of notification
     */
    public String getHighLevelType() 
    {
        return this.HIGH_LEVEL_TYPE;
    }

    /**
     * Gets type notification
     * @return string value of type notification
     */
    public String getType() 
    {
        return this.TYPE;
    }

    /**
     * Sets amount of Payment instance
     * @param amount amount to be set
     */
    public void setAmount(double amount) 
    {
        this.amount = amount;
    }

    /**
     * Checks if contents of Payment instance and another object are equal
     * @param object object to be compared with Payment instance
     * @return a boolean value that validates whether the object is equal to 
     * Payment instance
     */
    @Override
    public boolean equals(Object object) 
    {
        if (object == null) 
        {
            return false;
        }
        Payment payment = (Payment) object;

        boolean namesEqual = this.transactionName
                                        .equals(payment.getTransactionName());
        boolean amountsEqual = this.amount == payment.getAmount();
        boolean timestampsEqual = this.timestamp.equals(payment.getTimestamp());

        return namesEqual && amountsEqual && timestampsEqual;
    }

    /**
     * Prints payment details.
     * @return a string value.
     */
    @Override
    public String toString() 
    {
        return "Payment (" + getTransactionName() +
            ") amount: " + getAmount() + ", timestamp: " + getTimestamp();
    }

    /**
     * Card number of a CardPayment instance
     * @return the String representation of the card number
     */
    public String getCardNumber() 
    {
        return null;
    }

    /**
     * Expiry month of a card of a CardPayment instance
     * @return the month of the card's expiration date
     */
    public int getExpiryMonth() 
    {
        return 0;
    }

    /**
     * Expiry year of a card of a CardPayment instance
     * @return the year of the card's expiration date
     */
    public int getExpiryYear() 
    {
        return 0;
    }

    /**
     * Account ID of an ElectronicPayment instance
     * @return the long representation of the account ID
     */
    public long getAccountId() 
    {
        return 0;
    }

    /**
     * Email address of an ElectronicPayment instance
     * @return the String representation of the email
     */
    public String getEmailAddress() 
    {
        return null;
    }

    /**
     * Bank balance of a bank account linked to a DebitPayment
     * @return the double representation of the bank balance
     */
    public double getBankBalance() 
    {
        return 0;
    }

    /**
     * Credit limit of a card linked to a CreditPayment
     * @return the double representation of the credit limit
     */
    public double getCreditLimit() 
    {
        return 0;
    }

    /**
     * Outstanding balance of a card linked to a CreditPayment
     * @return the double representation of the outstanding balance
     */
    public double getCardBalance() 
    {
        return 0;
    }

    /**
     * Phone number linked to a MobilePayment
     * @return the String representation of the phone number
     */
    public String getPhoneNumber() 
    {
        return null;
    }

    /**
     * From 1 to 5 stars, the star rating of the user of the MobilePayment
     * @return the integer representation of the star rating
     */
    public int getStarRating() 
    {
        return 0;
    }

    /**
     * The digital wallet ID linked to the DigitalWalletPayment
     * @return the String representation of the wallet ID
     */
    public String getWalletId() 
    {
        return null;
    }

    /**
     * The number of previous transactions made by the digital wallet
     * of the DigitalWalletPayment
     * @return the integer representation of the number of previous transactions
     */
    public int getPreviousNumTransactions() 
    {
        return 0;
    }

    /**
     * The risk associated with an instance of a CardPayment
     * @return the risk represented as a double
     */
    public double calculateCardRisk() 
    {
        return 0;
    }

    /**
     * The risk associated with an instance of an ElectronicPayment
     * @return the risk represented as a double
     */
    public double calculateDigitalRisk() 
    {
        return 0;
    }
}
