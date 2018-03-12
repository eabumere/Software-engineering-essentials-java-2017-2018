package edu.tum.cs.i1.seecx;

import java.util.Random;

public class Client {
	
	//IMPORTANT: this class should NOT be changed

    public static void main(String[] args)  {

    	Context context = new Context();
    	Policy policy = new Policy();
    	policy.setContext(context);
    	
        // Run 10 times to simulate different customers
        for (int i = 0; i < 10; i++) {
            PaymentPreference paymentPreference = randomPaymentPreference();
            Double price = randomNumber(5.0, 40.0);
            Double payment = randomNumber(10.0, 45.0);

            System.out.println();
            System.out.println("Customer with bill of " + price + " EUR and preference to pay via " + 
            			(paymentPreference == PaymentPreference.prefersCash ? "Cash" : "Credit Card"));

            context.setPrice(price);
            context.setPaymentPreference(paymentPreference);

            policy.configure();
            
            Boolean success = context.executePayment(price, payment);
            System.out.println("Payment was" + (success ? "" : " NOT") + " successful");
        }
    }

    /**
     * Creates a random Double within given Range low ... high
     */
    public static Double randomNumber(Double low, Double high) {
        Random rand = new Random();
        Double amount = (high - low) * rand.nextDouble() + low;
        amount = (double)(Math.round(amount * 100)) / 100;
        return  amount;
    }

    /**
     * Creates a random PaymentPreference (cash or credit card)
     *
     * @return PaymentPreference.prefersCash or PaymentPreference.prefersCreditCard
     */
    public static PaymentPreference randomPaymentPreference() {
        return Math.random() < 0.5 ? PaymentPreference.prefersCash : PaymentPreference.prefersCreditCard;
    }
}