//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Main extends JFrame {
    private JTextField txtCustomer, txtPrice;
    private JComboBox<String> cmbProduct;
    private JButton btnProcess;

    public Main() {
        setTitle("Product App");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // The Menu
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        file.add(exit);

        JMenu tools = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        processItem.addActionListener(e -> processData());
        clearItem.addActionListener(e -> { txtCustomer.setText(""); txtPrice.setText(""); cmbProduct.setSelectedIndex(0); });
        tools.add(processItem);
        tools.add(clearItem);
        bar.add(file);
        bar.add(tools);
        setJMenuBar(bar);

        // The Form
        JPanel form = new JPanel(new GridLayout(3, 2, 5, 10));
        form.add(new JLabel("Customer Name:"));
        txtCustomer = new JTextField();
        form.add(txtCustomer);
        form.add(new JLabel("Select Product:"));
        cmbProduct = new JComboBox<>(new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});
        form.add(cmbProduct);
        form.add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        form.add(txtPrice);

        btnProcess = new JButton("PROCESS");
        btnProcess.addActionListener(e -> processData());

        add(form, BorderLayout.NORTH);
        add(btnProcess, BorderLayout.SOUTH);
    }

    private void processData() {
        try {
            String customer = txtCustomer.getText();
            String product = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            Product calc = new Product(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            String message = "Customer Name: " + customer + "\n"
                    + "Product: " + product + "\n"
                    + "VAT: R " + vat + "\n"
                    + "COMMISSION: R " + commission + "\n"
                    + "TOTAL: R " + total;

            // Shows the popup
            JOptionPane.showMessageDialog(this, message);

            // Save to data.txt
            try (PrintWriter out = new PrintWriter(new FileWriter("data.txt"))) {
                out.println("DATA LOG");
                out.println("************************************");
                out.println(message);
                out.println("************************************");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data.txt");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
//
//}
