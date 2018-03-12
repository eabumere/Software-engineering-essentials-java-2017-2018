package edu.tum.cs.i1.seecx;

public class Context {

	private Double price;
	private PaymentMethod paymentMethod;
	private PaymentPreference preference;
	
	public PaymentMethod getPaymentMethod() {
    	//TODO: method stub that needs to be implemented
    	return paymentMethod;
    }
    
	public void setPaymentMethod(PaymentMethod paymentMethod) {
    	//TODO: method stub that needs to be implemented
		this.paymentMethod = paymentMethod;
    }
    
	public Double getPrice() {
    	//TODO: method stub that needs to be implemented
    	return price;
    }

    public void setPrice(Double price) {
    	//TODO: method stub that needs to be implemented
    	this.price = price;
    }

    public PaymentPreference getPaymentPreference() {
    	//TODO: method stub that needs to be implemented
    	return preference;
    }
    
    public void setPaymentPreference(PaymentPreference preference) {
    	//TODO: method stub that needs to be implemented
    	this.preference = preference;
    }
    
    public Boolean executePayment(Double price, Double payment) {
    	//TODO: method stub that needs to be implemented
    	return paymentMethod.executePayment(price, payment);
    }
}