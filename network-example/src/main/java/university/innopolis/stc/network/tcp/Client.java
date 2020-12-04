package university.innopolis.stc.network.tcp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 */
public class Client {

    public static void main(String[] args) throws IOException {
        try (Socket client = new Socket()) {
            InetSocketAddress localhost = new InetSocketAddress("localhost", 8842);
            client.connect(localhost);

            try (OutputStream outputStream = client.getOutputStream();
                 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                 BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                 InputStream inputStream = client.getInputStream();
                 InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                 Scanner scanner = new Scanner(inputStreamReader)) {

                bufferedWriter.write("Test!!!");
                bufferedWriter.newLine();
                bufferedWriter.flush();

                String s = scanner.nextLine();
                System.out.println("Received string: " + s);
            }
        }
    }
}
