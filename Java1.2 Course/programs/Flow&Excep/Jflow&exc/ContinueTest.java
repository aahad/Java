class ContinueTest {
 public static void main(String[] args) {
  outerloop: for(int i=0; i<10; ++i) {
   innerloop: for(int j=0; j<10; ++j) {
    if((i+j) % 5 == 0) continue outerloop;
    if((i+j) % 5 == 3) continue innerloop;
    System.out.println("i = "+i+", j = "+j);
   }
  }
 }
}
