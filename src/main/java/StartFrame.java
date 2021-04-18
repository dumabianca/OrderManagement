import javax.swing.*;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame {
    private JButton buttonCustomers=new JButton("Clients Operations");
    private JButton buttonProducts=new JButton("Products Operations");
    private JButton buttonOrders=new JButton("Orders Operations");
    private JLabel labelChoose=new JLabel("Choose one");
    public StartFrame()
    {
        this.setTitle("Order Management");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel=new JPanel();
        JPanel customerPanel=new JPanel();
        JPanel orderPanel=new JPanel();
        JPanel productPanel=new JPanel();
        JPanel labelPanel=new JPanel();
        customerPanel.add(buttonCustomers);
        orderPanel.add(buttonOrders);
        productPanel.add(buttonProducts);
        labelPanel.add(labelChoose);
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.add(labelPanel);

        mainPanel.add(customerPanel);
        mainPanel.add(orderPanel);
        mainPanel.add(productPanel);
        this.setContentPane(mainPanel);
    }
    public void addListenerClients(ActionListener l)
    {
        buttonCustomers.addActionListener(l);
    }
    public void addListenerOrders(ActionListener l)
    {
        buttonOrders.addActionListener(l);
    }
    public void addListenerProducts(ActionListener l)
    {
        buttonProducts.addActionListener(l);
    }

}
