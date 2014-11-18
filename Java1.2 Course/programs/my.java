import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="my" width=300 height=50>
</applet>
*/

public class my extends Applet{
  // String move="1";
  int x=10;
  int y=20;
  int line=0;
  StringBuffer[] text = new StringBuffer[10];

  public void init(){
	setBackground(Color.gray);
	setForeground(Color.black);
	addMouseListener(new MouseAdapter(){
	  public void mouseClicked(MouseEvent me){
		showStatus("Mouse clicked");
	  }
	}
	);
	requestFocus();
	addKeyListener(new KeyAdapter() {
	  public void keyPressed(KeyEvent ke) {
		if (text[line].length() > 10) {
		  line++;
		}
		else {
		  text[line].append(ke.getKeyChar());
		}
		showStatus("Key pressed. " + ke.getKeyChar());
		repaint();
	  }
	}
	);

  }

  public void paint(Graphics g){
	g.drawString(text[line].toString(),x,y);
  }

}
