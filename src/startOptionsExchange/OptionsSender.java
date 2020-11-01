package startOptionsExchange;

import java.io.IOException;
import java.io.OutputStream;

public interface OptionsSender {
    /**
     * Read gameLayout from local file an send it to outputStream
     * @param filename local filename with layout of game
     * @param os connection to client
     */
    void sendGameDimension(String filename, OutputStream os) throws IOException;
}
