import com.itextpdf.text.DocumentException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class Controller {
     StartFrame startFrame;
     ClientOperationsFrame clientOperationsFrame;
     ProductOperationsFrame productOperationsFrame;
     OrderOperationFrame orderOperationFrame;

    public Controller(StartFrame startFrame, ClientOperationsFrame clientOperationsFrame, ProductOperationsFrame productOperationsFrame, OrderOperationFrame orderOperationFrame) {
        this.startFrame = startFrame;
        this.clientOperationsFrame = clientOperationsFrame;
        this.productOperationsFrame = productOperationsFrame;
        this.orderOperationFrame = orderOperationFrame;
        this.startFrame.addListenerClients(new ActionListenerClients());
        this.startFrame.addListenerOrders(new ActionListenerOrder());
        this.startFrame.addListenerProducts(new ActionListenerProduct());
        this.clientOperationsFrame.addListenerAdd(new ActionListenerAddClient());
        this.clientOperationsFrame.addListenerDelete(new ActionListenerDeleteClient());
        this.clientOperationsFrame.addListenerEdit(new ActionListenerEditClient());
        this.clientOperationsFrame.addListenerView(new ActionListenerViewClient());
        this.productOperationsFrame.addListenerAdd(new ActionListenerAddProduct());
        this.productOperationsFrame.addListenerDelete(new ActionListenerDeleteProduct());
        this.productOperationsFrame.addListenerEdit(new ActionListenerEditProduct());
        this.productOperationsFrame.addListenerView(new ActionListenerViewProduct());
        this.productOperationsFrame.addListenerFind(new ActionListenerFindProduct());
        this.orderOperationFrame.addActionListenerOrder(new ActionListenerAddOrder());
        this.clientOperationsFrame.addListenerFind(new ActionListenerFindClient());
        this.orderOperationFrame.addListenerFind(new ActionListenerFindOrder());
        this.orderOperationFrame.addActionListenerBill(new ActionListenerCreateBill());
    }
    public class ActionListenerCreateBill implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            int id=Integer.parseInt(orderOperationFrame.getBillId());
            try {
                OrderDAO.createBill(id);
            } catch (DocumentException documentException) {
                documentException.printStackTrace();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

        }
    }
    public class ActionListenerFindOrder implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            int id=Integer.parseInt(orderOperationFrame.getIdFind());

            if (OrderDAO.findById(id) == null) {
                JOptionPane.showMessageDialog(null,"Order not found");
                System.exit(2);
            }
            else  orderOperationFrame.findShow(OrderDAO.findById(id).toString());

        }
    }
    public class ActionListenerFindClient implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            int id=Integer.parseInt(clientOperationsFrame.getIdFind());

            if (ClientDAO.findById(id) == null) {
                JOptionPane.showMessageDialog(null,"Client not found");
                System.exit(2);
            }
            else  clientOperationsFrame.findShow(ClientDAO.findById(id).toString());
        }
    }
public class ActionListenerFindProduct implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) {
        int id=Integer.parseInt(productOperationsFrame.getIdFind());
        if (ProductDAO.findById(id) == null) {
            JOptionPane.showMessageDialog(null,"Product not found");
            System.exit(2);
        }
        else   productOperationsFrame.findShow(ProductDAO.findById(id).toString());
    }
}
    public class ActionListenerClients implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            clientOperationsFrame.setVisible(true);
        }
    }
    public class ActionListenerProduct implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            productOperationsFrame.setVisible(true);
        }
    }
    public class ActionListenerOrder implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            orderOperationFrame.setVisible(true);
        }
    }



    public class ActionListenerAddClient implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
          int id=Integer.parseInt(clientOperationsFrame.getIdAdd());
          String name=clientOperationsFrame.getNameAdd();
          String adress=clientOperationsFrame.getAdressAdd();
          String email=clientOperationsFrame.getEmailAdd();
          Client c=new Client(id,name,adress,email);
          EmailValidator validator=new EmailValidator();
          validator.validate(c);
          ClientDAO.insert(c);

        }
    }

    public class ActionListenerDeleteClient implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            int id=Integer.parseInt(clientOperationsFrame.getIdDelete());
            ClientDAO.delete(id);
        }
    }
    public class ActionListenerEditClient implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            int id=Integer.parseInt(clientOperationsFrame.getIdEdit());
            String field=clientOperationsFrame.getFieldEdit();
            String editInfo=clientOperationsFrame.getEditInfo();
            if(field.equals("id"))
                ClientDAO.editById(id,field,Integer.parseInt(editInfo),"");
            else
                ClientDAO.editById(id,field,0,editInfo);

        }
    }
    public class ActionListenerViewClient implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    public class ActionListenerAddProduct implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            int id=Integer.parseInt(productOperationsFrame.getIdAdd());
            String name=productOperationsFrame.getNameAdd();
            String quantity=productOperationsFrame.getQuantityAdd();
            int price =Integer.parseInt(productOperationsFrame.getPriceAdd());
            ProductDAO.insert(new Product(id, name, Integer.parseInt(quantity),price));
        }
    }

    public class ActionListenerDeleteProduct implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            int id=Integer.parseInt(productOperationsFrame.getIdDelete());
            ProductDAO.delete(id);
        }
    }
    public class ActionListenerEditProduct implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            int id=Integer.parseInt(productOperationsFrame.getIdEdit());
            String field=productOperationsFrame.getFieldEdit();
            String editInfo=productOperationsFrame.getEditInfo();
            if(field.equals("name"))
                ProductDAO.editById(id,field,0,editInfo);
            else
                ProductDAO.editById(id,field,Integer.parseInt(editInfo),"");
        }
    }
    public class ActionListenerViewProduct implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    public class ActionListenerAddOrder implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
                int id= Integer.parseInt(orderOperationFrame.getID());
                int client=Integer.parseInt(orderOperationFrame.getClient());
                int product=Integer.parseInt(orderOperationFrame.getProduct());
                int quantity=Integer.parseInt(orderOperationFrame.getQuantity());
                OrderDAO.insert(new Order(id,client,product,quantity));
        }
    }
    public static void main(String[] args)
    {
        StartFrame s1=new StartFrame();
        ClientOperationsFrame s2=new ClientOperationsFrame();
        ProductOperationsFrame s3=new ProductOperationsFrame();
        OrderOperationFrame s4=new OrderOperationFrame();
        Controller c=new Controller(s1,s2,s3,s4);
        s1.setVisible(true);
    }
}

