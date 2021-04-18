import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OrderOperationFrame extends JFrame {
    private JButton addOrderButton=new JButton("Add order");
    private JLabel idLabel=new JLabel("Id:");
    private JLabel clientLabel=new JLabel("Client:");
    private JLabel productLabel=new JLabel("Product:");
    private JLabel quantityLabel=new JLabel("Quantity:");
    private JTextField idField=new JTextField(5);
    private JTextField clientField=new JTextField(5);
    private JTextField productField=new JTextField(5);
    private JTextField quantityField=new JTextField(5);
    private JButton findProductButton=new JButton("FIND");
    private JTextField findField=new JTextField(5);
    private JTextArea findArea=new JTextArea();
    private JButton billButton=new JButton("PDF Bill");
    private JTextField billId=new JTextField(5);

    public OrderOperationFrame()
    {
        this.setTitle("Order operation");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        JPanel findPanel = new JPanel();
        findPanel.setBackground(Color.white);
        findPanel.add(idLabel);
        findPanel.add(findField);
        findPanel.add(findProductButton);
        findPanel.add(findArea);

        JPanel addPanel=new JPanel();
        addPanel.add(idLabel);
        addPanel.add(idField);
        addPanel.add(clientLabel);
        addPanel.add(clientField);
        addPanel.add(productLabel);
        addPanel.add(productField);
        addPanel.add(quantityLabel);
        addPanel.add(quantityField);
        addPanel.add(addOrderButton);
        JPanel billPanel=new JPanel();
        billPanel.setBackground(Color.white);
        billPanel.add(idLabel);
        billPanel.add(billId);
        billPanel.add(billButton);
        mainPanel.add(findPanel);
        mainPanel.add(addPanel);
        mainPanel.add(billPanel);
        this.setContentPane(mainPanel);
    }
    public String getClient()
    {
        return clientField.getText();
    }
    public String getProduct()
    {
        return productField.getText();
    }
    public String getQuantity()
    {
        return quantityField.getText();
    }
    public String getID()
    {
        return idField.getText();
    }
    public void addActionListenerOrder(ActionListener l)
    {
        addOrderButton.addActionListener(l);
    }
    public String getIdFind()
    {
        return findField.getText();
    }
    public void findShow(String text)
    {
        findArea.setText(text);
    }
    public String getBillId()
    {
        return billId.getText();
    }
    public void addListenerFind(ActionListener l)
    {
        findProductButton.addActionListener(l);
    }
    public void addActionListenerBill(ActionListener l)
    {
        billButton.addActionListener(l);
    }
}
