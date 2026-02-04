package Main;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CafeGUI gui = new CafeGUI();
            gui.setVisible(true);
        });
    }
}