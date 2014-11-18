package HTML;

public class HTMLHeading extends HTMLObject {

    private String text = null;

    public static final int H1 = 1;
    public static final int H2 = 2;
    public static final int H3 = 3;
    public static final int H4 = 4;
    public static final int H5 = 5;
    public static final int H6 = 6;
    private int heading = H1;

    // Constructor that initializes Heading Level to H1
    public HTMLHeading() {

    }

    // Constructor that sets the initial Heading Text and Level
    public HTMLHeading(String txt,  int head) {

      if ( txt != null ) {

        text = txt;
      }

      if ( head >= H1 && head <= H6 ) {

        heading = head;
      }
    }

    // Set Heading Text
    public void setText( String value) {

      if ( value != null ) {

        text = value;
      }
    }

    // Get Heading Text
    public String getText() {

      return text;
    }

    // Set Heading Level
    public void setHeadingLevel( int value) {

      if ( value >= H1 && value <= H6 ) {

        heading = value;
      }
    }

    // Get Heading Level
    public int getHeadingLevel() {

      return heading;
    }

    // Return String containing the HTML formatted Heading
    public String toHTML() {

      StringBuffer html = new StringBuffer("<H" + heading);

      switch ( getAlignment() ) {

        case HTMLObject.LEFT:
          html.append(" ALIGN=\"LEFT\"");
          break;

        case HTMLObject.CENTER:
          html.append(" ALIGN=\"CENTER\"");
          break;

        case HTMLObject.RIGHT:
          html.append(" ALIGN=\"RIGHT\"");
          break;
      }
      html.append(">");
      if ( text != null ) {

        html.append(text);
      }
      html.append("</H" + heading + ">");

      return html.toString();
    }
}
