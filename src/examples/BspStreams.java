package examples;

import java.io.*;

public class BspStreams {

    public void bspStream(){
        String filename = null;
        OutputStream os = null;

        try {
            filename = "testFile.txt";
            os = new FileOutputStream(filename);
        } catch (FileNotFoundException ex) {
            System.err.println("couldn’t open file - fatal");
            System.exit(0); // brutal exception handling
        }

        String someText = "Hallo";
        byte[] textAsByte = someText.getBytes();
        try {
            os.write(textAsByte);
        } catch (IOException ex) {
            System.err.println("couldn’t write data (fatal)");
            System.exit(0);
        }

        InputStream is = null;
        try {
            is = new FileInputStream(filename);
        } catch (FileNotFoundException ex) {
            System.err.println("couldn’t open file - fatal");
            System.exit(0);
        }

        byte[] readBuffer = new byte[100];
        try {
            is.read(readBuffer);
        } catch (IOException ex) {
            System.err.println("couldn’t read data (fatal)");
            System.exit(0);
        }
        String outputString = new String(readBuffer);
        System.out.println(outputString);

      }
    public void bspDataStream(){
        String filename = null;
        OutputStream os = null;

        try {
            filename = "testFile.txt";
            os = new FileOutputStream(filename);
        } catch (FileNotFoundException ex) {
            System.err.println("couldn’t open file - fatal");
            System.exit(0); // brutal exception handling
        }

        DataOutputStream dos = new DataOutputStream(os);
        try {
            dos.writeInt(42);
        } catch (IOException ex) {
            System.err.println("couldn’t write data (fatal)");
            System.exit(0);
        }

        InputStream is = null;
        try {
            is = new FileInputStream(filename);
        } catch (FileNotFoundException ex) {
            System.err.println("couldn’t open file - fatal");
            System.exit(0);
        }

        DataInputStream dis = new DataInputStream(is);
        try {
            int readIntValue = dis.readInt();
            System.out.println("read integer: " + readIntValue);
        } catch (IOException ex) {System.err.println("couldn’t read data (fatal)");
            System.exit(0);
        }
    }

    public void bspStreamReader(){
        String filename = null;
        OutputStream os = null;

        try {
            filename = "testFile.txt";
            os = new FileOutputStream(filename);
        } catch (FileNotFoundException ex) {
            System.err.println("couldn’t open file - fatal");
            System.exit(0); // brutal exception handling
        }

        PrintStream ps = new PrintStream(os);
        ps.println("Hello Stream");


        InputStream is = null;
        try {
            is = new FileInputStream(filename);
        } catch (FileNotFoundException ex) {
            System.err.println("couldn’t open file - fatal");
            System.exit(0);
        }

        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        try {
            String readString = br.readLine();
            System.out.println("read: " + readString);
        } catch (IOException ex) {
            System.err.println("couldn’t read data (fatal)");
            System.exit(0);
        }
    }

    public void bespSteamIO(){
        /*
        System.out.println("Bitte was eingeben:");
        isr = new InputStreamReader(System.in);

        br = new BufferedReader(isr);
        try {
            readString = br.readLine();
            System.out.println("las: " + readString);
        } catch (IOException ex) {
            System.err.println("nichts gelesen");
        }

         */
    }


}
