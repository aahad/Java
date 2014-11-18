import java.awt.*;
import java.awt.event.*;

class Anonymous extends Frame {
 public static void main(String[] args) {
  new Anonymous();
 }
 Anonymous() {
  setTitle("Anonymous");
  setLayout(new FlowLayout());
  final Button button = new Button("Click here!");
  button.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    String label = button.getLabel();
    if(label.equals("Click here!"))
     button.setLabel("Try again");
    else
     button.setLabel("Click here!");
   }
  });
  add(button);
  addWindowListener(new WindowAdapter() {
   public void windowClosing(WindowEvent e) {
    System.exit(0);
   }   
  });
  pack();
  setSize(200,200);
  show();
 }
}
