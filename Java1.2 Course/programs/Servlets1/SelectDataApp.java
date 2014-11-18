import java.sql.*;
import java.io.*;

public class SelectDataApp {

  public SelectDataApp() {

  }

  public void selectData() {

    Connection con = null;

    try {

      // Load the Driver class file
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

      // Make a connection to the ODBC datasource Movie Catalog
      con = DriverManager.getConnection("jdbc:odbc:Movie Catalog",
        "", "");

      // Create the statement
      Statement statement = con.createStatement();

      // Use the created statement to SELECT the DATA
      // FROM the Titles Table.
      ResultSet rs = statement.executeQuery("SELECT * " +
        "FROM Titles");

      // Iterate over the ResultSet
      while ( rs.next() ) {

        // get the title_id, which is a Number
        System.err.println("Title ID = " + rs.getString("title_id"));
        // get the title_name, which is a String
        System.err.println("Title Name = " + rs.getString("title_name"));
        // get the price
        System.err.println("Title Price = " + rs.getString("price"));
        // get the quantity
        System.err.println("Title Quantity = " + rs.getString("quantity"));
        // get the category_id
        System.err.println("category_id No. = " + rs.getString("category_id") + "\n");      

      }
      // Close the ResultSet
      rs.close();
      System.in.read();
    }
    catch (IOException ioe) {

      System.err.println(ioe.getMessage());
    }
    catch (SQLException sqle) {

      System.err.println(sqle.getMessage());
    }
    catch (ClassNotFoundException cnfe) {

      System.err.println(cnfe.getMessage());
    }
    catch (Exception e) {

      System.err.println(e.getMessage());
    }
    finally {

      try {

        if ( con != null ) {

          // Close the connection no matter what
          con.close();
        }
      }
      catch (SQLException sqle) {

        System.err.println(sqle.getMessage());
      }
    }
  }

  public static void main(String[] args) {

    SelectDataApp selectDataApp = new SelectDataApp();
    
    selectDataApp.selectData();
  }
}
