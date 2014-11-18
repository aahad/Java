// How to create a GridLayout
import java.awt.*;
import java.awt.event.*;

public class StudyGrid extends Frame implements ActionListener, WindowListener
{
    Button aButton[] = new Button[9];
    Button plusBtn   = new Button( " + " );
    Button minusBtn  = new Button( " - " );
    Button quitBtn   = new Button( "Quit" );    
    int hGap = 0, vGap = 0;
    
    public static void main( String args[] )
    {
        StudyGrid theApp = new StudyGrid();
    }
      
    public StudyGrid()
    {
        setTitle( "The StudyGrid Application" );
        setFont( new Font( "Helvetica", Font.BOLD, 28 ) );
        setLayout( new GridLayout( 4, 3 ) );

        for (int i = 0; i < aButton.length; i++)
        {
            aButton[i] = new Button("Button " + i);
            add(aButton[i]);
        }

        add( plusBtn  );
        add( minusBtn );
        add( quitBtn  );
        
        plusBtn.addActionListener(this);
        minusBtn.addActionListener(this);
        quitBtn.addActionListener(this);
        addWindowListener(this);
        
        pack( );
        setVisible(true);
    }
    
    public void actionPerformed( ActionEvent theEvent )
    {
        if ( theEvent.getSource( ) == plusBtn ) 
        { 
            hGap += 2;
            vGap += 2; 
            reShow();
            return;
        }
        
        if ( theEvent.getSource( ) == minusBtn )
        { 
            hGap -= ( hGap > 0 ? 2 : 0 );
            vGap -= ( vGap > 0 ? 2 : 0 ); 
            reShow();
            return;
        }

        if ( theEvent.getSource( ) == quitBtn ) quitApplication();
    }

    public void windowClosed     (WindowEvent theEvent) {  }
    public void windowClosing    (WindowEvent theEvent) { quitApplication( ); }
    public void windowDeiconified(WindowEvent theEvent) { }
    public void windowIconified  (WindowEvent theEvent) { }
    public void windowOpened     (WindowEvent theEvent) { }
    public void windowActivated  (WindowEvent theEvent) { }
    public void windowDeactivated(WindowEvent theEvent) { }

    public void quitApplication()
    {
        setVisible(false);
        dispose();
        System.exit(0);
    }

    public void reShow()
    {
        setLayout( new GridLayout( 4, 3, hGap, vGap ) );
        pack();
    }
}
