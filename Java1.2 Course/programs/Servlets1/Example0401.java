import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Example0401 extends HttpServlet {

  public void init(ServletConfig config) throws ServletException {

    // Always pass the ServletConfig object to the super class
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

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>Example0401</title></head>");
    out.println("<body>");

    // Get all the parameter names
    Enumeration parameters = request.getParameterNames();
    String param = null;

    // Interate over the names, getting the parameters
    while ( parameters.hasMoreElements() ) {

      param = (String)parameters.nextElement();
      out.println("<BOLD>" + param +
        " : " + request.getParameter(param) +
        "</BOLD><BR>");
    }

    out.println("</body></html>");
    out.close();
  }
//Get Servlet information
  
  public String getServletInfo() {
    return "Example0401 Information";
  }
}
 