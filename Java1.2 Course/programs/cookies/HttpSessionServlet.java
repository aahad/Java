import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class HttpSessionServlet extends HttpServlet {

  public void init(ServletConfig config)
    throws ServletException {

    super.init(config);
  }

  //Process the HTTP Get request, this method
  // will handle the checkout
  public void doGet(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {

    String[] movies = null;

    // Get a handle to the HttpSession Object
    // if there is no session create one
    HttpSession session = request.getSession(true);

    // Get the movies list object bound to the
    // name "Movies"
    if ( session != null ) {

      movies = (String[])session.getValue("Movies");
    }

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>Session Servlet</title></head>");
    out.println("<body>");

    // Iterate over the movies array, displaying the
    // current list of movies stored in the session
    out.println("<H2>Thank you for purchasing:</H2>");
    for ( int x = 0; x < movies.length; x++ ) {

      out.println(movies[x] + "<BR>");
    }
    out.println("</body></html>");
    out.close();
  }

  //Process the HTTP Post request
  public void doPost(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {

    // Parse the movies selected
    String movies[] = request.getParameterValues("Movies");

    // Get a handle to the HttpSession Object
    // if there is no session create one
    HttpSession session = request.getSession(true);

    // add the list of movies to the session
    // binding it to the String "Movies"
    if ( session != null ) {

      session.putValue("Movies", movies);
    }

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>Session Servlet</title></head>");
    out.println("<body>");

    out.println("<H2>Contents of Shopping Cart</H2>");

    // Display the submitted movie array
    for ( int x = 0; x < movies.length; x++ ) {

      out.println(movies[x] + "<BR>");
    }
    // Create a form to submit an order
    out.println("<FORM action=/servlet/HttpSessionServlet " +
      "METHOD=GET>");
    out.println("<input type=\"Submit\" name=\"add\" value=" +
      "\"Proceed to Checkout\"></FORM>");

    out.println("</body></html>");
    out.close();
  }

  //Get Servlet information
  public String getServletInfo() {

    return "HttpSessionServlet Information";
  }
}
