package wordguessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WordguessingServer {
    public static void main(String[] args) {
          try {
              
             Wordguessing  wordguess = new Wordguessing();
            ServerSocket server = new ServerSocket(5555);
            while (true) {
                Socket client = server.accept();
                BufferedReader incoming = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter send = new PrintWriter(client.getOutputStream());
                String inputString = incoming.readLine();
               System.out.println(inputString);
                String retval;
                try {
                   if(inputString.equals("New Letters")){
                       String a = wordguess.getLetters();
                       System.out.println(a);
                        send.println(a);   
                   }
                   else{
                        send.println(wordguess.guessWord(inputString));   
                   }
                    //retval = calculation.getResult();
                } catch (Exception ex) {
                    retval = "Error:" + ex.getMessage();
                }
              //  send.println(retval);
                send.flush();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
    