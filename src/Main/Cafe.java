package Main;

import java.util.ArrayList;
import java.util.Iterator;

public class Cafe {
    ArrayList<Order> order = new ArrayList<>();

    public void addOrder(Order order) {
        this.order.add(order);
    }

    public String getAllOrdersInfo() {
        if (order.isEmpty()) {
            return "No orders yet.";
        }
        StringBuilder sb = new StringBuilder();
        for (Order i : order) {
            sb.append(i.getInfo()).append("\n");
        }
        return sb.toString();
    }

    public String findOrderInfo(String customerName) {
        boolean found = false;
        StringBuilder sb = new StringBuilder();
        for (Order i : order) {
            if (i.getCustomerName().equalsIgnoreCase(customerName)) {
                sb.append(i.getInfo()).append("\n");
                found = true;
            }
        }
        if (!found) {
            return "Order is not found!";
        }
        return sb.toString();
    }

    public String removeOrder(String customerName) {
        boolean found = false;
        Iterator<Order> iterator = order.iterator();
        while (iterator.hasNext()) {
            Order o = iterator.next();
            if (o.getCustomerName().equalsIgnoreCase(customerName)) {
                iterator.remove();
                found = true;
            }
        }
        if (found) {
            return "Orders for " + customerName + " have been removed.";
        } else {
            return "No orders found for " + customerName + ".";
        }
    }
}