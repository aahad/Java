import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class HiddenFieldServlet extends HttpServlet {

  public void init(ServletConfig config)
    throws ServletException {

    super.init(config);
  }

  //Process the HTTP Get request
  public void doGet(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>HiddenFieldServlet" +
      "</title></head>");
    out.println("<body>");

    // Create the Form with Hidden Fields
    out.println("<FORM ACTION=" +
      "\"/servlet/HiddenFieldServlet\" METHOD=\"POST\">");

    // These values would be uniquely generated
    out.println("<INPUT TYPE=\"hidden\" NAME=" +
      "\"user\" VALUE=\"Asif\">");

    out.println("<INPUT TYPE=\"hidden\" NAME=" +
      "\"session\" VALUE=\"12892\">");

    // These are the currently selected movies
    out.println("<INPUT TYPE=\"hidden\" NAME=" +
      "\"movie\" VALUE=\"Happy Gilmore\">");

    out.println("<INPUT TYPE=\"hidden\" NAME=" +
      "\"movie\" VALUE=\"So I Married an Axe Murderer\">");

    out.println("<INPUT TYPE=\"hidden\" NAME=" +
      "\"movie\" VALUE=\"Jaws\">");

    out.println("<INPUT TYPE=\"submit\" VALUE=" +
      "\"Finished Shopping\">");
    out.println("</FORM>");

    out.println("</body></html>");
    out.close();
  }

  //Process the HTTP Post request
  public void doPost(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>HiddenFieldServlet" +
      "</title></head>");
    out.println("<body>");

    // Get the hidden inputs and echo them
    String user = request.getParameter("user");
    String session = request.getParameter("session");

    out.println("<H3>" + user +
      ", the contents of your Shopping Basket are:</H3><BR>");

    String[] movies = request.getParameterValues("movie");

    if ( movies != null ) {

      for ( int x = 0; x < movies.length; x++ ) {

        out.println(movies[x] + "<BR>");
      }
    }

    out.println("</body></html>");
    out.close();
  }

  //Get Servlet information
  public String getServletInfo() {

    return "HiddenFieldServlet Information";
  }
}
