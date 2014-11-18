import java.io.*;
import java.util.Enumeration;

import javax.servlet.http.*;
import javax.servlet.*;

public class UpperCaseServlet extends HttpServlet {

  public void service(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {

    Enumeration e = request.getHeaderNames();

    while (e.hasMoreElements()) {

      // The first step is to copy and set all header
      // information passed by the previous servlet
      String header = (String)e.nextElement();
      String value = request.getHeader(header);
      response.setHeader(header, value);
    }

    // Set the responses Content-Type before getting the Writer
    response.setContentType(request.getContentType());

    PrintWriter out = response.getWriter();

    // Make sure we have the write mime type
    if (request.getContentType().startsWith("text/html")) {

      BufferedReader reader = request.getReader();
      String s;

      while ( (s = reader.readLine()) != null) {

        // Convert everything to Upper Case
        String u = s.toUpperCase();
        out.println(u);
      }
    }
    // If not write data directly to response without change
    else {

      ServletInputStream in = request.getInputStream();
      int b;

      while ( (b = in.read()) != -1 ) {

        out.write(b);
      }
    }
    out.close();
  }

  public String getServletInfo() {

    return "UpperCaseServlet";
  }
}
