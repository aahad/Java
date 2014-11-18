class DoTest {
 public static void main(String[] args) {
  boolean finished = false;
  do {
   double d = Math.random();
   if(d > .5) finished = true;
   System.out.println(d);
  } while (!finished);
 }
}
