import java.awt.*;
import java.awt.event.*;

public class MenuApp extends Frame {
 MenuBar mb = new MenuBar();
 Label label = new Label("");
 public static void main(String[] args) {
  MenuApp app = new MenuApp();
 }
 public MenuApp() {
  super("MenuApp");
  Panel panel = new Panel();
  panel.add(label);
  add("Center",panel);
  addWindowListener(new WindowEventHandler());
  setupMenuBar();
  setMenuBar(mb);
  pack();
  setSize(400,400);
  show();
 }
 void setupMenuBar() {
  Menu fileMenu =  new Menu("File");
  Menu editMenu =  new Menu("Edit");
  Menu helpMenu = new Menu("Help");
  MenuItem newFileMenu = new MenuItem("New");
  MenuItem exitFileMenu = new MenuItem("Exit");
  fileMenu.add(newFileMenu);
  fileMenu.addSeparator();
  fileMenu.add(exitFileMenu);
  MenuItem cutEditMenu = new MenuItem("Cut");
  MenuItem copyEditMenu = new MenuItem("Copy");
  MenuItem pasteEditMenu = new MenuItem("Paste");
  Menu statusMenu = new Menu("Status");
  CheckboxMenuItem textMode = new CheckboxMenuItem("Text Mode",true);
  CheckboxMenuItem wordWrap = new CheckboxMenuItem("Word Wrap",true);
  statusMenu.add(textMode);
  statusMenu.add(wordWrap);
  editMenu.add(cutEditMenu);
  editMenu.add(copyEditMenu);
  editMenu.add(pasteEditMenu);
  editMenu.addSeparator();
  editMenu.add(statusMenu);
  MenuItem aboutHelp = new MenuItem("About");
  helpMenu.add(aboutHelp);
  mb.add(fileMenu);
  mb.add(editMenu);
  mb.setHelpMenu(helpMenu);
  MenuHandler mh = new MenuHandler();
  newFileMenu.addActionListener(mh);
  exitFileMenu.addActionListener(mh);
  cutEditMenu.addActionListener(mh);
  copyEditMenu.addActionListener(mh);
  pasteEditMenu.addActionListener(mh);
  textMode.addItemListener(mh);
  wordWrap.addItemListener(mh);
  aboutHelp.addActionListener(mh);
 }
 class MenuHandler implements ActionListener, ItemListener {
  public void actionPerformed(ActionEvent e){
   String s = e.getActionCommand();
   label.setText(s);
   validate();
   if(s.equals("Exit")) System.exit(0);
  }
  public void itemStateChanged(ItemEvent e){
   CheckboxMenuItem item = (CheckboxMenuItem) e.getItemSelectable();
   String status;
   if(item.getState()) status = "You checked: ";
   else status = "You unchecked: ";
   status += item.getLabel();
   label.setText(status);
   validate();
  }
 }
 class WindowEventHandler extends WindowAdapter{
  public void windowClosing(WindowEvent e) {
   System.exit(0);
  }
 }
}
