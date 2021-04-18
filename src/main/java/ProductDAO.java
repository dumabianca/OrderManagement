import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO {

    protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO product (id,name,quantity,price)"
            + " VALUES (?,?,?,?)";
    private final static String findStatementString = "SELECT * FROM product where id = ?";
    private final static String deleteStatementString="DELETE FROM product"+" where id= ?";
    public static Product findById(int productId) {
        Product toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, productId);
            rs = findStatement.executeQuery();
            rs.next();
            String name = rs.getString("name");
            int quantity = rs.getInt("quantity");
            int price = rs.getInt("price");
            toReturn = new Product(productId, name, quantity,price);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ProductDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        if (toReturn == null) {
            JOptionPane.showMessageDialog(null,"Product not found");
        }
        return toReturn;
    }

    public static int insert(Product product) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, product.getId());
            insertStatement.setString(2, product.getName());
            insertStatement.setInt(3, product.getQuantity());
            insertStatement.setInt(4, product.getPrice());

            insertStatement.executeUpdate();
            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
                System.out.println(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }
    public static void delete(int productId) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;

        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString);
            deleteStatement.setLong(1, productId);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ProductDAO:delete " + e.getMessage());
        } finally {

            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }

    }
    public static void editById(int productId,String editField,int newValueInteger, String newValueString) {

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement editStatement = null;
        String editStatementString=null;
        if(editField.equals("id"))
            editStatementString="UPDATE product SET id=? where id=?";
        if(editField.equals("name"))
            editStatementString="UPDATE product SET name=? where id=?";
        if(editField.equals("quantity"))
            editStatementString="UPDATE product SET quantity=? where id=?";
        if(editField.equals("price"))
            editStatementString="UPDATE product SET price=? where id=?";

        try {
            editStatement = dbConnection.prepareStatement(editStatementString);
            editStatement.setInt(2, productId);
            if(editField.equals("id") || editField.equals("price") || editField.equals("quantity") )
                editStatement.setInt(1, newValueInteger);
            else
                editStatement.setString(1, newValueString);
            int r;
            r = editStatement.executeUpdate();


        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ProductDAO:editById " + e.getMessage());
        } finally {

            ConnectionFactory.close(editStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

}
