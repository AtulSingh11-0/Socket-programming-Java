import java.io.*;
import java.net.*;

/**
 * The {@code Server} class sets up a server that listens for client connections.
 * It establishes a connection with a client, receives messages from the client,
 * and echoes the messages back to the client.
 */
public class Server {

  private static ServerSocket serverSocket;
  private static Socket clientSocket;
  private static PrintWriter output;
  private static BufferedReader input;

  /**
   * Constructs a {@code Server} object that listens on the specified port.
   *
   * @param port the port number on which the server listens for client connections
   */
  public Server(int port) {
    try {
      /**
       * A new ServerSocket is created on the provided port.
       */
      serverSocket = new ServerSocket(port);
      System.out.println("Server started listening on Port: " + serverSocket.getLocalPort());

      /**
       * The server waits for a client connection.
       * When a client connects, it prints the client's IP and port.
       */
      clientSocket = serverSocket.accept();
      System.out.println("Client connected with the server with IP: " + clientSocket.getInetAddress() + " and Port: " + clientSocket.getPort());

      /**
       * Creating the PrintWriter instance to send outputs to the client, with auto-flushing enabled.
       */
      output = new PrintWriter(clientSocket.getOutputStream(), true);

      /**
       * Creating a BufferedReader instance to receive input from the client.
       */
      input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

      String inputLine;

      /**
       * Reading client input line by line in a loop.
       */
      while ((inputLine = input.readLine()) != null) {
        /**
         * Printing the messages received from the client.
         */
        System.out.println("Received: " + inputLine);

        /**
         * If the client sends "bye." or "Bye.", the server responds with "Bye." and breaks the loop to close the connection.
         */
        if (inputLine.equalsIgnoreCase("bye.")) {
          output.println("Bye.");
          break;
        }

        /**
         * Sending the received message back to the client (echoing).
         */
        output.println(inputLine);
      }
    } catch (IOException ex) {
      System.out.println("Could not listen on Port: " + ex.getMessage());
    } finally {
      /**
       * Calling the stop function to close resources in the finally block, ensuring it executes regardless of try or catch.
       */
      stop();
    }
  }

  /**
   * Closes the server socket, client socket, output stream, and input stream.
   */
  public static void stop() {
    try {
      if (input != null) input.close();
      if (output != null) output.close();
      if (clientSocket != null) clientSocket.close();
      if (serverSocket != null) serverSocket.close();
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }

  /**
   * The main method that creates an instance of {@code Server} and starts a server on port 6969.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    Server server = new Server(6969);
  }
}
