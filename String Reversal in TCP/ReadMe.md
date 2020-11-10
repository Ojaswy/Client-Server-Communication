The aim of this project is to establish a Server and Multiple Clients Communication via the TCP protocol.
Multiple requests from the clients will be simultaneously handled by the server. By default this setup runs on Localhost on Port 4444.

Functionality: Clients can input a string and the server will reverse it. The output will be printed on both the server-side and client-side.

This is written in C and creates child processes to handle the requests from multiple clients.

Commands to run on a Terminal:

`gcc server.c -o server
gcc client.c -o client`

Then run ./server first and in a new terminal run ./client. You can open new terminals and start running new clients. 

