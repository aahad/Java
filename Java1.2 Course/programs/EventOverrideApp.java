import java.awt.*;
import java.awt.event.*;

public class EventOverrideApp extends Frame {
 public static void main(String args[]){
  EventOverrideApp app = new EventOverrideApp();
 }
 public EventOverrideApp() {
  super("Event Override");
  setup();
  setSize(300,300);
  // Add event handler for closing the frame.
  addWindowListener(new WindowEventHandler());
  show();
 }
 void setup() {
  setupMenuBars();
  setupPanels();
 }
 void setupMenuBars() {
  MenuBar menuBar = new MenuBar();
  Menu fileMenu = new Menu("File");
  MenuItem fileExit = new MenuItem("Exit");
  MenuItemHandler mh = new MenuItemHandler();
  // Add an action listener for File -> Exit.
  fileExit.addActionListener(mh);
  fileMenu.add(fileExit);
  menuBar.add(fileMenu);
  setMenuBar(menuBar);
 }
 void setupPanels() {
  Panel panel = new Panel();
  TextArea textArea = new TextArea(15,20);
  MyButton button = new MyButton("Click here!",textArea);
  panel.add(button);
  panel.add(textArea);
  add(panel);
 }
 class WindowEventHandler extends WindowAdapter {
  public void windowClosing(WindowEvent e){
   System.exit(0);
  }
 }
 class MenuItemHandler implements ActionListener {
  public void actionPerformed(ActionEvent ev){
   String s=ev.getActionCommand();
   if(s.equals("Exit")) System.exit(0);
  }
 }
}
class MyButton extends Button {
 TextArea textArea;
 public MyButton(String s, TextArea textArea) {
  super(s);
  this.textArea = textArea;
  enableEvents(AWTEvent.ACTION_EVENT_MASK);
 }
 public void processActionEvent(ActionEvent event) {
  String s = textArea.getText();
  s += "\nThe button was clicked.";
  textArea.setText(s);
  // super.processActionEvent(event);
  // Uncomment the above line to allow event listeners to 
  // also handle this event.
 }
}
