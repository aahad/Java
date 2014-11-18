

/*
<applet code="DemoApplet" width=420 height=220>
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


public class DemoApplet extends Applet implements IGeometryConstants, ActionListener, ItemListener {

  int DrawButtonStatus=0; // to check whether the Draw button is pressed or not

  // creating global references for panels and their components

  Panel shapePanel;
  CheckboxGroup shapeCBG;
  Checkbox squareCB, circleCB, ellipseCB;

  Panel xyPanel;
  Label xCoordLabel, yCoordLabel;
  TextField xCoord, yCoord;

  Panel sizePanel;
  Label sizeLabel;
  Choice sizeChoice;
  Checkbox fill;

  Panel leftPanel;

  Panel rightPanel;
  Button DrawButton;
  TextField MessageDisplay;

  DrawRegion DrawRegionObject;


  public void init() {
	setBackground(Color.white);

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

	sizeChoice = new Choice();
	sizeChoice.add(sizeNames[SMALL]);
	sizeChoice.add(sizeNames[MEDIUM]);
	sizeChoice.add(sizeNames[LARGE]);
	sizePanel.add(sizeChoice);

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
	rightPanel.setLayout(new BorderLayout());

	DrawButton = new Button("Draw");
	rightPanel.add(DrawButton, BorderLayout.NORTH);

	DrawRegionObject = new DrawRegion();
	rightPanel.add(DrawRegionObject, BorderLayout.CENTER);

	MessageDisplay = new TextField();
	MessageDisplay.setEnabled(false);
	rightPanel.add(MessageDisplay, BorderLayout.SOUTH);
  }



  void addListeners() {
	DrawButton.addActionListener(this);
	xCoord.addActionListener(this);
	yCoord.addActionListener(this);

	squareCB.addItemListener(this);
	circleCB.addItemListener(this);
	ellipseCB.addItemListener(this);

	sizeChoice.addItemListener(this);

	MessageDisplay.setText("Drawing" + shapeCBG.getSelectedCheckbox().getLabel());
  }


  public void actionPerformed(ActionEvent e) {
	showStatus(" ");
	int temp=0;

	if (e.getActionCommand().equals("Draw")) {
	  DrawButtonStatus = 1;
	  DrawRegionObject.repaint();
	}

	try {
	  temp = (Integer.decode(xCoord.getText())).intValue();
	  if (temp>109) {
		xCoord.setText("109");
		showStatus("X value should be less than 110 to be displayed.");
	  }
	  else if (temp<0) {
		xCoord.setText("0");
		showStatus("X value should not be a negative number.");
	  }

	}
	catch (NumberFormatException exc) {
	  xCoord.setText("0");
	  showStatus("Enter only integer values for X and Y.");
	}

	try {
	  temp = (Integer.decode(yCoord.getText())).intValue();
	  if (temp>109) {
		yCoord.setText("109");
		showStatus("Y value should be less than 110 to be displayed.");
	  }
	  else if (temp<0) {
		yCoord.setText("0");
		showStatus("Y value should not be a negative number.");
	  }
	}
	catch (NumberFormatException exc) {
	  yCoord.setText("0");
	  showStatus("Enter only integer values for X and Y.");
	}

  }

  public void itemStateChanged(ItemEvent e) {
	MessageDisplay.setText("Drawing" + shapeCBG.getSelectedCheckbox().getLabel());
  }


  class DrawRegion extends Canvas implements IGeometryConstants {

  	public DrawRegion() {
	  setSize(150, 150);
	  setBackground(Color.white);	
  	}

  	public void paint(Graphics g) {

	  int xcoord=0;
	  int ycoord=0;

	  if (!xCoord.getText().equals("") && !yCoord.getText().equals("")) {
	    xcoord = (Integer.decode(xCoord.getText())).intValue();
	    ycoord = (Integer.decode(yCoord.getText())).intValue();
	  }

	  if (DrawButtonStatus==1) {
		String shape = shapeCBG.getSelectedCheckbox().getLabel();
		int size = 0;

		switch (sizeChoice.getSelectedIndex()) {
                    case SMALL:  size = 20;  break;
                    case MEDIUM: size = 30;  break;
                    case LARGE:  size = 40; break;
                }


		if (shape.equals(shapeNames[SQUARE])) {
		  if (fill.getState())
			g.fillRect(xcoord, ycoord, size, size);
		  else
			g.drawRect(xcoord, ycoord, size, size);
		}
		else if (shape.equals(shapeNames[CIRCLE])) {
		  if (fill.getState())
			g.fillOval(xcoord, ycoord, size, size);
		  else
			g.drawOval( xcoord, ycoord, size, size);
		}
		else if (shape.equals(shapeNames[ELLIPSE])) {
		  if (fill.getState())
			g.fillOval(xcoord, ycoord, size, size/2);
		  else
			g.drawOval( xcoord, ycoord, size, size/2);
		}

	  }


  	}
  }

}