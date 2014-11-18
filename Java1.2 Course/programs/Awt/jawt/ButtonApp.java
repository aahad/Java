import java.awt.*;
import java.awt.event.*;

public class ButtonApp extends Frame {
 Label label = new Label("Default Label");
 Button button1 = new Button("One");
 Button button2 = new Button("Two");
 Button button3 = new Button("Three");
 Panel panel1 = new Panel();
 Panel panel2 = new Panel();
 public static void main(String[] args) {
  ButtonApp app = new ButtonApp();
 }
 public ButtonApp() {
  super("ButtonApp");
  panel1.add(label);
  button1.addActionListener(new ButtonHandler());
  button2.addActionListener(new ButtonHandler());
  button3.addActionListener(new ButtonHandler());
  panel2.add(button1);
  panel2.add(button2);
  panel2.add(button3);
  add("North",panel1);
  add("Center",panel2);
  addWindowListener(new WindowEventHandler());
  pack();
  show();
 }
 class ButtonHandler implements ActionListener {
  public void actionPerformed(ActionEvent e){
   String s = e.getActionCommand();
   label.setText(s);
  }
 }
 class WindowEventHandler extends WindowAdapter{
  public void windowClosing(WindowEvent e) {
   System.exit(0);
  }
 }
}
