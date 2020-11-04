package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(8888);
            Socket incoming = s.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
            PrintWriter out = new PrintWriter(incoming.getOutputStream(),true);
            out.println("Bonjour, Tapez OK pour sortir");
            boolean done = false;
            while (!done)
            {
                String line = in.readLine();
                if (line == null)
                {
                    done = false;
                }
                else {
                    out.println("Echo "+line);
                    if (line.trim().equals("OK"))
                    {
                        done = true;
                    }
                }
            }
            incoming.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
