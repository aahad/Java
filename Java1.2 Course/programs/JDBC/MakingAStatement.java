import java.sql.*;

public class MakingAStatement
{
  public static void main(String[] args)
  {
    // Load the driver
    try
    {
      // Load the driver class
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

      // Define the data source for the driver
      String sourceURL = new String("jdbc:odbc:technical_library");

      // Create a connection through the DriverManager 
      Connection databaseConnection = 
                                DriverManager.getConnection(sourceURL);
      Statement statement = databaseConnection.createStatement();
      ResultSet authorNames = statement.executeQuery("SELECT * FROM authors");
     // Output the resultset data
     while(authorNames.next())
        System.out.println(authorNames.getString("lastname") + " " + authorNames.getString("firstname") );
        
    }
    catch(ClassNotFoundException cnfe)
    {
      System.err.println(cnfe);
    }
    catch(SQLException sqle)
    {
      System.err.println(sqle);
    }
  }
}
