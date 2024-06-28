# Java Client-Server Application

This project demonstrates a simple client-server architecture using Java. The server listens for connections from clients, and once a connection is established, it can receive messages from the client and send responses back. The client connects to the server, sends messages, and displays the server's responses.

## Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [How It Works](#how-it-works)
- [Implementation Details](#implementation-details)
- [How to Run](#how-to-run)
- [Requirements](#requirements)

## Overview

This application consists of two main components:
1. **Server**: Waits for client connections and handles incoming messages.
2. **Client**: Connects to the server, sends messages, and displays responses from the server.

## Architecture

The client-server architecture follows these steps:

1. **Server**:
   - Listens on a specified port.
   - Accepts client connections.
   - Receives messages from the connected client.
   - Sends responses back to the client.

2. **Client**:

   - Connects to the server on a specified IP address and port.
   - Sends messages to the server.
   - Receives and displays responses from the server.

## How It Works

### Server

The server uses a `ServerSocket` to listen for incoming connections on a specified port. Once a client connects, the server accepts the connection and sets up input and output streams to communicate with the client. The server reads messages from the client, echoes them back, and closes the connection if the client sends "bye." or "Bye.".

### Client

The client connects to the server using a `Socket` with the server's IP address and port. It sets up input and output streams to send messages to the server and receive responses. The client reads user input from the console, sends it to the server, displays the server's response, and terminates the connection if the user types "bye." or "Bye.".

## Implementation Details

### Server.java

The `Server` class performs the following tasks:
- Sets up a `ServerSocket` to listen on a specified port.
- Accepts client connections using `accept()`.
- Uses `PrintWriter` and `BufferedReader` to send and receive messages.
- Echoes received messages back to the client.
- Closes the connection when "bye." or "Bye." is received.

### Client.java

The `Client` class performs the following tasks:
- Connects to the server using a `Socket` with the server's IP address and port.
- Uses `PrintWriter` to send messages to the server.
- Uses `BufferedReader` to receive and display messages from the server.
- Reads user input from the console and sends it to the server.
- Closes the connection when "bye." or "Bye." is typed by the user.

## How to Run

### Prerequisites

- Java Development Kit (JDK) installed on your system.

### Steps

1. **Compile the Server and Client classes**:

```bash
javac Server.java
javac Client.java
```

2. **Run the Server**:

```bash
java Server
```

3. **Run the Client**:
In a new terminal window or tab, run:

```bash
java Client
```

4. **Start Chatting**:

- After running the client, type messages in the client terminal. The messages will be sent to the server, which will echo them back to the client.

- To close the connection, type "bye." or "Bye." in the client terminal.

## Requirements

- Java Development Kit (JDK) 8 or higher.
- An Integrated Development Environment (IDE) or text editor to view and edit the source code.

This project demonstrates a basic client-server communication setup in Java. It can be extended with additional features like handling multiple clients, adding security layers, and more advanced message handling protocols.
