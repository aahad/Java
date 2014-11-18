import java.awt.*;
import java.awt.event.*;

public class TextApp extends Frame {
 TextField textField = new TextField(40);
 TextArea textArea = new TextArea(5,40);
 Button append = new Button("Append");
 Button clear = new Button("Clear");
 public static void main(String[] args) {
  TextApp app = new TextApp();
 }
 public TextApp() {
  super("TextApp");
  Panel panel1 = new Panel();
  Panel panel2 = new Panel();
  append.addActionListener(new ButtonHandler());
  clear.addActionListener(new ButtonHandler());
  panel1.add(append);
  panel1.add(clear);
  panel2.add(textField);
  panel2.add(textArea);
  add("North",panel1);
  add("Center",panel2);
  addWindowListener(new WindowEventHandler());
  pack();
  setSize(350,250);
  show();
 }
 class ButtonHandler implements ActionListener {
  public void actionPerformed(ActionEvent ev){
   String s=ev.getActionCommand();
   if(s.equals("Append")) {
    String text = textArea.getText();
    if(!text.equals("")) text += "\n"+textField.getText();
    else text = textField.getText();
    textArea.setText(text);
   }else if(s.equals("Clear")) textArea.setText("");
  }
 }
 class WindowEventHandler extends WindowAdapter{
  public void windowClosing(WindowEvent e) {
   System.exit(0);
  }
 }
}
