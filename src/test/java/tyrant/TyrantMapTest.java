package tyrant;

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
    void nothing() throws IOException {
        TyrantMap tyrantMap = new TyrantMap();
        tyrantMap.put(new byte[]{'k', 'e', 'y'}, new byte[]{'v', 'a', 'l', 'u', 'e'});
    }

    private class TyrantMap {
        public static final int OPERATION_PREFIX = 0xC8;
        public static final int PUT_OPERATION = 0x10;

        public void put(byte[] key, byte[] value) throws IOException {
            Socket socket = new Socket("localhost", 1978);
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
            writer.write(OPERATION_PREFIX);
            writer.write(PUT_OPERATION);
            writer.writeInt(key.length);
            writer.writeInt(value.length);
            writer.write(key);
            writer.write(value);

            DataInputStream reader = new DataInputStream(socket.getInputStream());
            int status = reader.read();
            Assertions.assertEquals(0, status);
        }

    }

}
