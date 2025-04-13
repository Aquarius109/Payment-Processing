// Title: CreditPayment 
// Files: CreditPayment.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa

/** 
 * The class extends the CardPayment class to create a subclass of 
 * credit payment instances.
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */
public class CreditPayment extends CardPayment 
{
    private double creditLimit;
    private double cardBalance;

    private static final String TYPE = "CreditPayment";

    /**
     * No-arg constructor of the CreditPayment class
     */
    public CreditPayment() {}

    /**
     * Constructs DebitPayment object instance.
     * 
     * @param transactionName name of transaction
     * @param amount value of amount transacted
     * @param timestamp time of transaction
     * @param cardNumber card number
     * @param expiryMonth month of expiry for credit card
     * @param expiryYear year of expiry for credit card
     * @param creditLimit credit limit of card associated with credit payment
     * @param cardBalance outstanding balance on card associated with credit
     * payment
     */
    public CreditPayment(String transactionName, double amount,
                            String timestamp, String cardNumber,
                            int expiryMonth, int expiryYear,
                            double creditLimit, double cardBalance) 
    {
        super(transactionName, amount, timestamp, cardNumber, expiryMonth,
            expiryYear);
        this.creditLimit = creditLimit;
        this.cardBalance = cardBalance;
    }

    /**
     * Gets credit limit associated with credit payment.
     * @return double value of credit limit
     */
    @Override
    public double getCreditLimit() 
    {
        return this.creditLimit;
    }

    /**
     * Gets credit card balance.
     * @return double value of credit card balance
     */
    @Override
    public double getCardBalance() 
    {
        return this.cardBalance;
    }

    /**
     * Gets type associated with credit payment.
     * @return string value of type of payment
     */
    @Override
    public String getType() 
    {
        return this.TYPE;
    }

    /**
     * Determines whether object has same contents as CreditPayment 
     * instance.
     * @param object object to be compared
     * @return validation that the two objects are the same or not the same
     */
    @Override
    public boolean equals(Object object) 
    {
        CreditPayment paymentObject = (CreditPayment) object;
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
        boolean isCreditLim = this.creditLimit == 
            paymentObject.getCreditLimit();
        boolean isCardBalance = this.cardBalance == 
            paymentObject.getCardBalance();

        return isTransactionName && isAmountEqual && isTimeStamp 
            && isCardNum && isExpMonth && isExpYear && isCreditLim && 
            isCardBalance;
    }

    /**
     * Calculates risk of credit payment.
     * @return double value of card risk
     */
    @Override
    public double calculateCardRisk() 
    {
        double availableCredit = this.creditLimit - this.cardBalance;
        return super.getAmount() - availableCredit;
    }

    /**
     * Prints payment details
     * @return a string value
     */
    @Override
    public String toString() 
    {
        return "CreditPayment (" + getTransactionName() +
            ") creditLimit: " + getCreditLimit() + ", cardBalance: " +
                getCardBalance();
    }
}
