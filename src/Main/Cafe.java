package Main;

import java.util.ArrayList;
import java.util.Iterator;

public class Cafe {
    ArrayList<Order> order = new ArrayList<>();

    public void addOrder(Order order) {
        this.order.add(order);
    }
    public void showAllOrders() {
        System.out.println();
        for(Order i : order) {
            i.showInfo();
        }
        System.out.println();
    }
    public void findOrder(String customerName) {
        boolean found = false;
        System.out.println();
        for(Order i : order) {
            if(i.getCustomerName().equalsIgnoreCase(customerName)) {
                i.showInfo();
                found = true;
            }
        }
        if(!found) {
            System.out.println();
            System.out.println("Order is not found!");
        }
    }
    public void removeOrder(String customerName) {
        boolean found = false;
        Iterator<Order> iterator = order.iterator();
        while(iterator.hasNext()) {
            Order o = iterator.next();
            if(o.getCustomerName().equalsIgnoreCase(customerName)) {
                iterator.remove();
                found = true;
                System.out.println();
                System.out.println("Removed!");
                System.out.println();
            }
        }
        if(found) {
            System.out.println("Orders for " + customerName + " have been removed.");
        } else {
            System.out.println("No orders found for " + customerName + ".");
        }
    }
}
