
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class SwingBoxLayout {
    public static void main(String args[]) {

        // Create the first row using a box.                           
        Container row1 = new Box(BoxLayout.X_AXIS);
        row1.add(createLabel("Row 1"));
        row1.add(createLabel("Glue -->"));
        row1.add(Box.createHorizontalGlue());
        row1.add(createLabel("Horiz. Strut -->"));
        row1.add(Box.createHorizontalStrut(50));
        row1.add(createLabel("End of Row 1"));

        // Create the second row using a box layout manager.           
        Container row2 = new JPanel();
        row2.setLayout(new BoxLayout(row2, BoxLayout.X_AXIS));
        row2.add(createLabel("Row 2"));
        row2.add(createLabel("Rigid Area -->"));
        row2.add(Box.createRigidArea(new Dimension(75, 50)));
        row2.add(createLabel("Glue -->"));
        row2.add(Box.createHorizontalGlue());
        row2.add(createLabel("End of Row 2"));

        // Create the root component and compose its content pane.     
        JFrame window = new JFrame("Swing layout");
        Container content = window.getContentPane();
        LayoutManager lm = new BoxLayout(content, BoxLayout.Y_AXIS);
        content.setLayout(lm);
        content.add(row1);
        content.add(new JSeparator(JSeparator.HORIZONTAL));
        content.add(row2);

        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent wEvt) {
                System.exit(0);
            }
        });

        window.pack();
        window.setVisible(true);
    }

    private static Component createLabel(String text) {
        JComponent label = new JLabel(text, SwingConstants.CENTER);
        label.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        return label;
    }
}
