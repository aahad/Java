/*
  <applet code="Clock" width=200 height=80>
  <param name=ServerTime value="23:59:55">
  </applet>
*/

import java.applet.*;
import java.awt.*;
import java.util.*;

public class Clock extends Applet implements Runnable {

  Thread t = new Thread(this);

  String ServerTime, CurrentTime;
  String Hour, AmPm, Min, Sec;
  int hour, min, sec;

  public void init() {
	setBackground(new Color(187, 187, 187));

	ServerTime = getParameter("ServerTime");

	StringTokenizer st = new StringTokenizer(ServerTime, ":");
	hour = (Integer.decode(st.nextToken())).intValue();
	min = (Integer.decode(st.nextToken())).intValue();
	sec = (Integer.decode(st.nextToken())).intValue();

	t.start();
  }

  public void run() {

	while(true) {

	  sec++;

	  if (sec==60) {
		sec = 0;
		min++;

		if (min==60) {
		  min = 0;
		  hour++;

		  if (hour==24) 
		    hour = 0;
		}
	  }


	  if (hour>11) {
	  	AmPm = " PM";
		if (hour==12)
	  	  Hour = Integer.toString(hour);
		else
	  	  Hour = Integer.toString(hour-12);
	  }
	  	else if (hour==0) {
	  	Hour = "12";
	  	AmPm = " AM";
	  }
	  else {
	  	Hour = Integer.toString(hour);
	  	AmPm = " AM";
	  }


	  if (min<10)
		Min = "0" + Integer.toString(min);
	  else
		Min = Integer.toString(min);

	  if (sec<10)
		Sec = "0" + Integer.toString(sec);
	  else
		Sec = Integer.toString(sec);

	  repaint();
	
	  try {
	  	t.sleep(1000);
	  }
    	  catch (InterruptedException e) { 
      		showStatus("Applet thread interrupted");
    	  }

	}

  }


  public void paint(Graphics g) {

	CurrentTime = Hour + ":" + Min + ":" + Sec + AmPm;
	g.drawString(CurrentTime, 0, 10);

  }


}