import java.awt.*;
import java.awt.event.*;

public class ScrollerApp extends Frame {
 Label label = new Label("Scrollbar Position");
 MyScrollbar hscroll = new MyScrollbar(Scrollbar.HORIZONTAL,
  50,1,0,100,label);
 MyScrollbar vscroll = new MyScrollbar(Scrollbar.VERTICAL,
  500,10,0,1000,label);
 public static void main(String[] args) {
  ScrollerApp app = new ScrollerApp();
 }
 public ScrollerApp() {
  super("ScrollerApp");
  add("Center",label);
  add("West",vscroll);
  add("North",hscroll);
  addWindowListener(new WindowEventHandler());
  pack();
  setSize(200,200);
  show();
 }
 class WindowEventHandler extends WindowAdapter{
  public void windowClosing(WindowEvent e) {
   System.exit(0);
  }
 }
}
class MyScrollbar extends Scrollbar {
 Label position;
 String direction = "     Horizontal";
 public MyScrollbar(int orientation,int value,int visible,int min,int max,
  Label label) {
  super(orientation,value,visible,min,max);
  position=label;
  if(orientation==Scrollbar.VERTICAL) direction = "     Vertical";
  addAdjustmentListener(new MyScrollbar.HandleScrolling());
 }
 class HandleScrolling implements AdjustmentListener {
  public void adjustmentValueChanged(AdjustmentEvent e){
   position.setText(direction+" Position: "+e.getValue());
  }
 }
}
