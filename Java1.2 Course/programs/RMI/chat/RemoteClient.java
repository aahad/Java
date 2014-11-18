import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteClient extends Remote {
    public abstract String getClientName() throws RemoteException;
    
    public abstract void receiveMessage(String msg) throws RemoteException;
}
