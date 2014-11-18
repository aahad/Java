import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import HTML.*;

public class SimpleTextServlet extends HttpServlet {

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

    HTMLDocument document = new HTMLDocument("SimpleTextServlet");

    // Simple text string, can be anything
    document.addObject(new HTMLText("Hello World!"));

    out.println(document.toHTML());
    out.close();
  }

  //Get Servlet information
  public String getServletInfo() {

    return "SimpleTextServlet Information";
  }
}
