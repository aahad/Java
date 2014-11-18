import java.sql.*;

public class CreateTablesApp {

  public void createTables() {

    Connection con = null;

    try {

      // Load the Driver class file
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

      // Make a connection to the ODBC datasource Movie Catalog
      con = DriverManager.getConnection("jdbc:odbc:Movie Catalog",
        "", "");

      // Create the statement
      Statement statement = con.createStatement();

      // Use the created statement to CREATE the database table
      // Create Titles Table
      statement.executeUpdate("CREATE TABLE Titles " +
        "(title_id INTEGER, title_name VARCHAR(50), " +
        "rating VARCHAR(5), price FLOAT, quantity INTEGER, " +
        "type_id INTEGER, category_id INTEGER)");
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

    CreateTablesApp createTablesApp = new CreateTablesApp();

    createTablesApp.createTables();
  }
}
