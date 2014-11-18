import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Enumeration;
import java.util.Vector;

public class ChatServer extends Thread implements RemoteChatServer {
    static public void main(String[] args) {
        try {
            ChatServer server = new ChatServer();
            Naming.rebind("Server", server);
            server.start();
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }

    private Vector clients  = new Vector();
    private Vector messages = new Vector();

    public ChatServer() throws RemoteException {
        super();
        UnicastRemoteObject.exportObject(this);
    }

    public void connect(RemoteClient client ) {
        synchronized( clients ) {
            if( clients.contains(client) ) {
                return;
            }
            clients.addElement(client);
        }
        sendMessage(client, "connected");
    }

    public void sendMessage(RemoteClient client, String msg) {
        synchronized( messages ) {
            messages.addElement(new Message(client, msg));
        }
    }

    public void run() {
        while( true ) {
            Message[] msgs;

            try { Thread.sleep(500); }
            catch( InterruptedException err ) { }
            synchronized( messages ) {
                if( messages.size() > 0 ) {
                    msgs = new Message[messages.size()];
                    messages.copyInto(msgs);
                    messages.removeAllElements();
                }
                else {
                    continue;
                }
            }
            for(int i=0; i<msgs.length; i++) {
                RemoteClient c = msgs[i].getClient();
                String msg = msgs[i].getMessage();
                Enumeration targs;
                String nom;
                try {
                    nom = c.getClientName();
                }
                catch( RemoteException err ) {
                    err.printStackTrace();
                    continue;
                }
                targs = clients.elements();
                while( targs.hasMoreElements() ) {
                    RemoteClient target = (RemoteClient)targs.nextElement();
                    try {
                        target.receiveMessage(nom + ": " + msg);
                    }
                    catch( RemoteException err ) {
                        synchronized( clients ) {
                            clients.removeElement(target);
                        }
                    }
                }
            }
        }
    }
}

class Message {
    private RemoteClient client;
    private String       message;

    public Message(RemoteClient c, String msg) {
        super();
        client = c;
        message = msg;
    }

    public RemoteClient getClient() {
        return client;
    }

    public String getMessage() {
        return message;
    }
}
