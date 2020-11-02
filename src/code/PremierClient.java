package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class PremierClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("time-a.nist.gov",13);
            BufferedReader bR = new BufferedReader(new InputStreamReader(s.getInputStream()));
            boolean more = true;
            while (more)
            {
                String line = bR.readLine();
                if (line == null)
                {
                    more =false;
                }
                else {
                    System.out.println("la date est "+line);
                }
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
