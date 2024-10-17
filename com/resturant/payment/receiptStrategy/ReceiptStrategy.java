package com.resturant.payment.receiptStrategy;
public interface ReceiptStrategy {
    void generateReceipt(double amount);
    ReceiptType getReceiptType();
}
