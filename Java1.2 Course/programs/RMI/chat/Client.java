import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements RemoteClient {
    static public void main(String[] args) {
        String url = "rmi://localhost/Server";
        Client client;
        RemoteChatServer server;
        BufferedReader input;
        if( args.length != 1 ) {
            System.out.println("Syntax: java Client NAME");
            return;
        }
        try {
            client = new Client(args[0]);
            System.out.println("Looking up: " + url);
            server = (RemoteChatServer)Naming.lookup(url);
            server.connect(client);
            System.out.println("Done.");
            input = new BufferedReader(new InputStreamReader(System.in));
        }
        catch( Exception e ) {
            e.printStackTrace();
            System.exit(-1);
            return;
        }
        System.out.print("> ");
        while( true ) {
            String str;

            try {
                str = input.readLine();
            }
            catch( java.io.IOException e ) {
                e.printStackTrace();
                System.exit(-1);
                return;
            }
            if( str.equals("quit") ) {
                System.exit(-1);
                return;
            }
            try {
                server.sendMessage(client, str);
            }
            catch( RemoteException e ) {
                e.printStackTrace();
                System.exit(-1);
                return;
            }
            System.out.print("> ");
        }
    }

    private String client_name;

    public Client(String nom) throws RemoteException {
        super();
        client_name = nom;
    }

    public String getClientName() {
        return client_name;
    }

    public void receiveMessage(String msg) {
        System.out.println(msg);
    }
}
