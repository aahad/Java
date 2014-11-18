class StaticMethod {
 public static void main(String[] args) {
  StaticClass.display("sample output");
 }
}
class StaticClass {
 static void display(String s) {
  System.out.println("StaticClass: "+s);
 }
}
