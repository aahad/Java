import java.sql.*;

public class UpdateDataApp {

  public UpdateDataApp() {

  }

  public void updateData() {

    Connection con = null;

    try {

      // Load the Driver class file
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

      // Make a connection to the ODBC datasource Movie Catalog
      con = DriverManager.getConnection("jdbc:odbc:Movie Catalog",
        "", "");

      // Create the statement
      Statement statement = con.createStatement();

      // Use the created statement to UPDATE DATA in
      // the database tables.
      // Update the Quantity of "The Last Emperor"
      statement.executeUpdate("UPDATE Titles " +
        "SET quantity = 5 " +
        "WHERE title_name = 'The Last Emperor'");
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

    UpdateDataApp updateDataApp = new UpdateDataApp();

    updateDataApp.updateData();
  }
}
