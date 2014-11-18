package HTML;

public class HTMLTableCell extends HTMLObject {

    private int type = DATA;
    private int colspan = 1;
    private int width = 0;
    public static final int HEADING = 6;
    public static final int DATA = 7;

    // Default Constructor
    public HTMLTableCell() {

    }

    // Constructor with initial Cell Type
    public HTMLTableCell(int cell_type) {

      type = cell_type;
    }

    // Set the number of columns the cell spans
    public void setColspan(int value) {

      if ( value > 0 ) {

        colspan = value;
      }
    }

    // Get the number of columns the cell spans
    public int getColspan() {

      return colspan;
    }

    // Set the Cell Width in Pixels
    public void setWidth(int value) {

      width = value;
    }

    // Get the cell width
    public int getWidth() {

      return width;
    }

    // Return String containing the HTML formatted Table Cell
    public String toHTML() {

      StringBuffer html = new StringBuffer("");
      String tag = null;
      String valign = null;
      String align = null;

      // Determine Alignment
      switch ( getVerticalAlign() ) {

        case TOP:
          valign = "TOP";
          break;

        case MIDDLE:
          valign = "MIDDLE";
          break;

        default:
          valign = "BOTTOM";
          break;
      }

      switch ( getHorizontalAlign() ) {

        case LEFT:
          align = "LEFT";
          break;

        case CENTER:
          align = "CENTER";
          break;

        default:
          align = "RIGHT";
          break;
      }

      if ( type == DATA ) {

        tag = new String("TD");
      }
      else {

        tag = new String("TH");
      }
      html.append("<" + tag + " VALIGN=" + valign +
        " ALIGN=" + align);
      if ( width > 0 ) {

        html.append(" WIDTH=" + width);
      }
      
      html.append(" COLSPAN=" + colspan + ">");

      // iterate through the objectVector
      for ( int x = 0; x < htmlObjects.size(); x ++ ) {

        try {

          html.append(
            ((HTMLObject)htmlObjects.elementAt(x)).toHTML());
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
      // close the cell
      html.append("</" + tag + ">");

      return html.toString();
    }
}
