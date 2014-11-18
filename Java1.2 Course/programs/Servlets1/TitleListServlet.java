import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

import HTML.*;

public class TitleListServlet extends HttpServlet {

  public void init(ServletConfig config)
    throws ServletException {

    super.init(config);
  }

  //Process the HTTP Get request
  public void doGet(HttpServletRequest request,
    HttpServletResponse response)
      throws ServletException, IOException {

    doPost(request, response);
  }

  //Process the HTTP Post request
  public void doPost(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {

    // Set the response content-type
    response.setContentType("text/html");
    // get the Writer object
    PrintWriter out = response.getWriter();
    // Get the search_string parameter, passed from the
    // SearchServlet.
    String search_string =
      request.getParameter("search_string");

    Connection con = null;

    // Create the HTML Document
    HTMLDocument document =
      new HTMLDocument("Title List Servlet");

    try {

      // Load the Driver class file
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

      // Make a connection to the ODBC datasource Movie Catalog
      // In this example we are opening a connection to the
      // database with every request.
      con =
        DriverManager.getConnection("jdbc:odbc:Movie Catalog",
        "", "");

      if ( con != null ) {

        // Create the statement
        Statement statement = con.createStatement();

        // Use the created statement to SELECT the DATA
        // FROM the Titles Table.
        // In this instance we are serching for an exact match.
        // If you were to deploy this to a production site, you
        // might want to use a "LIKE" clause instead of WHERE.
        ResultSet rs = statement.executeQuery("SELECT * " +
         "FROM Titles WHERE title_name = '" +
         search_string + "'");

        // Create the Table
        HTMLTable table = new HTMLTable();
        table.setBorder(1);

        HTMLTableRow row = null;
        HTMLTableCell cell = null;

        // Create the Cell Headings
        row = new HTMLTableRow();

        cell = new HTMLTableCell(HTMLTableCell.HEADING);
        cell.addObject(new HTMLText("ID"));
        row.addObject(cell);

        cell = new HTMLTableCell(HTMLTableCell.HEADING);
        cell.addObject(new HTMLText("Name"));
        row.addObject(cell);

        //cell = new HTMLTableCell(HTMLTableCell.HEADING);
        //cell.addObject(new HTMLText("Category_id"));
        //row.addObject(cell);

        cell = new HTMLTableCell(HTMLTableCell.HEADING);
        cell.addObject(new HTMLText("Price"));
        row.addObject(cell);

        cell = new HTMLTableCell(HTMLTableCell.HEADING);
        cell.addObject(new HTMLText("Quantity"));
        row.addObject(cell);

        /*cell = new HTMLTableCell(HTMLTableCell.HEADING);
        cell.addObject(new HTMLText("Type ID"));
        row.addObject(cell);*/

        cell = new HTMLTableCell(HTMLTableCell.HEADING);
        cell.addObject(new HTMLText("Category ID"));
        row.addObject(cell);

        table.addObject(row);

        // Iterate over the ResultSet
        while ( rs.next() ) {

          row = new HTMLTableRow();

          // get the id, which is an int
          cell = new HTMLTableCell(HTMLTableCell.DATA);
          cell.addObject(new HTMLText(
            new Integer(rs.getInt("title_id")).toString()));
          row.addObject(cell);

          // get the name, which is a String
          cell = new HTMLTableCell(HTMLTableCell.DATA);
          cell.addObject(
            new HTMLText(rs.getString("title_name")));
          row.addObject(cell);

          // get the rating, which is a String
          /*cell = new HTMLTableCell(HTMLTableCell.DATA);
          cell.addObject(
            new HTMLText(rs.getString("rating")));
          row.addObject(cell); */

          // get the price, which is a Float
          cell = new HTMLTableCell(HTMLTableCell.DATA);
          cell.addObject(new HTMLText(
            new Float(rs.getFloat("price")).toString()));
          row.addObject(cell);

          // get the Quantity, which is a Integer
          cell = new HTMLTableCell(HTMLTableCell.DATA);
          cell.addObject(new HTMLText(
            new Integer(rs.getInt("quantity")).toString()));
          row.addObject(cell);

          // get the Type, which is a Integer
          /*cell = new HTMLTableCell(HTMLTableCell.DATA);
          cell.addObject(new HTMLText(
            new Integer(rs.getInt("type_id")).toString()));
          row.addObject(cell);*/

          // get the Category, which is a Integer
          cell = new HTMLTableCell(HTMLTableCell.DATA);
          cell.addObject(new HTMLText(
            new Integer(rs.getInt("category_id")).toString()));
          row.addObject(cell);
          table.addObject(row);
        }
        // Close the ResultSet
        rs.close();
        document.addObject(table);
      }
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
    out.println(document.toHTML());
    out.close();
  }

  //Get Servlet information
  public String getServletInfo() {

    return "TitleListServlet Information";
  }
}
