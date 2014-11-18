public class Flight extends java.rmi.server.UnicastRemoteObject
implements RemoteFlight {
    int flight_number;
    public Flight(int number) throws java.rmi.RemoteException {
        super();
        flight_number = number;
    }
    public int getFlightNumber() {
        return flight_number;
    }
}
