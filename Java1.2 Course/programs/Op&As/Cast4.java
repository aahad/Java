import java.util.*;

class Cast4 {
 public static void main(String args[]) {
  String s1 = "abc";
  String s2 = "def";
  Vector v = new Vector();
  v.add(s1);
  s2 = (String) v.elementAt(0);
  System.out.println(s2);
 }
}
