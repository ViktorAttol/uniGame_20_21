package startOptionsExchange;

import java.io.IOException;
import java.io.InputStream;

public interface OptionsReceiver {
    /**
     * Receive gameLayout from inputStream and save it in local file.
     * @param filename local filename
     * @param is connection from host/content provider
     */
    void receiveGameDimension(String filename, InputStream is) throws IOException;
}
