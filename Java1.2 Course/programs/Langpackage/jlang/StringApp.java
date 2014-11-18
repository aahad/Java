public class StringApp {
 public static void main(String args[]) {
  String s = "  Java 2 Certification ";
  System.out.println(s);
  System.out.println(s.toUpperCase());
  System.out.println(s.toLowerCase());
  System.out.println("["+s+"]");
  s=s.trim();
  System.out.println("["+s+"]");
  s=s.replace('J','X');
  s=s.replace('C','Y');
  s=s.replace('2','Z');
  System.out.println(s);
  int i1 = s.indexOf('X');
  int i2 = s.indexOf('Y');
  int i3 = s.indexOf('Z');
  char ch[] = s.toCharArray();
  ch[i1]='J';
  ch[i2]='C';
  ch[i3]='2';
  s = new String(ch);
  System.out.println(s);
 }
}
