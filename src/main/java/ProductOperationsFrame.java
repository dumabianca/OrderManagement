import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProductOperationsFrame extends JFrame {
    private JButton addProductButton = new JButton("ADD");

    private JLabel idLabelAdd = new JLabel("Id:");
    private JLabel nameLabelAdd = new JLabel("Name:");
    private JLabel quantityLabelAdd=new JLabel("Quantity:");
    private JLabel priceLabelAdd=new JLabel("Price:");
    private JTextField idFieldAdd = new JTextField(5);
    private JTextField nameFieldAdd = new JTextField(15);
    private JTextField quantityFieldAdd = new JTextField(5);
    private JTextField priceFieldAdd = new JTextField(5);

    private JButton deleteProductButton = new JButton("DELETE");
    private JLabel deleteLabelId = new JLabel("Id:");
    private JTextField deleteFieldId = new JTextField(5);
    private JButton editProductButton = new JButton("EDIT");
    private JLabel editLabelId = new JLabel("Id:");
    private JTextField editFieldId = new JTextField(5);
    private JComboBox editCombo = new JComboBox(new String[]{"id", "name", "quantity","price"});
    private JTextField editField = new JTextField(10);
    private JButton viewProductsButton = new JButton("VIEW");
    private JTable tableProducts = new JTable();
    private JButton findProductButton=new JButton("FIND");
    private JTextField findField=new JTextField(5);
    private JTextArea findArea=new JTextArea();

    public ProductOperationsFrame() {
        this.setSize(500, 500);
        this.setTitle("Products Operations");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pMain = new JPanel();
        pMain.setLayout(new BoxLayout(pMain, BoxLayout.Y_AXIS));
        JPanel addPanelMain = new JPanel();
       /* addPanelMain.setLayout(new BoxLayout(addPanelMain, BoxLayout.Y_AXIS));
        JPanel addPanelID = new JPanel();
        addPanelID.add(idLabelAdd);
        addPanelID.add(idFieldAdd);
        addPanelMain.add(addPanelID);
        JPanel addPanelName = new JPanel();
        addPanelName.add(nameLabelAdd);
        addPanelName.add(nameFieldAdd);
        addPanelMain.add(addPanelName);
        JPanel addPanelQuantity = new JPanel();
        addPanelQuantity.add(quantityLabelAdd);
        addPanelQuantity.add(quantityFieldAdd);
        addPanelMain.add(addPanelQuantity);

        */
        addPanelMain.add(idLabelAdd);
        addPanelMain.add(idFieldAdd);
        addPanelMain.add(nameLabelAdd);
        addPanelMain.add(nameFieldAdd);
        addPanelMain.add(quantityLabelAdd);
        addPanelMain.add(quantityFieldAdd);
        addPanelMain.add(priceLabelAdd);
        addPanelMain.add(priceFieldAdd);
        addPanelMain.add(addProductButton);

        JPanel addPanelButton = new JPanel();
        addPanelButton.add(addProductButton);
        addPanelMain.add(addPanelButton);

        JPanel findPanel = new JPanel();
        findPanel.setBackground(Color.white);
        findPanel.add(idLabelAdd);
        findPanel.add(findField);
        findPanel.add(findProductButton);
        findPanel.add(findArea);


        JPanel deletePanelMain = new JPanel();
        deletePanelMain.add(deleteLabelId);
        deletePanelMain.add(deleteFieldId);
        deletePanelMain.add(deleteProductButton);
        deletePanelMain.setBackground(Color.white);

        JPanel editPanelMain = new JPanel();
        editPanelMain.add(editLabelId);
        editPanelMain.add(editFieldId);
        editPanelMain.add(editCombo);
        editPanelMain.add(editField);
        editPanelMain.add(editProductButton);

        JPanel viewPanelMain = new JPanel();
        viewPanelMain.add(viewProductsButton);
        viewPanelMain.add(tableProducts);
        viewPanelMain.setBackground(Color.white);


        pMain.add(findPanel);
        pMain.add(addPanelMain);
        pMain.add(deletePanelMain);
        pMain.add(editPanelMain);
        pMain.add(viewPanelMain);
        this.setContentPane(pMain);

    }
    public static void main(String[] args) {
        ProductOperationsFrame s = new ProductOperationsFrame();
        s.setVisible(true);
    }

    public String getIdAdd() {
        return idFieldAdd.getText();
    }

    public String getNameAdd() {
        return nameFieldAdd.getText();
    }

    public String getQuantityAdd() {
        return quantityFieldAdd.getText();
    }
    public String getPriceAdd() {
        return priceFieldAdd.getText();
    }


    public String getIdDelete() {
        return deleteFieldId.getText();
    }

    public String getIdEdit() {
        return editFieldId.getText();
    }
    public String getEditInfo() {
        return editField.getText();
    }

    public String getFieldEdit() {
        return (String) editCombo.getSelectedItem();
    }
    public String getIdFind()
    {
        return findField.getText();
    }
    public void findShow(String text)
    {
        findArea.setText(text);
    }
    public void addListenerAdd(ActionListener l)
    {
        addProductButton.addActionListener(l);
    }
    public void addListenerDelete(ActionListener l)
    {
        deleteProductButton.addActionListener(l);
    }
    public void addListenerEdit(ActionListener l)
    {
        editProductButton.addActionListener(l);
    }
    public void addListenerView(ActionListener l)
    {
        viewProductsButton.addActionListener(l);
    }
    public void addListenerFind(ActionListener l)
    {
        findProductButton.addActionListener(l);
    }
}
