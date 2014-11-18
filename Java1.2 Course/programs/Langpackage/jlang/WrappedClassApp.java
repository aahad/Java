public class WrappedClassApp {
 public static void main(String args[]) {
  Boolean b1 = new Boolean("TRUE");
  Boolean b2 = new Boolean("FALSE");
  System.out.println(b1.toString()+" or "+b2.toString());
  for(int j=0;j<16;++j)
   System.out.print(Character.forDigit(j,16));
  System.out.println();
  Integer i = new Integer(Integer.parseInt("ef",16));
  Long l = new Long(Long.parseLong("abcd",16));
  long m=l.longValue()*i.longValue();
  System.out.println(Long.toString(m,8));
  System.out.println(Float.MIN_VALUE);
  System.out.println(Double.MAX_VALUE);
 }
}
