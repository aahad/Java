package HTML;

public class HTMLTable extends HTMLObject {

    private HTMLObject caption = null;
    private int width = 0;
    private int height = 0;
    private int border = 0;
    private int cellspacing = -1;
    private int cellpadding = -1;
    private boolean percentage_width = true;

    // Default Constructor
    public HTMLTable() {

    }

    // Set the caption of the table
    public void setCaption(HTMLObject value) {

      if ( value != null ) {

        caption = value;
      }
    }

    // Get the caption of the table
    public HTMLObject getCaption() {

      return caption;
    }

    // Set the Table Border
    public void setBorder(int value) {

      if ( value > -1 ) {

        border = value;
      }
    }

    // Get the Table Border
    public int getBorder() {

      return border;
    }

    // Set the Cell Spacing
    public void setCellSpacing(int value) {

      if ( value >= 0 ) {

        cellspacing = value;
      }
    }

    // Get the Cell Spacing
    public int getCellSpacing() {

      return cellspacing;
    }

    // Set the Cell Padding
    public void setCellPadding(int value) {

      if ( value >= 0 ) {

        cellpadding = value;
      }
    }

    // Get the Cell Padding
    public int getCellPadding() {

      return cellpadding;
    }

    // Set the Table Width as a percentage
    public void setWidth(int value) {

      width = value;
      percentage_width = true;
    }

    // Set the Table Width in Pixels
    public void setWidthByPixel(int value) {

      width = value;
      percentage_width = false;
    }

    // Get the table width
    public int getWidth() {

      return width;
    }

    // Set the Table height
    public void setHeight(int value) {

      height = value;
    }

    // Get the table height
    public int getHeight() {

      return height;
    }

    // Return String containing the HTML formatted Table
    public String toHTML() {

      StringBuffer html = new StringBuffer("<TABLE ");

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

        case BOTTOM:
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

        case RIGHT:
          align = "RIGHT";
          break;
      }
      html.append(" VALIGN=" + valign +
        " ALIGN=" + align);


      if ( width > 0 ) {

        html.append(" WIDTH=" + width);
        if ( percentage_width ) {

          html.append("% ");
        }
        else {

          html.append(" ");
        }
      }

      if ( height > 0 ) {

        html.append(" HEIGHT=" + height + " ");
      }

      if ( border > -1 ) {

        html.append(" BORDER=" + border);
      }

      if ( cellspacing > -1 ) {

        html.append(" CELLSPACING=" + cellspacing);
      }

      if ( cellpadding > -1 ) {

        html.append(" CELLPADDING=" + cellpadding);
      }

      String color = getBackgroundColor();
      if ( color != null ) {

        html.append(" BGCOLOR=\"" + color + "\" ");
      }
      // Close the TABLE tag
      html.append(">\n");

      // Add the CAPTION
      if ( caption != null ) {

        html.append("\n<CAPTION>" + caption.toHTML()
          + "</CAPTION>\n");
      }

      // Iterate through the rows
      for ( int x = 0; x < htmlObjects.size(); x ++ ) {

        try {

          html.append((
            (HTMLObject)htmlObjects.elementAt(x)).toHTML() +
            "\n");
        }
        catch (ArrayIndexOutOfBoundsException ex) {

          System.err.println(ex.getMessage());
        }
        catch (Exception ex) {

          // This will be logged to stderr
          System.err.println(ex.getMessage());
        }
      }

      // close the table
      html.append("\n</TABLE>");

      return html.toString();
    }
}

