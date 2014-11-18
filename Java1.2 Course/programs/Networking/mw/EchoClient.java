// A client applet (works with EchoServer.java)
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;
import java.io.*;

public class EchoClient extends Applet implements ActionListener
{
    final static int thePort = 1234;

    Socket          theSocket;
    BufferedReader  in;
    PrintWriter     out;
    TextField       theField = new TextField();
    TextArea        theArea  = new TextArea();
    
    public void init()
    {
        try
        {
            setLayout(new BorderLayout());

            add( theField, "North" );
            add( theArea, "Center" );
            theArea.setEditable(false);

            setVisible(true);   
                         
            String host = getCodeBase().getHost();
            theSocket   = new Socket( host, thePort );    

            in  = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(theSocket.getOutputStream()), true);
            
            theField.addActionListener(this);
        }
        catch (IOException io)
        {
            System.err.println("IOException:\n" + io);
        }
    }
    
    public void start()
    {
        try
        {
            while (true)
            {
                String s = in.readLine();
                if ( s != null ) theArea.append( s + '\n' );
            }
        }
        catch (IOException io)
        {
            System.err.println( "IOException:\n" + io );
        }
    }
    
    public void actionPerformed(ActionEvent theEvent)
    {
        out.println( theField.getText() );
        theField.setText( "" );
    }
}
