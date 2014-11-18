<HTML>
<HEAD>
<TITLE>JSP JDBC Example 1</TITLE>
</HEAD>

<BODY>

<!-- Set the scripting language to java and -->
<!-- import the java.sql package -->
<%@ page language="java" import="java.sql.*" %>

<%

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
      %>
      <!-- Add an HTML table to format the results -->
      <TABLE BORDER="1">
      <TR>
      <TH>Title</TH><TH>Rating</TH><TH>Price</TH>
      <%

      while ( rs.next() ) {

        // get the title_name, which is a String
        out.println("<TR>\n<TD>" + rs.getString("title_name") + "</TD>");

        // get the price
        out.println("<TD>" + rs.getString("price") + "</TD>");

        // get the quantity
        out.println("<TD>" + rs.getString("quantity") + "</TD>\n</TR>");
      }
      // Close the ResultSet
      rs.close();
    }
    catch (IOException ioe) {

      out.println(ioe.getMessage());
    }
    catch (SQLException sqle) {

      out.println(sqle.getMessage());
    }
    catch (ClassNotFoundException cnfe) {

      out.println(cnfe.getMessage());
    }
    catch (Exception e) {

      out.println(e.getMessage());
    }
    finally {

      try {

        if ( con != null ) {

          // Close the connection no matter what
          con.close();
        }
      }
      catch (SQLException sqle) {

        out.println(sqle.getMessage());
      }
    }

%>

</BODY>
</HTML>
