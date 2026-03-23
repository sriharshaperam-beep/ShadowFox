import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class InventoryManagerGUI extends JFrame {

    private JTextField idField, nameField, quantityField, priceField;
    private JTable table;
    private DefaultTableModel model;

    public InventoryManagerGUI() {
        setTitle("Inventory Management System");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel panel = new JPanel(new GridLayout(5, 2));

        panel.add(new JLabel("Item ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Item Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        panel.add(quantityField);

        panel.add(new JLabel("Price:"));
        priceField = new JTextField();
        panel.add(priceField);

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        panel.add(addBtn);
        panel.add(updateBtn);
        panel.add(deleteBtn);

        add(panel, BorderLayout.NORTH);

        // Table
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Name", "Quantity", "Price"});
        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        // Button Actions
        addBtn.addActionListener(e -> addItem());
        updateBtn.addActionListener(e -> updateItem());
        deleteBtn.addActionListener(e -> deleteItem());

        // Table Click Event
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                idField.setText(model.getValueAt(row, 0).toString());
                nameField.setText(model.getValueAt(row, 1).toString());
                quantityField.setText(model.getValueAt(row, 2).toString());
                priceField.setText(model.getValueAt(row, 3).toString());
            }
        });

        setVisible(true);
    }

    private void addItem() {
        model.addRow(new Object[]{
                idField.getText(),
                nameField.getText(),
                quantityField.getText(),
                priceField.getText()
        });
        clearFields();
    }

    private void updateItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            model.setValueAt(idField.getText(), selectedRow, 0);
            model.setValueAt(nameField.getText(), selectedRow, 1);
            model.setValueAt(quantityField.getText(), selectedRow, 2);
            model.setValueAt(priceField.getText(), selectedRow, 3);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Select a row to update!");
        }
    }

    private void deleteItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            model.removeRow(selectedRow);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Select a row to delete!");
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InventoryManagerGUI::new);
    }
}