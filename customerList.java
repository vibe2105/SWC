import java.util.*;
import java.io.*;
import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class customerList {
    public static void main(String[] args) throws Exception {
        try {
            Queue qItem = new Queue();
            Queue qCustomer = new Queue();
            Queue qCounter1 = new Queue();
            Queue qCounter2 = new Queue();
            Queue qCounter3 = new Queue();
            Queue qCompleted = new Queue();

            Stack<itemInformation> completedStack = new Stack<>();

            BufferedReader in = new BufferedReader(new FileReader("customerlist.txt"));
            LinkedList<customerInformation> customer = new LinkedList<>();
            ArrayList<itemInformation> itemInfo = new ArrayList<>();
            String inData = null;
            customerInformation cust;
            itemInformation item;

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


            while ((inData = in.readLine()) != null) {
                
                StringTokenizer st = new StringTokenizer(inData, ";");
                String iD = st.nextToken();
                String iC = st.nextToken();
                String counterPaid = st.nextToken();
                String itemId = st.nextToken();
                String itemName = st.nextToken();
                

                Date datePurchase;
                try {
                    datePurchase = dateFormat.parse(st.nextToken());
                } catch (ParseException e) {
                    System.out.println("Invalid date format: " + e.getMessage());
                    continue;
                }
                
                
                int numOfItem = Integer.parseInt(st.nextToken());
                String itemPriceString = st.nextToken().replaceAll("[^0-9.]", ""); // Remove non-numeric characters from the string

                double itemPrice;
                try {
                    itemPrice = Double.parseDouble(itemPriceString);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid item price: " + e.getMessage());
                    continue;
                }


                double totalPayment = numOfItem * itemPrice;
                
                cust = new customerInformation(iD, iC, counterPaid, numOfItem, totalPayment);
                item = new itemInformation(itemId, itemName, datePurchase, itemPrice);

                qCustomer.enqueue(cust);
                qItem.enqueue(item);
            }
            in.close();

            for (int i = 0; i < 5; i++) {
                cust = (customerInformation) qCustomer.dequeue();
                item = (itemInformation) qItem.dequeue();
                qCounter1.enqueue(cust);
            }

            for (int i = 0; i < 5; i++) {
                cust = (customerInformation) qCustomer.dequeue();
                item = (itemInformation) qItem.dequeue();
                qCounter2.enqueue(cust);
            }

            for (int i = 0; i < 5; i++) {
                cust = (customerInformation) qCustomer.dequeue();
                item = (itemInformation) qItem.dequeue();
                qCounter3.enqueue(cust);
            }
            
            String input;
            int menu = 0;
            do {
                

                input = JOptionPane.showInputDialog(
                        "Menu 1 - Remove and add new customer at Counter 1\n" +
                                "Menu 2 - Remove and add new customer at Counter 2\n" +
                                "Menu 3 - Remove and add new customer at Counter 3\n" +
                                "Menu 4 - Exit and display completed customer");
                menu = Integer.parseInt(input);

                if (menu == 1) {
                    while (!qCounter1.empty()) {
                        cust = (customerInformation) qCounter1.dequeue();
                        // Delete 1 customer from counter 1
                        item = (itemInformation) qCounter1.dequeue();

                        // Add new customer into counter 1
                        qCounter1.enqueue(qCustomer.dequeue());

                        // Calculate payment for customer that has been dequeued
                        double totalPayment = item.getItemPrice() * cust.getNumOfItem();

                        // Add into qCompleted
                        qCompleted.enqueue(item);

                        System.out.println("1. View Receipt");
                        System.out.println("2. No\n");

                        input = JOptionPane.showInputDialog("Do you want a Receipt?");
                        int submenu = Integer.parseInt(input);
                        System.out.println("Receipt");
                        if (submenu == 1) {
                            System.out.println("--------- Receipt ---------");
                            System.out.println("Customer ID: " + cust.getID());
                            System.out.println("Item ID: " + item.getItemId());
                            System.out.println("Quantity: " + cust.getNumOfItem());
                            System.out.println("Item Price: MYR " + item.getItemPrice());
                            System.out.println("Counter Paid: " + cust.getCounterPaid());
                            System.out.println("Date of Purchase: " + item.getDatePurchase());
                            System.out.println("Total Payment : " + cust.getTotalPayment());
                            System.out.println("---------------------------");
                            System.out.println();
                        }
                        
                        // Push the completed item to the stack
                        completedStack.push(item);

                        // Ask user either to continue or stop
                        String answer = JOptionPane.showInputDialog("Do you want to continue deleting customers? (Yes/No)");
                        if (answer.equalsIgnoreCase("No")) {
                            break;
                        }
                    }
                }

                if (menu == 2) {
                    while (!qCounter2.empty()) {
                        cust = (customerInformation) qCounter2.dequeue();
                        // Delete 1 customer from counter 2
                        item = (itemInformation) qCounter2.dequeue();

                        // Add new customer into counter 2
                        qCounter2.enqueue(qCustomer.dequeue());

                        // Calculate payment for customer that has been dequeued
                        double totalPayment = item.getItemPrice() * cust.getNumOfItem();

                        // Add into qCompleted
                        qCompleted.enqueue(item);

                        System.out.println("1. View Receipt");
                        System.out.println("2. No\n");

                        input = JOptionPane.showInputDialog("Do you want a Receipt?");
                        int submenu = Integer.parseInt(input);
                        System.out.println("Receipt");
                        if (submenu == 1) {
                            System.out.println("--------- Receipt ---------");
                            System.out.println("Customer ID: " + cust.getID());
                            System.out.println("Item ID: " + item.getItemId());
                            System.out.println("Quantity: " + cust.getNumOfItem());
                            System.out.println("Item Price: MYR " + item.getItemPrice());
                            System.out.println("Counter Paid: " + cust.getCounterPaid());
                            System.out.println("Date of Purchase: " + item.getDatePurchase());
                            System.out.println("Total Payment : " + cust.getTotalPayment());
                            System.out.println("---------------------------");
                            System.out.println();
                        }

                        // Push the completed item to the stack
                        completedStack.push(item);
                        
                        // Ask user either to continue or stop
                        String answer = JOptionPane.showInputDialog("Do you want to continue deleting customers? (Yes/No)");
                        if (answer.equalsIgnoreCase("No")) {
                            break;
                        }
                    }
                }

                if (menu == 3) {
                    while (!qCounter3.empty()) {
                        cust = (customerInformation) qCounter3.dequeue();
                        // Delete 1 customer from counter 3
                        item = (itemInformation) qCounter3.dequeue();

                        // Add new customer into counter 3
                        qCounter3.enqueue(qCustomer.dequeue());

                        // Calculate payment for customer that has been dequeued
                        double totalPayment = item.getItemPrice() * cust.getNumOfItem();

                        // Add into qCompleted
                        qCompleted.enqueue(item);

                        System.out.println("1. View Receipt");
                        System.out.println("2. No\n");

                        input = JOptionPane.showInputDialog("Do you want a Receipt?");
                        int submenu = Integer.parseInt(input);
                        System.out.println("Receipt");
                        if (submenu == 1) {
                            System.out.println("--------- Receipt ---------");
                            System.out.println("Customer ID: " + cust.getID());
                            System.out.println("Item ID: " + item.getItemId());
                            System.out.println("Quantity: " + cust.getNumOfItem());
                            System.out.println("Item Price: MYR " + item.getItemPrice());
                            System.out.println("Counter Paid: " + cust.getCounterPaid());
                            System.out.println("Date of Purchase: " + dateFormat.format(item.getDatePurchase()));
                            System.out.println("Total Payment : " + cust.getTotalPayment());
                            System.out.println("---------------------------");
                            System.out.println();
                        }
                        // Ask user either to continue or stop
                        String answer = JOptionPane.showInputDialog("Do you want to continue deleting customers? (Yes/No)");
                        if (answer.equalsIgnoreCase("No")) {
                            break;
                        }
                    }
                }
            } while (menu != 4);

            // Display all completed customers
            System.out.println("\nCompleted Customers:");
            while (!completedStack.isEmpty()) {
                item = completedStack.pop();
                System.out.println(item.getItemId() + " - " + item.getItemName());
            }
        
        
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        
         catch(NumberFormatException nfe) {
                    System.out.println("Number Format Exception" + nfe.getMessage());
                }
        }

}
