// A Server that can handles multiple connections
import java.net.*;
import java.io.*;

public class JTTServer
{
    final static int thePort = 1234;
    ServerSocket theServerSocket;
    
    public static void main(String args[])
    {
        JTTServer theApp = new JTTServer();
        theApp.run();
    }
    
    public JTTServer()
    {
        try
        {
            theServerSocket  = new ServerSocket(thePort);        
        }
        catch (IOException io)
        {
            System.err.println("Socket error:  terminating");
            System.exit(1);
        }
    }
    
    public void run()
    {
        try
        {
            System.out.println("JT&T is open for business.");

            while (true)
            {
                Socket theSocket = theServerSocket.accept();
                System.out.println("A customer has requested a table.");
                Connection connection = new Connection(theSocket);
            }
        }
        catch (IOException io)
        {
            System.err.println("Socket error:  terminating");
            System.exit(1);
        }
        
    }
}

class Connection extends Thread
{
    Socket theSocket;
    BufferedReader in;
    PrintWriter out;
    
    public Connection(Socket socket)
    {
        try
        {
            theSocket = socket;
            in = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(theSocket.getOutputStream()), true);
            start();
        }
        catch (IOException io)
        {
            System.err.println("Socket error:  terminating");
            System.exit(1);
        }
    }
    
    public void run()
    {
        int table = 0;
        try
        {
            table = theSocket.getPort();
            System.out.println("Customer seated at table " + table + ".");
            out.println("Hello, table " + table + ", what can I get you?");
            while (true)
            {
                String line = in.readLine();
                if (line == null)
                    break;
                System.out.println("Table " + table + " wants " + line + ".");
                out.println("I'm sorry, we're out of " + line + " right now.");
                out.println("Is there something else you'd like instead?");
            }
            in.close();
            out.close();
            theSocket.close();
        }
        catch (IOException io)
        {
            System.err.println("Table " + table + " has abruptly left.");
        }
    }
}
