package HTML;

public class HTMLLineBreak extends HTMLObject {
    
    // Default Constructor
    public HTMLLineBreak() {
    }

    // Return String containing the HTML formatted Line Break
    public String toHTML() {

      return new String("<BR>");
    }
}
