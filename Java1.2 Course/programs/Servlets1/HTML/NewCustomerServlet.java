import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import HTML.*;

public class NewCustomerServlet extends HttpServlet {

  public void init(ServletConfig config) throws ServletException {

    super.init(config);
  }

  //Process the HTTP Get request
  public void doGet(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    HTMLDocument document =
      new HTMLDocument("New Customer Account");

    // Create the New Customer Account Form
    HTMLForm form = new HTMLForm();
    form.setAction("/servlet/NewCustomerServlet");
    form.setPostMethod(true);

    // Add the Heading
    HTMLHeading heading = new HTMLHeading("New Customer Account",
      HTMLHeading.H1);
    heading.setAlignment(HTMLObject.CENTER);
    form.addObject(heading);

    // Add the Name
    form.addObject(new HTMLText("Name : "));
    HTMLTextInput textinput = new HTMLTextInput();
    textinput.setName("name");
    textinput.setSize(30);
    form.addObject(textinput);
    form.addObject(new HTMLLineBreak());

    // Add the Email
    form.addObject(new HTMLText("Email Address : "));
    textinput = new HTMLTextInput();
    textinput.setName("email");
    textinput.setSize(30);
    form.addObject(textinput);
    form.addObject(new HTMLLineBreak());

    // Add the Billing Address
    form.addObject(new HTMLHeading("Billing Address",
      HTMLHeading.H4));

    form.addObject(new HTMLText("Street : "));
    textinput = new HTMLTextInput();
    textinput.setName("street");
    textinput.setSize(30);
    form.addObject(textinput);
    form.addObject(new HTMLLineBreak());

    // Add the City, State, Zip

    // City
    form.addObject(new HTMLText("City "));
    textinput = new HTMLTextInput();
    textinput.setName("city");
    textinput.setSize(30);
    form.addObject(textinput);

    // State
    form.addObject(new HTMLText("State "));
    textinput = new HTMLTextInput();
    textinput.setName("state");
    textinput.setSize(2);
    textinput.setMaxLength(2);
    form.addObject(textinput);

    // Zip
    form.addObject(new HTMLText("Zip "));
    textinput = new HTMLTextInput();
    textinput.setName("zip");
    textinput.setSize(5);
    textinput.setMaxLength(5);
    form.addObject(textinput);

    form.addObject(new HTMLLineBreak());
    form.addObject(new HTMLSubmitButton());
    form.addObject(new HTMLResetButton());
    
    document.addObject(form);

    // document string sent back in response
    out.println(document.toHTML());
    out.close();
  }
//Process the HTTP Post request

  public void doPost(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    HTMLDocument document =
      new HTMLDocument("Customer Account Added");

    // Add the Heading
    HTMLHeading heading = new HTMLHeading("Account Created",
      HTMLHeading.H2);
    heading.setAlignment(HTMLObject.CENTER);
    document.addObject(heading);

    // Display the submitted request
    document.addObject(new HTMLHeading("General Info.",
      HTMLHeading.H4));

    // Parse "name" parameter
    document.addObject(new HTMLText("Name : " +
      request.getParameter("name")));
    document.addObject(new HTMLLineBreak());

    // Parse "email" parameter
    document.addObject(new HTMLText("Email Address : " +
      request.getParameter("email")));

    document.addObject(new HTMLHeading("Billing Address",
      HTMLHeading.H4));

    // Parse "street" parameter
    document.addObject(new HTMLText(
      request.getParameter("street")));
    document.addObject(new HTMLLineBreak());

    // Parse "city", "state", and "zip" parameters
    document.addObject(new HTMLText(
      request.getParameter("city") + ", "));
    document.addObject(new HTMLText(
      request.getParameter("state")));
    document.addObject(new HTMLText(" "
      + request.getParameter("zip")));

    // document string sent back in response
    out.println(document.toHTML());
    out.close();
  }
//Get Servlet information

  public String getServletInfo() {
    return "NewCustomerServlet Information";
  }
}

 