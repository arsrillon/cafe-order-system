package Main;

public class Food extends Order {
    private int calories;
    public Food(String customerName, String dishName, double price, int calories) {
        super(customerName, dishName, price);
        this.calories = calories;
    }
    @Override
    public String getInfo() {
        return "Customer: " + getCustomerName() + ". Dish: " + getDishName() + ". Price: " + getPrice() + ". Calories: " + calories + ".";
    }
}
