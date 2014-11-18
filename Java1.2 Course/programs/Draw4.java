import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;

/* 
<applet code="Draw4" width=600 height=300>
</applet>
*/

public class Draw4 extends Applet implements ActionListener, MouseListener {

  Vector clicks = new Vector();   // acts as a temporary space to save data
  Vector polygons = new Vector(); // saves coordinates for polygons created
  Vector circles = new Vector();  // saves coordinates and radii for circles created

  String mode = new String("CreatePolygon");  // mode tells that program what it is currently creating

  Integer NewIndex = new Integer(-2000);  // used as a separator between data for 2 different objects within polygons and circles
  int currentX, currentY, previousX, previousY; // these are defined globally because they are used very heavily by clicks
  Button clear, CreatePolygon, CreateCircle;

  // Message displayed in status bar
  String directions = "Create Polygon: Draw a set of lines by clicking on the screen and end back at the first point you created.";

  public void init() {
	setLayout(new FlowLayout(FlowLayout.LEFT));
	setBackground(Color.white);
	setForeground(Color.black);

	clear = new Button("Clear Workspace");
	CreatePolygon = new Button("Create Polygon");
	CreateCircle = new Button("Create Circle");

	add(clear);
	add(CreatePolygon);
	add(CreateCircle);

	clear.addActionListener(this);
	CreatePolygon.addActionListener(this);
	CreateCircle.addActionListener(this);
	addMouseListener(this);
  }

  public void paint(Graphics g) {
	if (! clicks.isEmpty()) {
	  // g.drawString(clicks.toString(), 10, 65);
	  DrawClicks(g);
	}

	if (! polygons.isEmpty()) {
	  // g.drawString(polygons.toString(), 10, 50);
	  DrawPolygon(g);
	}

	if (! circles.isEmpty()) {
	  // g.drawString(circles.toString(), 10, 50);
	  DrawCircle(g);
	}

	showStatus(directions);
  }




// Setting up data in Vectors so that it can be used to paint **********************************

  public void DrawClicks(Graphics g) {
	  for (int count=0; count < clicks.size() - 1; count+=2) {
	  	currentX = ((Integer)clicks.elementAt(count)).intValue();
	  	currentY = ((Integer)clicks.elementAt(count+1)).intValue();
	  	g.drawOval(currentX-2, currentY-2, 4, 4);
		if (count > 1) {
	  	  previousX = ((Integer)clicks.elementAt(count-2)).intValue();
	  	  previousY = ((Integer)clicks.elementAt(count-1)).intValue();
		  g.drawLine(previousX, previousY, currentX, currentY);
		}
	  }
  }

  public void DrawPolygon(Graphics g) {
	  int NoPoints = polygons.indexOf(NewIndex) / 2;
  	  int[] X1 = new int[NoPoints];
  	  int[] Y1 = new int[NoPoints];
  	  for (int count=0; count < NoPoints ; count++) {
		X1[count] = ((Integer)polygons.elementAt(count*2)).intValue();
		Y1[count] = ((Integer)polygons.elementAt(count*2+1)).intValue();
  	  }
  	  g.drawPolygon(X1, Y1, NoPoints);

	  int NewPolygonIndex = polygons.indexOf(NewIndex);
	  NoPoints = (polygons.indexOf(NewIndex, NewPolygonIndex+1)-NewPolygonIndex-1) / 2;

	  while (NoPoints>0) {
	  	int[] X2 = new int[NoPoints];
	  	int[] Y2 = new int[NoPoints];
	  	for (int count=0; count < NoPoints ; count++) {
			X2[count] = ((Integer)polygons.elementAt(count*2+NewPolygonIndex+1)).intValue();
			Y2[count] = ((Integer)polygons.elementAt(count*2+NewPolygonIndex+2)).intValue();
	  	}
	  	g.drawPolygon(X2, Y2, NoPoints);
	  	NewPolygonIndex = polygons.indexOf(NewIndex, NewPolygonIndex+1);
		NoPoints = (polygons.indexOf(NewIndex, NewPolygonIndex+1)-NewPolygonIndex-1) / 2;
	  }
  }

  public void DrawCircle(Graphics g) {
	int NumOfCircles = (circles.lastIndexOf(NewIndex) + 1) / 5;

	for (int count=0; count<NumOfCircles; count++) {
	  int x1 = ((Integer)circles.elementAt(count*5)).intValue();
	  int y1 = ((Integer)circles.elementAt(count*5+1)).intValue();
	  int x2 = ((Integer)circles.elementAt(count*5+2)).intValue();
	  int y2 = ((Integer)circles.elementAt(count*5+3)).intValue();

	  int radius = (int) (Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2)));
	  int centerX = x1 - radius;
	  int centerY = y1 - radius;

	  g.drawOval(centerX, centerY, radius*2, radius*2);

	}
  }



// ActionListener Event Handling *********************************
  public void actionPerformed(ActionEvent e) {

	if (e.getActionCommand().equals("Clear Workspace")) {
	  polygons.removeAllElements();
	  circles.removeAllElements();
	}

	if (e.getActionCommand().equals("Create Polygon")) {
	  mode = "CreatePolygon";
	  directions = "Create Polygon: Draw a set of lines by clicking on the screen and end back at the first point you created.";
	}

	if (e.getActionCommand().equals("Create Circle")) {
	  mode = "CreateCircle";
	  directions = "Create Circle: Click 2 points on the screen. 1st point is for center and 2nd point defines radius of circle.";
	}

	clicks.removeAllElements();
	repaint();
  }




// MouseListener Event Handling *********************************

  public void mouseClicked(MouseEvent e) {

	int firstPointX=0, firstPointY=0;

	if (! clicks.isEmpty()){
	  firstPointX = ((Integer)clicks.elementAt(0)).intValue();
	  firstPointY = ((Integer)clicks.elementAt(1)).intValue();
	}


	if (mode.equals("CreatePolygon") && !clicks.isEmpty() && e.getX() > firstPointX-2 && e.getX() < firstPointX+2 && e.getY() > firstPointY-2 && e.getY() < firstPointY+2) {
	  polygons.addAll(clicks);
	  polygons.add(NewIndex);
	  clicks.removeAllElements();
	}
	else if (mode.equals("CreatePolygon")) {
	  Integer IntX = new Integer(e.getX());
	  Integer IntY = new Integer(e.getY());
	  clicks.add(IntX);
	  clicks.add(IntY);
	}
	else if (mode.equals("CreateCircle")) {
	  Integer IntX = new Integer(e.getX());
	  Integer IntY = new Integer(e.getY());
	  clicks.add(IntX);
	  clicks.add(IntY);

	  if (clicks.size() == 4) {
		circles.addAll(clicks);
		circles.add(NewIndex);
		clicks.removeAllElements();
	  }
	}

	repaint();
  }

  public void mouseEntered(MouseEvent e) {
	repaint();
  }

  public void mouseExited(MouseEvent e) {}

  public void mousePressed(MouseEvent e) {}

  public void mouseReleased(MouseEvent e) {}


}