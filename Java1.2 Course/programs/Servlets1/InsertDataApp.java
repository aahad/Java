import java.sql.*;

public class InsertDataApp {

  public InsertDataApp() {
  }

  public void insertData() {

    Connection con = null;

    try {

      // Load the Driver class file
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

      // Make a connection to the ODBC datasource Movie Catalog
      con = DriverManager.getConnection("jdbc:odbc:Movie Catalog",
        "", "");

      // Create the statement
      Statement statement = con.createStatement();

      // Use the created statement to INSERT DATA into
      // the database tables.

      // Insert Data into the Types Table
      statement.executeUpdate("INSERT INTO Types " +
        "VALUES (0, 'VHS')");

      statement.executeUpdate("INSERT INTO Types " +
        "VALUES (1, 'DVD')");

      statement.executeUpdate("INSERT INTO Types " +
        "VALUES (2, 'Laserdisc')");

      // Insert Data into the Categories Table
      statement.executeUpdate("INSERT INTO Categories " +
        "VALUES (0, 'Action Adventure')");

      statement.executeUpdate("INSERT INTO Categories " +
        "VALUES (1, 'Comedy')");

      statement.executeUpdate("INSERT INTO Categories " +
        "VALUES (2, 'Drama')");

      statement.executeUpdate("INSERT INTO Categories " +
        "VALUES (3, 'Western')");

      statement.executeUpdate("INSERT INTO Categories " +
        "VALUES (4, 'Sci-Fi')");

      statement.executeUpdate("INSERT INTO Categories " +
        "VALUES (5, 'Classics')");

      // Insert Data into the Titles Table
      statement.executeUpdate("INSERT INTO Titles " +
        "VALUES (0, 'The Adventures of Buckaroo Bonzai', " +
        "'PG', 19.95, 10, 0, 4)");

      statement.executeUpdate("INSERT INTO Titles " +
        "VALUES (1, 'Saving Private Ryan', " +
        "'R', 19.95, 12, 1, 0)");

      statement.executeUpdate("INSERT INTO Titles " +
        "VALUES (2, 'So I Married An Ax Murderer', " +
        "'PG', 19.95, 15, 1, 1)");

      statement.executeUpdate("INSERT INTO Titles " +
        "VALUES (3, 'Happy Gilmore', " +
        "'PG', 19.95, 9, 1, 1)");

      statement.executeUpdate("INSERT INTO Titles " +
        "VALUES (4, 'High Planes Drifter', " +
        "'PG', 29.95, 10, 2, 3)");

      statement.executeUpdate("INSERT INTO Titles " +
        "VALUES (5, 'Cape Fear', " +
        "'NR', 6.99, 21, 0, 5)");

      statement.executeUpdate("INSERT INTO Titles " +
        "VALUES (6, 'The Last Emperor', " +
        "'PG', 19.95, 12, 1, 2)");
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

    InsertDataApp insertDataApp = new InsertDataApp();

    insertDataApp.insertData();
  }
}
