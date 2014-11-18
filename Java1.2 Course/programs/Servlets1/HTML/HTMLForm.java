package HTML;

import java.util.*;

public class HTMLForm extends HTMLObject {

    private String action = new String("");
    private boolean post_method = false;

    // Default Constructor
    public HTMLForm() {

    }

    // Set the action
    public void setAction( String value) {

      if ( value != null ) {

        action = value;
      }
    }

    // Get the action
    public String getAction() {

      return action;
    }

    // Set the POST method to true/false
    public void setPostMethod( boolean value) {

      post_method = value;
    }

    // return true if POST, otherwise false
    public boolean isPostMethod() {

      return post_method;
    }

    // Return String containing the HTML formatted Form
    public String toHTML() {

      StringBuffer html = new StringBuffer("<FORM ACTION=\"");

      if ( action != null ) {

        html.append(action);
      }
      html.append("\"");

      // setup the method
      html.append(" METHOD=");

      if ( post_method ) {

        html.append("POST");
      }
      else {

        html.append("GET");
      }
      String color = getBackgroundColor();
      if ( color != null ) {

        html.append(" BGCOLOR=\"" + color + "\" ");
      }
      html.append(">\n");

      // adding HTMLInputs
      for ( int x = 0; x < htmlObjects.size(); x++ ) {

        try {

          html.append(
            ((HTMLObject)htmlObjects.elementAt(x)).toHTML() +
            "\n");
        }
        catch (Exception ex) {

          // Print exception to stderr
          System.err.println(ex.getMessage());
        }
      }
      html.append("\n</FORM>");
      if ( getAlignment() == CENTER ) {

        html.insert(0, "<CENTER>");
        html.append("</CENTER>");
      }
      return html.toString();
    }
}
