
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.resturant.menu.BeverageItem;
import com.resturant.menu.ComboItem;
import com.resturant.menu.FoodItem;
import com.resturant.menu.Menu;
import com.resturant.menu.MenuItem;
import com.resturant.payment.PaymentProcesser;
import com.resturant.payment.paymentStrategy.CreditCardPayment;
import com.resturant.payment.paymentStrategy.PayPalPayment;
import com.resturant.payment.paymentStrategy.PaymentStrategy;
import com.resturant.payment.receiptStrategy.EmailReceipt;
import com.resturant.payment.receiptStrategy.ReceiptStrategy;
import com.resturant.payment.receiptStrategy.SMSReceipt;

public class Main {

    public static void main(String[] args) {

        Menu menu = createMenu();

        Map<Integer, PaymentStrategy> paymentMap = new HashMap<>();
        Map<Integer, ReceiptStrategy> receiptMap = new HashMap<>();

        paymentMap.put(1, new PayPalPayment());
        paymentMap.put(2, new CreditCardPayment());
        
        receiptMap.put(1, new SMSReceipt());
        receiptMap.put(2, new EmailReceipt());

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Please choose your food!");
            System.out.println(menu.printMenu());


            ArrayList<MenuItem> orders = new ArrayList<>();

            boolean stillPicking = true;
            while(stillPicking){
                int foodOption = scanner.nextInt();
                if(foodOption > menu.getItems().size() || foodOption < 1){
                    System.out.println("invalid option, Please choose again.");
                    continue;
                }
                System.out.println("How many do you want?");
                int noOfItems = scanner.nextInt();

                MenuItem selectedItem = menu.getItemByIndex(foodOption-1);
                for(int i =0; i < noOfItems; i++){
                    orders.add(selectedItem);
                }                

                System.out.println("Continue to order?");
                String continueOrderOption = scanner.next();
                stillPicking = continueOrderOption.equals("y");
            }
            
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
            paymentProcesser.processPayment(calculateOrder(orders));

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }


    private static double calculateOrder(ArrayList<MenuItem> orders){
        double cost = 0;
        for(MenuItem item : orders){
            cost = cost + item.getPrice();
        }

        return cost;
    }



    private static Menu createMenu() {
        Menu menu = new Menu();
        MenuItem pizza = new FoodItem("Pizza", 20, null, null);
        MenuItem burger = new FoodItem("Burger", 10, null, null);

        MenuItem coke = new BeverageItem("Coke", 3, false);
        MenuItem beer = new BeverageItem("Beer", 5, true);
        

        ComboItem burgerMeal = new ComboItem("Burger set", 11);
        burgerMeal.addComboItem(burger);
        burgerMeal.addComboItem(coke);

        ComboItem PizzaMeal = new ComboItem("Pizza set", 11);
        PizzaMeal.addComboItem(beer);
        PizzaMeal.addComboItem(pizza);

        menu.addItem(pizza);
        menu.addItem(burger);
        menu.addItem(coke);
        menu.addItem(beer);
        menu.addItem(PizzaMeal);
        menu.addItem(burgerMeal);

        return menu;
    }
}
