
/* DemoApplet: Demonstrating GUI + EVENT HANDLING

  <applet code="DemoApplet" width=250 height=300>
  </applet>
*/



import java.awt.*;
import java.awt.event.*;
import java.applet.*;

interface IGeometryConstants {
    int SQUARE  = 0;
    int CIRCLE  = 1;
    int ELLIPSE = 2;
    String[] shapeNames = {"Square", "Circle", "Ellipse"};

    int SMALL  = 0;
    int MEDIUM = 1;
    int LARGE  = 2;
    String[] sizeNames = {"Small", "Medium", "Large"};
}

public class DemoApplet extends Applet implements IGeometryConstants {

    // Panel for shape
    Panel         shapePanel;
    CheckboxGroup shapeCBG;
    Checkbox      squareCB;
    Checkbox      circleCB;
    Checkbox      ellipseCB;

    // Panel for x,y coordinates
    Panel     xyPanel;
    Label     xLabel;
    TextField xInput;
    Label     yLabel;
    TextField yInput;

    // Panel for size and fill
    Panel    sizePanel;
    Label    sizeLabel;
    Choice   sizeChoices;
    Checkbox fillCB;

    // Panel for shape, coordinates, size and fill
    Panel leftPanel;

    // Panel for Message display, draw button and canvas
    Panel      rightPanel;
    Button     drawButton;
    DrawRegion drawRegion;
    TextField  messageDisplay;

    public void init() {

        makeShapePanel();
        makeXYPanel();
        makeSizePanel();
        makeLeftPanel();
        makeRightPanel();

        addListeners();

        add(leftPanel);
        add(rightPanel);

    }

    // Panel for shape
    void makeShapePanel() {
        shapePanel = new Panel();

        shapeCBG   = new CheckboxGroup();

        squareCB   = new Checkbox(shapeNames[SQUARE],  shapeCBG, true);
        circleCB   = new Checkbox(shapeNames[CIRCLE],  shapeCBG, false);
        ellipseCB  = new Checkbox(shapeNames[ELLIPSE], shapeCBG, false);

        shapePanel.setLayout(new FlowLayout());
        shapePanel.add(squareCB);
        shapePanel.add(circleCB);
        shapePanel.add(ellipseCB);
    }

    // Panel for x,y coordinates
    void makeXYPanel() {
        xyPanel = new Panel();

        xLabel  = new Label("X Coordinate:");
        yLabel  = new Label("Y Coordinate:");

        xInput  = new TextField(5);
        yInput  = new TextField(5);

        xyPanel.setLayout(new GridLayout(2,2));
        xyPanel.add(xLabel);
        xyPanel.add(xInput);
        xyPanel.add(yLabel);
        xyPanel.add(yInput);
    }

    // Panel for size and fill
    void makeSizePanel() {

        sizePanel   = new Panel();

        sizeLabel   = new Label("Size:");

        sizeChoices = new Choice();
        sizeChoices.add(sizeNames[SMALL]);
        sizeChoices.add(sizeNames[MEDIUM]);
        sizeChoices.add(sizeNames[LARGE]);

        fillCB = new Checkbox("Fill", false);

        sizePanel.setLayout(new FlowLayout());
        sizePanel.add(sizeLabel);
        sizePanel.add(sizeChoices);
        sizePanel.add(fillCB);

    }

    // Panel for shape, coordinates, size and fill
    void makeLeftPanel() {
        leftPanel = new Panel();

        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(shapePanel, "North");
        leftPanel.add(xyPanel,    "Center");
        leftPanel.add(sizePanel,  "South");
    }

    // Panel for Message display, draw button, and canvas
    void makeRightPanel() {
        rightPanel = new Panel();

        messageDisplay = new TextField("MESSAGE DISPLAY");
        messageDisplay.setEditable(false);
        messageDisplay.setBackground(Color.yellow);

        drawButton = new Button("Draw");
        drawButton.setBackground(Color.lightGray);

        drawRegion = new DrawRegion();
        drawRegion.setSize(150,150);
        drawRegion.setBackground(Color.white);

        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(drawButton,     BorderLayout.NORTH);
        rightPanel.add(messageDisplay, BorderLayout.SOUTH);
        rightPanel.add(drawRegion,     BorderLayout.CENTER);
    }

    // Add the listeners.
    void addListeners() {

        drawButton.addActionListener(new ActionListener() {        // (1)
            public void actionPerformed(ActionEvent evt) {         // (2)

                int shape, xCoord, yCoord, width;

                messageDisplay.setText("");

                // Get the shape                                      (3)
                if (squareCB.getState())
                    shape = SQUARE;
                else if (circleCB.getState())
                    shape = CIRCLE;
                else if (ellipseCB.getState())
                    shape = ELLIPSE;
                else {
                    messageDisplay.setText("Unknown shape.");
                    return;
                }

                // Get the coordinates                                (4)
                try {
                    xCoord = Integer.parseInt(xInput.getText());
                    yCoord = Integer.parseInt(yInput.getText());

                } catch (NumberFormatException e) {
                    messageDisplay.setText("Illegal coordinates.");
                    return;
                }

                // Get the size                                       (5)
                switch (sizeChoices.getSelectedIndex()) {
                    case SMALL:  width = 30;  break;
                    case MEDIUM: width = 60;  break;
                    case LARGE:  width = 120; break;
                    default: messageDisplay.setText("Unknown size."); return;
                }

                messageDisplay.setText("Drawing" + shapeNames[shape]);
                drawRegion.doDraw(                                 // (6)
                        shape,
                        xCoord, yCoord,
                        fillCB.getState(),
                        width
                );
            }
        });

        xInput.addTextListener(new TextListener() {                // (7)
            public void textValueChanged(TextEvent evt) {
                checkTF(xInput);
            }
        });

        yInput.addTextListener(new TextListener() {                // (8)
            public void textValueChanged(TextEvent evt) {
                checkTF(yInput);
            }
        });
    }

    // Check for legal integer value in the text field
    void checkTF(TextField tf) {                                   // (9)

        messageDisplay.setText("");
        try {
            Integer.parseInt(tf.getText());                        // (10)

        } catch (NumberFormatException e) {
            messageDisplay.setText("Illegal coordinate.");
        }
    }
}

/** Canvas for doing the drawing */
class DrawRegion extends Canvas implements IGeometryConstants {    // (11)

    // Values needed for drawing the shape
    private int     shape;
    private int     xCoord;
    private int     yCoord;
    private boolean fillFlag;
    private int     width;

    public DrawRegion() {
        setSize(150,150);
        setBackground(Color.white);
    }

    // Set the values and repaint the drawing region.
    public void doDraw(int shape,                                  // (12)
                       int xCoord, int yCoord,
                       boolean fillFlag, int width) {

        this.shape     = shape;
        this.xCoord    = xCoord;
        this.yCoord    = yCoord;
        this.fillFlag  = fillFlag;
        this.width     = width;

        repaint();                                                 // (13)
    }

    // Do the drawing of the shape
    public void paint(Graphics g) {                                // (14)

        switch (shape) {
            case SQUARE:
                if (fillFlag) g.fillRect(xCoord, yCoord, width, width);
                else g.drawRect(xCoord, yCoord, width, width);
                break;
            case CIRCLE:
                if (fillFlag) g.fillOval(xCoord, yCoord, width, width);
                else g.drawOval(xCoord, yCoord, width, width);
                break;
            case ELLIPSE:
                if (fillFlag) g.fillOval(xCoord, yCoord, width, width/2);
                else g.drawOval(xCoord, yCoord, width, width/2);
        }
    }
}
