import java.io.*;

public class InputConversionApp {
 public static void main(String args[]) throws IOException {
  InputStreamReader in = new InputStreamReader(System.in);
  BufferedReader inStream = new BufferedReader(in);
  // Get the encoding that is in use
  System.out.println("Encoding: "+in.getEncoding());
  String inputLine;
  do {
   System.out.print(">");
   System.out.flush();
   inputLine=inStream.readLine();
   System.out.println(inputLine);
  } while (inputLine.length() != 0);
 }
}
