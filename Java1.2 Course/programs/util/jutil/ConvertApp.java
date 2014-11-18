import java.util.*;

public class ConvertApp {
 public static void main(String args[]){
  String strings[] = {"Jason","Emily","Lisa","Jamie","Pierre",
   "Stanley","Gloria","Ben","Ken","Lela"};
  Arrays.sort(strings);
  List list = Arrays.asList(strings);
  displayList(list);
 }
 static void displayList(List list) {
  System.out.println("The size of the list is: "+list.size());
  ListIterator i = list.listIterator(0);
  while(i.hasNext()){
   Object o = i.next();
   if(o == null) System.out.println("null");
   else System.out.println(o.toString());
  }
 }
}
