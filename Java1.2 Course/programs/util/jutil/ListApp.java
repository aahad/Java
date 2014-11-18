import java.util.*;

public class ListApp {
 public static void main(String args[]){
    LinkedList list = new LinkedList();
    list.add("is");
    list.add("is");
    list.add("a");
    list.add("a");
    list.add(null);
    list.addLast("test");
    list.addFirst("This");
    displayList(list);
 }
 static void displayList(LinkedList list) {
  System.out.println("The size of the list is: "+list.size());
  ListIterator i = list.listIterator(0);
  while(i.hasNext()){
   Object o = i.next();
   if(o == null) System.out.println("null");
   else System.out.println(o.toString());
  }
 }
}
