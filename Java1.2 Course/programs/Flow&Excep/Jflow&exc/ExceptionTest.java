import java.io.*;

public class ExceptionTest {
 public static void main(String args[]) {
  boolean finished = false;
  do {
   try {
    processUserInput();
   }catch (VowelException x) {
    System.out.println("A vowel exception occurred.");
   }catch (BlankException x) {
    System.out.println("A blank exception occurred.");
   }catch (ExitException x) {
    System.out.println("An exit exception occurred.");
    finished = true;
   }finally {
    System.out.println("This is the finally clause.\n");
   }
  } while(!finished);
 }
 static void processUserInput() throws VowelException, BlankException,
   ExitException {
  System.out.print("Enter a character: ");
  System.out.flush();
  char ch;
  try {
   BufferedReader kbd = 
    new BufferedReader(new InputStreamReader(System.in));
   String line = kbd.readLine();
   if(line.length() == 0) ch = ' ';
   else ch=Character.toUpperCase(line.charAt(0));
  } catch (IOException x) {
   System.out.println("An IOException occurred.");
   return;
  }
  switch(ch) {
   case 'A':
   case 'E':
   case 'I':
   case 'O':
   case 'U':
    throw new VowelException();
   case ' ':
    throw new BlankException();
   case 'X':
    throw new ExitException();
  }
 }
}
class VowelException extends Exception {}
class BlankException extends Exception {}
class ExitException extends Exception {}
