import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteChatServer extends Remote {
    public abstract void connect(RemoteClient c) throws RemoteException;
    
    public abstract void sendMessage(RemoteClient client, String msg)
	 throws RemoteException;
}
