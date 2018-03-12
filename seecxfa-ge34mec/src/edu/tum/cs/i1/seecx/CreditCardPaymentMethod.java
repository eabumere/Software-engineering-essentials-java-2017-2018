package edu.tum.cs.i1.seecx;

public class CreditCardPaymentMethod implements PaymentMethod{

    private String creditCardNumber = "1234123412341234";

    public Boolean executePayment(Double price, Double payment) {

    	System.out.println("Execute credit card payment with " + payment + " EUR");

        if(payment < price) {
            System.out.println("Did not get enough money!");
            return false;
        }  
        else if(payment > price) {
        	System.out.println("Cannot pay more money than the price. Change is not possible for credit cards");
        	return false;
        }
        else {
            System.out.println("Connecting to payment provider...");
            System.out.println("Sending data for credit card " + creditCardNumber);
            System.out.println("Retreiving money " + payment + " EUR");
            System.out.println("Done!");
            
            return true;
        }
    }
}
