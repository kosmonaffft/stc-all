package university.innopolis.stc.network.tcp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8842);

        do {
            try (Socket clientSocket = serverSocket.accept();
                 InputStream inputStream = clientSocket.getInputStream();
                 InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                 Scanner scanner = new Scanner(inputStreamReader);

                 OutputStream outputStream = clientSocket.getOutputStream();
                 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                 BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {

                String s = scanner.nextLine();
                System.out.println("Readed line: " + s);

                String respone = "Hello, " + s;

                bufferedWriter.write(respone);
                bufferedWriter.flush();
            }
        } while (true);
    }
}
