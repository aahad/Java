import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
  <applet code="JButtonDemo" width=250 height=300>
  </applet>
*/
  
public class JButtonDemo extends JApplet 
implements ActionListener {
  JTextField jtf;

  public void init() {

    // Get content pane
    Container contentPane = getContentPane();
    contentPane.setLayout(new FlowLayout());

    // Add buttons to content pane
    ImageIcon cake = new ImageIcon("cake.gif");
    JButton jb = new JButton(cake);
    jb.setActionCommand("cake");
    jb.addActionListener(this);
    contentPane.add(jb);

    ImageIcon burger = new ImageIcon("burger.gif");
    jb = new JButton(burger);
    jb.setActionCommand("burger");
    jb.addActionListener(this);
    contentPane.add(jb);

     // Add text field to content pane
    jtf = new JTextField(15);
    contentPane.add(jtf);
  }

  public void actionPerformed(ActionEvent ae) {
    jtf.setText(ae.getActionCommand());
  }
}
