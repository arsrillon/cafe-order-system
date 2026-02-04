package Main;

public abstract class Order {
    private String customerName;
    private String dishName;
    private double price;

    public Order() {

    }

    public Order(String customerName, String dishName, double price) {
        this.customerName = customerName;
        this.dishName = dishName;
        this.price = price;
    }

    public String getInfo() {
        return "Customer: " + customerName + ". Dish: " + dishName + ". Price: " + price + ".";
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getDishName() {
        return dishName;
    }
    public double getPrice() {
        return price;
    }
}
