class Logical {
 static boolean sideEffect(boolean b) {
  System.out.print("Side effect! ");
  return b;
 }
 public static void main(String args[]) {
  boolean t = true;
  boolean f = false;
  System.out.println(false & sideEffect(true));
  System.out.println(false && sideEffect(true));
  System.out.println(true | sideEffect(true));
  System.out.println(true || sideEffect(true));
 }
}
