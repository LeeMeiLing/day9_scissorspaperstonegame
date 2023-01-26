package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SSPServer {

    public static void main(String[] args) throws IOException {
        
        Integer computerChoice, playerChoice = 0;
        String winner = "";

        SSP ssp = new SSP();
        computerChoice = ssp.generateComputerChoice();

        try(ServerSocket ss = new ServerSocket(5000)){

            System.out.println("waiting for client to connect...");
            Socket clientSocket = ss.accept();
            System.out.println("Client connected");

            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());

            boolean exit = false;

            while(!exit){

                pw.println("Enter (1)Scissors, (2) Paper, or (3) Stone: ");
                pw.flush();

                String clientInput = br.readLine();
                if (clientInput.equalsIgnoreCase("exit")){
                    exit = true;
                }
                
                try{
    
                    playerChoice = Integer.parseInt(clientInput);
    
                }catch(NumberFormatException e){
    
                    pw.println("Invalid input: Only number 1, 2 or 3 is allowed");
                    pw.flush();
                    // scanner.skip(Pattern.compile(".*")); /// must have this line, else the char will stay in scanner and cannot complete scanner.nextInt
                    continue;
                }
    
                if(!((playerChoice >= 1) && (playerChoice<=3))){
                    pw.println("Invalid input: Only number 1, 2 or 3 is allowed");
                    pw.flush();
                    continue;
                }
    
                winner = ssp.checkWinner(playerChoice, computerChoice);
                if(winner.equalsIgnoreCase("player")){
                    pw.println("You won!");
                    pw.flush();
                }else if(winner.equalsIgnoreCase("computer")){
                    pw.println("You lost!");
                    pw.flush();
                }else{
                    pw.println("It's a tie!");
                    pw.flush();
                }
        
                
            }

        }


    
    }
    
}
