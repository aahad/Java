package HTML;

public class HTMLLink extends HTMLObject {

    private String href = null;

    // Default Constructor
    public HTMLLink() {
    }

    // Constructor with initial href and HTMLObject
    public HTMLLink(String href_string,  HTMLObject object) {

      if ( href_string != null ) {

        href = href_string;
      }
      if ( object != null ) {

        addObject(object);
      }
    }

    // Set the HREF
    public void setHREF(String value) {

      if ( value != null ) {

        href = value;
      }
    }

    // Get the HREF
    public String getHREF() {

      return href;
    }

    // Return String containing the HTML formatted Line Break
    public String toHTML() {

      StringBuffer html = new StringBuffer("<a href=\"");
      html.append(href + "\">");

      // Iterate through the htmlObjects Vector
      for ( int x = 0; x < htmlObjects.size(); x ++ ) {

        try {

          html.append(
              ((HTMLObject)htmlObjects.elementAt(x)).toHTML()
              + "\n");
        }
        catch (ArrayIndexOutOfBoundsException ex) {

          // This will only log the error to stderr
          System.err.println(ex.getMessage());
        }
      }
      html.append("</a>");

      // Check for Alignment
      if ( getAlignment() == CENTER ) {

        html.insert(0, "<CENTER>");
        html.append("</CENTER>");
      }
      return html.toString();
    }
}
