package HTML;

public class HTMLPasswordInput extends HTMLInput {

  private int size = -1;
  private int maxlength = -1;

  // Default Constructor
  public HTMLPasswordInput() {

    // Set the Input Type
    setType("PASSWORD");
  }

  // Set the Input Size
  public void setSize(int value) {

    if ( value > -1 ) {

      size = value;
    }
  }

  // Get the Input Size
  public int getSize() {

    return size;
  }

  // Set the Maximum Length
  public void setMaxLength(int value) {

    if ( value > -1 ) {

      maxlength = value;
    }
  }

  // Get the Maximum Length
  public int getMaxLength() {

    return maxlength;
  }

  // Return String containing the HTML formatted Password
  public String toHTML() {

    StringBuffer attribute = new StringBuffer("");

    if ( size > -1 ) {

      attribute.append(" SIZE=" + size);
    }
    if ( maxlength > -1 ) {

      attribute.append(" MAXLENGTH=" + maxlength);
    }
    setAttributes(attribute.toString());

    return super.toHTML();
  }
}