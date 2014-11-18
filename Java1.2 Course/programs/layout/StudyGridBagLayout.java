// Shows how to use the GridBagLayout layout manager
import java.awt.*;
import java.awt.event.*;

public class StudyGridBagLayout extends Frame implements ActionListener, WindowListener
{
    GridBagLayout      theBag = new GridBagLayout();
    GridBagConstraints theGBC = new GridBagConstraints();  
  
    public static void main(String args[])
    {
        StudyGridBagLayout theApp = new StudyGridBagLayout( );
    }
      
    public StudyGridBagLayout( )
    {
        setTitle( "A Simple GridBagLayout" );
        setFont( new Font( "Courier", Font.BOLD, 36 ) );

        setLayout( theBag );

        theGBC.fill   = GridBagConstraints.BOTH;  // Fill both directions
        theGBC.insets = new Insets( 5, 5, 5, 5 ); // 5 pixels around each
        theGBC.weightx = 1.0;                     // Allow X expansion
        theGBC.weighty = 1.0;                     // Allow Y expansion
        
        addComponent( 0, 0, 1, 1, new Button( "7" ) );
        addComponent( 0, 1, 1, 1, new Button( "8" ) );
        addComponent( 0, 2, 1, 1, new Button( "9" ) );
        addComponent( 0, 3, 1, 1, new Button( "-" ) );
        addComponent( 0, 4, 1, 1, new Button( "%" ) );

        addComponent( 1, 0, 1, 1, new Button( "4" ) );
        addComponent( 1, 1, 1, 1, new Button( "5" ) );
        addComponent( 1, 2, 1, 1, new Button( "6" ) );
        addComponent( 1, 3, 3, 1, new Button( "+" ) );
        addComponent( 1, 4, 1, 1, new Button( "/" ) );

        addComponent( 2, 0, 1, 1, new Button( "1" ) );
        addComponent( 2, 1, 1, 1, new Button( "2" ) );
        addComponent( 2, 2, 1, 1, new Button( "3" ) );
        addComponent( 2, 4, 2, 1, new Button( "X" ) );

        addComponent( 3, 0, 1, 2, new Button( "0" ) );
        addComponent( 3, 2, 1, 1, new Button( "." ) );
        
        addWindowListener(this);

        setSize( 400, 300 );
        setVisible(true);
    }

    public void addComponent( int row, int col, int high, int wide,
                              Component theComponent )
    {
        theGBC.gridx      = col;
        theGBC.gridy      = row;
        theGBC.gridwidth  = wide;
        theGBC.gridheight = high;
        theBag.setConstraints( theComponent, theGBC );
        add( theComponent );
        if (theComponent instanceof Button)
            ((Button) theComponent).addActionListener(this);
    }
     
    public void actionPerformed(ActionEvent theEvent)
    {
        if (theEvent.getSource( ) instanceof Button)
        {
            String s = ((Button) theEvent.getSource( )).getLabel( );
            System.out.println( s );
        }
    }
    
    public void windowClosed     (WindowEvent theEvent) {  }
    public void windowClosing    (WindowEvent theEvent) { quitApplication( ); }
    public void windowDeiconified(WindowEvent theEvent) { }
    public void windowIconified  (WindowEvent theEvent) { }
    public void windowOpened     (WindowEvent theEvent) { }
    public void windowActivated  (WindowEvent theEvent) { }
    public void windowDeactivated(WindowEvent theEvent) { }

    public void quitApplication( )
    {
        setVisible(false);
        dispose();
        System.exit(0);
    }
}
