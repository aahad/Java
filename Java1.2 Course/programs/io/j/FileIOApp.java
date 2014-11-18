import java.io.*;

public class FileIOApp {
 public static void main(String args[]) throws IOException {
  // Create output file test.txt
  FileOutputStream outStream = new FileOutputStream("test.txt");
  String s = "This is a test.";
  for(int i=0;i<s.length();++i)
   outStream.write(s.charAt(i));
  outStream.close();
  // Open test.txt for input
  FileInputStream inStream = new FileInputStream("test.txt");
  int inBytes = inStream.available();
  System.out.println("inStream has "+inBytes+" available bytes");
  byte inBuf[] = new byte[inBytes];
  int bytesRead = inStream.read(inBuf,0,inBytes);
  System.out.println(bytesRead+" bytes were read");
  System.out.println("They are: "+new String(inBuf));
  inStream.close();
  File f = new File("test.txt");
  f.delete();
 }
}
