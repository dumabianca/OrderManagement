import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDAO {

    protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO warehousedb.order (id,client,product,quantity)"
            + " VALUES (?,?,?,?)";
    private final static String findStatementString = "SELECT * FROM warehousedb.order where id = ?";

    public static Order findById(int orderId) {
        Order toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, orderId);
            rs = findStatement.executeQuery();

            rs.next();
            int client = rs.getInt("client");
            int product = rs.getInt("product");
            int quantity = rs.getInt("quantity");
            toReturn = new Order(orderId, client, product, quantity);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "OrderDAO:findById " + e.getMessage());
            //JOptionPane.showMessageDialog(null,"Order not found");
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;
    }

    public static int insert(Order order) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        int insertedId = -1;
        int quantity = ProductDAO.findById(order.getProduct()).getQuantity();
        System.out.println(quantity+" "+ order.getQuantity() );
        if (quantity < order.getQuantity())
        {
            JOptionPane.showMessageDialog(null, "Out of stock!");
            System.exit(1);
        }
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, order.getId());
            insertStatement.setInt(2, order.getClient());
            insertStatement.setInt(3, order.getProduct());
            insertStatement.setInt(4, order.getQuantity());

                insertStatement.executeUpdate();
            System.out.println(quantity-order.getQuantity());
                ProductDAO.editById(order.getProduct(), "quantity", quantity - order.getQuantity(), "");

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
                System.out.println(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "OrderDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }


   public static void createBill(int orderId) throws DocumentException, FileNotFoundException {
        Document document = new Document();

       Connection dbConnection = ConnectionFactory.getConnection();
       PreparedStatement findStatement = null;
       ResultSet rs = null;
       int client=0;
       int quantity=0;
       int product=0;
       String name="";
       try {
           findStatement = dbConnection.prepareStatement(findStatementString);
           findStatement.setLong(1, orderId);
           rs = findStatement.executeQuery();
           rs.next();
           client = rs.getInt("client");
           product = rs.getInt("product");
           quantity = rs.getInt("quantity");
          name  = ClientDAO.findById(client).getName();
       } catch (SQLException e) {
           LOGGER.log(Level.WARNING,"OrderDAO:findById " + e.getMessage());
       } finally {
           ConnectionFactory.close(rs);
           ConnectionFactory.close(findStatement);
           ConnectionFactory.close(dbConnection);
       }
        PdfWriter.getInstance(document, new FileOutputStream(name+"_"+"Bill.pdf"));
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        document.add(new Paragraph("Client id: "+orderId+"\n"));
        document.add(new Paragraph("Client name: "+name+"\n"));
        document.add(new Paragraph("Product id: "+ product+"\n"));
       document.add(new Paragraph("Product name: "+ProductDAO.findById(product).getName()+"\n"));
       document.add(new Paragraph("Product price: "+ProductDAO.findById(product).getPrice()+"\n"));
       document.add(new Paragraph("Product quantity: "+quantity+"\n"));
       document.add(new Paragraph("Final price: "+quantity*ProductDAO.findById(product).getPrice()+"\n",font));
        document.close();

    }
}
