package edu.tum.cs.i1.seecx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class PaymentTest {
	
	String errorMessage = "The pattern was NOT implemented correctly.";

	@Test(timeout = 500)
	public void testPatternImplementation1() {
		Context context = configurePayment(15.0, PaymentPreference.prefersCash);
		PaymentMethod paymentMethod = context.getPaymentMethod();
		assertNotNull(errorMessage, paymentMethod);
	}

	@Test(timeout = 500)
	public void testPatternImplementation2() {
		assertTrue(errorMessage, PaymentMethod.class.isAssignableFrom(CashPaymentMethod.class));
	}

	@Test(timeout = 500)
	public void testPatternImplementation3() {
		assertTrue(errorMessage, PaymentMethod.class.isAssignableFrom(CreditCardPaymentMethod.class));
	}
	
	@Test(timeout = 500)
	public void testPatternImplementation4() {
		try {
			Field field = Context.class.getDeclaredField("price");
			assertTrue(errorMessage, field.getType() == Double.class);
		} catch(Exception ex) {
			fail(errorMessage);
		}
	}
	
	@Test(timeout = 500)
	public void testPatternImplementation5() {
		try {
			Method method = PaymentMethod.class.getDeclaredMethod("executePayment", Double.class, Double.class);
			System.out.println(method.getReturnType());
			assertEquals(errorMessage, method.getReturnType(), Boolean.class);
		} catch(Exception ex) {
			fail(errorMessage);
		}
	}
	
	@Test(timeout = 500)
	public void testPaymentCashBelow20EUR() {
		Double price = 15.0;
		Context context = configurePayment(price, PaymentPreference.prefersCash);
		PaymentMethod paymentMethod = context.getPaymentMethod();
		assertNotNull("The pattern was NOT implemented correctly.", paymentMethod);
		assertEquals("Payment for cash below 20 EUR not configured properly", paymentMethod.getClass(), CashPaymentMethod.class);
        Boolean success = context.executePayment(price,10.0);
        assertFalse("Cash payment was too low, but still successful", success);
        System.out.println("Payment was" + (success ? "" : " NOT") + " successful");
	}
	
	@Test(timeout = 500)
	public void testPaymentCashHigher20EUR() {
		Double price = 25.0;
		Context context = configurePayment(price, PaymentPreference.prefersCash);
		PaymentMethod paymentMethod = context.getPaymentMethod();
		assertNotNull("The pattern was NOT implemented correctly.", paymentMethod);
		assertEquals("Payment for cash higher 20 EUR not configured properly", paymentMethod.getClass(), CashPaymentMethod.class);
        Boolean success = context.executePayment(price, 30.0);
        assertTrue("Cash payment was high enough, but not successful", success);
        System.out.println("Payment was" + (success ? "" : " NOT") + " successful");
	}
	
	@Test(timeout = 500)
	public void testPaymentCreditCardBelow20EUR() {
		Double price = 15.0;
		Context context = configurePayment(price, PaymentPreference.prefersCreditCard);
		PaymentMethod paymentMethod = context.getPaymentMethod();
		assertNotNull("The pattern was NOT implemented correctly.", paymentMethod);
		assertEquals("Payment for credit card below 20 EUR not configured properly", paymentMethod.getClass(), CashPaymentMethod.class);
		Boolean success = context.executePayment(price, 20.0);
		assertTrue("Cash payment was high enough, but not successful", success);
        System.out.println("Payment was" + (success ? "" : " NOT") + " successful");
	}

	@Test(timeout = 500)
	public void testPaymentCreditCardHigher20EURSuccess() {
		Double price = 25.0;
		Context context = configurePayment(price, PaymentPreference.prefersCreditCard);
		PaymentMethod paymentMethod = context.getPaymentMethod();
		assertNotNull("The pattern was NOT implemented correctly.", paymentMethod);
		assertEquals("Payment for credit card higher 20 EUR not configured properly", paymentMethod.getClass(), CreditCardPaymentMethod.class);
        Boolean success = context.executePayment(price, 25.0);
        assertTrue("Credit card payment should succeed for the case payment == price", success);
        System.out.println("Payment was" + (success ? "" : " NOT") + " successful");
	}
	
	@Test(timeout = 500)
	public void testPaymentCreditCardHigher20EURFails() {
		Double price = 25.0;
		Context context = configurePayment(price, PaymentPreference.prefersCreditCard);
		PaymentMethod paymentMethod = context.getPaymentMethod();
		assertNotNull("The pattern was NOT implemented correctly.", paymentMethod);
		assertEquals("Payment for credit card higher 20 EUR not configured properly", paymentMethod.getClass(), CreditCardPaymentMethod.class);
        Boolean success = context.executePayment(price, 30.0);
        assertFalse("Credit card payment should succeed for the case payment != price", success);
        System.out.println("Payment was" + (success ? "" : " NOT") + " successful");
	}
	
	private Context configurePayment(Double price, PaymentPreference paymentPreference) {
		Context context = new Context(); 
		Policy policy = new Policy();
		policy.setContext(context);
		context.setPrice(price);
        context.setPaymentPreference(paymentPreference);
        policy.configure();
        return context;
	}
}
