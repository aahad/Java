class StaticApp {
 static String s = "This code is executed second.";
 String t  = "This code is executed last.";
 static {  // Static initializer
  display("This code is executed first.");
 }
 public static void main(String[] args) {
  display(s);
  StaticApp app = new StaticApp();
  app.display(app.t);
 }
 static void display(String s) {
  System.out.println(s);
 }
}
