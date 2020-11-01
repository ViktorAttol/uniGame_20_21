package startOptionsExchange;

import java.io.*;

public class OptionsExchanger implements OptionsSender, OptionsReceiver{

    @Override
    public void sendGameDimension(String filename, OutputStream os) throws IOException {
        //open File for read
        FileInputStream fis = new FileInputStream(filename);
        //sent to os
       streamData(fis, os);
        //close stream
        os.close();
    }

    @Override
    public void receiveGameDimension(String filename, InputStream is) throws IOException {
        //open for write
        FileOutputStream fos = new FileOutputStream(filename);
        //receive from is
        streamData(is, fos);
        //close stream
        is.close();

    }

    private void streamData(InputStream is, OutputStream os) throws IOException {
        int read = 0;
        {
            read = is.read();
            if(read != -1){
                os.write(read);
            }
        } while (read != -1);
    }

}
