package code;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Exemple1 {
    public static void main(String[] args) {

        InetAddress localAddress;
        InetAddress serverAddress;

        try {
            localAddress = InetAddress.getLocalHost();
            System.out.println("L'Adrresse locale est : "+localAddress);
            serverAddress = InetAddress.getByName("www.ucad.sn");
            System.out.println("L'adresse de serveur web de l'ucad est : "+serverAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
