class Precedence {
 public static void main(String args[]) {
  String s = "abc";
  int x = 10;
  boolean b = false;
  s = s += x = x++ + 1 - 2 * 3 + 

   ((Object) s instanceof String ? 4 << 5 / 6 & ++x: 

   7 ^ 8 % --x) | 9;  

  System.out.println(s);
 }
}
