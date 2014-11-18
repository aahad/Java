class Initialization {
 boolean bo;
 byte by;
 char c;
 short s;
 int i;
 long l;
 float f;
 double d;
 Object o;
 public static void main(String[] args) {
  byte var1=4;
  int var2=10;
  var3= var1 + var2;
  System.out.println("var1: "+var1);
  System.out.println("var2: "+var2);
  System.out.println("var3: "+var3);
  Initialization app = new Initialization();
  app.run();
 }
 void run() {
  int[] intArray = new int[2];
  Object[] objectArray = new Object[2];
  System.out.println("boolean: "+bo);
  System.out.println("byte: "+by);
  System.out.println("char: "+c);
  System.out.println("short: "+s);
  System.out.println("int: "+i);
  System.out.println("long: "+l);
  System.out.println("float: "+f);
  System.out.println("double: "+d);
  System.out.println("Object: "+o);
  System.out.println("int[2]: "+intArray[0]+" "+intArray[1]);
  System.out.println("Object[2]: "+objectArray[0]+" "+objectArray[1]);
 }
}
