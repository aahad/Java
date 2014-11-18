import java.applet.Applet;
import java.awt.*;
/* 
<applet code = "SimplePaint" width = 300 height = 250 >
</applet>
*/
public class SimplePaint extends Applet {
  public void paint(Graphics g)  {
    g.setColor(Color.black);
    g.fillRect(0,0,300,300);
  }
}
  
