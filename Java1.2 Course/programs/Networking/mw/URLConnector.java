// Using the URL class to connect to a site and read a document
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;

public class URLConnector extends Frame implements ActionListener, WindowListener
{
    TextField theLocation = new TextField("", 40);
    TextArea  theDoc      = new TextArea();    
    Button    fetchButton = new Button("Fetch");
    Button    quitButton  = new Button("Quit");
    
    public static void main(String args[])
    {
        URLConnector theApp = new URLConnector();
    }
    
    public URLConnector()
    {
        setTitle( "The URLConnector Example" );
        theLocation.setFont(new Font("Courier", Font.BOLD, 12));

        Panel p1 = new Panel();
        p1.add( new Label( "Enter a URL: " )); 
        p1.add( theLocation );
        add( p1, "North" );                   

        add( theDoc, "Center" );

        Panel p2 = new Panel();
        p2.add( fetchButton );
        p2.add( quitButton );
        add( p2, "South" );
        
        theLocation.addActionListener(this);
        fetchButton.addActionListener(this);
        quitButton.addActionListener(this);
        addWindowListener(this);
        
        setSize( 400, 300 );
        setVisible(true);
        theLocation.requestFocus();
    }
    
    public void actionPerformed(ActionEvent theEvent)
    {
        if (theEvent.getSource( ) == fetchButton || theEvent.getSource( ) == theLocation)
        {
            try
            {
                // Open the URL
                URL theURL = new URL( theLocation.getText() );
                theDoc.setText( "\nFetching: " + theURL + '\n' );
 
                // Open a URLConnection
                URLConnection con = theURL.openConnection();

                // Retrieve info about the document
                String  encoding = con.getContentEncoding();
                int     length   = con.getContentLength();
                String  type     = con.getContentType();
                long    expires  = con.getExpiration();
                Date    modified = new Date( con.getLastModified() );
                
                // Display document info
                theDoc.append("Content encoding: " + encoding + '\n');
                theDoc.append("Content length  : " + length   + '\n');
                theDoc.append("Content type    : " + type     + '\n');
                theDoc.append("Expires         : " + expires  + '\n');
                theDoc.append("Last modified   : " + modified + '\n');
   
                // Display the document if possible
                Object urlContent = theURL.getContent();

                String objectType = urlContent.getClass().getName();
                theDoc.append( "\nFetched a " + objectType + "\n\n" );

                if ( urlContent instanceof String )            // Plain text
                {
                    theDoc.append( (String) urlContent );
                }
                else if ( urlContent instanceof InputStream )  // Text/html file
                {
                    String s = "";
                    int b = 0;
                    while ( (b =((InputStream) urlContent).read()) != -1 )
                        s += (char) b;
                    
                    theDoc.append(s);                        
                }
                else
                {
                    theDoc.append("Sorry, cannot show that type of object");
                }
            }

            // Handle badly formed URLs
            catch (MalformedURLException badURL)
            {
                theDoc.append( "\nSorry, cannot interpret your URL\n" );
                theDoc.append( badURL.toString() );
            }
            // Handle I/O errors, etc
            catch (IOException io)
            {
                theDoc.append( "Sorry, URL contents are not available\n");            
                theDoc.append( io.toString() );                
            }
            catch (NullPointerException n)
            {
                theDoc.append( "Sorry, URL contents are not available\n");            
            }
        }
        else if (theEvent.getSource( ) == quitButton) quitApplication( );
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
