package Main;

import javax.swing.*;
import java.awt.*;

public class CafeGUI extends JFrame {

    private Cafe cafe = new Cafe();
    private JTextArea displayArea;

    public CafeGUI() {
        setTitle("Cafe Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        JButton addOrderButton = new JButton("Add Order");
        JButton showOrdersButton = new JButton("Show All Orders");
        JButton findOrderButton = new JButton("Find Order");
        JButton deleteOrderButton = new JButton("Delete Order");

        buttonsPanel.add(addOrderButton);
        buttonsPanel.add(showOrdersButton);
        buttonsPanel.add(findOrderButton);
        buttonsPanel.add(deleteOrderButton);

        mainPanel.add(buttonsPanel, BorderLayout.NORTH);

        // Display area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // --- Action Listeners ---

        // Show All Orders
        showOrdersButton.addActionListener(e -> {
            displayArea.setText(cafe.getAllOrdersInfo());
        });

        // Find Order
        findOrderButton.addActionListener(e -> {
            String customerName = JOptionPane.showInputDialog(this, "Enter customer name:");
            if (customerName != null && !customerName.trim().isEmpty()) {
                displayArea.setText(cafe.findOrderInfo(customerName));
            }
        });

        // Delete Order
        deleteOrderButton.addActionListener(e -> {
            String customerName = JOptionPane.showInputDialog(this, "Enter customer name to delete orders:");
            if (customerName != null && !customerName.trim().isEmpty()) {
                String result = cafe.removeOrder(customerName);
                JOptionPane.showMessageDialog(this, result);
                displayArea.setText(cafe.getAllOrdersInfo()); // Refresh the list
            }
        });

        // Add Order
        addOrderButton.addActionListener(e -> {
            showAddOrderDialog();
        });


        add(mainPanel);
    }

    private void showAddOrderDialog() {
        String[] options = {"Food", "Drink"};
        int choice = JOptionPane.showOptionDialog(this, "What would you like to add?", "Add Order",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (choice == 0) { // Food
            addFoodOrder();
        } else if (choice == 1) { // Drink
            addDrinkOrder();
        }
    }

    private void addFoodOrder() {
        try {
            String customerName = JOptionPane.showInputDialog(this, "Enter customer name:");
            if (customerName == null) return;
            String dishName = JOptionPane.showInputDialog(this, "Enter dish name:");
            if (dishName == null) return;
            double price = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter dish price:"));
            int calories = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter dish calories:"));

            Food food = new Food(customerName, dishName, price, calories);
            cafe.addOrder(food);
            JOptionPane.showMessageDialog(this, "Food order added successfully!");
            displayArea.setText(cafe.getAllOrdersInfo());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addDrinkOrder() {
        try {
            String customerName = JOptionPane.showInputDialog(this, "Enter customer name:");
            if (customerName == null) return;
            String dishName = JOptionPane.showInputDialog(this, "Enter drink name:");
            if (dishName == null) return;
            double price = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter drink price:"));
            int volume = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter drink volume:"));

            Drink drink = new Drink(customerName, dishName, price, volume);
            cafe.addOrder(drink);
            JOptionPane.showMessageDialog(this, "Drink order added successfully!");
            displayArea.setText(cafe.getAllOrdersInfo());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CafeGUI gui = new CafeGUI();
            gui.setVisible(true);
        });
    }
}