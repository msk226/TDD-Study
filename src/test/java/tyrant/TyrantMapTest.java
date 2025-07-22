package tyrant;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TyrantMapTest {

    @Test
    void nothing() throws IOException {
        Socket socket = new Socket("localhost", 1978);
        OutputStream writer = socket.getOutputStream();
        writer.write(0xC8);
        writer.write(0x10);
        writer.write(0);
        writer.write(0);
        writer.write(0);
        writer.write(3);

        writer.write(0);
        writer.write(0);
        writer.write(0);
        writer.write(5);
        writer.write(new byte[]{'k', 'e', 'y'});
        writer.write(new byte[]{'v', 'a', 'l', 'u', 'e'});

        InputStream reader = socket.getInputStream();
        int status = reader.read();
        Assertions.assertEquals(0, status);
    }
}
