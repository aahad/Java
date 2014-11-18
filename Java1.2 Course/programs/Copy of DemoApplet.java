/*
<applet code="DemoApplet" width=250 height=300>
</applet>
*/

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

interface IGeometryConstants {
  int SQUARE = 0;
  int CIRCLE = 1;
  int ELLIPSE = 2;
  String[] shapeNames = {"Square", "Circle", "Ellipse"};

  int SMALL = 0;
  int MEDIUM = 1;
  int LARGE = 2;
  String[] sizeNames = {"Small", "Medium", "Large"};
}


public class DemoApplet extends Applet implements IGeometryConstants {

  // creating global references for panels and their components

  Panel shapePanel;
  CheckboxGroup shapeCBG;
  Checkbox squareCB, circleCB, ellipseCB;

  Panel xyPanel;
  Label xCoordLabel, yCoordLabel;
  TextField xCoord, yCoord;

  Panel sizePanel;
  Label sizeLabel;
  Choice size;
  Checkbox fill;

  Panel leftPanel;

  Panel rightPanel;
  Button DrawButton;
  TextField MessageDisplay;


  public void init() {

	// Calling methods to define panels and add them to left and right parent panels
	makeShapePanel();
	makeXYPanel();
	makeSizePanel();
	makeLeftPanel();
	makeRightPanel();

	addListeners(); // method to add listeners

	add(leftPanel);
	add(rightPanel);
  }



// Make all panels and add smaller panels into left and right panels ****************

  void makeShapePanel() {
	shapePanel = new Panel();
	shapeCBG = new CheckboxGroup();

	squareCB = new Checkbox(shapeNames[SQUARE], shapeCBG, true);
	circleCB = new Checkbox(shapeNames[CIRCLE], shapeCBG, false);
	ellipseCB = new Checkbox(shapeNames[ELLIPSE], shapeCBG, false);

	shapePanel.setLayout(new FlowLayout());
	shapePanel.add(squareCB);
	shapePanel.add(circleCB);
	shapePanel.add(ellipseCB);
  }

  void makeXYPanel() {
	xyPanel = new Panel();
	xyPanel.setLayout(new GridLayout(2,2));

	xCoordLabel = new Label("X Coordinate: ");
	xCoord = new TextField();
	yCoordLabel = new Label("Y Coordinate: ");
	yCoord = new TextField();

	xyPanel.add(xCoordLabel);
	xyPanel.add(xCoord);
	xyPanel.add(yCoordLabel);
	xyPanel.add(yCoord);
  }

  void makeSizePanel() {
	sizePanel = new Panel();
	sizePanel.setLayout(new FlowLayout());
	
	sizeLabel = new Label("Size: ");
	sizePanel.add(sizeLabel);

	size = new Choice();
	size.add(sizeNames[SMALL]);
	size.add(sizeNames[MEDIUM]);
	size.add(sizeNames[LARGE]);
	sizePanel.add(size);

	fill = new Checkbox("Fill", true);
	sizePanel.add(fill);
  }

  void makeLeftPanel() {
	leftPanel = new Panel();
	leftPanel.setLayout(new BorderLayout());
	leftPanel.add(shapePanel, BorderLayout.NORTH);
	leftPanel.add(xyPanel, BorderLayout.CENTER);
	leftPanel.add(sizePanel, BorderLayout.SOUTH);
  }

  void makeRightPanel() {
	rightPanel = new Panel();

  }



  void addListeners() {

	add(leftPanel);

	/* class DrawRegion extends Canvas implements IGeometryConstants {

	  public DrawRegion() {
		setSize(150, 150);
		setBackground(Color.white);	
	  }
	} */
  }

  public void paint(Graphics g) {
	g.drawString("Ok it seems to be working till here.", 10, 100);
  }

}