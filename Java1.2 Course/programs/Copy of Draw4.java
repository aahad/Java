import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;

/* 
<applet code="Draw4" width=600 height=300>
</applet>
*/

public class Draw4 extends Applet implements ActionListener, MouseListener {

  Vector clicks = new Vector();
  String mode = new String("CreatePolygon");
  Vector polygons = new Vector();
  Vector circles = new Vector();
  Integer endPoly = new Integer(-2000);
  Integer currentX, currentY, previousX, previousY;
  Button clear, CreatePolygon, CreateCircle;
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


  public void DrawClicks(Graphics g) {
	  for (int count=0; count < clicks.size() - 1; count+=2) {
	  	currentX = Integer.decode(clicks.elementAt(count).toString());
	  	currentY = Integer.decode(clicks.elementAt(count+1).toString());
	  	g.drawOval(currentX.intValue()-2, currentY.intValue()-2, 4, 4);
		if (count > 1) {
	  	  previousX = Integer.decode(clicks.elementAt(count-2).toString());
	  	  previousY = Integer.decode(clicks.elementAt(count-1).toString());
		  g.drawLine(previousX.intValue(), previousY.intValue(), currentX.intValue(), currentY.intValue());
		}
	  }
  }

  public void DrawPolygon(Graphics g) {
	  int NoPoints = polygons.indexOf(endPoly) / 2;
  	  int[] X1 = new int[NoPoints];
  	  int[] Y1 = new int[NoPoints];
  	  for (int count=0; count < NoPoints ; count++) {
		X1[count] = Integer.decode(polygons.elementAt(count*2).toString()).intValue();
		Y1[count] = Integer.decode(polygons.elementAt(count*2+1).toString()).intValue();
  	  }
  	  g.drawPolygon(X1, Y1, NoPoints);

	  int NewPolygonIndex = polygons.indexOf(endPoly);
	  NoPoints = (polygons.indexOf(endPoly, NewPolygonIndex+1)-NewPolygonIndex-1) / 2;

	  while (NoPoints>0) {
	  	int[] X2 = new int[NoPoints];
	  	int[] Y2 = new int[NoPoints];
	  	for (int count=0; count < NoPoints ; count++) {
			X2[count] = Integer.decode(polygons.elementAt(count*2+NewPolygonIndex+1).toString()).intValue();
			Y2[count] = Integer.decode(polygons.elementAt(count*2+NewPolygonIndex+2).toString()).intValue();
	  	}
	  	g.drawPolygon(X2, Y2, NoPoints);
	  	NewPolygonIndex = polygons.indexOf(endPoly, NewPolygonIndex+1);
		NoPoints = (polygons.indexOf(endPoly, NewPolygonIndex+1)-NewPolygonIndex-1) / 2;
	  }
  }

  public void DrawCircle(Graphics g) {
	int NumOfCircles = (circles.lastIndexOf(endPoly) + 1) / 5;

	for (int count=0; count<NumOfCircles; count++) {
	  int x1 = Integer.decode(circles.elementAt(count*5).toString()).intValue();
	  int y1 = Integer.decode(circles.elementAt(count*5+1).toString()).intValue();
	  int x2 = Integer.decode(circles.elementAt(count*5+2).toString()).intValue();
	  int y2 = Integer.decode(circles.elementAt(count*5+3).toString()).intValue();

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


  // MouseListener Event Handling STARTS *********************************

  public void mouseClicked(MouseEvent e) {

	int firstPointX=-2, firstPointY=-2;

	if (! clicks.isEmpty() && firstPointX==-2 && firstPointY==-2){
	  firstPointX = Integer.decode(clicks.elementAt(0).toString()).intValue();
	  firstPointY = Integer.decode(clicks.elementAt(1).toString()).intValue();
	}


	if (mode.equals("CreatePolygon") && !clicks.isEmpty() && e.getX() > firstPointX-2 && e.getX() < firstPointX+2 && e.getY() > firstPointY-2 && e.getY() < firstPointY+2) {
	  polygons.addAll(clicks);
	  polygons.add(Integer.decode("-2000"));
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
		circles.add(Integer.decode("-2000"));
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

  // MouseListener Event Handling ENDS *********************************

}