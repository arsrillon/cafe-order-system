package Main;

public class Drink extends Order {
    private int volume;
    public Drink(String customerName, String dishName, double price, int volume) {
        super(customerName, dishName, price);
        this.volume = volume;
    }
    @Override
    public void showInfo() {
        System.out.println("Customer: " + getCustomerName() + ". Dish: " + getDishName() + ". Price: " + getPrice() + ". Volume: " + volume + ".");
    }
}
