import java.awt.*;
import java.awt.event.*;

public class CheckboxApp extends Frame {
 TextArea textArea = new TextArea(5,10);
 public static void main(String[] args) {
  CheckboxApp app = new CheckboxApp();
 }
 public CheckboxApp() {
  super("CheckboxApp");
  Panel panel1 = new Panel();
  Panel panel2 = new Panel();
  Checkbox one = new Checkbox("One");
  Checkbox two = new Checkbox("Two");
  Checkbox three = new Checkbox("Three");
  CheckboxGroup group = new CheckboxGroup();
  one.setCheckboxGroup(group);
  two.setCheckboxGroup(group);
  three.setCheckboxGroup(group);
  one.setState(true);
  Checkbox a = new Checkbox("A");
  Checkbox b = new Checkbox("B");
  Checkbox c = new Checkbox("C");
  CheckboxHandler ch = new CheckboxHandler();
  one.addItemListener(ch);
  two.addItemListener(ch);
  three.addItemListener(ch);
  a.addItemListener(ch);
  b.addItemListener(ch);
  c.addItemListener(ch);
  panel1.add(one);
  panel1.add(two);
  panel1.add(three);
  panel2.add(a);
  panel2.add(b);
  panel2.add(c);
  add(panel1,"West");
  add(panel2,"East");
  add(textArea,"South");
  addWindowListener(new WindowEventHandler());
  pack();
  setSize(400,200);
  show();
 }
 class CheckboxHandler implements ItemListener {
  public void itemStateChanged(ItemEvent e){
   String status;
   Checkbox checkbox = (Checkbox) e.getItemSelectable();
   if(checkbox.getState()) status = "You checked: ";
   else status = "You unchecked: ";
   status += checkbox.getLabel();
   textArea.setText(status);
  }
 }
 class WindowEventHandler extends WindowAdapter{
  public void windowClosing(WindowEvent e) {
   System.exit(0);
  }
 }
}
