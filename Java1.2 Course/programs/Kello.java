// Simple digital clock by Java.
// The Applet shows time and date according your systems clock. 
// Time is updated every second and date is shown every fifth second.

/*
<applet code="Kello" width=200 height=100></applet>
*/

// Libraries needed for this applet.
import java.awt.*;
import java.applet.*;
import java.util.*;
import java.text.*;


public class Kello extends Applet implements Runnable
{
	   // Global Variables
       Thread th;
       FontMetrics ft;
       int leveys, korkeus, laskuri;

       public void init()
       {
              // Set Font.
              Font font = new Font("Times New Roman", Font.BOLD, 12);
              setFont(font);
              ft = getFontMetrics(font);
              leveys = getBounds().width;
              korkeus = getBounds().height;
       }

       public void start()
       {
              if (th == null)
              {
                 th = new Thread(this);
                 th.start();
              }
       }

       public void run()
       {
              while (true)
              {
                    repaint();
                    laskuri++;
                    try
                    {
                       th.sleep(1000);
                    }
                    catch (InterruptedException e) {}
              }
       }

       public void paint(Graphics g)
       {
              // Make time.
              Calendar cal = Calendar.getInstance();

              // Every 5th sec the date is shown.
              int fleveys;
              String aika = "";

              if ((laskuri%6) == 5)
              {
                 // Show the date.
                 aika = DateFormat.getDateInstance().format(new Date());
                 fleveys = ft.stringWidth(aika);
              }

              else
              {
                  // Show the time.
                  aika = DateFormat.getTimeInstance().format(new Date());
                  fleveys = ft.stringWidth(aika);
              }

              // Center and print time or date.
              int x = (leveys - fleveys)/2;
              int y = (korkeus/2);
              g.drawString(aika, x, y);
       }

       public void stop()
       {
              th.stop();
              th = null;
       }
}
