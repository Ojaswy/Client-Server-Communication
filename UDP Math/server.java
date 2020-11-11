import java.net.*;
import java.io.*;
import java.nio.*;

/**
 * This example illustrates the basic method calls for connectionless
 * datagram socket using DatagramSocket class.
 * @author M. L. Liu
 */
public class server {

   public static void main(String[] args) {
      if (args.length != 1)
         System.out.println
            ("This program requires a command line argument: <port> ");
      else {
			int port = Integer.parseInt(args[0]);


         final int MAX_LEN = 1000; 
            // This is the assumed maximum byte length of the 
            //      datagram to be received.
      while(true){
         try {
               InetAddress myaddress=InetAddress.getByName("localhost");
               DatagramSocket mySocket = new DatagramSocket(port); 


// RECEIVES THE INTEGERS FROM SENDER
               // instantiates a datagram socket for receiving the data
               byte[ ] buffer = new byte[MAX_LEN];
               DatagramPacket datagram = new DatagramPacket(buffer, MAX_LEN);
               // System.out.println("\nThe receiver is up and waiting for a message .....\n");
               // mySocket.setSoTimeout(30000); // 30 sec
               mySocket.receive(datagram);
	       System.out.println("\nRecieved the integers\n");
               ByteBuffer byteBuffer = ByteBuffer.allocate(buffer.length);
               byteBuffer.put(buffer);
               IntBuffer intBuffer = byteBuffer.wrap(buffer).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
               int[] array = new int[intBuffer.remaining()];
               intBuffer.get(array);
               int res = array[0] + array[1];
	       String result = Integer.toString(res);
// SENDS THE SUM TO THE SENDER
	       InetAddress senderAddress = datagram.getAddress( ); 
               int senderPort = datagram.getPort( ); 
               byte[ ] buf = result.getBytes( ); 
	       DatagramPacket dg = new DatagramPacket(buf, buf.length, senderAddress, senderPort);  
               mySocket.send(dg);
	       System.out.println("\nSent the sum of integers\n");                                  
               //System.out.println("\nAdding the two numbers " + res + "\n");
               mySocket.close( );

               } // end try
         catch (Exception ex) {
               ex.printStackTrace( );
         }
            } // end else
      } // end while
   } // end main
} // end class
