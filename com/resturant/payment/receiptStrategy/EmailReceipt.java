package com.resturant.payment.receiptStrategy;
public class EmailReceipt implements ReceiptStrategy {

    @Override
    public void generateReceipt(double amount) {
        System.out.println("Email Receipt");
    }

    @Override
    public ReceiptType getReceiptType() {
        return ReceiptType.EMAIL;
    }
}
