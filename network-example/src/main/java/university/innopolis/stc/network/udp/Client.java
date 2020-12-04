package university.innopolis.stc.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * Hello world!
 */
public class Client {

    public static void main(String[] args) throws IOException {
        InetSocketAddress localhost = new InetSocketAddress("localhost", 8842);
        try (DatagramSocket client = new DatagramSocket()) {
            byte[] bytes = "Hello, STC!!!".getBytes();
            DatagramPacket p = new DatagramPacket(bytes, bytes.length, localhost);
            client.send(p);
        }
    }
}
