package com.resturant.payment.paymentStrategy;
public class PayPalPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paying with Paypal");
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.PAYPAL;
    }
    
}
