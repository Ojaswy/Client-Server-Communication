The aim of this project is to establish a Server and Multiple Clients Communication via the TCP protocol.
Multiple requests from the clients will be simultaneously handled by the server. By default this setup runs on Localhost on Port 4444.

Functionality: Clients can input a string and the server will reverse it. The output will be printed on both the server-side and client-side.

This is written in C and uses Fork to create child processes to handle requests simultaneously.
