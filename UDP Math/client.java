import java.net.*;
import java.io.*;
import java.nio.*;

/**
 * This example illustrates the basic method calls for connectionless
 * datagram socket. 
 * @author M. L. Liu
 */
public class client {

   public static void main(String[] args) {
      if (args.length != 3)
         System.out.println
            ("This program requires three command line arguments: <port> <int1> <int2>");
      else {
	        final int MAX_LEN = 1000;          
	try {
  		      	InetAddress receiverHost = InetAddress.getByName("localhost");
  		      	int receiverPort = Integer.parseInt(args[0]);


            		// String message = args[2];
               int[] numbers = new int[2];
               numbers[0] = Integer.parseInt(args[1]);
               numbers[1] = Integer.parseInt(args[2]);

// SENDS THE INTEGERS TO RECEIVER
  	
            // instantiates a datagram socket for sending the data
            ByteBuffer byteBuffer = ByteBuffer.allocate(numbers.length * 4);        
            IntBuffer intBuffer = byteBuffer.asIntBuffer();
            intBuffer.put(numbers);
            byte[] buffer = byteBuffer.array();
            DatagramSocket mySocket = new DatagramSocket();
            DatagramPacket datagram = new DatagramPacket(buffer, buffer.length, receiverHost, receiverPort);
            mySocket.send(datagram);
	    System.out.println("\nSent the integers\n");


// RECIEVES THE SUM FROM RECEIVER

            byte[ ] buf = new byte[MAX_LEN];                                     
            DatagramPacket dg = new DatagramPacket(buf, MAX_LEN);
            mySocket.receive(dg);
	    System.out.println("\nRecieved the sum of integers\n");
            String result = new String(buf);
//	    int res = Integer.parseInt(result);
            System.out.println("\nSum of the two numbers " + result + "\n");

            mySocket.close( );
         } // end try
	 catch (Exception ex) {
       ex.printStackTrace( );
	 }
      } // end else
   } // end main
} // end class
