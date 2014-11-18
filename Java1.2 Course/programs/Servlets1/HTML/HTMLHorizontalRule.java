package HTML;

public class HTMLHorizontalRule extends HTMLObject {
    
    // Default Constructor
    public HTMLHorizontalRule() {
    
    }

    // Return String containing the HTML formatted Horizontal Rule
    public String toHTML() {

      return new String("<HR>");
    }
}
