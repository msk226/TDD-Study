package tyrant;

import static org.junit.jupiter.api.Assertions.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class TyrantMapTest {

    @Test
    public void get_retrives_what_was_put() throws IOException {
        TyrantMap map = new TyrantMap(); // 3.1
        map.open();
        final byte[] key = "key".getBytes(); // 3.2
        final byte[] value = "value".getBytes(); // 3.3
        map.put(key, value); // 2
        assertEquals(Arrays.toString(value), Arrays.toString(map.get(key))); // 1
        map.close();
    }

    @Test
    void nothing() throws IOException {
        TyrantMap tyrantMap = new TyrantMap();
        tyrantMap.open();
        tyrantMap.put(new byte[]{'k', 'e', 'y'}, new byte[]{'v', 'a', 'l', 'u', 'e'});
        tyrantMap.close();
    }

    private class TyrantMap {
        public static final int OPERATION_PREFIX = 0xC8;
        public static final int PUT_OPERATION = 0x10;
        public static final int GET_OPERATION = 0x30;

        private Socket socket;
        private DataOutputStream writer;
        private DataInputStream reader;

        public void put(byte[] key, byte[] value) throws IOException {
            writeOperation(PUT_OPERATION);
            writer.writeInt(key.length);
            writer.writeInt(value.length);
            writer.write(key);
            writer.write(value);

            validateStatus();
        }

        public byte[] get(byte[] key) throws IOException {
            writeOperation(GET_OPERATION);
            writer.writeInt(key.length);
            writer.write(key);

            validateStatus();

            int size = reader.readInt();
            byte[] result = new byte[size];
            reader.read(result);
            return result;
        }

        public void open() throws IOException {
            socket = new Socket("localhost", 1978);
            writer = new DataOutputStream(socket.getOutputStream());
            reader = new DataInputStream(socket.getInputStream());
        }

        public void close() throws IOException {
            socket.close();
        }

        private void validateStatus() throws IOException {
            int status = reader.read();
            assertEquals(0, status);
        }

        private void writeOperation(int putOperation) throws IOException {
            writer.write(OPERATION_PREFIX);
            writer.write(putOperation);
        }

    }

}
