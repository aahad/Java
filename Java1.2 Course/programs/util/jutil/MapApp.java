import java.util.*;

public class MapApp {
 public static void main(String args[]){
    TreeMap map = new TreeMap();
    map.put("one","1");
    map.put("two","2");
    map.put("three","3");
    map.put("four","4");
    map.put("five","5");
    map.put("six","6");
    displayMap(map);
 }
 static void displayMap(TreeMap map) {
  System.out.println("The size of the map is: "+map.size());
  Collection c = map.entrySet();
  Iterator i = c.iterator();
  while(i.hasNext()){
   Object o = i.next();
   if(o == null) System.out.println("null");
   else System.out.println(o.toString());
  }
 }
}
