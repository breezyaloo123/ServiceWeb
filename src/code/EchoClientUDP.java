package code;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EchoClientUDP {
    final static int taille = 1024;
    final static byte buffer[] = new byte[taille];

    public static void main(String[] args) throws Exception{
        InetAddress serveur = InetAddress.getByName(args[0]);
        int length = args[1].length();
        byte buffer[] = args[1].getBytes();
        DatagramPacket datasent = new DatagramPacket(buffer,length,serveur,6666);
        DatagramSocket socket = new DatagramSocket();
        socket.send(datasent);

        DatagramPacket dataReceived = new DatagramPacket(new byte[length],length);
        socket.receive(dataReceived);
        System.out.println("Data Received "+new String(dataReceived.getData()));
        System.out.println("From :"+ dataReceived.getAddress()+ ":"+ dataReceived.getPort());

        //System.out.flush();

    }
}
