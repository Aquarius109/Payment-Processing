// Title: PaymentProcessor
// Files: PaymentProcessor.java
// Quarter: (CSE 11) (Fall) (2024)
//
// Author: Srisarada Ramesh
// Email: srramesh@ucsd.edu
// Instructor's Name: Mr. Benjamin Ochoa

import java.util.ArrayList;

/** 
 * The PaymentProcessor class contains payment processing methods.
 * 
 * Bugs: No Bugs
 * 
 * @author Srisarada Ramesh
 */
public class PaymentProcessor 
{
    private ArrayList<Payment> paymentList;

    private static final int MAX_EXPIRY_MONTH = 12;
    private static final int MIN_EXPIRY_YEAR = 2025;
    private static final int MAX_STARS = 5;
    private static final String UCSD_EMAIL = "@ucsd.edu";
    private static final String CARD_PAYMENT = "CardPayment";
    private static final String ELECTRONIC_PAYMENT = "ElectronicPayment";
    private static final String DEBIT_PAYMENT = "DebitPayment";
    private static final String CREDIT_PAYMENT = "CreditPayment";
    private static final String MOBILE_PAYMENT = "MobilePayment";
    private static final String DIGITAL_WALLET_PAYMENT = "DigitalWalletPayment";
    private static final int numOfChars = 9;

    /**
     * No-arg constructor for PaymentProcessor class.
     */
    public PaymentProcessor() 
    {
        paymentList = new ArrayList<Payment>();
    }
    /**
     * Checks if ucsd.edu repeats more than once in email address.
     * @param emailAddress email address to be analyzed
     * @return a boolean value
     */
    private static boolean noEmailRepetition(String emailAddress)
    {
        String substring = "";
        int k = 0;
        for(int i = 0; i <= (emailAddress.length() - numOfChars); i++)
        {
            if(i < emailAddress.length() - numOfChars)
            {
                substring = emailAddress.substring(i, i + numOfChars);
            }

            else if(i == (emailAddress.length() - numOfChars))
            {
                substring = emailAddress.substring(i);
            }
            
            if(substring.contains(UCSD_EMAIL))
            {
                ++k;
            }
        }
        if(k == 1)
        {
            return true;
        }
        return false;
    }

    /**
     * Add a payment to paymentList.
     * @param payment payment object to be added to list
     */
    public void addToPaymentList(Payment payment) 
    {
        this.paymentList.add(payment);
    }

    /**
     * Add a set of Payment objects to paymentList.
     * @param payments array of Payment objects
     */
    public void addToPaymentList(Payment[] payments) 
    {
        for(int i = 0; i < payments.length; i++)
        {
            this.paymentList.add(payments[i]);
        }
    }

    /**
     * Checks if a specific payment exists in paymentList.
     * @param paymentTransactionName name of payment transaction being searched
     * @return boolean value of result
     */
    public boolean hasPayment(String paymentTransactionName) 
    {
        String transactionName = "";
        Payment paymentObject = new Payment();
        for(int i = 0; i < this.paymentList.size(); i++)
        {
            paymentObject = this.paymentList.get(i);
            transactionName = paymentObject.getTransactionName();
            if(paymentTransactionName.equals(transactionName))
            {
                return true;
            }

        }
        return false;
    }

    /**
     * Gets and removes specific payment from paymentList based on transaction
     * name.
     * @param paymentTransactionName name of transaction being searched for
     * @return Payment being removed
     */
    public Payment getAndRemovePayment(String paymentTransactionName) 
    {
        String transactionName = "";
        Payment paymentObject = new Payment();
        for(int i = 0; i < this.paymentList.size(); i++)
        {
            paymentObject = this.paymentList.get(i);
            transactionName = paymentObject.getTransactionName();
            if(paymentTransactionName.equals(transactionName))
            {
                this.paymentList.remove(paymentObject);
                return paymentObject;
            }

        }
        return null;
    }

    /**
     * Compare risks for two payments.
     * @param paymentOne first payment
     * @param paymentTwo second payment
     * @return an int value that represents which payment has more risk
     */
    public static int compareRisk(Payment paymentOne, Payment paymentTwo) 
    {
        double risk1;
        double risk2;
        if(paymentOne.getHighLevelType().equals("CardPayment"))
        {
            risk1 = paymentOne.calculateCardRisk();
        }
        else
        {
            risk1 = paymentOne.calculateDigitalRisk();
        }

        if(paymentTwo.getHighLevelType().equals("CardPayment"))
        {
            risk2 = paymentTwo.calculateCardRisk();
        }
        else
        {
            risk2 = paymentTwo.calculateDigitalRisk();
        }
        
        if(risk1 < risk2)
        {
            return -1;
        }
        else if(risk1 == risk2)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    /**
     * Choose a random Payment object from paymentList and add generate new
     * payment using increaseRate.
     * @param increaseRate rate of increase in payment
     * @return index of payment object selected from paymentList
     */
    public int applyPaymentSurge(double increaseRate) 
    {
        double amount = 0.0;
        double newPayment = 0.0;
        double randomDouble = Math.random();
        int randomIndex = (int)(randomDouble * this.paymentList.size());
        Payment randomPayment = this.paymentList.get(randomIndex);
        if(increaseRate > 1)
        {
            amount = randomPayment.getAmount();
            newPayment = amount*increaseRate;
            this.paymentList.get(randomIndex).setAmount(newPayment);
        }
        return randomIndex;
    }

    /**
     * Return a boolean that represents whether the payment is able to 
     * be processed.
     * @param payment Payment object to be processed
     * @return boolean value that represents status of process
     */
    public static boolean processPayment(Payment payment) 
    {
        if(payment.getAmount() >= 0)
        {
            if(payment.getHighLevelType().equals(CARD_PAYMENT))
            {
                if(payment.getExpiryMonth() >= 1 && 
                    payment.getExpiryMonth() <= MAX_EXPIRY_MONTH)
                {
                    if(payment.getExpiryYear() >= MIN_EXPIRY_YEAR)
                    {
                        if(payment.getType().equals(DEBIT_PAYMENT))
                        {
                            if(payment.getBankBalance() >= 0)
                            {
                                return true;
                            }
                        }

                        else if(payment.getType().equals(CREDIT_PAYMENT))
                        {
                            if(payment.getCardBalance() >= 0)
                            {
                                if(payment.getCreditLimit() >= 0)
                                {
                                    if(payment.getCreditLimit() >= 
                                        payment.getCardBalance())
                                    {
                                        return true;
                                    }
                                }
                            }
                        }

                        else
                        {
                            return true;
                        }
                    }
                }
            }

            else if(payment.getHighLevelType().equals(ELECTRONIC_PAYMENT))
            {
                String email = payment.getEmailAddress();
                if(noEmailRepetition(email) == true)
                {
                    if(payment.getType().equals(MOBILE_PAYMENT))
                    {
                        if(payment.getStarRating() >= 0 &&
                            payment.getStarRating() <= MAX_STARS)
                        {
                            return true;
                        }
                    }

                    else if(payment.getType().equals(
                        DIGITAL_WALLET_PAYMENT))
                    {
                        if(payment.getPreviousNumTransactions() >= 0)
                        {
                            return true;
                        }
                    }

                    else
                    {
                        return true;
                    }
                    
                }
            }   
        }
        return false;
    }

    /**
     * The getter method of the paymentList member variable
     * @return the paymentList of the PaymentProcessor instance
     */
    public ArrayList<Payment> getPaymentList() 
    {
        return this.paymentList;
    }
}
