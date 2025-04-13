// Title: CardPayment 
// Files: CardPayment.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa

/** 
 * The CardPayment class extends the Payment class to create a subclass of 
 * card payment instances.
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */
public class CardPayment extends Payment 
{
    private String cardNumber;
    private int expiryMonth;
    private int expiryYear;

    private static final String HIGH_LEVEL_TYPE = "CardPayment";
    private static final String TYPE = "Untyped CardPayment";

    /**
     * No-arg constructor of the CardPayment class
     */
    public CardPayment() {}

    /**
     * Constructs CardPayment object instance.
     * 
     * @param transactionName name of transaction
     * @param amount value of amount transacted
     * @param timestamp time of transaction
     * @param cardNumber 10-digit number on card
     * @param expiryMonth month of card expiration
     * @param expiryYear year of card expiration
     */
    public CardPayment(String transactionName, double amount,
                             String timestamp, String cardNumber,
                             int expiryMonth, int expiryYear) 
    {
        super(transactionName, amount, timestamp);
        this.cardNumber = cardNumber;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
    }

    /**
     * Gets card number of CardPayment instance.
     * @return card number string value
     */
    @Override
    public String getCardNumber() 
    {
        return this.cardNumber;
    }

    /**
     * Gets expiry month of CardPayment instance.
     * @return expiry month int value
     */
    @Override
    public int getExpiryMonth() 
    {
        return this.expiryMonth;
    }

    /**
     * Gets expiry year of CardPayment instance.
     * @return expiry year int value
     */
    @Override
    public int getExpiryYear() 
    {
        return this.expiryYear;
    }

    /**
     * Gets high level type value of CardPayment instance.
     * @return high level type string value
     */
    @Override
    public String getHighLevelType() 
    {
        return this.HIGH_LEVEL_TYPE;
    }

    /**
     * Gets type of CardPayment instance.
     * @return type value string value
     */
    @Override
    public String getType() 
    {
        return this.TYPE;
    }

    /**
     * Determines whether object has same contents as CardPayment instance.
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
        CardPayment newPayment = (CardPayment) object;
        boolean isTransactionName = super.getTransactionName()
            .equals(newPayment.getTransactionName());
        boolean isAmountEqual = super.getAmount() == newPayment.getAmount();
        boolean isTimeStamp = super.getTimestamp()
            .equals(newPayment.getTimestamp());
        boolean isExpMonEqual = this.expiryMonth == newPayment.getExpiryMonth();
        boolean isCardNumber = this.cardNumber
            .equals(newPayment.getCardNumber());
        boolean isExpYearEqual = this.expiryYear == newPayment.getExpiryYear();

        return isTransactionName && isAmountEqual && isTimeStamp 
            && isExpMonEqual && isExpYearEqual && isCardNumber; 
    }

    /**
     * Prints payment details.
     * @return a string value.
     */
    @Override
    public String toString() 
    {
        return "CardPayment (" + getTransactionName() +
            ") cardNumber: " + getCardNumber() + ", expiryMonth: " +
                getExpiryMonth() + ", expiryYear: " + getExpiryYear();
    }
}
