package university.innopolis.stc.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Hello world!
 */
public class Server {

    private static byte[] buf = new byte[1024];

    public static void main(String[] args) throws IOException {
        try (DatagramSocket socket = new DatagramSocket(8842)) {
            do {
                DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
                socket.receive(datagramPacket);

                String string = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println(string);
            } while (true);
        }
    }
}
