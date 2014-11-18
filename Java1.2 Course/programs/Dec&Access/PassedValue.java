class PassedValue {
 public static void main(String args[]) {
  int i = 100;
  modifyMethod(i);
  System.out.println(i);
 }
 static void modifyMethod(int i) {
  i = i * 2;
 }
}
