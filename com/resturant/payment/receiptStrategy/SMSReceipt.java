package com.resturant.payment.receiptStrategy;
public class SMSReceipt implements ReceiptStrategy {

    @Override
    public void generateReceipt(double amount) {
        System.out.println("SMS Receipt");
    }

    @Override
    public ReceiptType getReceiptType() {
        return ReceiptType.SMS;
    }
    
}
