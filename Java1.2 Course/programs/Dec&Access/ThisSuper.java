class ThisSuper extends SuperClass {
 String s = "this";
 public static void main(String[] args) {
  new ThisSuper();
 }
 ThisSuper() {
  display(this.s);
  display(super.s);
  this.display(s);
  super.display(s);
 }
 void display(String s) {
  System.out.println("this: "+s);
 }
}
class SuperClass {
 String s = "super";
 void display(String s) {
  System.out.println("super: "+s);
 }
}
