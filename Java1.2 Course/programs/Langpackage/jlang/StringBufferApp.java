public class StringBufferApp {
 public static void main(String args[]) {
  StringBuffer sb = new StringBuffer(" is ");
  sb.append("Hot");
  sb.append('!');
  sb.insert(0,"Java");
  sb.append('\n');
  sb.append("This is ");
  sb.append(true);
  sb.setCharAt(21,'T');
  sb.append('\n');
  sb.append("Java is #");
  sb.append(1);
  String s = sb.toString();
  System.out.println(s);
 }
}
