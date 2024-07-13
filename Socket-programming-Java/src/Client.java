package Sockets_Java.Socket_programming_Java.src;

import java.io.*;
import java.net.*;

/**
 * The {@code Client} class establishes a connection to a server,
 * sends messages to the server, and prints the server's responses.
 */
public class Client {

  private static Socket clientSocket;
  private static PrintWriter output;
  private static BufferedReader input;

  /**
   * Constructs a {@code Client} object that connects to the specified IP address and port.
   *
   * @param ip   the IP address of the server
   * @param port the port number on which the server is listening
   */
  public Client(String ip, int port) {
    try {
      /**
       * A socket connection is established to the specified IP address and port of the server.
       */
      clientSocket = new Socket(ip, port);

      /**
       * Creating the PrintWriter instance to send input to the server, with auto-flushing enabled.
       */
      output = new PrintWriter(clientSocket.getOutputStream(), true);

      /**
       * Creating a BufferedReader instance to read the output received from the server.
       */
      input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

      /**
       * Creating a BufferedReader instance to take input from the user.
       */
      BufferedReader stdInput = new BufferedReader(new InputStreamReader(System.in));
      String userInput;

      /**
       * On successful connection with the server, the client can start sending messages to the server.
       */
      System.out.println("Connected to the Server. Enter your messages:");

      /**
       * Read user input line by line in a loop.
       */
      while ((userInput = stdInput.readLine()) != null) {
        /**
         * Send the user input to the server.
         */
        output.println(userInput);

        /**
         * Store the server's response in the response String and print it.
         */
        String response = input.readLine();
        System.out.println("Server: " + response);

        /**
         * If the user types "bye." or "Bye.", break the loop and close the connection.
         */
        if (userInput.equalsIgnoreCase("Bye.")) {
          break;
        }
      }
    } catch (IOException ex) {
      System.out.println("Could not connect to Server: " + ex.getMessage());
    } finally {
      /**
       * Call the stop function in the finally block to ensure it executes regardless of try or catch.
       */
      stop();
    }
  }

  /**
   * Closes the client socket, output stream, and input stream.
   */
  public static void stop() {
    try {
      if (input != null) input.close();
      if (output != null) output.close();
      if (clientSocket != null) clientSocket.close();
    } catch (IOException ex) {
      System.out.println("Something went wrong: " + ex.getMessage());
      System.exit(-1);
    }
  }

  /**
   * The main method that creates an instance of {@code Client} and connects to IP address 127.0.0.1 on port 6969.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    Client client = new Client("127.0.0.1", 6969);
  }
}
