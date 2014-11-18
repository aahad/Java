import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import HTML.*;

public class InitParameterServlet extends HttpServlet {

  //Initialize global variables
  private String company_name = null;

  public void init(ServletConfig config)
    throws ServletException {

    // Always pass the parent the ServletConfig
    super.init(config);

    // Parse the init parameter "company" and
    // store it in the private member company_name
    company_name = getInitParameter("company");
  }

  //Process the HTTP Get request
  public void doGet(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    // Use the HTMLDocument created in chapter 4
    HTMLDocument document = new HTMLDocument();

    // Add a Heading
    HTMLHeading heading = new HTMLHeading();
    heading.setAlignment(HTMLObject.CENTER);
    heading.setText("Welcome to the " +
      company_name + " Web Site");
    document.addObject(heading);

    // print the HTMLDocument's contents
    out.println(document.toHTML());
    out.close();
  }

  //Get Servlet information
  public String getServletInfo() {
    return "InitParameterServlet Information";
  }
}
