import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientOperationsFrame extends JFrame {
    private JButton addClientButton = new JButton("ADD");
    private JLabel idLabelAdd = new JLabel("Id:");
    private JLabel nameLabelAdd = new JLabel("Name:");
    private JLabel adressLabelAdd = new JLabel("Adress:");
    private JLabel emailLabelAdd = new JLabel("E-mail:");
    private JTextField idFieldAdd = new JTextField(5);
    private JTextField nameFieldAdd = new JTextField(15);
    private JTextField adressFieldAdd = new JTextField(15);
    private JTextField emailFieldAdd = new JTextField(15);
    private JButton deleteClientButton = new JButton("DELETE");
    private JLabel deleteLabelId = new JLabel("Id:");
    private JTextField deleteFieldId = new JTextField(5);
    private JButton editClientButton = new JButton("EDIT");
    private JLabel editLabelId = new JLabel("Id:");
    private JTextField editFieldId = new JTextField(5);
    private JComboBox editCombo = new JComboBox(new String[]{"id", "name", "adress", "email"});
    private JTextField editField = new JTextField(10);
    private JButton viewClientsButton = new JButton("VIEW");
    private JTable tableClients = new JTable();
    private JButton findProductButton=new JButton("FIND");
    private JTextField findField=new JTextField(5);
    private JTextArea findArea=new JTextArea();

    public ClientOperationsFrame() {
        this.setSize(500, 500);
        this.setTitle("Clients Operations");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pMain = new JPanel();
        pMain.setLayout(new BoxLayout(pMain, BoxLayout.Y_AXIS));
        JPanel addPanelMain = new JPanel();
        //addPanelMain.setLayout(new BoxLayout(addPanelMain, BoxLayout.Y_AXIS));
       /* JPanel addPanelID = new JPanel();
        addPanelID.add(idLabelAdd);
        addPanelID.add(idFieldAdd);
        addPanelMain.add(addPanelID);
        JPanel addPanelName = new JPanel();
        addPanelName.add(nameLabelAdd);
        addPanelName.add(nameFieldAdd);
        addPanelMain.add(addPanelName);
        JPanel addPanelAdress = new JPanel();
        addPanelAdress.add(adressLabelAdd);
        addPanelAdress.add(adressFieldAdd);
        addPanelMain.add(addPanelAdress);
        JPanel addPanelEmail = new JPanel();
        addPanelEmail.add(emailLabelAdd);
        addPanelEmail.add(emailFieldAdd);
        addPanelMain.add(addPanelEmail);
        JPanel addPanelButton = new JPanel();
        addPanelButton.add(addClientButton);
        addPanelMain.add(addPanelButton);*/
        JPanel findPanel = new JPanel();
        findPanel.setBackground(Color.white);
        findPanel.add(idLabelAdd);
        findPanel.add(findField);
        findPanel.add(findProductButton);
        findPanel.add(findArea);
        addPanelMain.add(idLabelAdd);
        addPanelMain.add(idFieldAdd);
        addPanelMain.add(nameLabelAdd);
        addPanelMain.add(nameFieldAdd);
        addPanelMain.add(adressLabelAdd);
        addPanelMain.add(adressFieldAdd);
        addPanelMain.add(emailLabelAdd);
        addPanelMain.add(emailFieldAdd);
        addPanelMain.add(addClientButton);


        JPanel deletePanelMain = new JPanel();
        deletePanelMain.add(deleteLabelId);
        deletePanelMain.add(deleteFieldId);
        deletePanelMain.add(deleteClientButton);
        deletePanelMain.setBackground(Color.white);

        JPanel editPanelMain = new JPanel();
        editPanelMain.add(editLabelId);
        editPanelMain.add(editFieldId);
        editPanelMain.add(editCombo);
        editPanelMain.add(editField);
        editPanelMain.add(editClientButton);

        JPanel viewPanelMain = new JPanel();
        viewPanelMain.add(viewClientsButton);
        viewPanelMain.add(tableClients);
        viewPanelMain.setBackground(Color.white);

        pMain.add(findPanel);
        pMain.add(addPanelMain);
        pMain.add(deletePanelMain);
        pMain.add(editPanelMain);
        pMain.add(viewPanelMain);
        this.setContentPane(pMain);

    }


    public String getIdAdd() {
        return idFieldAdd.getText();
    }

    public String getNameAdd() {
        return nameFieldAdd.getText();
    }

    public String getAdressAdd() {
        return adressFieldAdd.getText();
    }

    public String getEmailAdd() {
        return emailFieldAdd.getText();
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

    public void addListenerAdd(ActionListener l)
    {
        addClientButton.addActionListener(l);
    }
    public void addListenerDelete(ActionListener l)
    {
        deleteClientButton.addActionListener(l);
    }
    public void addListenerEdit(ActionListener l)
    {
        editClientButton.addActionListener(l);
    }
    public void addListenerView(ActionListener l)
    {
        viewClientsButton.addActionListener(l);
    }
    public String getIdFind()
    {
        return findField.getText();
    }
    public void findShow(String text)
    {
        findArea.setText(text);
    }
    public void addListenerFind(ActionListener l)
    {
        findProductButton.addActionListener(l);
    }
}
