package HTML;

public class HTMLTableRow extends HTMLObject {

    // Default Constructor
    public HTMLTableRow() {

    }

    // Return String containing the HTML formatted Text
    public String toHTML() {

      StringBuffer html = new StringBuffer("<TR");

      String color = getBackgroundColor();
      if ( color.length() > 0 ) {

        html.append(" BGCOLOR=\"" + color + "\">");
      }
      else {

        html.append(">");
      }

      // Iterate through the cells
      for ( int x = 0; x < htmlObjects.size(); x ++ ) {

        try {

          html.append(((HTMLObject)htmlObjects.elementAt(x)).toHTML());
        }
        catch (ArrayIndexOutOfBoundsException ex) {

          System.err.println(ex.getMessage());
        }
        catch (Exception ex) {

          // This will only log the error to stderr
          System.err.println(ex.getMessage());
        }
      }

      // close the Table Row
      html.append("</TR>\n");

      return html.toString();
    }
}
