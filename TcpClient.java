import java.net.*;
import java.io.*;
 
/**
 * This program demonstrates a simple TCP/IP socket client.
 *
 * @author www.codejava.net
 */
public class TcpClient {
 
    public static void main(String[] args) {
 
        String hostname = "10.32.143.15";
        int port = 65432;
 
        try (Socket socket = new Socket(hostname, port)) {
 
            //cria o stream do teclado
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            String line = inFromUser.readLine();

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println(line);
  
 
        } catch (UnknownHostException ex) {
 
            System.out.println("Server not found: " + ex.getMessage());
 
        } catch (IOException ex) {
 
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}