import java.util.*;

class PassedReference {
 public static void main(String args[]) {
  Vector v = new Vector();
  v.add(new String("a"));
  v.add(new String("b"));
  v.add(new String("c"));
  System.out.println(v);
  modifyReference(v);
  System.out.println(v);
  modifyReferencedObject(v);
  System.out.println(v);
 }
 static void modifyReference(Vector v) {
  v = new Vector();
  v.add(new String("1"));
  v.add(new String("2"));
  v.add(new String("3"));
 }
 static void modifyReferencedObject(Vector v) {
  v.removeAllElements();
  v.add(new String("1"));
  v.add(new String("2"));
  v.add(new String("3"));
 }
}
