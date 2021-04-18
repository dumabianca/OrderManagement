
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientDAO {

    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO client (id,name,adress,email)"
            + " VALUES (?,?,?,?)";
    private final static String findStatementString = "SELECT * FROM client where id = ?";
    private final static String deleteStatementString="DELETE FROM client"+" where id= ?";
    public static Client findById(int clientId) {
        Client toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, clientId);
            rs = findStatement.executeQuery();
            rs.next();

            String name = rs.getString("name");
            String address = rs.getString("adress");
            String email = rs.getString("email");
            toReturn = new Client(clientId, name, address, email);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ClientDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        if (toReturn == null) {
            JOptionPane.showMessageDialog(null,"Client not found");
        }

        return toReturn;
    }

    public static int insert(Client client) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, client.getId());
            insertStatement.setString(2, client.getName());
            insertStatement.setString(3, client.getAdress());
            insertStatement.setString(4, client.getEmail());

            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "StudentDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }
    public static void delete(int clientId) {
        Client toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;
        ResultSet rs = null;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString);
            deleteStatement.setLong(1, clientId);
            int r;
            r = deleteStatement.executeUpdate();


        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ClientDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }

    }
    public static void editById(int clientId,String editField,int newValueId, String newValueString) {

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement editStatement = null;
        String editStatementString=null;
        if(editField.equals("id"))
            editStatementString="UPDATE client SET id=? where id=?";
        if(editField.equals("name"))
            editStatementString="UPDATE client SET name=? where id=?";
        if(editField.equals("adress"))
            editStatementString="UPDATE client SET adress=? where id=?";
        if(editField.equals("email"))
            editStatementString="UPDATE client SET email=? where id=?";
        //ResultSet rs = null;

        try {
            editStatement = dbConnection.prepareStatement(editStatementString);
            editStatement.setInt(2, clientId);
            if(editField.equals("id"))
            editStatement.setInt(1, newValueId);
            else
                editStatement.setString(1, newValueString);
            int r;
            r = editStatement.executeUpdate();


        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ClientDAO:editById " + e.getMessage());
        } finally {

            ConnectionFactory.close(editStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

}
