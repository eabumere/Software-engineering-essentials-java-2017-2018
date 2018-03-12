package edu.tum.cs.i1.seecx;

public class CashPaymentMethod implements PaymentMethod{

    public Boolean executePayment(Double price, Double payment) {

    	System.out.println("Execute cash payment with " + payment + " EUR");

        if(payment < price) {
            System.out.println("Did not get enough money!");
            return false;
        } 
        else {
            System.out.println("Change: " + (double)Math.round((payment - price) * 100) / 100 + " EUR");
            return true;
        }
    }
}
