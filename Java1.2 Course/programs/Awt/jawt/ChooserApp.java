import java.awt.*;
import java.awt.event.*;

public class ChooserApp extends Frame {
 MyChoice mealChoice;
 MyList currentList;
 MyList mealList[];
 String meals[] = {"Breakfast","Lunch","Dinner"};
 String mealChoices[][] = {
  {"pancakes","eggs","bacon","ham","sausage","cereal",
   "toast","coffee","juice"},
  {"pizza","hamburger","hot dog","burrito","salad","fries",
   "chips","soda","milk"},
  {"spaghetti","carne asada","barbequed chicken","soup","salad",
   "bread","wine","beer","soda","milk"}
 };
 TextField text;
 public static void main(String[] args) {
  ChooserApp app = new ChooserApp();
 }
 public ChooserApp() {
  super("ChooserApp");
  setupChoice();
  setupLists();
  text = new TextField(40);
  add("North",new Label("Place your order:"));
  add("South",text);
  add("West",mealChoice);
  currentList = mealList[0];
  add("East",currentList);
  addWindowListener(new WindowEventHandler());
  pack();
  setSize(300,200);
  show();
 }
 void setupChoice(){
  mealChoice = new MyChoice(meals);
  mealChoice.addItemListener(new ChoiceHandler());
 }
 void setupLists(){
  mealList = new MyList[meals.length];
  ListHandler lh = new ListHandler();
  for(int i=0;i<meals.length;++i){
   mealList[i] = new MyList(5,true,mealChoices[i]);
   mealList[i].addItemListener(lh);
  }
 }
 class ChoiceHandler implements ItemListener {
  public void itemStateChanged(ItemEvent e){
   for(int i=0;i<meals.length;++i)
    if(meals[i].equals(mealChoice.getSelectedItem())){
     remove(currentList);
     currentList = mealList[i];
     add("East",currentList);
     text.setText(meals[i]);
    }
   validate();
  }
 }
 class ListHandler implements ItemListener {
  public void itemStateChanged(ItemEvent e){
   String order = mealChoice.getSelectedItem()+": ";
   String items[] = currentList.getSelectedItems();
   for(int i=0;i<items.length;++i) order += items[i]+" ";
   text.setText(order);
  }
 }
 class WindowEventHandler extends WindowAdapter{
  public void windowClosing(WindowEvent e) {
   System.exit(0);
  }
 }
}
class MyList extends List {
 public MyList(int rows,boolean multiple,String labels[]) {
  super(rows,multiple);
  int length = labels.length;
  for(int i=0;i<length;++i) {
   try {
    add(labels[i]);
   }catch (NullPointerException ex) {
    add("");
   }
  }
 }
}
class MyChoice extends Choice {
 public MyChoice(String labels[]) {
  super();
  int length = labels.length;
  for(int i=0;i<length;++i) {
   try {
    add(labels[i]);
   }catch (NullPointerException ex) {
    add("");
   }
  }
 }
}
