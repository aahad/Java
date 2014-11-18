class ForTest {
 public static void main(String[] args) {
  int i,j;
  for(i=0, j=0; i+j < 20; ++i, j += i) {
   System.out.println(i+j);
  }
 }
}
