
import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Start {
    protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());
    ClientDAO c= new ClientDAO();

    public static void main(String[] args) throws SQLException, FileNotFoundException, DocumentException {

      //ClientDAO.insert(new Client(134,"Alexandra Matei","Romania","alex@something"));
       // System.out.println(ClientDAO.findById(7));
       // ClientDAO.delete(4);\
      // ClientDAO.editById(3,"id",102,"");
     // ProductDAO.editById(101,"quantity",10,"");
      //  System.out.println( ProductDAO.findById(12));
       // ProductDAO.delete(61);
      //  ProductDAO.insert(new Product(23,"flori",3,10));
        //OrderDAO.insert(new Order(10,102,101,1));
       // System.out.println(ProductDAO.findById(101));
       // System.out.println(OrderDAO.findById(4));
        //System.out.println(OrderDAO.findById(4).getName());
       // OrderDAO.createBill(4);

    }
}