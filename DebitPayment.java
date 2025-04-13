// Title: DebitPayment 
// Files: DebitPayment.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa

/** 
 * The DebitPayment class extends the CardPayment class to create a subclass of 
 * debit payment instances.
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */
public class DebitPayment extends CardPayment 
{
    private double bankBalance;

    private static final String TYPE = "DebitPayment";

    /**
     * No-arg constructor of the DebitPayment class
     */
    public DebitPayment() {}

    /**
     * Constructs DebitPayment object instance.
     * 
     * @param transactionName name of transaction
     * @param amount value of amount transacted
     * @param timestamp time of transaction
     * @param cardNumber card number
     * @param expiryMonth month of card expiry
     * @param expiryYear year of debit card expiration
     * @param bankBalance amount of balance in bank account associated with 
     * debit payment
     */
    public DebitPayment(String transactionName, double amount,
                                String timestamp, String cardNumber,
                                int expiryMonth, int expiryYear,
                                double bankBalance) 
    {
        super(transactionName, amount, timestamp, cardNumber, expiryMonth,
            expiryYear);
        this.bankBalance = bankBalance; 
    }

    /**
     * Gets bank balance amount associated with debit payment.
     * @return double value of bank balance
     */
    @Override
    public double getBankBalance() 
    {
        return this.bankBalance;
    }

    /**
     * Gets type of payment method.
     * @return string value of type
     */
    @Override
    public String getType() 
    {
        return this.TYPE;
    }

    /**
     * Determines whether object has same contents as DebitPayment 
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
        DebitPayment paymentObject = (DebitPayment) object;
        boolean isTransactionName = super.getTransactionName()
            .equals(paymentObject.getTransactionName());
        boolean isAmountEqual = super.getAmount() == paymentObject.getAmount();
        boolean isTimeStamp = super.getTimestamp()
            .equals(paymentObject.getTimestamp());
        boolean isCardNum = super.getCardNumber()
            .equals(paymentObject.getCardNumber());
        boolean isExpMonth = super.getExpiryMonth() == 
            paymentObject.getExpiryMonth();
        boolean isExpYear = super.getExpiryYear() == 
            paymentObject.getExpiryYear();
        boolean isBankBalance = this.bankBalance == 
            paymentObject.getBankBalance();

        return isTransactionName && isAmountEqual && isTimeStamp 
            && isCardNum && isExpMonth && isExpYear && isBankBalance;
    }

    /**
     * Calculates risk of debit payment.
     * @return double value of card risk
     */
    @Override
    public double calculateCardRisk() 
    {
        return super.getAmount() - this.bankBalance;
    }

    /**
     * Prints payment details
     * @return a string value
     */
    @Override
    public String toString() 
    {
        return "DebitPayment (" + getTransactionName() +
            ") bankBalance: " + getBankBalance();
    }
}
