package HTML;

public class HTMLParagraph extends HTMLObject {
    
    // Default Constructor
    public HTMLParagraph() {
    }

    // Return String containing the HTML formatted Paragraph
    public String toHTML() {

      return new String("<P>");;
    }
}
