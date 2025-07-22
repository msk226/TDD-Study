package tyrant;

import static org.junit.jupiter.api.Assertions.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TyrantMapTest {

    @Test
    public void get_retrives_what_was_put() {
//        TyrantMap map = new TyrantMap(); // 3.1
//        final byte[] key = "key".getBytes(); // 3.2
//        final byte[] value = "value".getBytes(); // 3.3
//        map.put(key, value); // 2
//        assertEquals(value, map.get(key)); // 1
    }

    @Test
    void nothing() throws IOException {
        TyrantMap tyrantMap = new TyrantMap();
        tyrantMap.put(new byte[]{'k', 'e', 'y'}, new byte[]{'v', 'a', 'l', 'u', 'e'});
    }

    private class TyrantMap {
        public static final int OPERATION_PREFIX = 0xC8;
        public static final int PUT_OPERATION = 0x10;

        private Socket socket;
        private DataOutputStream writer;
        private DataInputStream reader;

        public void put(byte[] key, byte[] value) throws IOException {
            open();

            writer.write(OPERATION_PREFIX);
            writer.write(PUT_OPERATION);
            writer.writeInt(key.length);
            writer.writeInt(value.length);
            writer.write(key);
            writer.write(value);

            int status = reader.read();
            assertEquals(0, status);

            close();
        }

        private void open() throws IOException {
            socket = new Socket("localhost", 1978);
            writer = new DataOutputStream(socket.getOutputStream());
            reader = new DataInputStream(socket.getInputStream());
        }

        private void close() throws IOException {
            socket.close();
        }

    }

}
