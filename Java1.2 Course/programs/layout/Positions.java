import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/*
<APPLET CODE="Positions.class" WIDTH=500 HEIGHT=350>
</APPLET>
*/
public class Positions extends Applet {
 Label label1 = new Label("Label at (10,10)");
 Label label2 = new Label("Label at (100,100)");
 Button button1 = new Button("Button at (150,150)");
 Button button2 = new Button("Button at (200,200)");
 public void init() {
  setLayout(null);
  label1.setBounds(10,10,200,30);
  label2.setBounds(100,100,200,30);
  button1.setBounds(150,150,150,30);
  button2.setBounds(200,200,250,60);
  add(label1);
  add(label2);
  add(button1);
  add(button2);
 }
}
