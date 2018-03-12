package edu.tum.cs.i1.seecx;

public class Policy {
    private Context context;
	
    public void setContext(Context context) {
    	//TODO: method stub that needs to be implemented
    	this.context = context;
    }

    public void configure() {
    	//TODO: method stub that needs to be implemented
    	if (context.getPaymentPreference().equals(PaymentPreference.prefersCash)) {
    		context.setPaymentMethod(new CashPaymentMethod());
    	} else if (context.getPaymentPreference() == PaymentPreference.prefersCreditCard) {
    		if (context.getPrice() >= 20)
    			context.setPaymentMethod(new CreditCardPaymentMethod());
    		else {
    			context.setPaymentPreference(PaymentPreference.prefersCash);
    			context.setPaymentMethod(new CashPaymentMethod());
    		}
    	}
    }
}