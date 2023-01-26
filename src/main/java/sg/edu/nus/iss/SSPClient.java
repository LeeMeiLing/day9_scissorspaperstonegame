package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SSPClient {
    
    public static void main(String[] args) throws IOException {
        
        Socket socket = new Socket("localhost", 5000);

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream());

        String serverInput;
        Console cons = System.console();
        String toServer;
        boolean exit = false;

        while(!exit){

            serverInput = br.readLine();

            if (serverInput.equals("Enter (1)Scissors, (2) Paper, or (3) Stone: ")){

                toServer = cons.readLine(serverInput);

                if(toServer.trim().equalsIgnoreCase("exit")){
                    pw.println(toServer); 
                    pw.flush();
                    exit = true;
                }else{
                    pw.println(toServer); // use println because cons.readLIne never include \n
                    pw.flush();
                }
               
            }else{

                System.out.println(serverInput);

            }
            
        }

        pw.close();
        br.close();
        socket.close();

    }
}
