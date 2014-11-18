package HTML;

public class HTMLFont extends HTMLObject {

  private String face = "";
  private int size = 0;
  private String color = "#000000";

  public HTMLFont() {
  }

  public HTMLFont(String fface, int fsize, String fcolor) {

    if ( fface != null ) {

      face = fface;
    }
    if ( fsize >= 0 ) {

      size = fsize;
    }
    if ( fcolor != null ) {

      color = fcolor;
    }
  }

  public void setFace(String value) {

    if ( value != null ) {

      face = value;
    }
  }

  public String getFace() {

    return face;
  }

  public void setSize(int value) {

    if ( value >= 0 ) {

      size = value;
    }
  }

  public int getSize() {

    return size;
  }

  public void setColor(String value) {

    if ( value != null ) {

      color = value;
    }
  }

  public String getColor() {

    return color;
  }

  public String toHTML() {

    // example <font face="arial" color="#ffffff" size="2">
    return new String("<font face=\"" + face + "\" color=\"" + color + "\" size=\"" + size + "\">");
  }
}
