package HTML;

public class HTMLImage extends HTMLObject {

    private String image = null;
    private String text = null;
    private int border = 0;

    // Default Constructor
    HTMLImage() {

    }

    // Constructor with initial image and alternate text
    public HTMLImage(String image_string, String text_string) {

      if ( image_string != null ) {

        image = image_string;
      }
      if ( text_string != null ) {

        text = text_string;
      }
    }

    // Set the image location
    public void setImage(String value) {

      if ( value != null ) {

        image = value;
      }
    }

    // Get the image location
    public String getImage() {

      return image;
    }

    // Set the alternate text
    public void setText( String value) {

      if ( value != null ) {

        text = value;
      }
    }

    // Get the alternate text
    public String getText() {

      return text;
    }

    // Set the size of the image border
    public void setBorder(int value) {

      if ( value > -1 ) {

        border = value;
      }
    }

    // Get the size of the image border
    public int getBorder() {

      return border;
    }
    
    // Return String containing the HTML formatted Image
    public String toHTML() {

      StringBuffer html = new StringBuffer("<img src=\"");

      if ( image != null ) {

        html.append(image);
      }
      html.append("\" border=" + border + " alt=\"");
      if ( text != null ) {

        html.append(text);
      }
      html.append("\">");

      return html.toString();
    }
}
