package inventory;

import javax.swing.*;
import java.awt.*;

public class GameGUI extends JFrame {

    private static JTextArea outputArea;
    private static DefaultListModel<String> inventoryModel;

    private JTextField commandField;
    private JList<String> inventoryList;

    public GameGUI() {

        setTitle("Text Adventure");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main text area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        // Bigger font
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 20));

        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Inventory panel
        inventoryModel = new DefaultListModel<>();
        inventoryList = new JList<>(inventoryModel);

        // Bigger inventory font
        inventoryList.setFont(new Font("Monospaced", Font.PLAIN, 18));

        JPanel inventoryPanel = new JPanel(new BorderLayout());
        inventoryPanel.add(new JLabel("Inventory"), BorderLayout.NORTH);
        inventoryPanel.add(new JScrollPane(inventoryList), BorderLayout.CENTER);
        inventoryPanel.setPreferredSize(new Dimension(150, 0));

        add(inventoryPanel, BorderLayout.EAST);

        // Command field
        commandField = new JTextField();

        // Bigger command font
        commandField.setFont(new Font("Monospaced", Font.PLAIN, 18));

        commandField.addActionListener(e -> {

            String command = commandField.getText().trim();

            if (!command.isEmpty()) {

                printToScreen("> " + command);
                Game.processCommand(command);
            }

            commandField.setText("");
        });

        add(commandField, BorderLayout.SOUTH);

        setVisible(true);

        // Start game
        Game.startGame();
    }

    public static void printToScreen(String text) {
        outputArea.append(text + "\n");

        // Automatically scroll to the newest text
        outputArea.setCaretPosition(
                outputArea.getDocument().getLength());
    }

    public static void updateInventoryList(String[] items) {

        inventoryModel.clear();

        for (String item : items) {
            inventoryModel.addElement(item);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new GameGUI();
        });
    }
}