import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileApp extends Frame {
 List list = new List(5);
 TextArea textArea = new TextArea(10,80);
 File[] roots = File.listRoots();
 public static void main(String[] args) {
  FileApp app = new FileApp();
 }
 public FileApp() {
  super("FileApp");
  setup();
  addWindowListener(new WindowEventHandler());
  pack();
  setSize(450,450);
  show();
 }
 public void setup() {
  setFont(new Font("Courier",Font.BOLD,12));
  setLayout(new GridLayout(2,1));
  for(int i=0;i<roots.length;++i)
   list.add(roots[i].getAbsolutePath());
  list.addActionListener(new ListHandler());
  add(list);
  add(textArea);
 }
 void updateWindow(File file) {
  File[] contents = file.listFiles();
  list.removeAll();
  String parent = file.getParent();
  if(parent == null) list.add("---roots---");
  else list.add(parent);
  String text = "Files:\n";
  for(int i=0;i<contents.length;++i) {
   if(contents[i].isDirectory())
    list.add(contents[i].getAbsolutePath());
   if(contents[i].isFile())
    text += "\n" + contents[i].getName();
  }
  textArea.setText(text);
 }
 class ListHandler implements ActionListener {
  public void actionPerformed(ActionEvent e) {
   String item = (String) e.getActionCommand();
   if(item.equals("---roots---")) {
    list.removeAll();
    for(int i=0;i<roots.length;++i)
     list.add(roots[i].getAbsolutePath());
    textArea.setText("");
   }else updateWindow(new File(item));
   validate();
  }
 }
 class WindowEventHandler extends WindowAdapter{
  public void windowClosing(WindowEvent e) {
   System.exit(0);
  }
 }
}
