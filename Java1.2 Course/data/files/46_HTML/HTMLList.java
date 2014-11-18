package HTML;

public class HTMLList extends HTMLObject {

    // Initial list type
    private int listType = UL;

    // List Types
    public static final int UL = 0;
    public static final int OL = 1;
    public static final int MENU = 2;
    public static final int DIR = 3;

    // Default Constructor
    public HTMLList() {

    }

    // Constructor with initial list type value
    public HTMLList(int value) {

      // set to initial safe value
      listType = UL;

      if ( value >= UL && value <= DIR ) {

        listType = value;
      }
    }

    // Set the list type
    public void setListType(int value) {

      if ( value >= UL && value <= DIR ) {

        listType = value;
      }
    }

    // Get the list type
    public int getListType() {

      return listType;
    }

    // Return String containing the HTML formatted Line Break
    public String toHTML() {

      StringBuffer html = new StringBuffer("\n");

      // Iterate through the htmlObjects Vector
      for ( int x = 0; x < htmlObjects.size(); x ++ ) {

        try {

          html.append("<LI>" +
              ((HTMLObject)htmlObjects.elementAt(x)).toHTML()
              + "\n");
        }
        catch (ArrayIndexOutOfBoundsException ex) {

          // This will only log the error to stderr
          System.err.println(ex.getMessage());
        }
      }
      if ( listType == UL ) {

        html.insert(0, "<UL>");
        html.append("</UL>");
      }
      else if ( listType == OL ) {

        html.insert(0, "<OL>");
        html.append("</OL>");
      }
      else if ( listType == MENU ) {

        html.insert(0, "<MENU>");
        html.append("</MENU>");
      }
      else {

        html.insert(0, "<DIR>");
        html.append("</DIR>");
      }
      return html.toString();
    }
}
