import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

public class ObjServer extends UnicastRemoteObject implements RemoteObjServer {
    static public void main(String[] args) {
        try {
            ObjServer server = new ObjServer();
            Naming.rebind("ObjServer", server);
        }
        catch( MalformedURLException e ) {
            e.printStackTrace();
        }
        catch( RemoteException e ) {
            e.printStackTrace();
        }
    }

    private Hashtable flights = new Hashtable();

    public ObjServer() throws RemoteException {
        super();
    }

    public RemoteFlight getFlight(int number) throws RemoteException {
        Integer i = new Integer(number);
        synchronized(flights) {
            if( flights.containsKey(i) ) {
                return (RemoteFlight)flights.get(i);
            }
            else {
                Flight f = new Flight(number);

                flights.put(i, f);
                return (RemoteFlight)f;
            }
        }
    }
}
