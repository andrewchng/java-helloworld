package com.resturant.payment.paymentStrategy;
public interface PaymentStrategy {
    void pay(double amount);
    PaymentType getPaymentType();
}
