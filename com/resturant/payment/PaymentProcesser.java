package com.resturant.payment;
import com.resturant.payment.paymentStrategy.PaymentStrategy;
import com.resturant.payment.receiptStrategy.ReceiptStrategy;

public class PaymentProcesser {

    private ReceiptStrategy receiptStrategy;
    private PaymentStrategy paymentStrategy;

    public void setReceiptStrategy(ReceiptStrategy receiptStrategy) {
        this.receiptStrategy = receiptStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        if (paymentStrategy == null || receiptStrategy == null) {
            throw new RuntimeException("Payment or Receipt strategy not set");
        }
        receiptStrategy.generateReceipt(amount);
        paymentStrategy.pay(amount);
    }

}
