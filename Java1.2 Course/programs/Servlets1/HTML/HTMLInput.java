package HTML;

public class HTMLInput extends HTMLObject {

    protected String type = null;
    protected String name = null;
    protected String input_value = null;
    protected String attributes = null;

    // Default Constructor
    public HTMLInput() {
    }

    // Set the Input Type
    protected void setType(String value) {

      if ( value != null ) {

        type = value;
      }
    }

    // Get the Input Type
    public String getType() {

      return type;
    }

    // Set the Input Name
    public void setName(String value) {

      if ( value != null ) {

        name = value;
      }
    }

    // Get the Input Name
    public String getName() {

      return name;
    }

    // Set the value of the Input Object
    public void setValue(String value) {

      if ( value != null ) {

        input_value = value;
      }
    }

    // Get the value of the Input Object
    public String getValue() {

      return input_value;
    }

    // Set the additional attributes string
    // This will be used to specialize an input type
    protected void setAttributes(String value) {

      if ( value != null ) {

        attributes = value;
      }
    }

    // Get the additional attributes string
    public String getAttributes() {

      return attributes;
    }

    // Return String containing the HTML formatted Input
    public String toHTML() {

      StringBuffer html = new StringBuffer("<INPUT TYPE=\"");

      if ( type != null ) {

        html.append(type);
      }

      html.append("\" NAME=\"");

      if ( name != null ) {

        html.append(name);
      }

      html.append("\" ");

      // Add the VALUE
      if ( input_value != null ) {

        html.append(" VALUE=\"" + input_value + "\"");
      }

      // If there is any additional attributes
      if ( attributes != null ) {

        html.append(attributes);
      }
      // Ending Character
      html.append(">");

      return html.toString();
    }
}
