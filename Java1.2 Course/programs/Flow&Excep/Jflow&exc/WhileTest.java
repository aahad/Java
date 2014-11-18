class WhileTest {
 public static void main(String[] args) {
  boolean finished = false;
  while (!finished) {
   double d = Math.random();
   if(d > .5) finished = true;
   System.out.println(d);
  }
 }
}
