package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        connectionExpl();
    }

    public void tcpClient() throws IOException {
        String name = "localhost";
        int port = 3333;
        Socket socket = new Socket(name, port);
    }

    public void tcpServer() throws IOException {
        int port = 3333;
        ServerSocket server = new ServerSocket(port);
        //socket erzeugt und durch accept methode listen gestartet
        Socket socket = server.accept();
        //socket objekt kann zur kommunikation genutzt werden -> ab hier server und client identisch
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
    }

    public static void connectionExpl() throws IOException, InterruptedException {
        int port = 3333;
        ServerSocket server = new ServerSocket(port);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        long readLongSensorValue = 0;
        float readFloatSensorValue = 0;
        String readSensorName = "";

        DataInputStream dis = new DataInputStream(is);

        try {
            readLongSensorValue = dis.readLong();
            readFloatSensorValue = dis.readFloat();
            readSensorName = dis.readUTF();
            System.out.println("read long and float: " + readLongSensorValue + ", " + readFloatSensorValue + ", " + readSensorName);
        } catch (IOException ex) {System.err.println("couldn’t read data (fatal)");
            System.exit(0);
        }

        DataOutputStream dos = new DataOutputStream(os);

        try {
            dos.writeLong(readLongSensorValue);
            dos.writeFloat(readFloatSensorValue);
            dos.writeUTF(readSensorName);
        } catch (IOException ex) {
            System.err.println("couldn’t write data (fatal)");
            System.exit(0);
        }

        Thread.sleep(1000);
        socket.close();
    }


}
