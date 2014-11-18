import java.util.*;

class Instance {
 public static void main(String args[]) {
  String s = "abcd";
  Vector v = new Vector();
  v.add(s);
  Object o = v.elementAt(0);
  System.out.println(s instanceof String);
  System.out.println(s instanceof Object);
  System.out.println(o instanceof String);
  System.out.println(o instanceof Object);
  System.out.println(o instanceof Vector);
 }
}
