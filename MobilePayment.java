// Title: MobilePayment 
// Files: MobilePayment.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa

/** 
 * The MobilePayment class extends the ElectronicPayment class to create a 
 * subclass of mobile payment instances.
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */
public class MobilePayment extends ElectronicPayment 
{
    private String phoneNumber;
    private int starRating;

    private static final String TYPE = "MobilePayment";

    private static final double MAX_STAR_RATING = 5.0;

    /**
     * No-arg constructor for the MobilePayment class
     */
    public MobilePayment() {}

    /**
     * Constructs MobilePayment object instance.
     * 
     * @param transactionName name of transaction
     * @param amount value of amount transacted
     * @param timestamp time of transaction
     * @param accountId account identification number
     * @param emailAddress email address associated with payment method
     * @param phoneNumber phone number associated with mobile payment
     * @param starRating star rating given to product
     */
    public MobilePayment(String transactionName, double amount,
                                String timestamp, long accountId,
                                String emailAddress, String phoneNumber,
                                int starRating) 
    {
        super(transactionName, amount, timestamp, accountId, emailAddress);
        this.phoneNumber = phoneNumber;
        this.starRating = starRating;
    }

    /**
     * Gets phone number associated with mobile payment.
     * @return phone number
     */
    @Override
    public String getPhoneNumber() 
    {
        return this.phoneNumber;
    }

    /**
     * Gets star rating associated with mobile payment.
     * @return star rating
     */
    @Override
    public int getStarRating() 
    {
        return this.starRating;
    }

    /**
     * Gets type value associated with mobile payment.
     * @return type value
     */
    @Override
    public String getType() 
    {
        return this.TYPE;
    }

    /**
     * Determines whether object has same contents as MobilePayment 
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
        MobilePayment paymentObject = (MobilePayment) object;
        boolean isTransactionName = super.getTransactionName()
            .equals(paymentObject.getTransactionName());
        boolean isAmountEqual = super.getAmount() == paymentObject.getAmount();
        boolean isTimeStamp = super.getTimestamp()
            .equals(paymentObject.getTimestamp());
        boolean isAccountId = super.getAccountId() == 
            paymentObject.getAccountId();
        boolean isEmail = super.getEmailAddress()
            .equals(paymentObject.getEmailAddress());
        boolean isPhone = this.phoneNumber
            .equals(paymentObject.getPhoneNumber());
        boolean isRating = this.starRating == paymentObject.getStarRating();

        return isTransactionName && isAmountEqual && isTimeStamp 
            && isAccountId && isEmail && isPhone && isRating;
    }

    /**
     * Calculates risk of digital payment.
     * @return double value of digital payment risk
     */
    @Override
    public double calculateDigitalRisk() 
    {
        double starRatingNormalized = this.starRating/MAX_STAR_RATING;
        return super.getAmount()/starRatingNormalized;
    }

    /**
     * Prints payment details
     * @return a string value
     */
    @Override
    public String toString() 
    {
        return "MobilePayment (" + getTransactionName() +
            ") phoneNumber: " + getPhoneNumber() + ", starRating: " +
                getStarRating();
    }
}
