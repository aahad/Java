package HTML;

public class HTMLDocument extends HTMLObject {

    private String title = null;
    private String backgroundImage = null;
    private String backgroundColor = null;
    private String textColor = null;
    private String linkColor = null;
    private String vlink = null;
    private String alink = null;

    // Default Constructor
    public HTMLDocument() {

    }

    // Constructor with title
    public HTMLDocument(String value) {

      if ( value != null ) {

        title = value;
      }
    }

    // Set the document Title
    public void setTitle(String value) {

      if ( value != null ) {

        title = value;
      }
    }

    // Get the document Title
    public String getTitle() {

      return title;
    }

    // Set the document Background Image
    public void setBackgroundImage(String value) {

      if ( value != null ) {

        backgroundImage = value;
      }
    }

    // Get the document Background Image
    public String getBackgroundImage() {

      return backgroundImage;
    }

    // Set the document Background Color
    public void setBackgroundColor( String value) {

      if ( value != null ) {

        backgroundColor = value;
      }
    }

    // Get the document Background Color
    public String getBackgroundColor() {

      return backgroundColor;
    }

    // Set the document Text Color
    public void setTextColor(String value) {

      if ( value != null ) {

        textColor = value;
      }
    }

    // Get the document Text Color
    public String getTextColor() {

      return textColor;
    }

    // Set the document Link Color
    public void setLinkColor(String value) {

      if ( value != null ) {

        linkColor = value;
      }
    }

    // Get the document Link Color
    public String getLinkColor() {

      return linkColor;
    }

    // Set the document Visited Link Color
    public void setVLinkColor(String value) {

      if ( value != null ) {

        vlink = value;
      }
    }

    // Get the document Visited Link Color
    public String getVLinkColor() {

      return vlink;
    }

    // Set the document Active Link Color
    public void setALinkColor(String value) {

      if ( value != null ) {

        alink = value;
      }
    }

    // Get the document Active Link Color
    public String getALinkColor() {

      return alink;
    }

    // Return String containing the HTML formatted document
    public String toHTML() {

      StringBuffer document = new StringBuffer("<html><head>\n");
      document.append("<title>");
      if ( title != null ) {

        document.append(title);
      }
      document.append("</title></head>\n\n<body ");

      if ( backgroundImage != null ) {

        document.append("BACKGROUND=\"" +
          backgroundImage + "\" ");
      }
      String color = getBackgroundColor();
      if ( color != null ) {

        document.append("BGCOLOR=\"" + color +
          "\" ");
      }
      String textColor = getTextColor();
      if ( textColor != null ) {

        document.append("TEXT=\"" + textColor +
          "\" ");
      }
      if ( linkColor != null ) {

        document.append("LINK=\"" + linkColor +
          "\" ");
      }
      if ( vlink != null ) {

        document.append("VLINK=\"" + vlink + "\" ");
      }
      if ( alink != null ) {

        document.append("ALINK=\"" + alink + "\" ");
      }
      document.append(">\n");

      // Iterate through all objects in the htmlObjects Vector
      for ( int x = 0; x < htmlObjects.size(); x ++ ) {

        try {

          document.append(
              ((HTMLObject)htmlObjects.elementAt(x)).toHTML() +
              "\n");
        }
        catch (ArrayIndexOutOfBoundsException ex) {

          // This will only log the error to stderr
          System.err.println(ex.getMessage());
        }
        catch (Exception ex) {

          // This will only log the error to stderr
          System.err.println(ex.getMessage());
        }
      }

      // Then close the document
      document.append("\n</body>\n</html>\n");

      return document.toString();
    }
}
