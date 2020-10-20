package Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        connectionExpl();
    }
    public static void connectionExpl() throws IOException, InterruptedException {
        //System.out.println("Bitte geben sie den namen des Host ein:");
        Scanner scanner = new Scanner(System.in);
        //String hostName = scanner.nextLine();
        String name = "localhost";
        //System.out.println("Bitte geben sie den port ein :");
        //int port = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int port = 3333;

        Socket socket = new Socket(name, port);
        InputStream is = socket.getInputStream();


        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        long longValue =  50;
        float floatValue = 5;
        String stringValue = "try";
        try {
            dos.writeLong(longValue);
            dos.writeFloat(floatValue);
            dos.writeUTF(stringValue);
        } catch (IOException ex) {
            System.err.println("couldn’t write data (fatal)");
            System.exit(0);
        }
        DataInputStream dis = new DataInputStream(is);
        try {
            long readLongSensorValue = dis.readLong();
            float readFloatSensorValue = dis.readFloat();
            String readSensorName = dis.readUTF();

            System.out.println("read long and float: " + readLongSensorValue + ", " + readFloatSensorValue + ", " + readSensorName);
        } catch (IOException ex) {System.err.println("couldn’t read data (fatal)");
            System.exit(0);
        }
        /*

        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        try {
            String readString = br.readLine();
            System.out.println("read: " + readString);
        } catch (IOException ex) {
            System.err.println("couldn’t read data (fatal)");
            System.exit(0);
        }
        ps.println("Hello Stream");
        ps.println("Hello Stream");
  */
        Thread.sleep(1000);
        socket.close();
    }
}
