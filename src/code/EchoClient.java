package code;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        try {
            //"10.153.43.52"
            //10.153.42.189
            Socket s = new Socket("10.153.43.52", 5555);
            BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            Scanner clavier = new Scanner(System.in);

            boolean more = true;
            while (more)
            {
                String line = r.readLine();
                if (line == null)
                {
                    more = false;
                }
                else
                {
                    System.out.println(line);
                    line = clavier.nextLine();
                    out.println(line);
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
