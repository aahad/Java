package HTML;

public class HTMLText extends HTMLObject {

    private String text = new String("");
    private boolean bold = false;
    private boolean italic = false;
    private boolean underline = false;
    private boolean center = false;
    private boolean preformatted = false;

    // Default Contructor
    public HTMLText() {

    }

    // Constructor initialized with Text value
    public HTMLText(String value) {

      if ( value != null ) {

        text = value;
      }
    }

    // Set the text value
    public void setText(String value) {

      if ( value != null ) {

        text = value;
      }
    }

    // Get the current text value
    public String getText() {

      return text;
    }

    // Set Text Bold to true/false
    public void setBold(boolean value) {

      bold = value;
    }

    // Returns True if Bold is on
    public boolean isBold() {

      return bold;
    }

    // Set Text Italic to true/false
    public void setItalic( boolean value) {

      italic = value;
    }

    // Returns True if Italic is on
    public boolean isItalic() {

      return italic;
    }

    // Set Text Underline to true/false
    public void setUnderline( boolean value) {

      underline = value;
    }

    // Returns True if Underline is on
    public boolean isUnderline() {

      return underline;
    }

    // Set Text Center to true/false
    public void setCenter( boolean value) {

      center = value;
    }

    // Returns True if Center is on
    public boolean isCenter() {

      return center;
    }

    // Set Text Preformatted to true/false
    public void setPreformatted( boolean value) {

      preformatted = value;
    }

    // Returns True if Preformatted is on
    public boolean isPreformatted() {

      return preformatted;
    }

    // Return String containing the HTML formatted Text
    public String toHTML() {

      StringBuffer html = new StringBuffer(text);

      if ( isBold() ) {

        html.insert(0, "<B>");
        html.append("</B>");
      }

      if ( isItalic() ) {

        html.insert(0, "<I>");
        html.append("</I>");
      }

      if ( isUnderline() ) {

        html.insert(0, "<U>");
        html.append("</U>");
      }

      if ( isCenter() ) {

        html.insert(0, "<CENTER>");
        html.append("</CENTER>");
      }

      if ( isPreformatted() ) {

        html.insert(0, "<PRE>");
        html.append("</PRE>");
      }
      return html.toString();
    }
}
