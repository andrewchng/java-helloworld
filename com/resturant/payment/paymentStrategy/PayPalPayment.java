package com.resturant.payment.paymentStrategy;
public class PayPalPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paying with Paypal: $"+ amount);
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.PAYPAL;
    }
    
}
