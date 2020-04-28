package transmission;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetSocketAddress;

public class DataConnector implements DataConnection {

    private InetSocketAddress address;
    private int port;

    /**
     * Create client side - open connection to address / port
     *
     * @param hostname
     */
    public DataConnector(String hostname, int port) {
        // TODO
        address = new InetSocketAddress(hostname, port);

    }

    /**
     * Create server side - open port on this port and wait for one client
     *
     * @param port
     */
    public DataConnector(int port) {
        // TODO
        this.port = port;

    }

    @Override
    public DataInputStream getDataInputStream() throws IOException {

        ServerSocket ss = new ServerSocket(port);
        Socket remoteClientSocket = ss.accept();
        DataInputStream din = new DataInputStream(remoteClientSocket.getInputStream());


        return din;


    }

    @Override
    public DataOutputStream getDataOutputStream() throws IOException {

        String msg = "Hallo";
        Socket socket = new Socket();
        socket.connect(address, 5000);
        DataOutputStream din = new DataOutputStream(socket.getOutputStream());
        din.writeUTF(msg);
        din.flush();

        //Verbindung schliessen
        din.close();
        socket.close();

        return din;
    }
}
