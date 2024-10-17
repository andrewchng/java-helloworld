
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.resturant.payment.PaymentProcesser;
import com.resturant.payment.paymentStrategy.CreditCardPayment;
import com.resturant.payment.paymentStrategy.PayPalPayment;
import com.resturant.payment.paymentStrategy.PaymentStrategy;
import com.resturant.payment.receiptStrategy.EmailReceipt;
import com.resturant.payment.receiptStrategy.ReceiptStrategy;
import com.resturant.payment.receiptStrategy.SMSReceipt;

public class Main {

    public static void main(String[] args) {
        Map<Integer, PaymentStrategy> paymentMap = new HashMap<>();
        Map<Integer, ReceiptStrategy> receiptMap = new HashMap<>();

        paymentMap.put(1, new PayPalPayment());
        paymentMap.put(2, new CreditCardPayment());
        
        receiptMap.put(1, new SMSReceipt());
        receiptMap.put(2, new EmailReceipt());

        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("Please select a payment option");
            for(Map.Entry<Integer, PaymentStrategy> entry : paymentMap.entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue().getPaymentType());
            }
            int paymentOption = scanner.nextInt();

            PaymentStrategy selectedStrategy = paymentMap.get(paymentOption);

            System.out.println("Please select a receipt option");
            for(Map.Entry<Integer, ReceiptStrategy> entry : receiptMap.entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue().getReceiptType());
            }
            int receiptOption = scanner.nextInt();

            ReceiptStrategy selectedReceiptStrategy = receiptMap.get(receiptOption);

            PaymentProcesser paymentProcesser = new PaymentProcesser();
            paymentProcesser.setPaymentStrategy(selectedStrategy);
            paymentProcesser.setReceiptStrategy(selectedReceiptStrategy);
            paymentProcesser.processPayment(10);

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
