package HTML;

import java.util.Vector;

public abstract class HTMLObject{

    // Vector used to hold other HTMLObjects
    protected Vector htmlObjects = null;

    // Static Alignment values
    public static final int LEFT = 0;
    public static final int CENTER = 1;
    public static final int RIGHT = 2;
    public static final int TOP = 3;
    public static final int MIDDLE = 4;
    public static final int BOTTOM = 5;

    // Set the objects initial alignment to LEFT
    private int alignment = LEFT;

    // horizontal and vertical alignments
    private int horizontal = LEFT;
    private int vertical = MIDDLE;

    // This abstract method forces all derived classes to
    // impliment the toHTML() method.  The toHTML() method
    // should return the HTML String necessary to
    // display this object in its current state.
    public abstract String toHTML();

    private String backgroundColor = new String("");;

    // Constructor
    public HTMLObject() {

      // Default size of HTMLObject vector
      htmlObjects = new Vector(5);
    }

    // Add a HTMLObject
    public void addObject( HTMLObject value) {

      if ( value != null ) {

        htmlObjects.addElement(value);
      }
    }

    // Set the cell's horizontal alignment
    public void setHorizontalAlign( int value) {

      horizontal = value;
    }

    // Get the cell's horizontal alignment
    public int getHorizontalAlign() {

      return horizontal;
    }

    // Set the cell's vertical alignment
    public void setVerticalAlign( int value) {

      if ( value >= TOP && value <= BOTTOM ) {

        vertical = value;
      }
    }

    // Get the cell's vertical alignment
    public int getVerticalAlign() {

      return vertical;
    }

    // Remove a HTMLObject, if the element is removed
    // successfully, returns true
    public boolean removeObject( HTMLObject value) {

      if ( value != null ) {

        return htmlObjects.removeElement(value);
      }
      return false;
    }

    // Set the Objects Background Color
    public void setBackgroundColor( String value) {

      if ( value != null ) {

        backgroundColor = value;
      }
    }

    // Get the Objects Background Color
    public String getBackgroundColor() {

      return backgroundColor;
    }

    // Set the object's Alignment
    public void setAlignment(int value) {

      if ( value >= LEFT && value <= RIGHT ) {

        alignment = value;
      }
    }

    // Get the object's Alignment
    public int getAlignment() {

      return alignment;
    }
}
